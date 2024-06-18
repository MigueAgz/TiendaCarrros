/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.Administrador;
import modelos.Auto;

/**
 *
 * @author rosal
 */
public interface I_Auto {

    public void createAuto(Auto a, Administrador ad);

    public Auto readAuto(int id);

    public DefaultComboBoxModel<Auto> listaAutos();

    public DefaultTableModel tablaAutos();

    public void updateAuto(Auto a, Administrador ad);

    public void deleteAuto(int id, Administrador ad);
}
