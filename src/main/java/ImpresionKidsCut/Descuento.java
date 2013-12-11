/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresionKidsCut;

/**
 *
 * @author AlbertoM
 */
public class Descuento {
    private String nombre;
    private String descuento;
    private String formaDescuento;

    public Descuento() {
        nombre = "";
        descuento = "";
        formaDescuento = "";
    }
    public Descuento(String nombre, String descuento, String formaDescuento) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.formaDescuento = formaDescuento;                
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descuento
     */
    public String getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the formaDescuento
     */
    public String getFormaDescuento() {
        return formaDescuento;
    }

    /**
     * @param formaDescuento the formaDescuento to set
     */
    public void setFormaDescuento(String formaDescuento) {
        this.formaDescuento = formaDescuento;
    }
    
    
    
}
