/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import javax.swing.table.DefaultTableModel;
import modelos.Administrador;
import modelos.Venta;

/**
 *
 * @author rosal
 */
public interface I_Venta {

    public void createVentas(Venta v, Administrador ad);

    public DefaultTableModel tablaVentas();

}
