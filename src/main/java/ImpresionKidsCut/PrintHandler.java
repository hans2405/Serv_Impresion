package ImpresionKidsCut;

import java.util.ArrayList;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
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

	public static void ImprimirDocumento(){ 
		String cadena=""; 
		for(int cabecera=0;cabecera<CabezaLineas.size();cabecera++ ){
			cadena+=CabezaLineas.get(cabecera);
		} 
		for(int subcabecera=0;subcabecera<subCabezaLineas.size();subcabecera++){
			cadena+=subCabezaLineas.get(subcabecera);
		} 		
		for(int pie=0;pie<LineasPie.size();pie++){
			cadena+=LineasPie.get(pie);
		}	
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
		PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
		DocPrintJob pj = service.createPrintJob(); 
		byte[]bytes =cadena.getBytes(); 
		Doc doc = new SimpleDoc(bytes, flavor,null); 
		try{ 
			pj.print(doc,null); 	
                        CabezaLineas=new ArrayList<String>();
                        subCabezaLineas=new ArrayList<String>();
                        LineasPie=new ArrayList<String>();
		}catch(Exception e){ 
			System.out.println(e.getMessage());
		} 
	} 
} 
 
