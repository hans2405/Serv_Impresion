/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresionKidsCut;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlbertoM
 */
public class Servicio {
    private String nombre;
    private String personal;
    private String compuesto;
    private List<Servicio> subServicios;

    public Servicio() {
        nombre = "";
        personal = "";
        //compuesto puede ser si, o no. si es o no un servicio compuesto.
        compuesto = "no";
        subServicios = new ArrayList<Servicio>();
        
    }
    public Servicio(String nombre, String personal,String compuesto, List<Servicio> subServicios) {
        this.nombre = nombre;
        this.personal = personal;
        this.compuesto = compuesto;
        this.subServicios = subServicios;
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
     * @return the personal
     */
    public String getPersonal() {
        return personal;
    }

    /**
     * @param personal the personal to set
     */
    public void setPersonal(String personal) {
        this.personal = personal;
    }

    /**
     * @return the subServicios
     */
    public List<Servicio> getSubServicios() {
        return subServicios;
    }

    /**
     * @param subServicios the subServicios to set
     */
    public void setSubServicios(List<Servicio> subServicios) {
        this.subServicios = subServicios;
    }

    /**
     * @return the compuesto
     */
    public String getCompuesto() {
        return compuesto;
    }

    /**
     * @param compuesto the compuesto to set
     */
    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }
     
    
}
