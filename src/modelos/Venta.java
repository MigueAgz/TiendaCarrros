/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author rosal
 */
public class Venta {

    private int id;
    private int id_administrador;
    private int id_cliente;
    private int id_auto;
    private int cantidad;
    private float subtotal;
    private int id_direccion;
    private int id_tarjeta;

    public Venta(int id, int id_administrador, int id_cliente, int id_auto, int cantidad, float subtotal, int id_direccion, int id_tarjeta) {
        this.id = id;
        this.id_administrador = id_administrador;
        this.id_cliente = id_cliente;
        this.id_auto = id_auto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.id_direccion = id_direccion;
        this.id_tarjeta = id_tarjeta;
    }

    public Venta(int id_administrador, int id_cliente, int id_auto, int cantidad, float subtotal, int id_direccion, int id_tarjeta) {
        this.id_administrador = id_administrador;
        this.id_cliente = id_cliente;
        this.id_auto = id_auto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.id_direccion = id_direccion;
        this.id_tarjeta = id_tarjeta;
    }

    public Venta() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_administrador
     */
    public int getId_administrador() {
        return id_administrador;
    }

    /**
     * @param id_administrador the id_administrador to set
     */
    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_auto
     */
    public int getId_auto() {
        return id_auto;
    }

    /**
     * @param id_auto the id_auto to set
     */
    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the id_direccion
     */
    public int getId_direccion() {
        return id_direccion;
    }

    /**
     * @param id_direccion the id_direccion to set
     */
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    /**
     * @return the id_tarjeta
     */
    public int getId_tarjeta() {
        return id_tarjeta;
    }

    /**
     * @param id_tarjeta the id_tarjeta to set
     */
    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

}
