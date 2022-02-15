/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import com.group6.capstoneprojectregistration.dtos.InvitationPendingDTO;
import com.group6.capstoneprojectregistration.dtos.UserDTO;
import com.group6.capstoneprojectregistration.dtos.UserStatusDTO;
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
    private static final String GET_LIST_INVITATION_BY_GROUP_ID = " SELECT * FROM [Invitation Pending] WHERE [Group] = ?";

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

    public List<InvitationPendingDTO> getAllInvitedByGroup(int groupId) throws SQLException {
        List<InvitationPendingDTO> listInvitation = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_LIST_INVITATION_BY_GROUP_ID;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, groupId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    int statusId = rs.getInt("Status");
                    String userId = rs.getString("User");
                    String userInvited = rs.getString("UserInvited");

                    UserStatusDAO statusDao = new UserStatusDAO();
                    UserDAO userDao = new UserDAO();
                    GroupDAO grDao = new GroupDAO();

                    listInvitation.add(new InvitationPendingDTO(statusDao.getStatusById(statusId), userDao.getStrUserById(userId), grDao.getGroupById(groupId), userInvited));
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

        return listInvitation;
    }
}
