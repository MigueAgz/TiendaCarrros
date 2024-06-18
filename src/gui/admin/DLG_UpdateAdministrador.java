/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.admin;

import clases.Encriptador;
import dao.DAO_Administrador;
import javax.swing.JOptionPane;
import modelos.Administrador;

/**
 *
 * @author rosal
 */
public class DLG_UpdateAdministrador extends javax.swing.JDialog {

    /**
     * Creates new form ActualizarDatos
     */
    public DLG_UpdateAdministrador(java.awt.Frame parent, boolean modal, Administrador a) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        this.a = a;
        jTextFieldnombre.setText(a.getNombre());
        jTextFieldApellido.setText(a.getApellido());
        jTextFieldCorreo.setText(a.getCorreo());
        jTextFieldContraseña.setText(Encriptador.desencriptar(a.getContraseña()));
    }
    Administrador a;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldnombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jTextFieldContraseña = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 300, -1));

        jLabel2.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel2.setText("Apellido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 300, -1));

        jLabel3.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel3.setText("Correo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel4.setText("Contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn.png"))); // NOI18N
        jButton1.setText("ACTUALIZAR");
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 350, -1));
        getContentPane().add(jTextFieldnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 250, -1));
        getContentPane().add(jTextFieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, -1));
        getContentPane().add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 250, -1));
        getContentPane().add(jTextFieldContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 250, -1));

        jLabel7.setFont(new java.awt.Font("Futurist Fixed-width", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CUENTA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 80));

        jLabel6.setFont(new java.awt.Font("Futurist Fixed-width", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ACTUALIZAR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, 60));

        jButton3.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn.png"))); // NOI18N
        jButton3.setText("SALIR");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 350, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dao.DAO_Administrador dao = new DAO_Administrador();
        String nombre = jTextFieldnombre.getText();
        String apellido = jTextFieldApellido.getText();
        String correo = jTextFieldCorreo.getText();
        String contraseña = Encriptador.encriptar(jTextFieldContraseña.getText());
        dao.updateAdministrador(new Administrador(a.getId(), nombre, apellido, correo, contraseña));
        JOptionPane.showMessageDialog(this, "Cierra sesion y vuelve a iniciarla para que lso cambios surtan efecto");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //hilo.interrupt();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldContraseña;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldnombre;
    // End of variables declaration//GEN-END:variables
}