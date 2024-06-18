/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.Tarjeta;

/**
 *
 * @author rosal
 */
public interface I_Tarjeta {

    public void createTarjeta(Tarjeta t);

    public Tarjeta readTarjeta(int id);

    public DefaultComboBoxModel listaTarjeta(int id_cliente);

    public DefaultTableModel tablaTarjeta(int id_cliente);

    public void updateTarjeta(Tarjeta t);

    public void deleteTarjeta(int id);
}
