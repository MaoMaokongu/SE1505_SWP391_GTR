/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.EventDAO;
import com.group6.capstoneprojectregistration.daos.GroupDAO;
import com.group6.capstoneprojectregistration.daos.InvitationPendingDAO;
import com.group6.capstoneprojectregistration.daos.UserDAO;
import com.group6.capstoneprojectregistration.dtos.GroupDTO;
import com.group6.capstoneprojectregistration.dtos.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
// Khi leader click invite 1 sinh vien tren danh sach
// 
@WebServlet(name = "InviteUserController", urlPatterns = {"/InviteUserController"})
public class InviteUserController extends HttpServlet {

    private static final String ERROR = "student_nogroup.jsp";
    private static final String SUCCESS = "student_nogroup.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;

        String receiverEmail = request.getParameter("receiver_email");
        String senderEmail = request.getParameter("sender_email");
        String groupName = request.getParameter("group_name");

        UserDAO usDao = new UserDAO();
        GroupDAO grDao = new GroupDAO();
        InvitationPendingDAO peDao = new InvitationPendingDAO();
        EventDAO evDao = new EventDAO();

        try {
            UserDTO sender = usDao.getUserByEmail(senderEmail);
            GroupDTO group = grDao.getGroupByName(groupName);
            boolean checkUserPending = peDao.insertPendingUser(sender, group);
//          UserDTO receiver = usDao.getUserByEmail(receiverEmail);
            boolean checkInviteEvent = evDao.insertInviteEvent(receiverEmail, sender);

            if (checkUserPending && checkInviteEvent) {
                request.setAttribute("INVITE", "Invite successfully!");
                url = SUCCESS;
            } else {
                request.setAttribute("INVITE", "Invitation failed!");
                url = ERROR;
            }
        } catch (Exception e) {
            log("Error at PendingController" + e.toString());
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
