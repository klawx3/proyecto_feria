/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.bean;

/**
 *
 * @author Alumno
 */
public class Usuario {
    private String email;
    private String encrypted_password;
    private String decrypted_password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public String getDecrypted_password() {
        return decrypted_password;
    }

    public void setDecrypted_password(String decrypted_password) {
        this.decrypted_password = decrypted_password;
    }
    
    
}
