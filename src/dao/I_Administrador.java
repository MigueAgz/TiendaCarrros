/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import modelos.Administrador;

/**
 *
 * @author rosal
 */
public interface I_Administrador {

    public void createAdministrador(Administrador a);

    public Administrador sesionAdministrador(String correo, String contraseña);

    public void updateAdministrador(Administrador a);

}
