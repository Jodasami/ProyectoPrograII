/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.UserBusiness;
import Domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio
 */
public class UserInfoServlet extends HttpServlet {

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
            out.println("<title>Servlet UserInfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserInfoServlet at " + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public boolean checkboxToString(String checkbox) {
        boolean disabilityPresented;
        if (checkbox==null) {
            disabilityPresented = false;
        } else {
            disabilityPresented = true;
        }
        return disabilityPresented;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            UserBusiness userBusiness = new UserBusiness();
            User currentUser =userBusiness.getUser(userBusiness.getCurrentUser());
            if(currentUser.getRole().equalsIgnoreCase("clerk")||currentUser.getRole().equalsIgnoreCase("admin")){
            
            }
            
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String phone = request.getParameter("phone");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String checkbox = request.getParameter("disabilityPresented");
            boolean disabilityPresented = checkboxToString(checkbox);
            String userRole="customer";

            User user = new User(name, id, phone, username, password, disabilityPresented,userRole);
            
            
            String success = userBusiness.insertUser(user);
            
            if(currentUser.getRole().equalsIgnoreCase("clerk")){
                if (success.equals("yes")) {
                RequestDispatcher dispacher = request.getRequestDispatcher("/User/Clerk_Confirmation.jsp");
                dispacher.forward(request, response);
            } else {
                RequestDispatcher dispacher = request.getRequestDispatcher("Register_Client.jsp");
                response.setHeader("error", "Cliente duplicado");
                dispacher.forward(request, response);
            }
            }
            if(currentUser.getRole().equalsIgnoreCase("customer")){
            if (success.equals("yes")) {
                RequestDispatcher dispacher = request.getRequestDispatcher("/User/User_Confirmation.jsp");
                dispacher.forward(request, response);
            } else {
                RequestDispatcher dispacher = request.getRequestDispatcher("Register_Client.jsp");
                response.setHeader("error", "Cliente duplicado");
                dispacher.forward(request, response);
            }
            }
            if(currentUser.getRole().equalsIgnoreCase("admin")){
                if (success.equals("yes")) {
                RequestDispatcher dispacher = request.getRequestDispatcher("/User/Admin_Confirmation.jsp");
                dispacher.forward(request, response);
            } else {
                RequestDispatcher dispacher = request.getRequestDispatcher("Register_Client.jsp");
                response.setHeader("error", "Cliente duplicado");
                dispacher.forward(request, response);
            }
            }
        } catch (ServletException | IOException | org.json.simple.parser.ParseException | ParseException ex) {
            Logger.getLogger(UserInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        UserBusiness userBusiness = new UserBusiness();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        

        try {
            user = userBusiness.getUser(username, password);
            //verifica que se encontró el cliente y por ende, tiene un nombre
            if (!user.getName().equals("")&&user.getRole().equals("customer")) {
            //Aviso de que inicio sesión correctamente
                userBusiness.setCurrentUser(username);
                RequestDispatcher dispacher = request.getRequestDispatcher("Client_Menu.jsp");
                //response.setHeader("name", user.getName());
                dispacher.forward(request, response);
            }
            if (!user.getName().equals("")&&user.getRole().equals("admin")) {
            //Aviso de que inicio sesión correctamente
                userBusiness.setCurrentUser(username);
                RequestDispatcher dispacher = request.getRequestDispatcher("Administrator_Menu.jsp");
                //response.setHeader("name", customer.getName());
                dispacher.forward(request, response);
            }
            if (!user.getName().equals("")&&user.getRole().equals("clerk")) {
            //Aviso de que inicio sesión correctamente
                userBusiness.setCurrentUser(username);
                RequestDispatcher dispacher = request.getRequestDispatcher("Clerk_Menu.jsp");
                //response.setHeader("name", customer.getName());
                dispacher.forward(request, response);
            }

        } catch (ParseException | IOException | ServletException | org.json.simple.parser.ParseException ex) {
            //ToDo: qué hago?
            Logger.getLogger(UserInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
 

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
