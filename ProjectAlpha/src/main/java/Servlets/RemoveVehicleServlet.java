/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.FeeBusiness;
import Business.ParkingLotBusiness;
import Business.VehicleBusiness;
import Data.UserData;
import Domain.Fee;
import Domain.ParkingLot;
import Domain.Vehicle;
import java.io.FileNotFoundException;
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
public class RemoveVehicleServlet extends HttpServlet {

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
            out.println("<title>Servlet RemoveVehicleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveVehicleServlet at " + request.getContextPath() + "</h1>");
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
            String plate = request.getParameter("plate");

            VehicleBusiness vehicleBusiness = new VehicleBusiness();
            Vehicle vehicle = vehicleBusiness.getVehicle(plate);

            FeeBusiness feeBusiness = new FeeBusiness();
            Fee feeByVehicleType = feeBusiness.getFee(vehicle.getVehicleType().getDescription());

            String fee = vehicle.getParkingTime();
            String numParkingTime = "";
            String parkingTime = "";
            int totalAmount = 0;

            for (int i = 0; i < fee.length(); i++) {
                if (fee.contains("0123456789")) {
                    numParkingTime += fee.charAt(i);
                }
                if (fee.contains("abcdefghijklmnopqrstuvwxyz")) {
                    parkingTime += fee.charAt(i);
                }
            }

            int amountByVehicle = Integer.parseInt(feeByVehicleType.getFee());
            int feeClient = Integer.parseInt(numParkingTime);

            switch (parkingTime) {
                case "hours": {

                    totalAmount = amountByVehicle * feeClient;

                }
                case "days": {

                    int totalHours = feeClient * 24;

                    totalAmount = amountByVehicle * totalHours;

                }
                case "weeks": {

                    int totalHours = feeClient * 168;

                    totalAmount = amountByVehicle * totalHours;

                }
                case "months": {

                    int totalHours = feeClient * 730;

                    totalAmount = amountByVehicle * totalHours;

                }
                case "years": {

                    int totalHours = feeClient * 8760;

                    totalAmount = amountByVehicle * totalHours;

                }

            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pay_ParkingLot.jsp");
            request.setAttribute("fee", totalAmount);
            request.setAttribute("idParking", idParking);
            request.setAttribute("plate", plate);
            requestDispatcher.forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(RemoveVehicleServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(RemoveVehicleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            String plate = request.getParameter("plate");

            ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
            ParkingLot parkingLot = parkingLotBusiness.getParkingLot(idParking);

            VehicleBusiness vehicleBusiness = new VehicleBusiness();
            Vehicle vehicle = vehicleBusiness.getVehicle(plate);

            parkingLotBusiness.removeVehicleFromParkingLot(vehicle, parkingLot);

            if (UserData.getCurrentRoleUser().equalsIgnoreCase("admin")) {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Administrator_Menu.jsp");
                requestDispatcher.forward(request, response);
            }

            if (UserData.getCurrentRoleUser().equalsIgnoreCase("clerk")) {

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Clerk_Menu.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (FileNotFoundException | ParseException | java.text.ParseException ex) {
            Logger.getLogger(RemoveVehicleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
