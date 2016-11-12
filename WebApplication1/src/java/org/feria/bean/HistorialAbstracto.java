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
public abstract class HistorialAbstracto {
    protected Integer id;
    protected int id_dispositivo;
    protected Date fecha_accion;
    protected int valor;

    public HistorialAbstracto(Integer id, int id_dispositivo, Date fecha_accion, int valor) {
        this.id = id;
        this.id_dispositivo = id_dispositivo;
        this.fecha_accion = fecha_accion;
        this.valor = valor;
    }
    
    
    
    
    
}
