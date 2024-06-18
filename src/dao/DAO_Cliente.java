/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Administrador;
import modelos.Cliente;
import modelos.Registro;

/**
 *
 * @author rosal
 */
public class DAO_Cliente extends conexion implements I_Cliente {

    @Override
    public void createCliente(Cliente c, Administrador ad) {
        try {
            create(c, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public Cliente readCliente(int id) {
        Cliente c = null;
        try {
            c = read(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
        return c;
    }

    private ArrayList<Cliente> readClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from cliente;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                clientes.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }

    @Override
    public void updateCliente(Cliente c, Administrador ad) {
        try {
            update(c, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public void deleteCliente(int id, Administrador ad) {
        try {
            delete(id, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void create(Cliente c, Administrador ad) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into cliente(nombre, apellido) values (?,?);");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            if (ps.executeUpdate() > 0) {

                PreparedStatement ps1 = this.conexion.prepareStatement("select id from cliente where nombre = ? and apellido = ?");
                ps1.setString(1, c.getNombre());
                ps1.setString(2, c.getApellido());
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
                    c.setId(rs.getInt("id"));
                    JOptionPane.showMessageDialog(null, "Se creo con exito we");
                    DAO_Registro daor = new DAO_Registro();
                    daor.registroCreateCliente(new Registro(ad.getId(), c.getId(), "Creo un cliente"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Checale pq no se guardo");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    private Cliente read(int id) throws SQLException {
        Cliente c = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from cliente where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
        return c;

    }

    private void update(Cliente c, Administrador ad) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update cliente set nombre = ?, apellido = ? where id = ?;");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setInt(3, c.getId());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo con exito we");
                DAO_Registro daor = new DAO_Registro();
                daor.registroUpdateCliente(new Registro(ad.getId(), c.getId(), "Actualizo un cliente"));
            } else {
                JOptionPane.showMessageDialog(null, "no se actualizo we");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    private void delete(int id, Administrador ad) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("delete from cliente where id = ?;");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito we");
                DAO_Registro daor = new DAO_Registro();
                daor.registroDelete(new Registro(ad.getId(), "Borro un cliente"));
            } else {
                JOptionPane.showMessageDialog(null, "no se elimino we");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    @Override
    public DefaultTableModel tablaClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");

        for (Cliente c : readClientes()) {
            Object[] fila = new Object[3];
            fila[0] = c.getId();
            fila[1] = c.getNombre();
            fila[2] = c.getApellido();
            modelo.addRow(fila);
        }
        return modelo;
    }

    @Override
    public DefaultComboBoxModel listaClientes() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Cliente c : readClientes()) {
            modelo.addElement(c);
        }
        return modelo;
    }

}
