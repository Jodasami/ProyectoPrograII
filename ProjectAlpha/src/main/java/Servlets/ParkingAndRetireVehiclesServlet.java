/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.ParkingLotBusiness;
import Business.VehicleBusiness;
import Domain.ParkingLot;
import Domain.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabio
 */
public class ParkingAndRetireVehiclesServlet extends HttpServlet {

    ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
    VehicleBusiness vehicleBusiness = new VehicleBusiness();

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
            out.println("<title>Servlet ParkingVehiclesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingVehiclesServlet at " + request.getContextPath() + "</h1>");
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
            String idParking = request.getParameter("idParking");
            //Por ahora no se ocupa la cédula, únicamente la placa ya que es única y podemos traer todo
            String idUser = request.getParameter("idUser");
            String plate = request.getParameter("plate");

            Vehicle vehicle = vehicleBusiness.getVehicle(plate);
            ParkingLot parkingLot = parkingLotBusiness.getParkingLot(idParking);

            int spaceNumber = parkingLotBusiness.parkVehicleInParkingLot(vehicle, parkingLot);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ParkingLot/Park_Vehicle_Confirmation.jsp");
            request.setAttribute("spaceNumber", spaceNumber);
            requestDispatcher.forward(request, response);

        } catch (ParseException | java.text.ParseException ex) {
            Logger.getLogger(ParkingAndRetireVehiclesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        try {
            String idParking = request.getParameter("idParking");
            //Por ahora no se ocupa la cédula, únicamente la placa ya que es única y podemos traer todo
            String idUser = request.getParameter("idUser");
            String plate = request.getParameter("plate");
            
            //Iría alguna parte del fee aquí?

            Vehicle vehicle = vehicleBusiness.getVehicle(plate);
            ParkingLot parkingLot = parkingLotBusiness.getParkingLot(idParking);

            parkingLotBusiness.removeVehicleFromParkingLot(vehicle, parkingLot);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ParkingLot/Remove_Vehicle_Confirmation.jsp");
            
            requestDispatcher.forward(request, response);

        } catch (ParseException | java.text.ParseException ex) {
            Logger.getLogger(ParkingAndRetireVehiclesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
