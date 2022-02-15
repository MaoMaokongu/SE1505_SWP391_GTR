/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.InvitationPendingDAO;
import com.group6.capstoneprojectregistration.daos.UserDAO;
import com.group6.capstoneprojectregistration.dtos.InvitationPendingDTO;
import com.group6.capstoneprojectregistration.dtos.UserDTO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "NoGroupStudentController", urlPatterns = {"/NoGroupStudentController"})
public class NoGroupStudentController extends HttpServlet {

    private static final String ERROR = "student_nogroup.jsp";
    private static final String SUCCESS = "student_nogroup.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;

//        String userId = request.getParameter("userid");
        HttpSession session = request.getSession();
        try {
            UserDTO user = (UserDTO)session.getAttribute("USER");
            int groupId = user.getGroup().getGroupId();
            
            //1.LIST_INVITATION_BYGROUP
            InvitationPendingDAO invitationDao = new InvitationPendingDAO();
            List<InvitationPendingDTO> listInvitation = (List<InvitationPendingDTO>) invitationDao.getAllInvitedByGroup(groupId);

            //2.LIST_NO_GROUP_USER
            UserDAO usDao = new UserDAO();
            List<UserDTO> listUser = (List<UserDTO>) usDao.getListNoGroupUser();
            //--------------------------
            if (listUser.size() > 0) {
                request.setAttribute("LIST_INVITATION_BYGROUP", listInvitation);
                request.setAttribute("LIST_NO_GROUP_USER", listUser);
                url = SUCCESS;
            } else {
                request.setAttribute("LIST_NO_GROUP_USER", "There are no students who haven't had group!");
            }

        } catch (Exception e) {
            log("Error at NoGroupUserController" + e.toString());
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
