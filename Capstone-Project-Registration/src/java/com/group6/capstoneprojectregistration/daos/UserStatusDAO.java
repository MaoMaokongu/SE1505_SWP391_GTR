/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.RoleDTO;
import com.group6.capstoneprojectregistration.dtos.UserStatusDTO;
import com.group6.capstoneprojectregistration.untils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author haitu
 */
public class UserStatusDAO {
    public static final String GET_STATUS=" SELECT [Status] FROM [User Status] WHERE [StatusId]=?";
    
    public UserStatusDTO getStatusById(int statusId) throws SQLException{
        UserStatusDTO status = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            String sql = GET_STATUS;
            stm = conn.prepareStatement(sql);
            stm.setInt(1, statusId);
            rs = stm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Status");
                
                status = new UserStatusDTO(statusId, name);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (rs != null) {
                rs.close();
            }
            if (stm !=null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        
        return status;
    }
}
