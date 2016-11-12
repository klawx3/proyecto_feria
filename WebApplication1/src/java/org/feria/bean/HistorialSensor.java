/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.bean;

import java.util.Date;

/**
 *
 * @author Alumno
 */
public class HistorialSensor extends HistorialAbstracto{

    public HistorialSensor(Integer id, int id_dispositivo, Date fecha_accion, int valor) {
        super(id, id_dispositivo, fecha_accion, valor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(int id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public Date getFecha_accion() {
        return fecha_accion;
    }

    public void setFecha_accion(Date fecha_accion) {
        this.fecha_accion = fecha_accion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    

    
}
