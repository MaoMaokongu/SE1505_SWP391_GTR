/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.utils;

import com.group6.capstoneprojectregistration.daos.GroupDAO;
import com.group6.capstoneprojectregistration.daos.ProjectDAO;
import com.group6.capstoneprojectregistration.daos.UserDAO;
import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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

     public static void ImportProject(InputStream inputStream) throws IOException, SQLException {
        ProjectDAO projectDao = new ProjectDAO();
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);

        //1/3 Create Project
        ArrayList<ArrayList<String>> list = ImportExcelUtils.ReadDataFromXLS(wb);

        for (ArrayList<String> project : list) {
            boolean checkInsertProject = projectDao.insert(project);
        }
    }
    
    public static void ImportStudent(InputStream inputStream) throws IOException, SQLException {
        UserDAO userDao = new UserDAO();
        GroupDAO groupDao = new GroupDAO();
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);

        //1/3 Create Students
        ArrayList<ArrayList<String>> list = ImportExcelUtils.ReadDataFromXLS(wb);

        for (ArrayList<String> student : list) {
            boolean checkInsertStudent = userDao.insert(student);
        }

        //groups
        HashMap<String, ArrayList<String>> hashGroup = ImportExcelUtils.ReadDataGroupFromExcel(wb);

        for (HashMap.Entry<String, ArrayList<String>> set : hashGroup.entrySet()) {
            //2/3 CreateGroup
            String groupName = set.getKey();
            boolean checkInsertGroup = groupDao.insertGroupName(groupName);
            //  if (checkGroupInsert == true) {
            //
            //     }

            GroupDTO group = groupDao.getGroupByName(groupName);
            //3/3 Update group's student
            ArrayList<String> students = set.getValue();
            int i = 0; //for count who is leader
            boolean isLeader = false;
            for (String studentId : students) {
                if (i == 0) {
                    isLeader = true;
                } else {
                    isLeader = false;
                }
                boolean checkUpdateGroup = userDao.updateGroupFromExcel(studentId, group, isLeader);
                i++;
                // if (checkGroupUpdate == true) {
                //
                // }
            }
        }
    }

    private static ArrayList<ArrayList<String>> ReadDataFromXLS(HSSFWorkbook wb) throws FileNotFoundException, IOException {
        //obtaining input bytes from a file  
//        FileInputStream fis = new FileInputStream(new File(fileUrl));

        //creating workbook instance that refers to .xls file  
        // HSSFWorkbook wb = new HSSFWorkbook(filecontent);
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

        wb.close();
        listCell.remove(0); //remove header of excel
        return listCell;
    }

    private static HashMap<String, ArrayList<String>> ReadDataGroupFromExcel(HSSFWorkbook wb) throws FileNotFoundException, IOException {
        //obtaining input bytes from a file  
//        FileInputStream fis = new FileInputStream(new File(fileUrl));

        //creating workbook instance that refers to .xls file  
        //HSSFWorkbook wb = new HSSFWorkbook(filecontent);
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

        wb.close();
        return hashStudent;
    }

}
