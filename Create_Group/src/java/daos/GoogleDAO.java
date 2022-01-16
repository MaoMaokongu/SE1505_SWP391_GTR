/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.AccountGoogleDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import until.DBUtils;

/**
 *
 * @author admin
 */
public class GoogleDAO {

    public static final String REGISTER_GOOGLE = " INSERT INTO tblUsers (ID ,Email, Verified_email, Picture) VALUES(?,?,?,?)";
    public static final String CHECK_GOOGLE = " SELECT * FROM tblUsers WHERE email=?";

    public boolean register(String id, String email, boolean verified_email, String picture) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = REGISTER_GOOGLE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, email);
            stm.setBoolean(3, true);
            stm.setString(4, picture);
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

    public AccountGoogleDAO checklogin(String email) throws SQLException {

        AccountGoogleDAO gg = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = CHECK_GOOGLE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("ID");
                boolean verified_email = rs.getBoolean("Verified_email");
                String name = rs.getString("Name");
                String given_name = rs.getString("given_name");
                String family_name = rs.getString("family_name");
                String picture = rs.getString("picture");

                gg = new AccountGoogleDAO(id, email, verified_email, name, given_name, family_name, picture);
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
        return gg;
    }
}
