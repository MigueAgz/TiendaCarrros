/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author rosal
 */
public class Tarjeta {

    private int id;
    private int id_cliente;
    private String banco;
    private String noTarjeta;

    public Tarjeta(int id, int id_cliente, String banco, String noTarjeta) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.banco = banco;
        this.noTarjeta = noTarjeta;
    }

    public Tarjeta(int id_cliente, String banco, String noTarjeta) {
        this.id_cliente = id_cliente;
        this.banco = banco;
        this.noTarjeta = noTarjeta;
    }

    public Tarjeta() {
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
     * @return the noTarjeta
     */
    public String getNoTarjeta() {
        return noTarjeta;
    }

    /**
     * @param noTarjeta the noTarjeta to set
     */
    public void setNoTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return getBanco() + " - " + verTarjeta(getNoTarjeta());
    }

    public static String verTarjeta(String noTarjeta) {
        int longitud = noTarjeta.length();
        String tarjetaOculta = "**** **** **** " + noTarjeta.substring(longitud - 4);
        return tarjetaOculta;

    }

}
