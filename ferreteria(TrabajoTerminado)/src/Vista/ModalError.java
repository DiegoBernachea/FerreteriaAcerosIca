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
public class ModalError extends javax.swing.JFrame {

    /**
     * Creates new form ModalVerificar
     * @param mensaje
     */
    public ModalError(String mensaje) {
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
        
        getContentPane().add(paneVerificar, java.awt.BorderLayout.CENTER);
        getContentPane().add(paneHeaderLogin, java.awt.BorderLayout.PAGE_START);
        
         //layout de header de la ventana
        paneHeaderLogin.setLayout(new BoxLayout(paneHeaderLogin, BoxLayout.X_AXIS));
        
        FlowLayout flowlayoutHeaderOpciones = new FlowLayout(FlowLayout.RIGHT,0,0);
        paneHeaderOpciones.setLayout(flowlayoutHeaderOpciones);
        paneHeaderLogin.add(lblHeaderLogo);
        paneHeaderLogin.add(Box.createHorizontalGlue()); // Espaciador flexible
        paneHeaderLogin.add(paneHeaderOpciones);
        
        //layout de contenido de la ventana
        paneVerificar.setLayout(new BorderLayout());
        paneVerificar.add(lblmensaje, java.awt.BorderLayout.CENTER);
        paneVerificar.add(paneBotones, java.awt.BorderLayout.PAGE_END);
        
        FlowLayout flowlayoutBotones = new FlowLayout(FlowLayout.CENTER,30,20);
        paneBotones.setLayout(flowlayoutBotones);
            btnSi.setLayout(new CardLayout());
            
        
    }
    
     private void iniSize(){
        //tamaño de ventana
        this.setBounds(0,0,400, 200);
        //tamaño del panel header
        paneHeaderLogin.setPreferredSize(new Dimension( 1, 40));
        lblHeaderLogo.setSize(new Dimension( 40, 40));
        lblCerrarVentana.setPreferredSize(new Dimension( 40, 40));
        
        
        //tamaño del panel que contiene el login
        btnSi.setPreferredSize(new Dimension( 100, 30));
      
            
            
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
        lblsi.setHorizontalAlignment(SwingConstants.CENTER);
      
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
        paneVerificar = new javax.swing.JPanel();
        lblmensaje = new javax.swing.JLabel();
        paneBotones = new javax.swing.JPanel();
        btnSi = new javax.swing.JPanel();
        lblsi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        paneHeaderLogin.setBackground(new java.awt.Color(143, 24, 24));

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

        paneVerificar.setBackground(new java.awt.Color(255, 238, 238));

        lblmensaje.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblmensaje.setText("Error");

        paneBotones.setOpaque(false);

        btnSi.setBackground(new java.awt.Color(190, 25, 25));
        btnSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSiMouseMoved(evt);
            }
        });
        btnSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSiMouseExited(evt);
            }
        });

        lblsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblsi.setForeground(new java.awt.Color(255, 255, 255));
        lblsi.setText("Aceptar");

        javax.swing.GroupLayout btnSiLayout = new javax.swing.GroupLayout(btnSi);
        btnSi.setLayout(btnSiLayout);
        btnSiLayout.setHorizontalGroup(
            btnSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSiLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(lblsi)
                .addGap(51, 51, 51))
        );
        btnSiLayout.setVerticalGroup(
            btnSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblsi)
                .addContainerGap())
        );

        javax.swing.GroupLayout paneBotonesLayout = new javax.swing.GroupLayout(paneBotones);
        paneBotones.setLayout(paneBotonesLayout);
        paneBotonesLayout.setHorizontalGroup(
            paneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBotonesLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        paneBotonesLayout.setVerticalGroup(
            paneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneBotonesLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout paneVerificarLayout = new javax.swing.GroupLayout(paneVerificar);
        paneVerificar.setLayout(paneVerificarLayout);
        paneVerificarLayout.setHorizontalGroup(
            paneVerificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVerificarLayout.createSequentialGroup()
                .addComponent(paneBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paneVerificarLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lblmensaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneVerificarLayout.setVerticalGroup(
            paneVerificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneVerificarLayout.createSequentialGroup()
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
                        .addComponent(paneVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(paneVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnSiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiMouseMoved
        // TODO add your handling code here:
        
        btnSi.setBackground(new Color(247,71,71));
    }//GEN-LAST:event_btnSiMouseMoved

    private void btnSiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiMouseExited
        // TODO add your handling code here:
        btnSi.setBackground(new Color(190,25,25));
    }//GEN-LAST:event_btnSiMouseExited

    private void btnSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiMouseClicked
        // TODO add your handling code here:
        
        this.dispose(); // Cierra la ventana
        this.setVisible(false);
    }//GEN-LAST:event_btnSiMouseClicked

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
            java.util.logging.Logger.getLogger(ModalError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModalError("ERROR").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSi;
    private javax.swing.JLabel lblCerrarVentana;
    private javax.swing.JLabel lblHeaderLogo;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblsi;
    private javax.swing.JPanel paneBotones;
    private javax.swing.JPanel paneHeaderLogin;
    private javax.swing.JPanel paneHeaderOpciones;
    private javax.swing.JPanel paneVerificar;
    // End of variables declaration//GEN-END:variables
}
