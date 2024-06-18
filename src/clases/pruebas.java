/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import dao.DAO_Administrador;
import dao.DAO_Cliente;
import dao.DAO_Direccion;
import database.conexion;
import gui.admin.DLG_UpdateAdministrador;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Administrador;
import modelos.Cliente;
import modelos.Direccion;

/**
 *
 * @author rosal
 */
public class pruebas extends conexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(verTarjeta("3741937826394638"));

    }

    public static String verTarjeta(String noTarjeta) {
        int longitud = noTarjeta.length();
        String tarjetaOculta = "**** **** **** " + noTarjeta.substring(longitud - 4);
        return tarjetaOculta;

    }

}
