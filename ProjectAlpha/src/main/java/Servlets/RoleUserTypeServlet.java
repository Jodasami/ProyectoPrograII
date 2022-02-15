/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.UserBusiness;
import Data.UserData;
import Domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabio
 */
@WebServlet(name = "RoleUserTypeServlet", urlPatterns = {"/RoleUserTypeServlet"})
public class RoleUserTypeServlet extends HttpServlet {

    UserBusiness userBusiness = new UserBusiness();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RoleUserTypeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoleUserTypeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            //Valida redirección a la hora de eliminar un usuario

            User user = userBusiness.getUser(UserData.getCurrentUsername());

            if (user.getRole().equalsIgnoreCase("admin")) {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Show_Users_Admin.jsp");
                requestDispatcher.forward(request, response);
            }
            if (user.getRole().equalsIgnoreCase("clerk")) {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Show_Users_Clerk.jsp");
                requestDispatcher.forward(request, response);
            }
            if (user.getRole().equalsIgnoreCase("customer")) {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Client_Menu.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (ParseException ex) {
            Logger.getLogger(RoleUserTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(RoleUserTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        //Modificar
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
