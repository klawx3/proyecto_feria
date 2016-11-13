/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.app;

import java.util.Calendar;
import org.feria.bd.Conexion;
import org.feria.bean.HistorialSensor;
import org.feria.bean.Sensor;
import org.feria.model.HistorialSensorDAO;
import org.feria.model.SensorDAO;

/**
 *
 * @author Kenshi
 */
public class ArduinoHandler implements com.klaw.easyarduinorxtx.event.ArduinoEventListener{
    
    private Conexion con;
    private SensorDAO sen;
    private HistorialSensorDAO his;
    
    public ArduinoHandler(Conexion con){
        this.con = con;
        sen = new SensorDAO(con);
        his = new HistorialSensorDAO(con);
    }
    

    @Override
    public void arduinoEvent(String eventString) {
        String[] split = eventString.split("-");
        if (split.length != 3) {
            System.err.println("Error rescatando el msg de arduino");
            return;
        }
        ArduinoEvent arduinoEvent = null;
        try {
            arduinoEvent = new ArduinoEvent(split[0], split[1], split[2]);
            addToDatabase(arduinoEvent);
        } catch (NumberFormatException e) {
            System.err.println("Error de protocolo ej: tipocurva-nombresensor-valor  a-0-203");
            return;
        }
    }


    private void addToDatabase(ArduinoEvent arduinoEvent) {
        Sensor _sen = sen.getDispositivoBYPin(arduinoEvent.getPin());
        HistorialSensor hist_sen = new HistorialSensor(null,
                _sen.getId(),
                null, // se hace con la bd
                arduinoEvent.getValor());
        his.addNewHistorico(hist_sen);
    }



}
