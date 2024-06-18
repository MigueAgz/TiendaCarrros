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
import modelos.Direccion;

/**
 *
 * @author rosal
 */
public class DAO_Direccion extends conexion implements I_Direccion {

    @Override
    public void createDireccion(Direccion d) {
        try {
            create(d);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public Direccion readDireccion(int id) {
        Direccion d = null;
        try {
            d = read(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
        return d;
    }

    @Override
    public DefaultComboBoxModel listaDireccion(int id_cliente) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Direccion d : readDirecciones(id_cliente)) {
            modelo.addElement(d);
        }
        return modelo;
    }

    @Override
    public void updateDireccion(Direccion d) {
        try {
            update(d);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public void deleteDireccion(int id) {
        try {
            delete(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void create(Direccion d) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into direcciones(calle, numero, ciudad, cp, colonia, id_cliente) values (?,?,?,?,?,?);");
            ps.setString(1, d.getCalle());
            ps.setInt(2, d.getNumero());
            ps.setString(3, d.getCiudad());
            ps.setInt(4, d.getCp());
            ps.setString(5, d.getColonia());
            ps.setInt(6, d.getId_cliente());
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

    private Direccion read(int id) throws SQLException {
        Direccion d = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from direcciones where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d = new Direccion();
                d.setId(rs.getInt("id"));
                d.setCalle(rs.getString("calle"));
                d.setNumero(rs.getInt("numero"));
                d.setCiudad(rs.getString("ciudad"));
                d.setCp(rs.getInt("cp"));
                d.setColonia(rs.getString("colonia"));
                d.setId_cliente(rs.getInt("id_cliente"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
        return d;
    }

    private ArrayList<Direccion> readDirecciones(int id_cliente) {
        ArrayList<Direccion> direcciones = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("select * from direcciones where id_cliente = ?;");
            ps.setInt(1, id_cliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Direccion d = new Direccion();
                d.setId(rs.getInt("id"));
                d.setCalle(rs.getString("calle"));
                d.setNumero(rs.getInt("numero"));
                d.setCiudad(rs.getString("ciudad"));
                d.setCp(rs.getInt("cp"));
                d.setColonia(rs.getString("colonia"));
                d.setId_cliente(rs.getInt("id_cliente"));
                direcciones.add(d);
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
        return direcciones;
    }

    private void update(Direccion d) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update direcciones set calle = ?, numero = ?, ciudad = ?, cp = ?, colonia = ? where id = ?;");
            ps.setString(1, d.getCalle());
            ps.setInt(2, d.getNumero());
            ps.setString(3, d.getCiudad());
            ps.setInt(4, d.getCp());
            ps.setString(5, d.getColonia());
            ps.setInt(6, d.getId());
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
            PreparedStatement ps = this.conexion.prepareStatement("delete from direcciones where id = ?;");
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
    public DefaultTableModel tablaDireccion(int id_cliente) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Calle");
        modelo.addColumn("Numero");
        modelo.addColumn("Codigo Postal");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Colonia");

        for (Direccion d : readDirecciones(id_cliente)) {
            Object[] fila = new Object[6];
            fila[0] = d.getId();
            fila[1] = d.getCalle();
            fila[2] = d.getNumero();
            fila[3] = d.getCp();
            fila[4] = d.getCiudad();
            fila[5] = d.getColonia();
            modelo.addRow(fila);
        }
        return modelo;

    }
}
