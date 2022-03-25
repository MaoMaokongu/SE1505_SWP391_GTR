/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.utils;

import com.group6.capstoneprojectregistration.daos.ProjectDAO;
import java.io.File;
import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

/**
 *
 * @author haitu
 */
public class ImportDocumentUtils {
    public static void ImportProjectDocument(String dataDir, String fileNameWithOutExt) throws Exception {
        ConvertDocumentToHTML(dataDir, fileNameWithOutExt);
    }
    
    private static boolean ConvertDocumentToHTML(String dataDir, String fileNameWithOutExt) throws Exception {
        //Read and Convert
        DocumentConverter converter = new DocumentConverter();
        Result<String> result = converter.convertToHtml(new File(dataDir + fileNameWithOutExt + ".docx"));
        String discription = result.getValue(); // The generated HTML
     
        ProjectDAO dao = new ProjectDAO();
        boolean check = dao.updateProjectDiscription(fileNameWithOutExt, discription);
        return check;
    }
}
