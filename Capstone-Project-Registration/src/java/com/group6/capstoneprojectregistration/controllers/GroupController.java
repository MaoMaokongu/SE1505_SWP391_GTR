/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.controllers;

import com.group6.capstoneprojectregistration.daos.GroupDAO;
import com.group6.capstoneprojectregistration.daos.UserDAO;
import com.group6.capstoneprojectregistration.dtos.GroupDTO;
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
// Hiển thị list sinh viên theo group id
@WebServlet(name = "GroupController", urlPatterns = {"/GroupController"})
public class GroupController extends HttpServlet {

    private static final String ERROR = "studentgroup.jsp";
    private static final String SUCCESS = "studentgroup.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        String groupName = request.getParameter("groupName");
        //String email = request.getParameter("email");
        try {

            if (!groupName.equals("")) {
                GroupDAO grDao = new GroupDAO();
                GroupDTO group = grDao.getGroupByName(groupName);

                UserDAO usDao = new UserDAO();
                //UserDTO user = usDao.getUserByEmail(email);
                List<UserDTO> listUser = usDao.getListUserByGroupId(group.getGroupId());
                HttpSession session = request.getSession();
//                List<UserDTO> listUser1 = (List<UserDTO>) session.getAttribute("LIST_USER_IN_GROUP");
                if (listUser.size() > 0) {
                    session.setAttribute("LIST_USER_IN_GROUP", listUser);
                    url = SUCCESS;
                }
            } else{
                url = ERROR;
            }

        } catch (Exception e) {
            log("Error at GroupController" + e.toString());
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
