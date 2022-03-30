/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.daos;

import com.group6.capstoneprojectregistration.dtos.ProjectDTO;
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
public class ProjectDAO {

    private static final String GET_LIST_PROJECT = " SELECT * FROM Project";
    private static final String GET_PROJECT_BY_NAME = " SELECT * FROM Project WHERE Name = ?";
    private static final String GET_PROJECT_BY_ID = " SELECT * FROM Project WHERE ProjectId = ?";
    private static final String GET_TOTAL_PROJECT = " SELECT count(*) FROM Project";
    private static final String UPDATE_PROJECT = " UPDATE Project SET IsSelected = ? WHERE ProjectId =?";
    private static final String GET_LIST_BY_MENTOR = " SELECT * FROM Project WHERE MentorId = ?";
    private static final String GET_PAGING_PROJECT = " SELECT * FROM Project WHERE IsSelected = 0 "
            + " ORDER BY ProjectId "
            + " OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
    private static final String GET_PROJECT_BY_MENTOR_ID = " Select * \n"
            + "from Project p join [Group] g\n"
            + "on p.ProjectId = g.ProjectId\n"
            + "Where MentorId = ?";

    public List<ProjectDTO> getProjectByMentorId(String mentorId) throws SQLException {
        List<ProjectDTO> project = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_PROJECT_BY_MENTOR_ID;
                stm = conn.prepareStatement(sql);
                stm.setString(1, mentorId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String projectId = rs.getString("ProjectId");
                    String projectName = rs.getString("Name");
                    project.add(new ProjectDTO(projectId, projectName));
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

        return project;
    }

    public ProjectDTO getProject(String projectName) throws SQLException {
        ProjectDTO project = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_PROJECT_BY_NAME;
                stm = conn.prepareStatement(sql);
                stm.setString(1, projectName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String projectId = rs.getString("ProjectId");
                    String projectMentor = rs.getString("MentorId");
                    String projectCoMentor = rs.getString("Co-Mentor");
                    int projectNumOfStudent = rs.getInt("NumOfStus");
                    boolean isSelected = rs.getBoolean("IsSelected");
                    String discription = rs.getString("Discription");
                    int semester = rs.getInt("semester");
                    SemesterDAO seDao = new SemesterDAO();
                    UserDAO usDao = new UserDAO();
                    project = new ProjectDTO(projectId, projectName, usDao.getUserById(projectMentor), projectCoMentor, projectNumOfStudent, isSelected, discription, seDao.getSemesterById(semester));
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

        return project;
    }

    public List<ProjectDTO> getListProject() throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            SemesterDAO dao = new SemesterDAO();
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_LIST_PROJECT;
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String projectId = rs.getString("ProjectId");
                    String name = rs.getString("Name");
                    String mentor = rs.getString("MentorId");
                    String coMentor = rs.getString("Co-Mentor");
                    int num = rs.getInt("NumOfStus");
                    boolean isSelected = rs.getBoolean("IsSelected");
                    String discription = rs.getString("Discription");
                    int semester = rs.getInt("Semester");
                    UserDAO usDao = new UserDAO();
                    list.add(new ProjectDTO(projectId, name, usDao.getUserById(mentor), coMentor, num, isSelected,
                            discription, dao.getSemesterById(semester)));
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

    public int getTotalProject() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(GET_TOTAL_PROJECT);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<ProjectDTO> pagingProject(int index) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        SemesterDAO dao = new SemesterDAO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {

                stm = conn.prepareStatement(GET_PAGING_PROJECT);
                stm.setInt(1, (index - 1) * 10);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String projectId = rs.getString("ProjectId");
                    String name = rs.getString("Name");
                    String mentor = rs.getString("MentorId");
                    String coMentor = rs.getString("Co-Mentor");
                    int num = rs.getInt("NumOfStus");
                    boolean isSelected = rs.getBoolean("IsSelected");
                    String discription = rs.getString("Discription");
                    int semester = rs.getInt("Semester");
                    UserDAO usDao = new UserDAO();
                    list.add(new ProjectDTO(projectId, name, usDao.getUserById(mentor), coMentor, num, isSelected,
                            discription, dao.getSemesterById(semester)));
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

    public ProjectDTO getProjectById(String projectId) throws SQLException {
        ProjectDTO project = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_PROJECT_BY_ID;
                stm = conn.prepareStatement(sql);
                stm.setString(1, projectId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String projectName = rs.getString("Name");
                    String projectMentor = rs.getString("MentorId");
                    String projectCoMentor = rs.getString("Co-Mentor");
                    int projectNumOfStudent = rs.getInt("NumOfStus");
                    boolean isSelected = rs.getBoolean("IsSelected");
                    String discription = rs.getString("Discription");
                    int semester = rs.getInt("semester");
                    SemesterDAO seDao = new SemesterDAO();
                    UserDAO usDao = new UserDAO();
                    project = new ProjectDTO(projectId, projectName, usDao.getUserById(projectMentor), projectCoMentor, projectNumOfStudent, isSelected, discription, seDao.getSemesterById(semester));
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

        return project;
    }

    public List<ProjectDTO> getListByMentor(String mentor) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_LIST_BY_MENTOR;
                stm = conn.prepareStatement(sql);
                stm.setString(1, mentor);
                rs = stm.executeQuery();
                while (rs.next()) {

                    String projectId = rs.getString("ProjectId");
                    String projectName = rs.getString("Name");
                    String projectMentor = rs.getString("MentorId");
                    String projectCoMentor = rs.getString("Co-Mentor");
                    int projectNumOfStudent = rs.getInt("NumOfStus");
                    boolean isSelected = rs.getBoolean("IsSelected");
                    String discription = rs.getString("Discription");
                    int semester = rs.getInt("semester");
                    SemesterDAO seDao = new SemesterDAO();
                    UserDAO usDao = new UserDAO();
                    list.add(new ProjectDTO(projectId, projectName, usDao.getUserById(projectMentor), projectCoMentor, projectNumOfStudent, isSelected, discription, seDao.getSemesterById(semester)));
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

    public boolean updateProject(String projectId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = UPDATE_PROJECT;
                stm = conn.prepareStatement(sql);
                stm.setBoolean(1, true);
                stm.setString(2, projectId);
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
