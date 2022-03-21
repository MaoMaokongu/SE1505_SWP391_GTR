/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.EventDAO;
import com.group6.capstoneprojectregistration.daos.InvitationPendingDAO;
import com.group6.capstoneprojectregistration.dtos.EventDTO;
import com.group6.capstoneprojectregistration.dtos.InvitationPendingDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LeaderDeleteUserPendingController", urlPatterns = {"/LeaderDeleteUserPendingController"})
public class LeaderDeleteUserPendingController extends HttpServlet {

    private static final String ERROR = "group.jsp";
    private static final String SUCCESS = "group.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        
        HttpSession session = request.getSession();
        String userInvited = request.getParameter("userInvited");
        String currentUser = request.getParameter("userId");
        
        try {
            EventDAO evDao = new EventDAO();
            InvitationPendingDAO dao = new InvitationPendingDAO();
            boolean checkDeleteEvent = evDao.deleteMessageByReceiverAndSender(userInvited, currentUser);
            boolean checkDeleteUserPending = dao.deleteUserPendingByUserInvited(userInvited);
            List<InvitationPendingDTO> listInvitationPending = dao.getUserPedingByLoginUserAndStatus(currentUser, 1);
            List<EventDTO> listEvent = evDao.getAllEventByReceiverEmail(userInvited);
            if (checkDeleteUserPending && checkDeleteEvent) {
                session.setAttribute("EVENT", listEvent);
                session.setAttribute("INVITATION", listInvitationPending);
                request.setAttribute("MESSAGE_DELETE_USER_PENDING", "Delete user pending successful");
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at LeaderDeleteUserPendingController " + e.toString());
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
