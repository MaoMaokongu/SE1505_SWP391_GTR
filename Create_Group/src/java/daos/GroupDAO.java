/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.GroupDTO;
import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import until.DBUtils;

/**
 *
 * @author admin
 */
public class GroupDAO {

    private static final String INSERT = " INSERT INTO tblGroups (Group_name) VALUES (?)";
    private static final String GET_ID = " SELECT Group_id FROM tblGroups WHERE Group_name=?";
    private static final String GET_GROUP_NAME = " SELECT Group_name FROM tblGroups WHERE Group_id=?";
    private static final String CHECK_DUPLICATE = " SELECT Group_name FROM tblGroups WHERE Group_name=? ";


    public boolean checkDuplicate(String group_name) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(CHECK_DUPLICATE);
                stm.setString(1, group_name);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public GroupDTO getGroupById(int group_id) throws SQLException {
        GroupDTO group = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_GROUP_NAME;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, group_id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String group_name = rs.getString("Group_name");

                    group = new GroupDTO(group_id, group_name);
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

        return group;
    }

    public GroupDTO getGroupByName(String group_name) throws SQLException {
        GroupDTO group = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_ID);
                stm.setString(1, group_name);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int group_id = rs.getInt("Group_id");
                    group = new GroupDTO(group_id, group_name);
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

        return group;
    }

    public boolean insert_GroupName(String group_name) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT);
                stm.setString(1, group_name);
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
