/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.EventDAO;
import com.group6.capstoneprojectregistration.daos.GroupDAO;
import com.group6.capstoneprojectregistration.daos.InvitationPendingDAO;
import com.group6.capstoneprojectregistration.daos.MessageEventDAO;
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

    private static final String URL = "NoGroupStudentController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = URL;

        String receiverEmail = request.getParameter("receiver_email");
        String senderEmail = request.getParameter("sender_email");
        String groupName = request.getParameter("group_name");

        UserDAO usDao = new UserDAO();
        GroupDAO grDao = new GroupDAO();
        InvitationPendingDAO peDao = new InvitationPendingDAO();
        EventDAO evDao = new EventDAO();
        MessageEventDAO meDao = new MessageEventDAO();

        try {
            UserDTO sender = usDao.getUserByEmail(senderEmail);
            GroupDTO group = grDao.getGroupByName(groupName);
            boolean checkUserPending = peDao.insertPendingUser(sender, group, receiverEmail);
//          UserDTO receiver = usDao.getUserByEmail(receiverEmail);
            boolean checkInviteEvent = evDao.insertInviteEvent(receiverEmail, sender);
//            EventDTO event = evDao.getEventOf(receiverEmail, sender, null);
//            List<EventDTO> listEvent = evDao.getAllEventByReceiverEmail(receiverEmail);
//            
//            System.out.println(event);
//            System.out.println(listEvent);
//            listEvent.hashCode();
//            listEvent.equals(event);
//            System.out.println(listEvent.hashCode());
//           boolean check = listEvent.contains(event);
//            
//           Set<EventDTO> intersect = new HashSet<>(event);
//            intersect.retainAll(listEvent);
//           System.out.println(intersect.size());
//           System.out.println(intersect);
//            
//            if (listEvent.contains(event)) {
//                request.setAttribute("INVITE", "Mời rồi mời gì nữa 3!");
//                url = ERROR;
//            } else 

            if (checkUserPending && checkInviteEvent) {
                request.setAttribute("INVITE", "Invite successfully!");
            } else {
                request.setAttribute("INVITE", "Invitation failed!");
            }
        } catch (Exception e) {
            log("Error at PendingController" + e.toString());
        } finally {
            response.sendRedirect(url);
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
