/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class ConexionBD {
    
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/DBEstudiante";
    String usuario = "postgres";
    String password = "12345";
    
    public Connection conectar(){

        try {
            
            conn = DriverManager.getConnection(url, usuario, password);

            // Do something with the Connection
            if (conn != null){
                System.out.println("Conexion establecida");
            }             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

}
