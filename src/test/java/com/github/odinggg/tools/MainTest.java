package com.github.odinggg.tools;

import com.github.odinggg.tools.model.WorkWeChatMessageXML;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-12-21 16:48
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook sheets = new XSSFWorkbook();
        XSSFSheet sheet = sheets.createSheet();
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("jslajlasksjla哆啦卡里克");
        XSSFCell cell1 = row.createCell(2);
        cell1.setCellValue(122.22);
        sheets.write(new FileOutputStream(new File("a")));
    }
}
