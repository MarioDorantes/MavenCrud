//Mario Dorantes
package com.mycompany.mavenproyecto;

import com.mycompany.ConexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
        
        obtenerEstudiantes();
        
    }
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    private void obtenerEstudiantes(){
        try{
            jtTablaEstudiantes.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConexionBD conn = new ConexionBD();
            Connection con = conn.conectar();
            
            String sql = "SELECT primer_nom, seg_nom, primer_ape, seg_ape FROM ESTUDIANTE WHERE estatus = 'Activo'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Primer Nombre");
            modelo.addColumn("Segundo Nombre");
            modelo.addColumn("Primer Apellido");
            modelo.addColumn("Segundo Apellido");
            
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for(int i = 0; i < cantidadColumnas; i++){
                    filas[i] = rs.getObject(i + 1);
                }
                
                modelo.addRow(filas);
            }
            
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la BD"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaEstudiantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Sistema Estudiantes");

        btnAgregar.setBackground(new java.awt.Color(0, 255, 51));
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 255, 0));
        btnModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jtTablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTablaEstudiantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgregarEstudiante formulario = new AgregarEstudiante();
        formulario.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        PreparedStatement ps = null;
        try{
            ConexionBD objCon = new ConexionBD();
            Connection conn = objCon.conectar();
            
            int Fila = jtTablaEstudiantes.getSelectedRow();
            
            if(Fila >= 0){
                int res = JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if(res == 0){
                    String nombreUnoEstudiante = jtTablaEstudiantes.getValueAt(Fila, 0).toString();
                    String nombreDosEstudiante = jtTablaEstudiantes.getValueAt(Fila, 1).toString();
                    String ApellidoUno = jtTablaEstudiantes.getValueAt(Fila, 2).toString();
                    String ApellidoDos = jtTablaEstudiantes.getValueAt(Fila, 3).toString();
            
                    ps = conn.prepareStatement("UPDATE ESTUDIANTE SET ESTATUS = 'Inactivo' WHERE primer_nom = ? AND seg_nom = ? AND primer_ape = ? AND seg_ape = ?");
                    ps.setString(1, nombreUnoEstudiante);
                    ps.setString(2, nombreDosEstudiante);
                    ps.setString(3, ApellidoUno);
                    ps.setString(4, ApellidoDos);
                    ps.execute();
            
                    modelo.removeRow(Fila);
                }
                
            } else{
                JOptionPane.showMessageDialog(null, "Seleccione un registro para poder eliminarlo", "Sin selección", JOptionPane.ERROR_MESSAGE);
            }
    
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al eliminar de la BD"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ConexionBD objCon = new ConexionBD();
            Connection conn = objCon.conectar();
            
            int Fila = jtTablaEstudiantes.getSelectedRow();
            
            if(Fila >= 0){
                String nomUno = jtTablaEstudiantes.getValueAt(Fila, 0).toString();
                String nomDos = jtTablaEstudiantes.getValueAt(Fila, 1).toString();
                String apeUno = jtTablaEstudiantes.getValueAt(Fila, 2).toString();
            
                ps = conn.prepareStatement("SELECT primer_nom, seg_nom, primer_ape, seg_ape FROM ESTUDIANTE WHERE primer_nom = ? AND seg_nom = ? AND primer_ape = ?");
                ps.setString(1, nomUno);
                ps.setString(2, nomDos);
                ps.setString(3, apeUno);
                rs = ps.executeQuery();
            
            
                String auxNomUno = "";
                String auxNomDos = "";
                String auxApeUno = "";
                String auxApeDos = "";
            
            
                while (rs.next()){
                    auxNomUno = rs.getString("primer_nom");
                    auxNomDos = rs.getString("seg_nom");
                    auxApeUno = rs.getString("primer_ape");
                    auxApeDos = rs.getString("seg_ape");
                }

                ModificarEstudiante modificar = new ModificarEstudiante();
                modificar.setVisible(true);
                dispose();
            
                modificar.llenarCampos(auxNomUno, auxNomDos, auxApeUno, auxApeDos);
            } else{
                JOptionPane.showMessageDialog(null, "Seleccione un registro para poder editarlo", "Sin selección", JOptionPane.ERROR_MESSAGE);
            }
    
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al eliminar de la BD"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTablaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
