from pathlib import Path
from typing import List

from app.schemas.models import OutputFormat, ParserType, RegexRule
from app.parsers.base import BaseStatementParser
from app.parsers.cmb import CMBStatementParser


def create_parser(
    *,
    parser_type: ParserType,
    input_dir: Path,
    rules: List[RegexRule],
    output_format: OutputFormat,
) -> BaseStatementParser:
    if parser_type == ParserType.CMB:
        return CMBStatementParser(input_dir, rules, output_format)
    raise ValueError(f"Unsupported parser type: {parser_type}")

