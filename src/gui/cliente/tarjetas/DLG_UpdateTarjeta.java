/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.cliente.tarjetas;

import dao.DAO_Cliente;
import dao.DAO_Tarjeta;
import javax.swing.SwingUtilities;
import modelos.Cliente;
import modelos.Tarjeta;

/**
 *
 * @author rosal
 */
public class DLG_UpdateTarjeta extends javax.swing.JDialog implements Runnable {

    /**
     * Creates new form DLG_UpdateTarjeta
     */
    public DLG_UpdateTarjeta(java.awt.Frame parent, boolean modal) {
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
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTarjeta = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextFieldNoTarjeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldIdCliente = new javax.swing.JTextField();
        jTextFieldBanco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldIdTarjeta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel3.setText("Selecciona el cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 252, -1));

        jLabel5.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel5.setText("Selecciona la tarjeta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jComboBoxTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTarjetaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 250, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));
        getContentPane().add(jTextFieldNoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 238, -1));

        jLabel4.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel4.setText("Numero Tarjeta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel2.setText("Banco");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel8.setText("ID Cliente");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 20));

        jTextFieldIdCliente.setEditable(false);
        getContentPane().add(jTextFieldIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 84, -1));
        getContentPane().add(jTextFieldBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 238, -1));

        jLabel6.setFont(new java.awt.Font("Futurist Fixed-width", 0, 12)); // NOI18N
        jLabel6.setText("ID Tarjeta");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jTextFieldIdTarjeta.setEditable(false);
        getContentPane().add(jTextFieldIdTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 81, -1));

        jLabel9.setFont(new java.awt.Font("Futurist Fixed-width", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TARJETA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 350, 80));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 330, 10));

        jLabel7.setFont(new java.awt.Font("Futurist Fixed-width", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ACTUALIZAR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 60));

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
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 350, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        // TODO add your handling code here:
        String id_cliente = String.valueOf(jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId());
        jTextFieldIdCliente.setText(id_cliente);
        int id_cliente2 = jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId();
        SwingUtilities.invokeLater(() -> {
            jComboBoxTarjeta.setModel(new DAO_Tarjeta().listaTarjeta(id_cliente2));
        });
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jComboBoxTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTarjetaActionPerformed
        // TODO add your handling code here:
        String banco = jComboBoxTarjeta.getItemAt(jComboBoxTarjeta.getSelectedIndex()).getBanco();
        String noTarjeta = jComboBoxTarjeta.getItemAt(jComboBoxTarjeta.getSelectedIndex()).getNoTarjeta();
        String id_tarjeta = String.valueOf(jComboBoxTarjeta.getItemAt(jComboBoxTarjeta.getSelectedIndex()).getId());
        String id_cliente = String.valueOf(jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId());

        jTextFieldIdCliente.setText(id_cliente);
        jTextFieldBanco.setText(banco);
        jTextFieldNoTarjeta.setText(noTarjeta);
        jTextFieldIdTarjeta.setText(id_tarjeta);

    }//GEN-LAST:event_jComboBoxTarjetaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id_cliente = jComboBoxCliente.getItemAt(jComboBoxCliente.getSelectedIndex()).getId();
        int id = jComboBoxTarjeta.getItemAt(jComboBoxTarjeta.getSelectedIndex()).getId();
        String banco = jTextFieldBanco.getText();
        String noTarjeta = jTextFieldNoTarjeta.getText();

        DAO_Tarjeta dao = new DAO_Tarjeta();
        dao.updateTarjeta(new Tarjeta(id, id_cliente, banco, noTarjeta));

        SwingUtilities.invokeLater(() -> {
            jComboBoxTarjeta.setModel(new DAO_Tarjeta().listaTarjeta(id_cliente));
        });

        limpiacajas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //hilo.interrupt();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void limpiacajas() {
        jTextFieldIdTarjeta.setText("");
        jTextFieldBanco.setText("");
        jTextFieldIdCliente.setText("");
        jTextFieldNoTarjeta.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Cliente> jComboBoxCliente;
    private javax.swing.JComboBox<Tarjeta> jComboBoxTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldBanco;
    private javax.swing.JTextField jTextFieldIdCliente;
    private javax.swing.JTextField jTextFieldIdTarjeta;
    private javax.swing.JTextField jTextFieldNoTarjeta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        jComboBoxCliente.setModel(new DAO_Cliente().listaClientes());
    }
}
