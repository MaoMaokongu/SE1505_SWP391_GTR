/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RoleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import until.DBUtils;

/**
 *
 * @author admin
 */
public class RoleDAO {

    public static final String GET_ROLE = " SELECT Role_Name FROM tblRole WHERE Role_id=?";

    public RoleDTO getRole(int role_id) throws SQLException {
        RoleDTO role = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_ROLE;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, role_id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String role_name = rs.getString("Role_Name");

                    role = new RoleDTO(role_id, role_name);
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

        return role;
    }
}
