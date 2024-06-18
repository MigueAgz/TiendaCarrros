/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.Administrador;
import modelos.Cliente;

/**
 *
 * @author rosal
 */
public interface I_Cliente {

    public void createCliente(Cliente c, Administrador ad);

    public Cliente readCliente(int id);

    public DefaultTableModel tablaClientes();

    public DefaultComboBoxModel listaClientes();

    public void updateCliente(Cliente c, Administrador ad);

    public void deleteCliente(int id, Administrador ad);
}
