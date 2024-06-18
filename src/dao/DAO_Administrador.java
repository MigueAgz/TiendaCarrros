/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import clases.Encriptador;
import database.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Administrador;

/**
 *
 * @author rosal
 */
public class DAO_Administrador extends conexion implements I_Administrador {

    @Override
    public void createAdministrador(Administrador a) {
        try {
            create(a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void create(Administrador a) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into administrador(nombre, apellido, correo, contraseña) values (?,?,?,?);");
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getCorreo());
            ps.setString(4, a.getContraseña());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se registro con exito we");
            } else {
                JOptionPane.showMessageDialog(null, "No se registro, checale we");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void updateAdministrador(Administrador a) {
        try {
            update(a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void update(Administrador a) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update administrador set nombre = ?, apellido = ?, correo = ?, contraseña = ? where id = ?;");
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getCorreo());
            ps.setString(4, a.getContraseña());
            ps.setInt(5, a.getId());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo con exito we");
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizo, checale we");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Administrador sesionAdministrador(String correo, String contraseña) {
        Administrador a = null;
        try {
            a = read(correo, contraseña);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
        return a;

    }

    private Administrador read(String correo, String contraseña) throws SQLException {
        Administrador a = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from administrador where correo = ? and contraseña = ?;");
            ps.setString(1, correo);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Administrador();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setCorreo(rs.getString("correo"));
                a.setContraseña(rs.getString("contraseña"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
        return a;
    }

}
