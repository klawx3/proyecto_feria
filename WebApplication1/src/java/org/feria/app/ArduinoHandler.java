/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.app;

import com.klaw.easyarduino.event.ArduinoEventListener;
import org.feria.bd.Conexion;

/**
 *
 * @author Kenshi
 */
public class ArduinoHandler implements ArduinoEventListener {
    
    private Conexion con;
    
    public ArduinoHandler(Conexion con){
        this.con = con;
    }
    /**
     * 
     * @param string el string de arduino debe ser con este estandar
     * ej: nombresensor-valor;
     *     luz-203;
     */
    @Override
    public void arduinoEvent(String string) {
        String[] split = string.split("-");
        if (split.length != 2) {
            System.err.println("Error rescatando el msg de arduino");
            return;
        }
        String sensor = split[0];
        String valor = split[1];
        int _valor;
        try {
            _valor = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            System.err.println("Error transformando el valor del sensor:" + sensor);
            return;
        }
        addToDatabase(sensor,_valor);
    }

    private void addToDatabase(String sensor, int _valor) {
        
    }
    
}
