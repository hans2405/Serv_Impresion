/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ImpresionKidsCut.Descuento;
import ImpresionKidsCut.FichaAtencion;
import ImpresionKidsCut.Servicio;
import Logs_Sistema.Logs;
import ServerSocket.ServerSocket;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import org.jvnet.substance.SubstanceLegacyDefaultLookAndFeel;

/** 
 * @author AlbertoM
 */
public class PControlPanel extends javax.swing.JFrame {
    private ServerSocket server;
    private boolean  serverActivo;

    /**
     * Creates new form PControlPanel
     */
    public PControlPanel() {
        initComponents();
        this.setSize(631, 355);
        this.setTitle("serv_imp v12.12.2013");
        jEstado.setText("Inactivo");
        jEstado.setOpaque(true);
        jEstado.setBackground(Color.RED);
        jEstado.setForeground(Color.BLACK);
        jbtnIniciarParar.setText("Iniciar");
        jtxtConsola.setText("");
        server = new ServerSocket("localhost", 9092,this);
        serverActivo = false;
        jtxtConsola.setBorder(BorderFactory.createTitledBorder(""));
        Font font = new Font("Times New Roman", Font.ITALIC, 14);
        jtxtConsola.setFont(font);
        jtxtConsola.setForeground(Color.BLACK);
        jtxtConsola.setBackground(Color.BLACK);
    }
    
    public static void liberarMemoria(){
        try{ 
                Runtime basurero = Runtime.getRuntime(); 
                basurero.gc(); //Solicitando ... 
        }catch(RuntimeException e){
                Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, ""),3);
        }
        catch( Exception e ){
                Logs.escribirLog(Logs.ste2String(e.getStackTrace(), e, ""),3);
        }
    }
	
    public static void mostrarMensaje(String mensaje){
        jtxtConsola.insert(mensaje, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jEstadoTip = new javax.swing.JLabel();
        jEstado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtConsola = new javax.swing.JTextArea();
        jbtnLimpiar = new javax.swing.JButton();
        jbtnIniciarParar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Panel de Control Servidor");

        jEstadoTip.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jEstadoTip.setText("Estado: ");

        jEstado.setBackground(new java.awt.Color(204, 0, 0));
        jEstado.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jEstado.setText("Activo");

        jtxtConsola.setColumns(20);
        jtxtConsola.setRows(5);
        jScrollPane1.setViewportView(jtxtConsola);

        jbtnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jbtnLimpiar.setText("Limpiar");
        jbtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarActionPerformed(evt);
            }
        });

        jbtnIniciarParar.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jbtnIniciarParar.setText("Iniciar");
        jbtnIniciarParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIniciarPararActionPerformed(evt);
            }
        });

        jButton1.setText("Test de Impresion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jbtnIniciarParar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEstadoTip, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(130, 130, 130)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnIniciarParar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jEstadoTip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarActionPerformed
        // TODO add your handling code here:
        jtxtConsola.setText("");
    }//GEN-LAST:event_jbtnLimpiarActionPerformed

    private void jbtnIniciarPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIniciarPararActionPerformed
        // TODO add your handling code here:
        if (serverActivo) {
            if (server.detenerServidor()) {
                serverActivo = false;
                jbtnIniciarParar.setText("Iniciar");
                jEstado.setText("Inactivo");
                jEstado.setBackground(Color.RED);
                jEstado.setForeground(Color.BLACK);
            }
        }else{
            if (server.iniciarServidor()) {
                serverActivo = true;
                jbtnIniciarParar.setText("Detener");
                jEstado.setText("Activo");
                jEstado.setBackground(Color.GREEN);
                jEstado.setForeground(Color.BLACK);
            }
        }
    }//GEN-LAST:event_jbtnIniciarPararActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList servicios = new ArrayList();
        Servicio s = new Servicio("Servicio 1", "Empleado 1", "1", new ArrayList<Servicio>());
        Servicio s2 = new Servicio("Servicio 2", "Empleado 2", "1", new ArrayList<Servicio>());
        servicios.add(s);
        servicios.add(s2);
        
        ArrayList descuentos = new ArrayList();
        Descuento d = new Descuento("Descuento 1", "##", "1");
        Descuento d2 = new Descuento("Descuento 2", "##", "1");
        descuentos.add(d);
        descuentos.add(d2);
        
        FichaAtencion fichaPrueba = new FichaAtencion("XX-XXX-XX-XXXXXX", "00:00:00", "Algun Cliente", "Algun Ninio", "Sucursal K#", 
                servicios, descuentos);
        String respuesta = fichaPrueba.imprimir();  
        if (!respuesta.equals("ok")) {
            jtxtConsola.append(respuesta+"\n\r");
        }else{
            jtxtConsola.append("------|Se imprimio la ficha de PRUEBA con codigo: "+fichaPrueba.getCodigoFicha()+"\n\r");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceLegacyDefaultLookAndFeel()); // buena eleccion
                     javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
                    javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
                 } catch (Exception ex) {
                 }
                new PControlPanel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jEstadoTip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnIniciarParar;
    private javax.swing.JButton jbtnLimpiar;
    public static javax.swing.JTextArea jtxtConsola;
    // End of variables declaration//GEN-END:variables
}
