/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RoleDTO;
import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import until.DBUtils;

/**
 *
 * @author admin
 */
public class UserDAO {
    
    public static final String GET_USER = " SELECT User_id, Email, Username, Gender, Role_id FROM tblUsers WHERE Email=?";
    
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
                String user_id = rs.getString("User_id");
                String mail = rs.getString("Email");
                String username = rs.getString("Username");
                String gender = rs.getString("Gender");
                int role = rs.getInt("Role_id");
                RoleDAO dao = new RoleDAO();
                user = new UserDTO(user_id, mail, username, gender, dao.getRole(role));
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
