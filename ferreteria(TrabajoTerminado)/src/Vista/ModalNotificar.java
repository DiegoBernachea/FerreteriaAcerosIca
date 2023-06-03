/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author enriq
 */
public class ModalNotificar extends javax.swing.JFrame {

    /**
     * Creates new form ModalVerificar
     * @param mensaje
     */
    public ModalNotificar(String mensaje) {
        initComponents();
        iniComplementLayout();
        iniSize();
        iniLocation();
        iniDiseños();
        lblmensaje.setText(mensaje);
    }
    
     public void redimencionarImagenen(JLabel lblicon,String img){
      // Cargamos la imagen desde un archivo
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(img));//"/Img/login2.jpg"

        // Ajustamos el tamaño de la imagen al tamaño del JLabel
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(lblicon.getWidth(), lblicon.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Establecemos la imagen en el JLabel                
            
        ///labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.jpg"))); 
        lblicon.setIcon(scaledIcon);    
    }
    
    private void iniComplementLayout(){
        //layout de la ventana  
        getContentPane().setLayout(new BorderLayout());
        
        getContentPane().add(paneNotificar, java.awt.BorderLayout.CENTER);
        getContentPane().add(paneHeaderLogin, java.awt.BorderLayout.PAGE_START);
        
         //layout de header de la ventana
        paneHeaderLogin.setLayout(new BoxLayout(paneHeaderLogin, BoxLayout.X_AXIS));
        
        FlowLayout flowlayoutHeaderOpciones = new FlowLayout(FlowLayout.RIGHT,0,0);
        paneHeaderOpciones.setLayout(flowlayoutHeaderOpciones);
        paneHeaderLogin.add(lblHeaderLogo);
        paneHeaderLogin.add(Box.createHorizontalGlue()); // Espaciador flexible
        paneHeaderLogin.add(paneHeaderOpciones);
        
        //layout de contenido de la ventana
        paneNotificar.setLayout(new BorderLayout());
        paneNotificar.add(lblmensaje, java.awt.BorderLayout.CENTER);
        paneNotificar.add(paneBotones, java.awt.BorderLayout.PAGE_END);
        
        FlowLayout flowlayoutBotones = new FlowLayout(FlowLayout.CENTER,30,20);
        paneBotones.setLayout(flowlayoutBotones);
            btnNo.setLayout(new CardLayout());
        
    }
    
     private void iniSize(){
        //tamaño de ventana
        this.setBounds(0,0,400, 200);
        //tamaño del panel header
        paneHeaderLogin.setPreferredSize(new Dimension( 1, 40));
        lblHeaderLogo.setSize(new Dimension( 40, 40));
        lblCerrarVentana.setPreferredSize(new Dimension( 40, 40));
        
        
        //tamaño del panel que contiene el login

        btnNo.setPreferredSize(new Dimension( 100, 30)); 
            
            
    }
     
    private void iniLocation(){
        //centrando ventana
        this.setLocationRelativeTo(null);
        
        
    }
   
    private void iniDiseños(){
        //iniciar imagen del login 
       
        
        //inicaiar imagenes del Header de la ventana.
        redimencionarImagenen(lblHeaderLogo,"/img/logo.png");
         
        lblCerrarVentana.setVerticalAlignment(SwingConstants.CENTER);

        
        lblCerrarVentana.setHorizontalAlignment(SwingConstants.CENTER);
        lblno.setHorizontalAlignment(SwingConstants.CENTER);
        lblmensaje.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneHeaderLogin = new javax.swing.JPanel();
        lblHeaderLogo = new javax.swing.JLabel();
        paneHeaderOpciones = new javax.swing.JPanel();
        lblCerrarVentana = new javax.swing.JLabel();
        paneNotificar = new javax.swing.JPanel();
        lblmensaje = new javax.swing.JLabel();
        paneBotones = new javax.swing.JPanel();
        btnNo = new javax.swing.JPanel();
        lblno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        paneHeaderLogin.setBackground(new java.awt.Color(25, 34, 143));

        lblHeaderLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        paneHeaderOpciones.setBackground(new java.awt.Color(27, 39, 187));
        paneHeaderOpciones.setOpaque(false);

        lblCerrarVentana.setBackground(new java.awt.Color(255, 58, 97));
        lblCerrarVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarVentana.png"))); // NOI18N
        lblCerrarVentana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarVentana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCerrarVentanaMouseMoved(evt);
            }
        });
        lblCerrarVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarVentanaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarVentanaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paneHeaderOpcionesLayout = new javax.swing.GroupLayout(paneHeaderOpciones);
        paneHeaderOpciones.setLayout(paneHeaderOpcionesLayout);
        paneHeaderOpcionesLayout.setHorizontalGroup(
            paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneHeaderOpcionesLayout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(lblCerrarVentana)
                .addGap(48, 48, 48))
        );
        paneHeaderOpcionesLayout.setVerticalGroup(
            paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHeaderOpcionesLayout.createSequentialGroup()
                .addComponent(lblCerrarVentana)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneHeaderLoginLayout = new javax.swing.GroupLayout(paneHeaderLogin);
        paneHeaderLogin.setLayout(paneHeaderLoginLayout);
        paneHeaderLoginLayout.setHorizontalGroup(
            paneHeaderLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneHeaderLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblHeaderLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneHeaderOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        paneHeaderLoginLayout.setVerticalGroup(
            paneHeaderLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHeaderLoginLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(paneHeaderLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeaderLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneHeaderOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        paneNotificar.setBackground(new java.awt.Color(222, 236, 255));

        lblmensaje.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblmensaje.setText("¿Está seguro de querer realizar esta acción?");

        paneBotones.setOpaque(false);

        btnNo.setBackground(new java.awt.Color(72, 84, 247));
        btnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNoMouseMoved(evt);
            }
        });
        btnNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNoMouseExited(evt);
            }
        });

        lblno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblno.setForeground(new java.awt.Color(255, 255, 255));
        lblno.setText("Aceptar");

        javax.swing.GroupLayout btnNoLayout = new javax.swing.GroupLayout(btnNo);
        btnNo.setLayout(btnNoLayout);
        btnNoLayout.setHorizontalGroup(
            btnNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblno)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        btnNoLayout.setVerticalGroup(
            btnNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblno)
                .addContainerGap())
        );

        javax.swing.GroupLayout paneBotonesLayout = new javax.swing.GroupLayout(paneBotones);
        paneBotones.setLayout(paneBotonesLayout);
        paneBotonesLayout.setHorizontalGroup(
            paneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBotonesLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneBotonesLayout.setVerticalGroup(
            paneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneBotonesLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout paneNotificarLayout = new javax.swing.GroupLayout(paneNotificar);
        paneNotificar.setLayout(paneNotificarLayout);
        paneNotificarLayout.setHorizontalGroup(
            paneNotificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNotificarLayout.createSequentialGroup()
                .addComponent(paneBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paneNotificarLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lblmensaje)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        paneNotificarLayout.setVerticalGroup(
            paneNotificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneNotificarLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(paneBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneNotificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(paneHeaderLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(paneHeaderLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneNotificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarVentanaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseMoved
        // TODO add your handling code here:
        lblCerrarVentana.setOpaque(true);
        lblCerrarVentana.repaint();
    }//GEN-LAST:event_lblCerrarVentanaMouseMoved

    private void lblCerrarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseClicked
        // TODO add your handling code here:
        lblCerrarVentana.setOpaque(false);
        lblCerrarVentana.repaint();
        this.dispose(); // Cierra la ventana
        this.setVisible(false); // Oculta la ventana

    }//GEN-LAST:event_lblCerrarVentanaMouseClicked

    private void lblCerrarVentanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseExited
        // TODO add your handling code here:
        lblCerrarVentana.setOpaque(false);
        lblCerrarVentana.repaint();
    }//GEN-LAST:event_lblCerrarVentanaMouseExited

    private void btnNoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoMouseMoved
        // TODO add your handling code here:
        btnNo.setBackground(new Color(26,37,190));
    }//GEN-LAST:event_btnNoMouseMoved

    private void btnNoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoMouseExited
        // TODO add your handling code here:
        btnNo.setBackground(new Color(72,84,247));
    }//GEN-LAST:event_btnNoMouseExited

    private void btnNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoMouseClicked
        // TODO add your handling code here:
        btnNo.setBackground(new Color(72,84,247));
        dispose(); // Cierra la ventana
        setVisible(false); // Oculta la ventana
    }//GEN-LAST:event_btnNoMouseClicked

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModalNotificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalNotificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalNotificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalNotificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModalNotificar("mensaje").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnNo;
    private javax.swing.JLabel lblCerrarVentana;
    private javax.swing.JLabel lblHeaderLogo;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblno;
    private javax.swing.JPanel paneBotones;
    private javax.swing.JPanel paneHeaderLogin;
    private javax.swing.JPanel paneHeaderOpciones;
    private javax.swing.JPanel paneNotificar;
    // End of variables declaration//GEN-END:variables
}
