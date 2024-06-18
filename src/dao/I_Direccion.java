/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.Direccion;

/**
 *
 * @author rosal
 */
public interface I_Direccion {

    public void createDireccion(Direccion d);

    public Direccion readDireccion(int id);

    public DefaultComboBoxModel listaDireccion(int id_cliente);

    public DefaultTableModel tablaDireccion(int id_cliente);

    public void updateDireccion(Direccion d);

    public void deleteDireccion(int id);
}
