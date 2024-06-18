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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Registro;

/**
 *
 * @author rosal
 */
public class DAO_Registro extends conexion implements I_Registro {

    @Override
    public void registroCreateAuto(Registro r) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into registro(id_administrador, accion, id_auto) values (?,?,?);");
            ps.setInt(1, r.getId_administrador());
            ps.setString(2, r.getAccion());
            ps.setInt(3, r.getId_tabla());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void registroDelete(Registro r) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into registro(id_administrador, accion) values (?,?);");
            ps.setInt(1, r.getId_administrador());
            ps.setString(2, r.getAccion());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void regitroUpdateAuto(Registro r) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into registro(id_administrador, accion, id_auto) values (?,?,?);");
            ps.setInt(1, r.getId_administrador());
            ps.setString(2, r.getAccion());
            ps.setInt(3, r.getId_tabla());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void registroCreateCliente(Registro r) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into registro(id_administrador, accion, id_cliente) values (?,?,?);");
            ps.setInt(1, r.getId_administrador());
            ps.setString(2, r.getAccion());
            ps.setInt(3, r.getId_tabla());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void registroUpdateCliente(Registro r) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into registro(id_administrador, accion, id_cliente) values (?,?,?);");
            ps.setInt(1, r.getId_administrador());
            ps.setString(2, r.getAccion());
            ps.setInt(3, r.getId_tabla());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void registroCreateVentas(Registro r) {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into registro(id_administrador, accion, id_ventas) values (?,?,?);");
            ps.setInt(1, r.getId_administrador());
            ps.setString(2, r.getAccion());
            ps.setInt(3, r.getId_tabla());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public DefaultTableModel tablaRegistro() {
        ArrayList<String[]> registros = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("""
                                                                  SELECT registro.id, administrador.nombre as administrador, registro.accion, autos.marca as auto, cliente.nombre as cliente, registro.id_ventas as venta, registro.fecha
                                                                  FROM registro 
                                                                  inner join administrador on registro.id_administrador = administrador.id
                                                                  left join autos on registro.id_auto = autos.id
                                                                  left join cliente on registro.id_cliente =  cliente.id
                                                                  order by fecha desc;""");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idRegistro = rs.getString("id");
                String nombreAdministrador = rs.getString("administrador");
                String accion = rs.getString("accion");
                String marcaAuto = rs.getString("auto");
                String nombreCliente = rs.getString("cliente");
                String idVenta = rs.getString("venta");
                Date fecha = rs.getDate("fecha");

                String[] registro = {idRegistro, nombreAdministrador, accion, marcaAuto, nombreCliente, idVenta, String.valueOf(fecha)};
                registros.add(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al leer el registro: " + e.getMessage());
        } finally {
            try {
                this.cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Administrador");
        model.addColumn("Accion");
        model.addColumn("Auto");
        model.addColumn("Cliente");
        model.addColumn("ID Venta");
        model.addColumn("Fecha");
        for (String[] registro : registros) {
            model.addRow(registro);
        }
        return model;

    }

}
