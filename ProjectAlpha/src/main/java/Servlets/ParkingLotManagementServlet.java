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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class ParkingLotManagementServlet extends HttpServlet {

    ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
    LinkedList<ParkingLot> parkingLots;

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
            out.println("<title>Servlet ParkingLotManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingLotManagementServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //Viene el href de ShowParkingLots para traer los datos
        
         try {
            
            parkingLots = parkingLotBusiness.getAllparkingLots();
                   
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Show_Parking_Lots.jsp");
            request.setAttribute("parkingLots", parkingLots);
            requestDispatcher.forward(request, response);
            
        } catch (ParseException ex) {
            Logger.getLogger(VehicleShowManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int numberOfSpaces = Integer.parseInt(request.getParameter("numberOfSpaces"));
            int numberOfSpacesWithDisabiltyAdaptation = Integer.parseInt(request.getParameter("numberOfSpacesWithDisabiltyAdaptation"));

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            ParkingLotData.parkingLotsVehicles.add(Integer.parseInt(id), vehicles);
            Space[] spaces = new Space[numberOfSpaces];
            spaces = parkingLotBusiness.configureSpaces(spaces, numberOfSpacesWithDisabiltyAdaptation);

            ParkingLot parkingLot = new ParkingLot(id, name, numberOfSpaces, numberOfSpacesWithDisabiltyAdaptation, vehicles, spaces);

            String success;

            success = parkingLotBusiness.createParkingLot(parkingLot);

            if (success.equals("yes")) {
                RequestDispatcher dispacher = request.getRequestDispatcher("/ParkingLot/Parking_Lot_Confirmation.jsp");
                dispacher.forward(request, response);
            } else {
                RequestDispatcher dispacher = request.getRequestDispatcher("Create_Parking_Lot.jsp");
                response.setHeader("error", "Parqueo ya Existente");
                dispacher.forward(request, response);
            }

        } catch (ParseException | java.text.ParseException | ServletException | IOException ex) {
            Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
