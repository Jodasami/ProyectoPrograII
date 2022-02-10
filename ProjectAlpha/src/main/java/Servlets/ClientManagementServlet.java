/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.UserBusiness;
import Business.VehicleBusiness;
import Domain.User;
import Domain.Vehicle;
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
@WebServlet(name = "UserManagementServlet", urlPatterns = {"/UserManagementServlet"})
public class ClientManagementServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UserBusiness userBusiness;
    VehicleBusiness vehicleBusiness = new VehicleBusiness();

    @Override
    public void init()
            throws ServletException {

        userBusiness = new UserBusiness();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserManagementServlet at " + request.getContextPath() + "</h1>");
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

        try{

                String userUsername = userBusiness.getCurrentUser();
                
                //if para verificar si tiene un carro registrado y eliminarlo
        
                Vehicle vehicle = vehicleBusiness.getVehicleByCustomerUsername(userUsername);
                if(vehicle==null){
                     userBusiness.deleteUser(userUsername);
                }else{
                    vehicleBusiness.deleteVehicle(vehicle.getPlate());
                    userBusiness.deleteUser(userUsername);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/User/DeleteUser_Confirmation.jsp");
                dispatcher.forward(request, response);

            
        } catch (ParseException | IOException | ServletException | java.text.ParseException ex) {
            Logger.getLogger(ClientManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        try {
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String phone = request.getParameter("phone");
            String username = userBusiness.getCurrentUser();
            String password = request.getParameter("password");
            String checkbox = request.getParameter("disabilityPresented");
            boolean disabilityPresented = checkboxToString(checkbox);

            User user = new User(name, id, phone, username, password, disabilityPresented);

            userBusiness.modifyUser(username, user);
            
            User getCustomerRole = userBusiness.getUser(username);
            
            if(getCustomerRole.getRole().equalsIgnoreCase("customer")){
                
            RequestDispatcher dispatcher = request.getRequestDispatcher("/User/ModifyUser_Confirmation.jsp");
            dispatcher.forward(request, response);
            
            }
            
             if(getCustomerRole.getRole().equalsIgnoreCase("clerk")){
                
            RequestDispatcher dispatcher = request.getRequestDispatcher("/User/Clerk_Confirmation.jsp");
            dispatcher.forward(request, response);
            
            }
             
              if(getCustomerRole.getRole().equalsIgnoreCase("admin")){
                
            RequestDispatcher dispatcher = request.getRequestDispatcher("/User/Admin_Confirmation.jsp");
            dispatcher.forward(request, response);
            
            }

        } catch (ParseException | IOException | ServletException | java.text.ParseException ex) {
            Logger.getLogger(ClientManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
