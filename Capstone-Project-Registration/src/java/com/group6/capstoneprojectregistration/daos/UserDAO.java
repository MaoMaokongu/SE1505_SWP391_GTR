/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.UserDTO;
import com.group6.capstoneprojectregistration.untils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class UserDAO {
    
    public static final String GET_USER = " SELECT UserId, Email, Username, Gender, Role, Isleader, HasGroup FROM [User] WHERE Email = ?";
    
    public UserDTO getUser (String email) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            String sql = GET_USER;
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            if (rs.next()) {
                String userId = rs.getString("UserId");
                String mail = rs.getString("Email");
                String userName = rs.getString("Username");
                String gender = rs.getString("Gender");
                int role = rs.getInt("Role");
                RoleDAO dao = new RoleDAO();
                boolean isLeader = rs.getBoolean("Isleader");
                boolean hasGroup = rs.getBoolean("HasGroup");
                user = new UserDTO(userId, mail, userName, gender, dao.getRole(role), isLeader,hasGroup);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (rs!=null) {
                rs.close();
            }
            if (stm!=null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return user;
    }
}
