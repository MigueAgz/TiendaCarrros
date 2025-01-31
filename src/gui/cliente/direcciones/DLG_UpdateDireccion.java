/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.cliente.direcciones;

import dao.DAO_Cliente;
import dao.DAO_Direccion;
import javax.swing.SwingUtilities;
import modelos.Cliente;
import modelos.Direccion;

/**
 *
 * @author rosal
 */
public class DLG_UpdateDireccion extends javax.swing.JDialog implements Runnable {

    /**
     * Creates new form DLG_UpdateDireccion
     */
    public DLG_UpdateDireccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        hilo.start();
    }
    Thread hilo = new Thread(this);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxDireccion = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jTextFieldIdDireccion = new javax.swing.JTextField();
        jTextFieldCalle = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldCp = new javax.swing.JTextField();
        jTextFieldCiudad = new javax.swing.JTextField();
        jTextFieldColonia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIdCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel3.setText("Selecciona el cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 290, -1));

        jLabel9.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel9.setText("Selecciona una direccion");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jComboBoxDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 290, -1));

        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn.png"))); // NOI18N
        jButton2.setText("ACTUALIZAR");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 390, -1));

        jTextFieldIdDireccion.setEditable(false);
        getContentPane().add(jTextFieldIdDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 80, -1));
        getContentPane().add(jTextFieldCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 203, -1));
        getContentPane().add(jTextFieldNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 203, -1));
        getContentPane().add(jTextFieldCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 203, -1));
        getContentPane().add(jTextFieldCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 203, -1));
        getContentPane().add(jTextFieldColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 203, -1));

        jLabel7.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel7.setText("Colonia");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 20));

        jLabel6.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel6.setText("Ciudad");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 20));

        jLabel5.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel5.setText("CP");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 20));

        jLabel2.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel2.setText("Numero");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 20));

        jLabel4.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel4.setText("Calle");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 20));

        jLabel8.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel8.setText("ID Cliente");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel10.setText("ID direccion");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jTextFieldIdCliente.setEditable(false);
        getContentPane().add(jTextFieldIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 79, -1));

        jLabel11.setFont(new java.awt.Font("Futurist Fixed-width", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DIRECCION");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, 80));

        jLabel12.setFont(new java.awt.Font("Futurist Fixed-width", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ACTUALIZAR");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 60));

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
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 390, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BgDimension2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int id_cliente = jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId();
        int id = jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getId();
        int numero = Integer.parseInt(jTextFieldNumero.getText());
        int cp = Integer.parseInt(jTextFieldCp.getText());
        String calle = jTextFieldCalle.getText();
        String ciudad = jTextFieldCiudad.getText();
        String colonia = jTextFieldColonia.getText();

        DAO_Direccion dao = new DAO_Direccion();
        dao.updateDireccion(new Direccion(id, id_cliente, numero, cp, calle, ciudad, colonia));

        limpiacajas();
        SwingUtilities.invokeLater(() -> {
            jComboBoxDireccion.setModel(new DAO_Direccion().listaDireccion(id_cliente));
        });

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        // TODO add your handling code here:
        int id_cliente = jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId();
        jTextFieldIdCliente.setText(String.valueOf(id_cliente));
        SwingUtilities.invokeLater(() -> {
            jComboBoxDireccion.setModel(new DAO_Direccion().listaDireccion(id_cliente));
        });
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jComboBoxDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDireccionActionPerformed
        // TODO add your handling code here:
        String id_cliente = String.valueOf(jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId());
        String numero = String.valueOf(jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getNumero());
        String cp = String.valueOf(jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getCp());
        String calle = jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getCalle();
        String ciudad = jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getCiudad();
        String colonia = jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getColonia();
        String id = String.valueOf(jComboBoxDireccion.getItemAt(jComboBoxDireccion.getSelectedIndex()).getId());

        jTextFieldCalle.setText(calle);
        jTextFieldCiudad.setText(ciudad);
        jTextFieldColonia.setText(colonia);
        jTextFieldCp.setText(cp);
        jTextFieldIdCliente.setText(id_cliente);
        jTextFieldNumero.setText(numero);
        jTextFieldIdDireccion.setText(id);
    }//GEN-LAST:event_jComboBoxDireccionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //hilo.interrupt();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Cliente> jComboBoxCliente;
    private javax.swing.JComboBox<Direccion> jComboBoxDireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldCalle;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldColonia;
    private javax.swing.JTextField jTextFieldCp;
    private javax.swing.JTextField jTextFieldIdCliente;
    private javax.swing.JTextField jTextFieldIdDireccion;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        jComboBoxCliente.setModel(new DAO_Cliente().listaClientes());
    }

    private void limpiacajas() {
        jTextFieldIdDireccion.setText("");
        jTextFieldCalle.setText("");
        jTextFieldCiudad.setText("");
        jTextFieldColonia.setText("");
        jTextFieldCp.setText("");
        jTextFieldIdCliente.setText("");
        jTextFieldNumero.setText("");
    }
}
