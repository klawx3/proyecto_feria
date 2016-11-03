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
public class HistorialActuador extends HistorialAbstracto {
    
    private String email_id_usuario;

    public HistorialActuador(int id, int id_dispositivo, Date fecha_accion, int valor,String email_id_usuario) {
        super(id, id_dispositivo, fecha_accion, valor);
        this.email_id_usuario = email_id_usuario;
    }

    public String getEmail_id_usuario() {
        return email_id_usuario;
    }

    public void setEmail_id_usuario(String email_id_usuario) {
        this.email_id_usuario = email_id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
