/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.UserBusiness;
import Business.VehicleBusiness;
import Domain.User;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author jodas
 */
@WebServlet(name = "VehicleInfoServlet", urlPatterns = {"/VehicleInfoServlet"})
public class VehicleInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    UserBusiness userBusiness = new UserBusiness();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        String vehicle = request.getParameter("vehicleType");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<i><font color=blue size=4>"+vehicle+"</font></i>");
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
             
            String plate = request.getParameter("plate");
            String color = request.getParameter("color");
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            String username = userBusiness.getCurrentLoggedUser();
            String vT = request.getParameter("vehicleType");
            // Obtener valor del Select
            //Temporal
            UserBusiness userBusiness = new UserBusiness();
            VehicleBusiness vehicleBusiness = new VehicleBusiness();
            //REVISAR
            User owner = userBusiness.getUser(username);
            VehicleType vehicleType = vehicleBusiness.getVechileType(vT);
            
            Vehicle vehicle = new Vehicle(plate, color, brand, model, owner, vehicleType);
            
            
            String success = vehicleBusiness.insertVehicle(vehicle);
            if (success.equals("yes")) {
            
                RequestDispatcher dispacher = request.getRequestDispatcher("/Vehicle/Vehicle_Confirmation.jsp");
                dispacher.forward(request, response);
            } else {
               
                RequestDispatcher dispacher = request.getRequestDispatcher("Create_Vehicle.jsp");
                response.setHeader("error", "Vehículo duplicado");
                dispacher.forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String action = request.getParameter("action");
        
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
