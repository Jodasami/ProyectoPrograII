/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.ParkingLotBusiness;
import Data.ParkingLotData;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class SpacesTypeServlet extends HttpServlet {

    ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();

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
            out.println("<title>Servlet SpaceTypeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SpaceTypeServlet at " + request.getContextPath() + "</h1>");
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
            String id = request.getParameter("id");
            int motorcycle = Integer.parseInt(request.getParameter("motorcycle"));
            int ligthVehicles = Integer.parseInt(request.getParameter("ligthVehicles"));
            int heavyVehicles = Integer.parseInt(request.getParameter("heavyVehicles"));
            int bike = Integer.parseInt(request.getParameter("bike"));
            int other = Integer.parseInt(request.getParameter("other"));
            String vehicleTypeDisability = request.getParameter("vehicleTypeDisability");

            ParkingLot parkingLot = parkingLotBusiness.getParkingLot(id);
            Space[] spaces = new Space[parkingLot.getNumberOfSpaces()];

            //Configurar espacios para personas con discapacidad
            spaces = parkingLotBusiness.configureSpacesForDisabiltityAdaptation(spaces, parkingLot.getNumberOfSpacesWithDisabiltyAdaptation(), vehicleTypeDisability);

            int sumSpacesType = (motorcycle + ligthVehicles + heavyVehicles + bike + other);
            int standardAvailableSpaces = parkingLot.getNumberOfSpaces()-parkingLot.getNumberOfSpacesWithDisabiltyAdaptation();

            if (sumSpacesType == standardAvailableSpaces) {

                parkingLotBusiness.configureSpaces(spaces, sumSpacesType, motorcycle, ligthVehicles, heavyVehicles, bike, other);
                parkingLot.setSpaces(spaces);
                ParkingLotData.spacesParkingLots.add(Integer.parseInt(id)-1, spaces);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ParkingLot/Parking_Lot_Confirmation.jsp");
                dispatcher.forward(request, response);

            } else {

                RequestDispatcher dispacher = request.getRequestDispatcher("Spaces_Type.jsp");
                response.setHeader("error", "La cantidad de espacios que digitó sobrepasa la cantidad original");
                dispacher.forward(request, response);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpacesTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SpacesTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
