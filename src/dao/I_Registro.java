/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import javax.swing.table.DefaultTableModel;
import modelos.Registro;

/**
 *
 * @author rosal
 */
public interface I_Registro {

    public void registroCreateAuto(Registro r);

    public void registroDelete(Registro r);

    public void regitroUpdateAuto(Registro r);

    public void registroCreateCliente(Registro r);

    public void registroUpdateCliente(Registro r);

    public void registroCreateVentas(Registro r);

    public DefaultTableModel tablaRegistro();

}
