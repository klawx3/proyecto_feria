/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.controller;

import com.klaw.easyarduinorxtx.SerialArduino;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kenshi
 */
public class ArduinoActuadorServletController extends HttpServlet {

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
        Integer pin = 0;
        try {
            pin = Integer.parseInt(request.getParameter("pin").trim()); // PIN
      
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato del pin");
            response.sendRedirect("registro.jsp");
            return;
        }
        String set = request.getParameter("set"); //--- SET
        SerialArduino a = (SerialArduino) request.getServletContext().getAttribute("a");
        if (a != null) {
            if (a.isConnected()) {
                switch (set) {
                    case "on":
                        a.send("onn" + pin);
                        break;
                    case "off":
                        a.send("off" + pin);
                        break;
                    default:
                        System.err.println("el paremetro set esta");

                }
            } else {
                System.err.println("No esta conectado a arduino :'c");

            }
        } else {
            System.err.println("SerialArduino object is null");

        }
        response.sendRedirect("registro.jsp");
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
