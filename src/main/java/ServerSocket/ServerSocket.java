package ServerSocket;

import ImpresionKidsCut.FichaAtencion;
import Logs_Sistema.Logs;
import Presentacion.PControlPanel;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

public class ServerSocket {
    private final SocketIOServer server;
    private PControlPanel frame;
    private String host;
    private  int port;
    private final DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    public ServerSocket(String host, int port, JFrame frame) {
        this.frame = (PControlPanel) frame;
        this.port = port;
        this.host = host;
        
        Configuration config = new Configuration();
        config.setHostname(host);
        config.setPort(port);
        
        server = new SocketIOServer(config);
        server.addEventListener("print", FichaAtencion.class, new DataListener<FichaAtencion>() {
            @Override
            public void onData(SocketIOClient client, FichaAtencion data, AckRequest ackRequest) {
                String respuesta = data.imprimir();  
                if (!respuesta.equals("ok")) {
                    enviarMensajeConsola(respuesta);
                }else{
                    enviarMensajeConsola("------|Se imprimio la ficha con codigo: "+data.getCodigoFicha()+" a las "+hourdateFormat.format(new Date()));
                }
                try {
                    client.sendEvent("response", respuesta);
                } catch (Exception e) {
                    client.sendEvent("response", e.getMessage());
                    Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, " Ocurrio un error al momento de responder al cliente sobre la impresion."), 2);
                    enviarMensajeConsola("Ocurrio un error al momento de responder al cliente sobre la impresion.");
                }                
            }
        });
        server.addConnectListener(new ConnectListener() {
            public void onConnect(SocketIOClient client) {
                enviarMensajeConsola("*Se ha conectado el cliente con Address:"+ client.getRemoteAddress());
            }
        });
        
        server.addDisconnectListener(new DisconnectListener() {
            public void onDisconnect(SocketIOClient client) {
                        enviarMensajeConsola("*Se ha desconectado el cliente con Address:"+ client.getRemoteAddress());
            }
        });
    }
    
    public boolean iniciarServidor(){ 
        try {
            server.start();
            enviarMensajeConsola("|----------SERVIDOR SE HA INICIADO A LAS "+hourdateFormat.format(new Date())+"----------|en el puerto "+port);
            System.out.println("Servidor Iniciado....");
            Logs.escribirLog("El servidor se ha INICIADO a las "+hourdateFormat.format(new Date()), 1);
            return true;
        } catch (Exception e) {
            enviarMensajeConsola("***No fue posible iniciar el servidor. Error: "+e.getMessage());
            Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, "No fue posible iniciar el servidor."), 3);
            return false;
        }        
    }
    
    public boolean detenerServidor(){
        try {
            server.stop();
            enviarMensajeConsola("|----------SERVIDOR SE HA DETENIDO A LAS "+hourdateFormat.format(new Date())+"--------|");
            Logs.escribirLog("El servidor se ha DETENIDO a las "+hourdateFormat.format(new Date()), 1);
            return true;
        } catch (Exception e) {
            enviarMensajeConsola("***No fue posible detener el servidor. Error: "+e.getMessage());
            Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, "No fue posible detener el servidor."), 3);
            return false;
        }
    }
    
    public void enviarMensajeConsola(String mensaje){
        try {
            PControlPanel.jtxtConsola.append(mensaje+"\n\r");
            Logs.escribirLog("Mensaje en consola: "+mensaje, 1);            
        } catch (Exception e) {
            Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, "No fue posible mostrar el mensaje: "+mensaje+" en la consola"), 2);
        }
    }
}
