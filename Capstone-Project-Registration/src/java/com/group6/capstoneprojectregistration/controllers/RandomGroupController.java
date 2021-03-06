/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.GroupDAO;
import com.group6.capstoneprojectregistration.daos.ProjectDAO;
import com.group6.capstoneprojectregistration.daos.UserDAO;
import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import com.group6.capstoneprojectregistration.dtos.ProjectDTO;
import com.group6.capstoneprojectregistration.dtos.UserDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "RandomGroupController", urlPatterns = {"/RandomGroupController"})
public class RandomGroupController extends HttpServlet {

    private static final String ERROR = "";
    private static final String SUCCESS = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;

        int count = 0;
        int group = 0;
        int counting = 0;
        String templateName = "GroupRandom ";

        UserDAO usDao = new UserDAO();
        GroupDAO grDao = new GroupDAO();
        ProjectDAO prDao = new ProjectDAO();

        HttpSession session = request.getSession();
        String groupname = request.getParameter("groupName");

        List<List<UserDTO>> splitStudent = (List<List<UserDTO>>) session.getAttribute("SPLIT_GROUP");
        List<ProjectDTO> listProject = (List<ProjectDTO>) session.getAttribute("SPLIT_PROJECT");
        try {
            for (List<UserDTO> listSplitStudent : splitStudent) {
                if (listSplitStudent.size() == 4) { // chia c??c th??nh vi??n th??nh c??c nh??m 4 ng?????i
                    String temp = templateName + counting; // random t??n nh??m
                    boolean checkInsertNewGroup = grDao.insertNewGroup(temp); // new group v???i t??n nh??m random
//                    ProjectDTO project = listProject.get(listProject.size() - 1);
                    List<GroupDTO> listGroup = grDao.getAllGroup(); // get all group hi???n c?? + group m???i th??m ??? b?????c tr??n

                    GroupDTO cuGroup = listGroup.get(listGroup.size() - 1); // l???y group m???i add v??o table group

                    Random rand = new Random();
                    int numberOfElements = 1;

                    for (int i = 0; i < numberOfElements; i++) {
                        int randomIndex = rand.nextInt(listProject.size());
                        ProjectDTO project = listProject.get(randomIndex);
                        boolean checkUpdateGroup = grDao.updateGroup(project.getProjectId(), cuGroup.getGroupId());
                        boolean checkUpdateProject = prDao.updateProjectIsSelected(project.getProjectId());
                        listProject.remove(randomIndex);
                        System.out.println(project);
                    }
                    counting++;
                    for (UserDTO student : listSplitStudent) { // duy???t student ch??a c?? nh??m
                        // update attribute group c???a tbl user th??nh group id c???a group m???i add
                        boolean checkUpdateGroupUser = usDao.updateGroupByUserId(student.getUserId(), cuGroup.getGroupId());

                        count++;// t??ng s??? l?????ng sinh vi??n ???? add v??o group
                        System.out.println(count);
                        if (count == 4) { // s??? l?????ng student ????? 4 th?? reset bi???n count
                            group++;
                            count = 0;
                        }
                    }
                } else {
                    System.out.println("le 1 em");
                }
            }
        } catch (Exception e) {
            log("Error at RandomGroupController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
