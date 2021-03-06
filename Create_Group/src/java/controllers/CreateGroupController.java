/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GroupDAO;
import daos.UserDAO;
import dtos.GroupDTO;
import dtos.UserDTO;
import java.io.IOException;
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
@WebServlet(name = "CreateGroupController", urlPatterns = {"/CreateGroupController"})
public class CreateGroupController extends HttpServlet {

    public static final String ERROR = "createGroup.jsp";
    public static final String SUCCESS = "student.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {

            String groupname = request.getParameter("group_name");
            String email = request.getParameter("email");

            UserDAO userdao = new UserDAO();
            UserDTO user = userdao.getUser(email);

            GroupDAO grdao = new GroupDAO();

            if (user.getGroup_id() != null) {
                request.setAttribute("BUG", "Co nhom roi kia !, dang ky gi nua @@");
            } else {
                boolean checkDuplicate = grdao.checkDuplicate(groupname);
                if (checkDuplicate) {
                    request.setAttribute("BUG", "Ten nhom da ton tai!");
                } else {
                    //Insert group name user mới tạo
                    boolean checkInsert_name = grdao.insert_GroupName(groupname);
                    //Get group mới thêm
                    GroupDTO group = grdao.getGroupByName(groupname);
                    //Update group id và leader cho user tạo group
                    boolean checkInsert_id = userdao.UpdateUser(group, userdao.getUser(email));
                    //Lấy session để update attribute USER mới
                    HttpSession session = request.getSession();
                    if (checkInsert_name && checkInsert_id) {
                        //Đẩy user mới update lên lại session
                        user = userdao.getUser(email);
                        session.setAttribute("USER", user);
                        //-----------------------------------------
                        request.setAttribute("SUCCESS", "Tao nhom thanh cong!");
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "Khong Insert duoc kia!");
                    }
                }
            }
        } catch (Exception e) {
            log("Error at CreateGroupController: " + e.toString());
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
