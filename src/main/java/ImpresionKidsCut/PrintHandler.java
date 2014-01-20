package ImpresionKidsCut;

import Logs_Sistema.Logs;
import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.standard.PrinterState;
import javax.print.attribute.standard.PrinterStateReason;
import javax.print.attribute.standard.PrinterStateReasons;
public class PrintHandler{ 
    static ArrayList<String> CabezaLineas=new ArrayList<String>(); 
    static ArrayList<String> subCabezaLineas=new ArrayList<String>(); 
    static ArrayList<String> items=new ArrayList<String>(); 
    static ArrayList<String> totales=new ArrayList<String>(); 
    static ArrayList<String> LineasPie=new ArrayList<String>(); 

    public static void AddCabecera(String line){
        CabezaLineas.add(line);
    } 
    public static void AddSubCabecera(String line){
        subCabezaLineas.add(line);
    } 	
    public static void AddPieLinea(String line){
        LineasPie.add(line);
    } 
    public static String DibujarLinea(int valor){ 
        String raya="";
        for(int x=0;x<valor;x++){
                raya+="-";
        }
        return raya; 
    } 
    public static String DarEspacio(){
        return "\n\r";
    } 
    public static String CortarPapel(){
//		char[] CORTAR_PAPEL=new char[]{0x1B,'m'}; // codigo q corta el papel
//		return new String(CORTAR_PAPEL);		
        return (char)27+ "m";
    } 
    public static String PrepararCorte(){
        String result = PrintHandler.DarEspacio();
        result += PrintHandler.DarEspacio();
        result += PrintHandler.DarEspacio();
        result += PrintHandler.DarEspacio();
        result += PrintHandler.DarEspacio();
        result += PrintHandler.DarEspacio();
        result += PrintHandler.DarEspacio();
        return result;
    } 

    public static String ImprimirCentrado(String mensaje, int dimension){
        int mensajeDim = mensaje.length()/2;
        int cantEspacios = (dimension / 2) - mensajeDim;
        String mensajeRes = "";
        for (int i = 0; i < cantEspacios; i++) {
            mensajeRes += " ";
        }
        mensajeRes += mensaje;
        return mensajeRes;
    }

    public static String ImprimirDocumento(){ 
        String cadena="";
        String resultado = "";
        for(int cabecera=0;cabecera<CabezaLineas.size();cabecera++ ){
            cadena+=CabezaLineas.get(cabecera);
        } 
        for(int subcabecera=0;subcabecera<subCabezaLineas.size();subcabecera++){
            cadena+=subCabezaLineas.get(subcabecera);
        } 		
        for(int pie=0;pie<LineasPie.size();pie++){
            cadena+=LineasPie.get(pie);
        }
        DocFlavor flavor        = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
        PrintService service    = PrintServiceLookup.lookupDefaultPrintService(); 
        DocPrintJob pj          = service.createPrintJob(); 
        byte[]bytes             = cadena.getBytes(); 
        Doc doc = new SimpleDoc(bytes, flavor,null); 
        if (impresoraDisponible(service)) {//verificarEstadoImpresora.
            try{ 
                pj.print(doc,null); 
                resultado = "ok";
            }catch(PrintException pe){
                Logs.escribirLog(Logs.ste2String(pe.getStackTrace(), pe, "Ocurrio un error al momento de Imprimir."), 3);
                resultado = "Ocurrio un error al momento de Imprimir. Error: "+pe.getMessage();
                System.out.println(pe.getMessage());
            }catch(Exception e){ 
                Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, "Ocurrio un error al momento de Imprimir."), 3);
                resultado = "Ocurrio un error al momento de Imprimir. Error: "+e.getMessage();
                System.out.println(e.getMessage());
            }            
        }
        CabezaLineas=new ArrayList<String>();
        subCabezaLineas=new ArrayList<String>();
        LineasPie=new ArrayList<String>();
        return resultado;
    } 
    
    public static boolean impresoraDisponible(PrintService printService){
//        printService    = PrintServiceLookup.lookupDefaultPrintService();
//        AttributeSet attributes = printService.getAttributes();
//        String printerStateReason = attributes.get(PrinterStateReason.class).toString();
//
//        System.out.println("printerStateReason = " + printerStateReason); // If your printer state returns STOPPED, for example, you can identify the reason 
//        if (printerStateReason.equals(PrinterStateReason.SHUTDOWN.toString())) {
//            System.out.println("La impresora no esta conectada");
//            return false;
//        }
        return true;
    }
    
    public static void main(String[] args) {
        PrintService printer = PrintServiceLookup.lookupDefaultPrintService();
        PrinterStateReasons pe = new PrinterStateReasons();
        pe.getCategory();
        AttributeSet att = printer.getAttributes();
        for (Attribute a : att.toArray()) {
            String attributeName;
            String attributeValue;
            attributeName = a.getName();
            attributeValue = att.get(a.getClass()).toString();
            System.out.println(attributeName + " : " + attributeValue);
        }
    }
} 
 
