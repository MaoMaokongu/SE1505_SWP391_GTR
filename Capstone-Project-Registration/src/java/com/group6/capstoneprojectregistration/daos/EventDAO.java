/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.EventDTO;
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
public class EventDAO {

    private static final String INSERT_EVENT = " INSERT INTO [Event] (Receiver, Sender, [Event]) VALUES (?, ?, ?)";
    private static final String GET_ALL_EVENT_BY_EMAIL = " SELECT Receiver, Sender, [Event] FROM [Event] WHERE Receiver = ?";

    public List<EventDTO> getAllEventByEmail(String receiverEmail) throws SQLException {
        List<EventDTO> listEvent = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_ALL_EVENT_BY_EMAIL;
                stm = conn.prepareStatement(sql);
                stm.setString(1, receiverEmail);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String sender = rs.getString("Sender");
                    String event = rs.getString("Event");
                    MessageEventDAO meDao = new MessageEventDAO();
                    UserDAO usDao = new UserDAO();
                    listEvent.add(new EventDTO(receiverEmail, usDao.getStrUserById(sender), meDao.getMessageContentByEvent(event)));
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

        return listEvent;
    }

    public boolean insertInviteEvent(String receiverEmail, UserDTO sender) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = INSERT_EVENT;
                stm = conn.prepareStatement(sql);
                stm.setString(1, receiverEmail);
                stm.setString(2, sender.getUserId());
                stm.setString(3, "Invite");
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
}
