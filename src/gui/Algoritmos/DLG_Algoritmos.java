/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.Algoritmos;

import gui.FRM_Login;

/**
 *
 * @author rosal
 */
public class DLG_Algoritmos extends javax.swing.JDialog {

    dibujoBurbuja arregloBurbuja = new dibujoBurbuja(generaArreglo());
    dibujoSeleccion arregloSeleccion = new dibujoSeleccion(generaArreglo());
    dibujoInsercion arregloInsercion = new dibujoInsercion(generaArreglo());
    dibujoHeapSort arregloHeapSort = new dibujoHeapSort(generaArreglo());

    /**
     * Creates new form DLG_Algoritmos
     */
    public DLG_Algoritmos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        jPanel2.add(arregloBurbuja);
        jPanel3.add(arregloSeleccion);
        jPanel4.add(arregloInsercion);
        jPanel5.add(arregloHeapSort);
    }

    public int[] generaArreglo() {
        int[] arreglo = new int[15];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
        return arreglo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, -1, -1));

        jButton1.setText("ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("genera");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(471, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("burbuja"));
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 585, 302));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion"));
        jPanel3.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 308, 585, 250));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Insercion"));
        jPanel4.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 6, 16, 295));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("HeapSort"));
        jPanel5.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 308, 16, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Thread burbuja = new Thread(arregloBurbuja);
        burbuja.start();
        Thread seleccion = new Thread(arregloSeleccion);
        seleccion.start();
        Thread insercion = new Thread(arregloInsercion);
        insercion.start();
        Thread heapsort = new Thread(arregloHeapSort);
        heapsort.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //burbuja
        arregloBurbuja = new dibujoBurbuja(generaArreglo());
        jPanel2.removeAll();
        jPanel2.add(arregloBurbuja);
        jPanel2.revalidate();
        jPanel2.repaint();
        //seleccion
        arregloSeleccion = new dibujoSeleccion(generaArreglo());
        jPanel3.removeAll();
        jPanel3.add(arregloSeleccion);
        jPanel3.revalidate();
        jPanel3.repaint();
        //insercion
        arregloInsercion = new dibujoInsercion(generaArreglo());
        jPanel4.removeAll();
        jPanel4.add(arregloInsercion);
        jPanel4.revalidate();
        jPanel4.repaint();
        //heapsort
        arregloHeapSort = new dibujoHeapSort(generaArreglo());
        jPanel5.removeAll();
        jPanel5.add(arregloHeapSort);
        jPanel5.revalidate();
        jPanel5.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}