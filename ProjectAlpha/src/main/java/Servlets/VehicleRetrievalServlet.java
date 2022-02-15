/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.UserBusiness;
import Business.VehicleBusiness;
import Data.VehicleData;
import Domain.User;
import Domain.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
@WebServlet(name = "VehicleRetrievalServlet", urlPatterns = {"/VehicleRetrievalServlet"})
public class VehicleRetrievalServlet extends HttpServlet {

    UserBusiness userBusiness;
    VehicleBusiness vehicleBusiness;
    LinkedList<Vehicle> vehicles;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vehicleRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vehicleRetrievalServlet at " + request.getContextPath() + "</h1>");
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
    public void init()
            throws ServletException {

        userBusiness = new UserBusiness();
        vehicleBusiness = new VehicleBusiness();
        vehicles = new LinkedList<>();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = request.getParameter("action");
            String vehiclePlate = request.getParameter("vehiclePlate");
//            userBusiness.setCurrentUser(vehiclePlate);

            if (action.equalsIgnoreCase("delete")) {
                
                vehicleBusiness.deleteVehicle(vehiclePlate);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Vehicles/DeleteVehicle_Confirmation.jsp");
                dispatcher.forward(request, response);

            } else if (action.equalsIgnoreCase("edit")) {
                
                VehicleData.setCurrentVehiclePlate(vehiclePlate);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Modify_Vehicle.jsp");
                dispatcher.forward(request, response);

            }

        } catch (ParseException | IOException | ServletException | java.text.ParseException ex) {
            Logger.getLogger(AdminRetrievalServlet.class.getName()).log(Level.SEVERE, null, ex);
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
