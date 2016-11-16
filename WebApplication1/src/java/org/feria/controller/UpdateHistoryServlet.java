/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.feria.bd.Conexion;
import org.feria.model.HistorialSensorDAO;

/**
 * 
 *
 * @author martin
 */
@WebServlet(name = "UpdateSensorHistoryServlet", urlPatterns = {"/update.do"})
public class UpdateHistoryServlet extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            HistorialSensorDAO hsDao = new HistorialSensorDAO(Conexion.getInstance());
            String h = request.getParameter("h");
            String query = null;
            
            if (h == null) {
                response.sendRedirect("registro.jsp");
                return;
            }
            else if ((Integer.parseInt(h) > 2)) {
                response.sendRedirect("registro.jsp");
                return;
            }
            else if (h.equals("1")) {
                query = "select s.pin_sensor, s.nombre_sensor, hs.valor_historial \n"
                    + "from sensor s, historial_sensor hs \n"
                    + "where hs.fk_sensor = s.id_sensor \n"
                    + "order by hs.id_historial desc limit 2;";
            }else{
                query = "select a.pin_actuador, a.nombre_actuador, ha.valor_historial \n"
                    + "from actuador a, historial_actuador ha \n"
                    + "where ha.fk_actuador = a.id_actuador  order by ha.id_historial desc limit 2;";
            }
            
            ResultSet res = Conexion.getInstance().executeQueryRS(query);
            
            while (res.next()) {
                out.print("<tr>");
                out.print("<th scope=\"row\">"+res.getInt(1)+"</th>");
                out.print("<td>"+res.getString(2)+"</td>");
                out.print("<td>"+res.getInt(3)+"</td>");
                out.print("</tr>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
