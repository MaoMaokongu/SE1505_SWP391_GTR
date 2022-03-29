/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.GroupDAO;
import com.group6.capstoneprojectregistration.daos.ProjectDAO;
import com.group6.capstoneprojectregistration.daos.ProjectDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "LecturerAcceptGroupController", urlPatterns = {"/LecturerAcceptGroupController"})
public class LecturerAcceptGroupController extends HttpServlet {

    private static final String ERROR = "projectlist.jsp";
    private static final String SUCCESS = "LecturerProjectPendingController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        int groupId = Integer.parseInt(request.getParameter("groupId"));
        String projectId = request.getParameter("projectId").trim();
        GroupDAO grDao = new GroupDAO();
        ProjectDAO prDao = new ProjectDAO();
        ProjectDetailDAO pdDao = new ProjectDetailDAO();

        try {
            boolean checkDeleteProjectPending = pdDao.deleteAllProjectPendingByGroupId(groupId);
            boolean checkUpdateGroup = grDao.updateGroup(projectId, groupId);
            boolean checkUpdateProject = prDao.updateProject(projectId);
            if (checkUpdateProject && checkUpdateGroup && checkDeleteProjectPending) {
                request.setAttribute("ACCEPTED", "Accept Successful!");
                url = SUCCESS;
            } else {
                request.setAttribute("ACCEPTED", "Accept Fail!");
                url = ERROR;
            }
        } catch (Exception e) {
            log("Error at AcceptGroupController " + e.toString());
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
