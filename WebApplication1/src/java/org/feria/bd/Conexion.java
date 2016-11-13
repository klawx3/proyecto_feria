/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.bd;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Conexion { // SINGLETON
    
    private Connection con;
    private static Conexion instancia;
    private boolean conectado;
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion("localhost", "root", "", "bd_feria");
        }
        return instancia;
    }
    
    private Conexion(String ip,String user,String password,String bd){
        conectado = false;
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(bd);
        ds.setServerName(ip);

        try {
            con = ds.getConnection();
            conectado = true;
        } catch (SQLException ex) {
            System.err.println("No se ha podido establecer conexion con la bd" + ex.getMessage());
        }
    }

    public boolean isConectado(){
        return conectado;
    }

    public ResultSet executeQueryRS(String sql) {
        try {
            return con.createStatement().executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean execute(String sql){
        try {
            con.createStatement().execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        instancia = null;
    }

    

    
}
