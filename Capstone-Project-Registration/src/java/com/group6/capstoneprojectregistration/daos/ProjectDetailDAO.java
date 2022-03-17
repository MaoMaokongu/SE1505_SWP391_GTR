/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import com.group6.capstoneprojectregistration.dtos.ProjectDetailsDTO;
import com.group6.capstoneprojectregistration.untils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProjectDetailDAO {

    private static final String INSERT_PROJECT = " INSERT INTO ProjectDetail (ProjectId,GroupId) VALUES (?,?) ";
    private static final String GET_PROJECT = " SELECT ProjectId,GroupId FROM ProjectDetail WHERE ProjectId=? AND GroupId=? ";
    private static final String GET_LIST_PROJECT_PENDING = " SELECT ProjectId,GroupId FROM ProjectDetail WHERE ProjectId=? AND GroupId=? ";
    private static final String GET_LIST_PROJECT_GUIDING = " SElect p.ProjectId, g.GroupId, MentorId, IsSelected,g.Name, g.IsApproved from ProjectDetail pjd inner join Project p  on p.ProjectId=pjd.ProjectId left join [Group] g on g.GroupId = pjd.GroupId where MentorId = ? AND g.IsApproved = 1 AND p.IsSelected = 1 ";
    private static final String GET_PROJECTDETAILS_BY_MENTORID = " SElect p.ProjectId, g.GroupId, MentorId, IsSelected from ProjectDetail pjd inner join Project p  on p.ProjectId=pjd.ProjectId left join [Group] g on g.GroupId = pjd.GroupId where MentorId = ? AND IsSelected = 0  AND IsApproved = 0";
    
    
    
    public boolean insertProjectId(String projectId, int groupId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = INSERT_PROJECT;
                stm = conn.prepareStatement(sql);
                stm.setString(1, projectId);
                stm.setInt(2, groupId);
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

    public ProjectDetailsDTO getProjectDetailByGroupIdAndProjectId(int groupId, String projectId) throws SQLException {
        ProjectDetailsDTO projectDetail = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_PROJECT;
                stm = conn.prepareStatement(sql);
                stm.setString(1, projectId);
                stm.setInt(2, groupId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    ProjectDAO pdao  = new ProjectDAO();
                    GroupDAO gdao = new GroupDAO();
                    projectDetail = new ProjectDetailsDTO(pdao.getProjectById(projectId), gdao.getGroupById(groupId));
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
        return projectDetail;
    }
    public List<ProjectDetailsDTO> getProjectDetailsByMentorId(String mentorId) throws SQLException{
        List<ProjectDetailsDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null) {
                String sql = GET_PROJECTDETAILS_BY_MENTORID;
                stm = conn.prepareStatement(sql);
                stm.setString(1, mentorId);
                rs = stm.executeQuery();
                while(rs.next()){
                    String projectId = rs.getString("ProjectId");
                    int groupId = rs.getInt("GroupId");
                    String mentorID = rs.getString("MentorId");
                    ProjectDAO prjDao = new ProjectDAO();
                    GroupDAO grDao = new GroupDAO();
                    list.add(new ProjectDetailsDTO(prjDao.getProjectById(projectId), grDao.getGroupById(groupId)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
