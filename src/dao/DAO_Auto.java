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
import modelos.Auto;
import modelos.Registro;

/**
 *
 * @author rosal
 */
public class DAO_Auto extends conexion implements I_Auto {

    @Override
    public void createAuto(Auto a, Administrador ad) {
        try {
            create(a, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public Auto readAuto(int id) {
        Auto a = null;
        try {
            a = read(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
        return a;
    }

    @Override
    public void updateAuto(Auto a, Administrador ad) {
        try {
            update(a, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    @Override
    public void deleteAuto(int id, Administrador ad) {
        try {
            delete(id, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void create(Auto a, Administrador ad) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into autos(marca, modelo, precio) values (?,?,?);");
            ps.setString(1, a.getMarca());
            ps.setString(2, a.getModelo());
            ps.setFloat(3, a.getPrecio());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se creo con exito we");
                PreparedStatement ps1 = this.conexion.prepareStatement("select id from autos where marca = ? and modelo = ? and precio = ?");
                ps1.setString(1, a.getMarca());
                ps1.setString(2, a.getModelo());
                ps1.setFloat(3, a.getPrecio());
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
                    a.setId(rs.getInt("id"));
                    PreparedStatement ps2 = this.conexion.prepareStatement("insert into almacen(id_auto, cantidad) values (?, ?)");
                    ps2.setInt(1, a.getId());
                    if (a.getStock() > 0) {
                        ps2.setInt(2, a.getStock());
                    } else {
                        a.setStock(1);
                        ps2.setInt(2, a.getStock());
                    }
                    if (ps2.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Al auto: " + a.getMarca() + " se le asigno el stock de: " + a.getStock());
                        DAO_Registro daoR = new DAO_Registro();
                        daoR.registroCreateAuto(new Registro(ad.getId(), a.getId(), "Creo un auto"));
                    }
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

    private Auto read(int id) throws SQLException {
        Auto a = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("""
                                                                  SELECT autos.*, almacen.cantidad
                                                                  FROM autos
                                                                  LEFT JOIN almacen ON autos.id = almacen.id_auto
                                                                  where autos.id = ? ;""");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Auto();
                a.setId(rs.getInt("id"));
                a.setMarca(rs.getString("marca"));
                a.setModelo(rs.getString("modelo"));
                a.setPrecio(rs.getFloat("precio"));
                a.setStock(rs.getInt("cantidad"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.cerrar();
        }
        return a;
    }

    private void update(Auto a, Administrador ad) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update autos set marca = ?, modelo = ?, precio = ? where id = ?;");
            ps.setString(1, a.getMarca());
            ps.setString(2, a.getModelo());
            ps.setFloat(3, a.getPrecio());
            ps.setInt(4, a.getId());
            if (ps.executeUpdate() > 0) {
                PreparedStatement ps1 = this.conexion.prepareStatement("update almacen set cantidad = ? where id_auto = ?");
                ps1.setInt(1, a.getStock());
                ps1.setInt(2, a.getId());
                if (ps1.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizo con exito we");
                    DAO_Registro daoR = new DAO_Registro();
                    daoR.regitroUpdateAuto(new Registro(ad.getId(), a.getId(), "Actualizo un auto"));
                }
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
            PreparedStatement ps = this.conexion.prepareStatement("delete from autos where id = ?;");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito we");
                DAO_Registro daoR = new DAO_Registro();
                daoR.registroDelete(new Registro(ad.getId(), "elimino un auto"));
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
    public DefaultComboBoxModel<Auto> listaAutos() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Auto a : readAutos()) {
            modelo.addElement(a);
        }
        return modelo;
    }

    @Override
    public DefaultTableModel tablaAutos() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");

        for (Auto a : readAutos()) {
            Object[] fila = new Object[5];
            fila[0] = a.getId();
            fila[1] = a.getMarca();
            fila[2] = a.getModelo();
            fila[3] = a.getPrecio();
            fila[4] = a.getStock();
            modelo.addRow(fila);
        }
        return modelo;
    }

    private ArrayList<Auto> readAutos() {
        ArrayList<Auto> autos = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("""
                                                                  SELECT autos.*, almacen.cantidad
                                                                  FROM autos
                                                                  LEFT JOIN almacen ON autos.id = almacen.id_auto;""");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Auto a = new Auto();
                a.setId(rs.getInt("id"));
                a.setMarca(rs.getString("marca"));
                a.setModelo(rs.getString("modelo"));
                a.setPrecio(rs.getFloat("precio"));
                a.setStock(rs.getInt("cantidad"));
                autos.add(a);
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
        return autos;
    }

}
