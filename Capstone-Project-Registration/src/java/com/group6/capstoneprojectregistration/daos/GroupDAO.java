/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import com.group6.capstoneprojectregistration.utils.DBUtils;
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
public class GroupDAO {

    private static final String INSERT = " INSERT INTO [Group] (Name, IsApproved) VALUES (?,?)";
    private static final String GET_GROUP_BY_NAME = " SELECT * FROM [Group] WHERE Name=?";
    private static final String GET_GROUP_NAME = " SELECT Name FROM [Group] WHERE GroupId=?";
    private static final String GET_LIST_PROJECT_GUIDING = " SELECT p.ProjectId, g.GroupId, MentorId,g.Name, IsSelected, g.IsApproved from ProjectDetail pjd inner join Project p  on p.ProjectId=pjd.ProjectId left join [Group] g on g.GroupId = pjd.GroupId where MentorId = ? AND g.IsApproved = 1 AND p.IsSelected = 1 ";
    private static final String GET_GROUP_BY_ID = " SELECT * FROM [Group] WHERE GroupId=?";
    private static final String CHECK_DUPLICATE = " SELECT Name FROM [Group] WHERE Name=? ";
    private static final String UPDATE_GROUP = " UPDATE [Group] SET IsApproved= ?, ProjectId = ? WHERE GroupId = ?";

    public boolean isDuplicateGroupName(String groupName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(CHECK_DUPLICATE);
                stm.setString(1, groupName);
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

    public GroupDTO getGroupById(int groupId) throws SQLException {
        GroupDTO group = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_GROUP_NAME;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, groupId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("Name");

                    group = new GroupDTO(groupId, name);
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

    public GroupDTO getGroupByName(String groupName) throws SQLException {
        GroupDTO group = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_GROUP_BY_NAME);
                stm.setString(1, groupName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int groupId = rs.getInt("GroupId");
                    boolean isApproved = rs.getBoolean("IsApproved");
                    String projectId = rs.getString("ProjectId");
                    ProjectDAO prDao = new ProjectDAO();
                    group = new GroupDTO(groupId, groupName, isApproved, prDao.getProjectById(projectId));
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

    public boolean insertGroupName(String groupName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT);
                stm.setString(1, groupName);
                stm.setBoolean(2, false);
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

    public boolean updateGroup(String projectId, int groupId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = UPDATE_GROUP;
                stm = conn.prepareStatement(sql);
                stm.setBoolean(1, true);
                stm.setString(2, projectId);
                stm.setInt(3, groupId);
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

    public GroupDTO getGroupByGroupId(int groupId) throws SQLException {
        GroupDTO group = new GroupDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_GROUP_BY_ID;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, groupId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int groupID = rs.getInt("GroupId");
                    String groupName = rs.getString("Name");
                    boolean isApproved = rs.getBoolean("IsApproved");
                    String projectId = rs.getString("ProjectId");
                    ProjectDAO prDao = new ProjectDAO();
                    group = new GroupDTO(groupId, groupName, isApproved, prDao.getProjectById(projectId));
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

    public List<GroupDTO> getListGuiding(String mentorId) throws SQLException {
        List<GroupDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_LIST_PROJECT_GUIDING;
                stm = conn.prepareStatement(sql);
                stm.setString(1, mentorId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int groupId = rs.getInt("GroupId");
                    String name = rs.getString("Name");
                    boolean isApproved = rs.getBoolean("IsApproved");
                    String projectId = rs.getString("ProjectId");
                    ProjectDAO prDao = new ProjectDAO();
                    list.add(new GroupDTO(groupId, name, isApproved, prDao.getProjectById(projectId)));
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
}
