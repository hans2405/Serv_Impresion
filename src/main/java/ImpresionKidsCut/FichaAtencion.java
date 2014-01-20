/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresionKidsCut;

import java.util.List;

/**
 *
 * @author AlbertoM
 */
public class FichaAtencion {
    private String codigoFicha;
    private String horaLlegada;
    private String nombreCliente;
    private String nombreNinio;
    private String sucursal;
    private List<Servicio> servicios;
    private List<Descuento> descuentos;
    private final int dimLinea = 37;

    public FichaAtencion() {
    }
    
    public FichaAtencion(String codigoFicha,String horaLlegada,String nombreCliente,String nombreNinio,String sucursal,
            List<Servicio> servicios, List<Descuento> descuentos) {
        super();
        this.codigoFicha = codigoFicha;
        this.horaLlegada = horaLlegada;
        this.nombreCliente = nombreCliente;
        this.nombreNinio = nombreNinio;
        this.sucursal = sucursal;
        this.servicios = servicios;
        this.descuentos = descuentos;
    }
    
    public synchronized String imprimir(){
        //------------IMPRESION PARA EL ADMINISTRADOR-----------------//
        PrintHandler.AddCabecera(PrintHandler.ImprimirCentrado("DATOS FICHA", 37));
        PrintHandler.AddCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddCabecera(PrintHandler.DibujarLinea(dimLinea));
        PrintHandler.AddCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Codigo      : "+codigoFicha);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Hr. Llegada  : "+horaLlegada);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Cliente     : "+nombreCliente);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Ninio       : "+nombreNinio);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("Servicios y Personal", 37));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        for (int i = 0; i < servicios.size(); i++) {
            Servicio aux = servicios.get(i);
            if (aux.getCompuesto().equals("2")) {
                PrintHandler.AddSubCabecera(aux.getNombre());
                PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            }
            for (int j = 0; j < aux.getSubServicios().size(); j++) {
                Servicio subServicio = aux.getSubServicios().get(j);
                PrintHandler.AddSubCabecera("*"+subServicio.getNombre()+" -> "+subServicio.getPersonal());
                PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            }
        }
        if (descuentos.size() > 0) {
            PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("Descuentos Aplicados.", 37));    
            PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
            PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            for (int i = 0; i < descuentos.size(); i++) {
                Descuento desc = descuentos.get(i);
                PrintHandler.AddSubCabecera("*"+desc.getNombre()+"("+desc.getDescuento()+
                        ((desc.getFormaDescuento().equals("1"))?"%":"")+")");
                PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            }                        
        }
//        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(32));
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.PrepararCorte());
        PrintHandler.AddSubCabecera(PrintHandler.CortarPapel());

        //------------IMPRESION PARA EL PELUQUERO---------------------//
        PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("DATOS FICHA", 37));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Codigo      : "+codigoFicha);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Cliente     : "+nombreCliente);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Ninio       : "+nombreNinio);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("Servicios y Personal", 37));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        for (int i = 0; i < servicios.size(); i++) {
            Servicio aux = servicios.get(i);
            if (aux.getCompuesto().equals("2")) {
                PrintHandler.AddSubCabecera(aux.getNombre());
                PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            }
            for (int j = 0; j < aux.getSubServicios().size(); j++) {
                Servicio subServicio = aux.getSubServicios().get(j);
                PrintHandler.AddSubCabecera("*"+subServicio.getNombre()+" -> "+subServicio.getPersonal());
                PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            }
        }                             
//        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.PrepararCorte());
        PrintHandler.AddSubCabecera(PrintHandler.CortarPapel());
        
        //----------------IMPRESION PARA EL CLIENTE-----------------//
        PrintHandler.AddSubCabecera("Bienvenido......");
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("KidsCut : Sucursal "+sucursal);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Codigo      : "+codigoFicha);        
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        PrintHandler.AddSubCabecera("Ninio       : "+nombreNinio);
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());   
        if (descuentos.size() > 0) {
            PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("Descuentos Aplicados.", dimLinea));    
            PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
            PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            for (int i = 0; i < descuentos.size(); i++) {
                Descuento desc = descuentos.get(i);
                PrintHandler.AddSubCabecera("*"+desc.getNombre()+"("+desc.getDescuento()+
                        ((desc.getFormaDescuento().equals("1"))?"%":"")+")");
                PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
            }                        
        }
        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        //-------------------Datos de la colilla del cliente-------------------
//        PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("Para una mejor atencion!!",dimLinea));
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera(PrintHandler.ImprimirCentrado("Por Favor Facilitenos Estos Datos.", dimLinea));
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera("Correo:______________________________");
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera("#Carnet:_____________________________");
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera("#Telefono:___________________________");
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
//        PrintHandler.AddSubCabecera(PrintHandler.DibujarLinea(dimLinea));
//        PrintHandler.AddSubCabecera(PrintHandler.DarEspacio());
        //-------------------------------------------------------------------
        PrintHandler.AddSubCabecera(PrintHandler.PrepararCorte());
        PrintHandler.AddSubCabecera(PrintHandler.CortarPapel()); 
        return PrintHandler.ImprimirDocumento();
    }

    /**
     * @return the codigoFicha
     */
    public String getCodigoFicha() {
        return codigoFicha;
    }

    /**
     * @param codigoFicha the codigoFicha to set
     */
    public void setCodigoFicha(String codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    /**
     * @return the horaLlegada
     */
    public String getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * @param horaLlegada the horaLlegada to set
     */
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the nombreNinio
     */
    public String getNombreNinio() {
        return nombreNinio;
    }

    /**
     * @param nombreNinio the nombreNinio to set
     */
    public void setNombreNinio(String nombreNinio) {
        this.nombreNinio = nombreNinio;
    }

    /**
     * @return the servicios
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the sucursal
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the descuentos
     */
    public List<Descuento> getDescuentos() {
        return descuentos;
    }

    /**
     * @param descuentos the descuentos to set
     */
    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }
    
}
