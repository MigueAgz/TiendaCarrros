/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Tarjeta;

/**
 *
 * @author rosal
 */
public class DAO_Tarjeta extends conexion implements I_Tarjeta {

    @Override
    public void createTarjeta(Tarjeta t) {
        try {
            create(t);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public Tarjeta readTarjeta(int id) {
        Tarjeta t = null;
        try {
            t = read(id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
        return t;
    }

    @Override
    public DefaultComboBoxModel listaTarjeta(int id_cliente) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Tarjeta t : readTarjetas(id_cliente)) {
            modelo.addElement(t);
        }
        return modelo;
    }

    @Override
    public void updateTarjeta(Tarjeta t) {
        try {
            update(t);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public void deleteTarjeta(int id) {
        try {
            delete(id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void create(Tarjeta t) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into tarjetas(noTarjeta, banco, id_cliente) values (?,?,?);");
            ps.setString(1, t.getNoTarjeta());
            ps.setString(2, t.getBanco());
            ps.setInt(3, t.getId_cliente());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se creo con exito we");
            } else {
                JOptionPane.showMessageDialog(null, "Checale pq no se guardo");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    private Tarjeta read(int id) throws SQLException {
        Tarjeta t = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from tarjetas where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Tarjeta();
                t.setNoTarjeta(rs.getString("noTarjeta"));
                t.setBanco(rs.getString("banco"));
                t.setId_cliente(rs.getInt("id_cliente"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
        return t;
    }

    private ArrayList<Tarjeta> readTarjetas(int id_clientes) {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from tarjetas where id_cliente = ?;");
            ps.setInt(1, id_clientes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta t = new Tarjeta();
                t.setNoTarjeta(rs.getString("noTarjeta"));
                t.setBanco(rs.getString("banco"));
                t.setId_cliente(rs.getInt("id_cliente"));
                t.setId(rs.getInt("id"));
                tarjetas.add(t);
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
        return tarjetas;
    }

    private void update(Tarjeta t) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update tarjetas set noTarjeta = ?, banco = ?, id_cliente = ? where id = ?;");
            ps.setString(1, t.getNoTarjeta());
            ps.setString(2, t.getBanco());
            ps.setInt(3, t.getId_cliente());
            ps.setInt(4, t.getId());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo con exito we");
            } else {
                JOptionPane.showMessageDialog(null, "no se actualizo we");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
    }

    private void delete(int id) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("delete from tarjetas where id = ?;");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito we");
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
    public DefaultTableModel tablaTarjeta(int id_cliente) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("banco");
        modelo.addColumn("noTarjeta");
        for (Tarjeta t : readTarjetas(id_cliente)) {
            Object[] fila = new Object[3];
            fila[0] = t.getId();
            fila[1] = t.getBanco();
            fila[2] = Tarjeta.verTarjeta(t.getNoTarjeta());
            modelo.addRow(fila);
        }
        return modelo;
    }

}
