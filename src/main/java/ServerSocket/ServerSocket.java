package ServerSocket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import ImpresionKidsCut.FichaAtencion;
import Presentacion.PControlPanel;
import com.corundumstudio.socketio.listener.ConnectListener;
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
                try {
//                    System.out.println(data.getCodigoFicha());
                    data.imprimir();                    
                    enviarMensajeConsola("------|Se imprimio la ficha con codigo: "+data.getCodigoFicha()+" a las "+hourdateFormat.format(new Date()));
                    client.sendEvent("response", "ok");
                } catch (Exception e) {
                    client.sendEvent("response", e.getMessage());
                    e.printStackTrace();
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
            return true;
        } catch (Exception e) {
            enviarMensajeConsola("*** No es posible iniciar el servidor, debido a que ya hay una aplicacion usando el puerto "+port);
            e.printStackTrace();
            return false;
        }   

        
    }
    
    public void detenerServidor(){
        server.stop();
        enviarMensajeConsola("|----------SERVIDOR SE HA DETENIDO A LAS "+hourdateFormat.format(new Date())+"--------|");
    }
    
    public void enviarMensajeConsola(String mensaje){
        frame.jtxtConsola.append(mensaje+"\n\r");
    }

//    public static void main(String[] args) throws InterruptedException {
//
//        Configuration config = new Configuration();
//        config.setHostname("localhost");
//        config.setPort(9092);
//
//        final SocketIOServer server = new SocketIOServer(config);
//        
//        server.addEventListener("print", FichaAtencion.class, new DataListener<FichaAtencion>() {
//            @Override
//            public void onData(SocketIOClient client, FichaAtencion data, AckRequest ackRequest) {
//                try {
//                    System.out.println(data.getCodigoFicha());
////                    data.imprimir();
//                    client.sendEvent("response", "ok");
//                } catch (Exception e) {
//                    client.sendEvent("response", e.getMessage());
//                }                
//            }
//        });
//        server.start();
//        System.out.println("Servidor Iniciado....");
////        server.stop();
//    }

}
