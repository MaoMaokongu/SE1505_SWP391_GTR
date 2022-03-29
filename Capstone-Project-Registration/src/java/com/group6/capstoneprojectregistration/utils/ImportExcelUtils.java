/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author haitu
 */
public class ImportExcelUtils {

    public static ArrayList<ArrayList<String>> ReadDataFromXLS(InputStream filecontent) throws FileNotFoundException, IOException {
        //obtaining input bytes from a file  
//        FileInputStream fis = new FileInputStream(new File(fileUrl));

        //creating workbook instance that refers to .xls file  
        HSSFWorkbook wb = new HSSFWorkbook(filecontent);
        //creating a Sheet object to retrieve the object  
        HSSFSheet sheet = wb.getSheetAt(0);
        //evaluating cell type   
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        ArrayList<ArrayList<String>> listCell = new ArrayList<>();

        for (Row row : sheet) //iteration over row using for each loop  
        {
            ArrayList<String> listRow = new ArrayList<>();
            for (Cell cell : row) //iteration over cell using for each loop  
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type  
                        //getting the value of the cell as a number  
                        listRow.add(Double.toString(cell.getNumericCellValue()));
                        break;
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                        //getting the value of the cell as a string  
                        listRow.add(cell.getStringCellValue());
                        break;
                }
            }
            listCell.add(listRow);
        }

        listCell.remove(0); //remove header of excel
        return listCell;
    }

    public static HashMap<String, ArrayList<String>> ReadDataGroupFromExcel(InputStream filecontent) throws FileNotFoundException, IOException {
        //obtaining input bytes from a file  
//        FileInputStream fis = new FileInputStream(new File(fileUrl));

        //creating workbook instance that refers to .xls file  
        HSSFWorkbook wb = new HSSFWorkbook(filecontent);
        //creating a Sheet object to retrieve the object  
        HSSFSheet sheet = wb.getSheetAt(1);
        //evaluating cell type   
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        HashMap<String, ArrayList<String>> hashStudent = new HashMap<>();
        for (Row row : sheet) //iteration over row using for each loop  
        {
            if (row.getRowNum() != 0) {
                ArrayList<String> list = new ArrayList<>();
                String key = null;
                String value = null;
                for (Cell cell : row) //iteration over cell using for each loop  
                {
                    if (cell.getColumnIndex() != 0) {
                        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type  
                                //getting the value of the cell as a number  
                                if (cell.getColumnIndex() == 1) {
                                    key = Double.toString(cell.getNumericCellValue());
                                } else {
                                    value = Double.toString(cell.getNumericCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                                //getting the value of the cell as a string  
                                if (cell.getColumnIndex() == 1) {
                                    key = cell.getStringCellValue();
                                } else {
                                    value = cell.getStringCellValue();
                                }
                                break;
                        }
                        if (value != null) {
                            list.add(value);
                        }
                    }
                }

                if (key != null && value != null) {
                    hashStudent.put(key, list);
                }

            }
        }

        return hashStudent;
    }
}
