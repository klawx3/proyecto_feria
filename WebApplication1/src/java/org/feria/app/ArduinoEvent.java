/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.app;

/**
 *
 * @author Kenshi
 */
public class ArduinoEvent {
    private String tipo;
    private int pin;
    private int valor;

    public ArduinoEvent(String tipo, String pin, String valor) throws NumberFormatException {
        this.tipo = tipo;
        this.pin = Integer.parseInt(pin);
        this.valor = Integer.parseInt(valor);
    }

    public String getTipo() {
        return tipo;
    }

    public int getPin() {
        return pin;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ArduinoEvent{" + "tipo=" + tipo + ", pin=" + pin + ", valor=" + valor + '}';
    }
    
    


    
    
}
