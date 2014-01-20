package Logs_Sistema;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Presentacion.PControlPanel;

public class Logs {
    /****************** CONTIENE LA ULTIMA FECHA DEL SISTEMA TOMADA ***************/
    private static String fechaActiva = getFecha();

    /*************** CONTIENE AL ARCHIVO SOBRE EL CUAL TODOS ESCRIBIRAS **********/
    public static FileHandler fileTxt;

    /******************* LOGGER GLOBAL PARA TODAS LAS CLASES *********************/
    public static Logger logger = Logger.getLogger("Global");


    /*********************** SEPARACION ENTRE MENSAJES ******************************/
    public static final String separacion = "-----------------------------------------------------------";

    public Logs() {
    }
    /**
     * Metodo que de un pila de excepciones comienza a darle formato para asi mostrar
     * y guardar esta cadena devuelta en los logs de errores.       
     * @param elementos la pila de excepciones a ser convertida a string
     * @param e el objeto de  la excepcion.
     * @param mensajeFinal un mensaje descriptivo sobre el error que pudo
     * causar la excepcion.
     * @return 
     */
    public static String ste2String(StackTraceElement[] elementos, Object e, String mensajeFinal) {
        String result = "";
        for (int i = 0; i < elementos.length; i++) {
                StackTraceElement ele = elementos[i];
                result = result + " ->Error en la clase: " + ele.getClassName()
                                + "\n   En el metodo: " + ele.getMethodName()
                                + "\n   En la linea: " + ele.getLineNumber() + "\n";
        }
        result = "Error: " + e + "\n" + result +mensajeFinal+"\n"+ separacion;
        return result;
    }

    /**
     * FUNCION LLAMADA DENTRO DEL HILO QUE BUSCA ACTUALIZACIONES PARA SUBIR AL
     * SERVIDOR.
     */
    public static void verficarDia() {
        String fecha = getFecha();
        if (!fecha.equals(fechaActiva)) {
            fileTxt.close();
            iniciarLog();
        }
    }

    /**
     * FUNCION LLAMADA DENTRO DEL CONSTRUCTOR DLE MAIN DE LA APLICACION, PARA INICIAR
     * LOS LOGS DEL SISTEMA. PREFERENTEMENTE LLAMAR ANTES QUE TODO SE CREE PARA
     * ASI TENER LOG DE TODO.
     */
    public static void iniciarLog() {
            try {
                File carpetaLog = new File("logs");
                carpetaLog.mkdir();
                if (carpetaLog.exists()) {
                    fechaActiva = getFecha();
                    fileTxt = new FileHandler("logs/" + fechaActiva + ".erp", true);
                    PControlPanel.mostrarMensaje("Se creo el archivo de log con la fecha "+fechaActiva+"\n" );
                    SimpleFormatter formatterTxt = new SimpleFormatter();
                    fileTxt.setFormatter(formatterTxt);
                    logger.addHandler(fileTxt);
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static String getFecha() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH) + "-"+ (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
    }
    
    public static void escribirLog(String mensajeExcepcion,int tipo){
        switch (tipo) {
            case 1:{//log de informacion (info)
                logger.info(mensajeExcepcion);
                break;
            }
            case 2:{//log de peligro (warning)
                logger.warning(mensajeExcepcion);
                break;
            }
            case 3:{//log de error (severe)
                logger.severe(mensajeExcepcion);
                break;
            }                
        }        
    }
}
