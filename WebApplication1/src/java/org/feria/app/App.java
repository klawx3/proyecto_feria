/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.app;


import com.klaw.easyarduinorxtx.SerialArduino;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.feria.bd.Conexion;


public class App implements ServletContextListener {
    
    public static final String SERIAL_PORT = "/dev/ttyACM0";
    public static final int DATA_RATE = 9600;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SerialArduino arduino = new SerialArduino(SERIAL_PORT, DATA_RATE);
        arduino.initialize();
        Conexion con = Conexion.getInstance();
        if (con.isConectado()) {
            System.out.printf("Conectado a : %s\n", con.toString());            
        } else {
            System.err.println("No ha podido conectar con la base de datos");
        }
        if (arduino.isConnected()) {
            System.out.printf("Conectado a arduino (%s,%s)\n", SERIAL_PORT,
                    DATA_RATE);
            if (con.isConectado()) { // que feo xDdxddXD
                ArduinoHandler ah = new ArduinoHandler(con);
                arduino.addArduinoEvent(ah);
            }
        } else {
            System.err.println("No ha podido conectar con arduino");
        }

        sce.getServletContext().setAttribute("c", con);
        sce.getServletContext().setAttribute("a", arduino);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Conexion c = (Conexion) sce.getServletContext().getAttribute("c");
        if (c != null) {
            c.close();
        }        
        SerialArduino a = (SerialArduino) sce.getServletContext().getAttribute("a");        
        if (a != null) {
            if (a.isConnected()) {
                a.close();
            }
        }
    }
}
