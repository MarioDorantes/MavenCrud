/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.ConexionBD.ConexionBD;
import com.mycompany.pocos.Estudiante;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class EstudianteDAO {
    
    ConexionBD conn = new ConexionBD();
    
    public void agregarEstudiante(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String estatus){
        try{
            Connection conexion = conn.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "INSERT INTO ESTUDIANTE (primer_nom, seg_nom, primer_ape, seg_ape, estatus) VALUES ('"+primerNombre+"', '"+segundoNombre+"', '"+primerApellido+"', '"+segundoApellido+"', '"+estatus+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Registro fallido"+ex, "Falla en el registro", JOptionPane.ERROR_MESSAGE);
        }
           
    }
    
}
