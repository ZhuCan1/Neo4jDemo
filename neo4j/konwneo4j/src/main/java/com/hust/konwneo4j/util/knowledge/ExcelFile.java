package com.hust.konwneo4j.util.knowledge;

import com.hust.konwneo4j.entity.AccountSubject;
import com.hust.konwneo4j.entity.EconomicMatter;
import com.hust.konwneo4j.entity.Purpose;
import com.hust.konwneo4j.entity.TestEntity;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelFile {

    public static List<TestEntity> getFromExcel() throws Exception{
        File file = new File("D:\\Program Files\\code\\konwneo4j\\src\\main\\resources\\jinjishixiang.xlsx");
        String fileName = file.getName();
        //验证文件名是否合格
        if (!ExcelImportUtils.validateExcel(fileName)) {
            throw new Exception("文件必须是excel格式！");
        }
        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        if (StringUtils.isEmpty(fileName)) {
            throw new Exception("文件必是excel格式！");
        }
        //判断excel件格式来创建Workbook
        Workbook wb = null;
        InputStream is = new FileInputStream(file);
        if (ExcelImportUtils.isExcel2007(fileName)) {
            wb = new XSSFWorkbook(is);
        } else {
            wb = new HSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        List<TestEntity> list = new ArrayList<>();
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            TestEntity testEntity = new TestEntity();
            EconomicMatter economicMatter = new EconomicMatter();
            Purpose purpose = new Purpose();
            AccountSubject accountSubject = new AccountSubject();
            System.out.println("第" + i + "行");
           if (i == 665){
               break;
            }

            for (int j = 0; j < row.getLastCellNum(); j++){
                boolean isMerge = ExcelImportUtils.isMergedRegion(sheet,i,j);
                if (isMerge){
                    String rs = ExcelImportUtils.getMergedRegionValue(sheet,i,j);
                    purpose.setContent(rs);
                }else{
                    if (j == 0){
                        economicMatter.setCode(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }else if (j == 1){
                        economicMatter.setName(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }else if (j == 2){
                        purpose.setCode(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }
                    else if (j == 3){
                        purpose.setName(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }
                    else if (j == 4){
                        purpose.setContent(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }else if (j == 5){
                        purpose.setIsUse(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }else if (j == 6){
                        accountSubject.setCode(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }else if (j == 7){
                        accountSubject.setName(ExcelImportUtils.getCellValue(row.getCell(j)));
                    }
                }
            }
            testEntity.setEconomicMatter(economicMatter);
            testEntity.setPurpose(purpose);
            testEntity.setAccountSubject(accountSubject);
            list.add(testEntity);
            System.out.println(JSONObject.fromObject(testEntity));
            System.out.println("-------------");
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        ExcelFile.getFromExcel();
    }

}
