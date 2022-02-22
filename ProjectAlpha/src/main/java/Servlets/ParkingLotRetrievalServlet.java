/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Business.ParkingLotBusiness;
import Domain.ParkingLot;
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
public class ParkingLotRetrievalServlet extends HttpServlet {

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
            out.println("<title>Servlet ParkingLotRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingLotRetrievalServlet at " + request.getContextPath() + "</h1>");
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
        //Action
        try {
            String action = request.getParameter("action");
            String parkingLotId = request.getParameter("parkingLotId");

            ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
            ParkingLot parkingLot = parkingLotBusiness.getParkingLot(parkingLotId);

            if (action.equalsIgnoreCase("delete")) {

                parkingLotBusiness.deleteParkingLot(parkingLotId);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/User/DeleteUser_Confirmation.jsp");
                dispatcher.forward(request, response);

            } else if (action.equalsIgnoreCase("edit")) {

                RequestDispatcher dispatcher = request.getRequestDispatcher("Modify_Parking_Lot.jsp");
                dispatcher.forward(request, response);

            }

        } catch (ParseException | IOException | ServletException ex) {
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

        try {
            String id = request.getParameter("name");
            String name = request.getParameter("id");
            String numberOfSpaces = request.getParameter("numberOfSpaces");
            String numberOfSpacesWithDisabiltyAdaptation = request.getParameter("numberOfSpacesWithDisabiltyAdaptation");

            ParkingLot parkingLot = new ParkingLot(id, name, Integer.parseInt(numberOfSpaces), Integer.parseInt(numberOfSpacesWithDisabiltyAdaptation));

            ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
            parkingLotBusiness.modifyParkingLot(id, parkingLot);

        } catch (ParseException | IOException ex) {
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
