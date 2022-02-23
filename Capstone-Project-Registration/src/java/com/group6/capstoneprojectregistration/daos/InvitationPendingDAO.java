/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import com.group6.capstoneprojectregistration.dtos.UserDTO;
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
public class InvitationPendingDAO {

    private static final String INSERT_PENDING_USER = " INSERT INTO [Invitation Pending] ([Status], [User], [Group], Userinvited) VALUES (?, ?, ?, ?)";
    private static final String GET_LIST_USER_INVITED = " SELECT * FROM [User] tbl1 WHERE EXISTS(SELECT * FROM [Invitation Pending] tbl2 WHERE tbl1.Email = tbl2.UserInvited AND [Group] = ? AND [Status] = 1) AND [Group] is null";

    public boolean insertPendingUser(UserDTO user, GroupDTO group, String receiver) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = INSERT_PENDING_USER;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, 1);
                stm.setString(2, user.getUserId());
                stm.setInt(3, group.getGroupId());
                stm.setString(4, receiver);
                check = stm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public List<UserDTO> getListUserInvited(int groupId) throws SQLException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_LIST_USER_INVITED;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, groupId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userId = rs.getString("UserId");
                    String email = rs.getString("Email");
                    String userName = rs.getString("Username");
                    String gender = rs.getString("Gender");
                    int role = rs.getInt("role");
                    int group = rs.getInt("Group");
                    boolean isLeader = rs.getBoolean("IsLeader");
                    RoleDAO rlDao = new RoleDAO();
                    GroupDAO grDao = new GroupDAO();
                    listUser.add(new UserDTO(userId, email, userName, gender, rlDao.getRole(role), grDao.getGroupById(group), isLeader));
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

        return listUser;
    }
}
