/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.ProjectDTO;
import com.group6.capstoneprojectregistration.untils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProjectDAO {

    private static final String GET_LIST_PROJECT = " SELECT * FROM Project";

    public List<ProjectDTO> getListProject() throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            SemesterDAO dao = new SemesterDAO();
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_LIST_PROJECT;
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String projectId = rs.getString("ProjectId");
                    String name = rs.getString("Name");
                    String mentor = rs.getString("Mentor");
                    String coMentor = rs.getString("Co-Mentor");
                    int num = rs.getInt("NumOfStus");
                    boolean isSelected = rs.getBoolean("IsSelected");
                    String discription = rs.getString("Discription");
                    int semester = rs.getInt("Semester");
                    list.add(new ProjectDTO(projectId, name, mentor, coMentor, num, isSelected,
                            discription, dao.getSemesterById(semester)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }
}
