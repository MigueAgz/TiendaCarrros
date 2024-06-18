/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author rosal
 */
public class Direccion {

    private int id;
    private int id_cliente;
    private int numero;
    private int cp;
    private String calle;
    private String ciudad;
    private String colonia;

    public Direccion() {
    }

    public Direccion(int id, int id_cliente, int numero, int cp, String calle, String ciudad, String colonia) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.numero = numero;
        this.cp = cp;
        this.calle = calle;
        this.ciudad = ciudad;
        this.colonia = colonia;

    }

    public Direccion(int id_cliente, int numero, int cp, String calle, String ciudad, String colonia) {
        this.id_cliente = id_cliente;
        this.numero = numero;
        this.cp = cp;
        this.calle = calle;
        this.ciudad = ciudad;
        this.colonia = colonia;
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
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return getCalle() + " #" + getNumero();
    }

}
