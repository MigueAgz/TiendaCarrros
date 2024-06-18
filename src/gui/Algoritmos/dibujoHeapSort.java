/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.Algoritmos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rosal
 */
public class dibujoHeapSort extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form arreglodibujado
     *
     * @param arreglo
     */
    public dibujoHeapSort(int[] arreglo) {
        initComponents();
        this.arreglo = arreglo;
    }
    int[] arreglo;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 50;
        int n = arreglo.length;
        int maxValue = getMaxValue(arreglo); // Obtener el valor máximo del arreglo
        g.setColor(Color.black);
        for (int i = 0; i < n; i++) {
            int barHeight = (int) ((arreglo[i] * getHeight() * 0.5) / maxValue); // Calcular la altura proporcional
            int y = getHeight() - barHeight - 50; // Calcular la posición vertical del rectángulo

            g.drawRect(x, y, 20, barHeight);
            g.drawString(Integer.toString(arreglo[i]), x, y + barHeight + 15); // Mostrar el valor del arreglo debajo de la barra
            x += 30;
        }
    }

// Método auxiliar para obtener el valor máximo del arreglo
    private int getMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        arreglo = monticulo(arreglo, arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            arreglo = eliminarRaiz(arreglo, arreglo.length - i);
            arreglo = monticulo(arreglo, arreglo.length - i - 1);
            //repintamos todo
            repaint();
            try {
                //un sleep
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    //Función para construir montículo
    private int[] monticulo(int[] data, int n) {
        for (int i = 0; i < n; i++) {
            if (padre(i) != -1) {
                int p = data[padre(i)];
                if (data[i] > p) {
                    data[padre(i)] = data[i];
                    data[i] = p;
                    monticulo(data, n);

                }
            }
        }
        return data;
    }

    //Función para determinar padres
    private int padre(int index) {
        return (index == 0) ? -1 : (index - 1) / 2;
    }

    //Función para eliminar las raices
    private int[] eliminarRaiz(int[] data, int n) {
        Integer aux;
        aux = data[n - 1];
        data[n - 1] = data[0];
        data[0] = aux;
        return data;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
