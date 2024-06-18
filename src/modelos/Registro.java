/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author rosal
 */
public class Registro {

    private int id;
    private int id_administrador;
    private int id_tabla;
    private String accion;

    public Registro(int id, int id_administrador, int id_tabla, String accion) {
        this.id = id;
        this.id_administrador = id_administrador;
        this.id_tabla = id_tabla;
        this.accion = accion;
    }

    public Registro(int id_administrador, int id_tabla, String accion) {
        this.id_administrador = id_administrador;
        this.id_tabla = id_tabla;
        this.accion = accion;
    }

    public Registro() {
    }

    public Registro(int id_administrador, String accion) {
        this.id_administrador = id_administrador;
        this.accion = accion;
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
     * @return the id_tabla
     */
    public int getId_tabla() {
        return id_tabla;
    }

    /**
     * @param id_tabla the id_tabla to set
     */
    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}
