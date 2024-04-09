/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.MobileDBContext;
import Model.Mobile;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kienb
 */
public class AddNewMobileController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("AddNewMobile.jsp").forward(request, response);
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
        processRequest(request, response);
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
        String id = request.getParameter("id");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String quantity = request.getParameter("quantity");
        Boolean isSale = request.getParameter("sale").equals("0");
        String year = request.getParameter("year");
        String mobileName = request.getParameter("name");
        MobileDBContext mobileDBContext = new MobileDBContext();
        Mobile mobile = mobileDBContext.getByID(id);
        if (mobile == null) {
            mobileDBContext.insert(id, mobileName, Float.parseFloat(price), description, Integer.parseInt(quantity), isSale, Integer.parseInt(year));
            request.setAttribute("report", "Add Successfully!");
            doGet(request, response);
        } else {
            request.setAttribute("id", id);
            request.setAttribute("price", price);
            request.setAttribute("description", description);
            request.setAttribute("quantity", quantity);
            request.setAttribute("year", year);
            request.setAttribute("mobileName", mobileName);
            request.setAttribute("isSale", isSale);
            request.setAttribute("error", "Mobile ID existed!");
            doGet(request, response);
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
