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
public class UserDAO {

    public static final String GET_USER = " SELECT User_id, Email, Username, Gender, Role_id, Group_id, leader FROM tblUsers WHERE Email=?";
    public static final String UPDATE_GROUP_ID = " UPDATE tblUsers SET Group_id = ?, leader =? WHERE Email =?";
    private static final String GET_USERS = " SELECT User_id, Email, Username, Gender, Role_id, leader FROM tblUsers WHERE Group_id=?";

    public List<UserDTO> getUsersByGroupID(int group_id) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_USERS;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, group_id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("User_id");
                    String email = rs.getString("Email");
                    String username = rs.getString("Username");
                    String gender = rs.getString("Gender");
                    int role_id = rs.getInt("Role_id");
                    boolean leader = rs.getBoolean("leader");
                    RoleDAO dao = new RoleDAO();
                    GroupDAO grdao = new GroupDAO();
                    list.add(new UserDTO(id, email, username, gender, dao.getRole(role_id), grdao.getGroupById(group_id), leader));
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

    public boolean UpdateUser(GroupDTO group, UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(UPDATE_GROUP_ID);
            stm.setInt(1, group.getGroup_id());
            stm.setBoolean(2, true);
            stm.setString(3, user.getEmail());
            check = stm.executeUpdate() > 0 ? true : false;
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

    public boolean UpdateUser_normal(GroupDTO group, UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(UPDATE_GROUP_ID);
            stm.setInt(1, group.getGroup_id());
            stm.setBoolean(2, false);
            stm.setString(3, user.getEmail());
            System.out.println(group.getGroup_id());
            check = stm.executeUpdate() > 0 ? true : false;
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

    public UserDTO getUser(String email) throws SQLException {
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
                String user_id = rs.getString("User_id");
                String username = rs.getString("Username");
                String gender = rs.getString("Gender");
                int role = rs.getInt("Role_id");
                int groupid = rs.getInt("Group_id");
                boolean leader = rs.getBoolean("leader");
                RoleDAO dao = new RoleDAO();
                GroupDAO grdao = new GroupDAO();
                user = new UserDTO(user_id, email, username, gender, dao.getRole(role), grdao.getGroupById(groupid), leader);
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

        return user;
    }
}
