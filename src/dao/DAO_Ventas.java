/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Adler32;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Administrador;
import modelos.Auto;
import modelos.Registro;
import modelos.Tarjeta;
import modelos.Venta;

/**
 *
 * @author rosal
 */
public class DAO_Ventas extends conexion implements I_Venta {

    @Override
    public void createVentas(Venta v, Administrador ad) {
        try {
            create(v, ad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Checale we pq hubo un error-> " + e);
        }
    }

    private void create(Venta v, Administrador ad) throws SQLException {
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into ventas(id_administrador, id_cliente, id_auto, cantidad, subtotal, id_direccion, id_tarjeta) values (?,?,?,?,?,?,?);");
            ps.setInt(1, v.getId_administrador());
            ps.setInt(2, v.getId_cliente());
            ps.setInt(3, v.getId_auto());
            ps.setInt(4, v.getCantidad());
            ps.setFloat(5, v.getSubtotal());
            ps.setInt(6, v.getId_direccion());
            ps.setInt(7, v.getId_tarjeta());
            if (ps.executeUpdate() > 0) {
                DAO_Auto dao = new DAO_Auto();
                Auto a = dao.readAuto(v.getId_auto());
                int newStock = a.getStock() - v.getCantidad();
                PreparedStatement ps1 = this.conexion.prepareStatement("update almacen set cantidad = ? where id_auto = ?");
                ps1.setInt(1, newStock);
                ps1.setInt(2, a.getId());
                if (ps1.executeUpdate() > 0) {
                    PreparedStatement ps2 = this.conexion.prepareStatement("select id from ventas where id_administrador = ? and id_cliente = ? and id_auto = ? and cantidad = ? and subtotal = ? and id_direccion = ? and id_tarjeta = ?");
                    ps2.setInt(1, v.getId_administrador());
                    ps2.setInt(2, v.getId_cliente());
                    ps2.setInt(3, v.getId_auto());
                    ps2.setInt(4, v.getCantidad());
                    ps2.setFloat(5, v.getSubtotal());
                    ps2.setInt(6, v.getId_direccion());
                    ps2.setInt(7, v.getId_tarjeta());
                    ResultSet rs1 = ps2.executeQuery();
                    if (rs1.next()) {
                        v.setId(rs1.getInt("id"));
                        JOptionPane.showMessageDialog(null, "Se creo con exito we");
                        DAO_Registro daor = new DAO_Registro();
                        daor.registroCreateVentas(new Registro(ad.getId(), v.getId(), "Creo una venta"));
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

    @Override
    public DefaultTableModel tablaVentas() {
        ArrayList<String[]> ventas = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement(
                    "SELECT ventas.id, administrador.nombre AS administrador, cliente.nombre AS cliente, direcciones.calle, tarjetas.noTarjeta, autos.marca, ventas.cantidad, ventas.subtotal "
                    + "FROM ventas "
                    + "LEFT JOIN administrador ON ventas.id_administrador = administrador.id "
                    + "LEFT JOIN cliente ON ventas.id_cliente = cliente.id "
                    + "LEFT JOIN direcciones ON ventas.id_direccion = direcciones.id "
                    + "LEFT JOIN tarjetas ON ventas.id_tarjeta = tarjetas.id "
                    + "LEFT JOIN autos ON ventas.id_auto = autos.id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idVenta = rs.getString("id");
                String nombreAdministrador = rs.getString("administrador");
                String nombreCliente = rs.getString("cliente");
                String calleDireccion = rs.getString("calle");
                String noTarjeta = Tarjeta.verTarjeta(rs.getString("noTarjeta"));
                String marcaAuto = rs.getString("marca");
                int cantidad = rs.getInt("cantidad");
                float subtotal = rs.getFloat("subtotal");

                String[] venta = {idVenta, nombreAdministrador, nombreCliente, calleDireccion, noTarjeta, marcaAuto, Integer.toString(cantidad), Float.toString(subtotal)};
                ventas.add(venta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al leer las ventas: " + e.getMessage());
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
        model.addColumn("Cliente");
        model.addColumn("Calle");
        model.addColumn("No. Tarjeta");
        model.addColumn("Marca");
        model.addColumn("Cantidad");
        model.addColumn("Subtotal");
        for (String[] venta : ventas) {
            model.addRow(venta);
        }
        return model;
    }

}
