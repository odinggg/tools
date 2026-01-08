import re
import logging
from pathlib import Path
from typing import List, Dict
from bs4 import BeautifulSoup
from app.schemas.models import RegexRule, OutputFormat
from app.parsers.base import BaseStatementParser

logger = logging.getLogger(__name__)

class CMBStatementParser(BaseStatementParser):
    """招商银行流水解析器（实现 Markdown->交易抽取，其余输出复用基类）"""

    def __init__(self, input_dir: Path, rules: List[RegexRule], output_format: OutputFormat):
        super().__init__(input_dir=input_dir, rules=rules, output_format=output_format)
        self.account_prefix = "Assets:Bank:CMB"

    def _parse_single_md(self, file_path: Path):
        try:
            content = file_path.read_text(encoding='utf-8')
            soup = BeautifulSoup(content, 'html.parser')

            if self.account_name == "Unknown":
                name_match = re.search(r"户名[：:]\s*(\S+)", content)
                if name_match: self.account_name = name_match.group(1).strip()

                acct_match = re.search(r"账号[：:]\s*([0-9a-zA-Z]+)", content)
                if acct_match:
                    self.account_number = acct_match.group(1).strip()
                    self.beancount_account = f"{self.account_prefix}:{self.account_number[-4:]}"

            table = soup.find('table')
            if not table: return

            for row in table.find_all('tr'):
                cells = row.find_all('td')
                if not cells: continue
                row_text = [c.get_text(strip=True) for c in cells]

                if len(row_text) < 6 or "记账日期" in row_text[0] or "Date" in row_text[0]:
                    continue

                date_str = row_text[0]
                if not re.match(r'\d{4}-\d{2}-\d{2}', date_str): continue

                try:
                    amount = float(row_text[2].replace(",", ""))
                    balance = float(row_text[3].replace(",", "")) if len(row_text) > 3 else 0.0
                except ValueError:
                    continue

                abstract = row_text[4]
                counter_party = row_text[5]
                customer_note = row_text[6] if len(row_text) > 6 else ""

                rule_result = self._apply_rules(row_text)

                self.all_transactions.append({
                    'date': date_str,
                    'amount': amount,
                    'balance': balance,
                    'payee': counter_party or "Unknown",
                    'narration': f"{abstract} - {customer_note}",
                    'tags': rule_result['tags'],
                    'meta': rule_result['meta']
                })
        except Exception as e:
            logger.error(f"Parse Markdown Error: {e}")