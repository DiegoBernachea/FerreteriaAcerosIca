/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import Controller.LoginController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


/**
 *
 * @author enriq
 */
public class LoginFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form login
     */
    private final LoginController LoginCon=new LoginController();
    public static Map<String, Object> sesionUsuario;
    public static boolean pantallaMaximizada;
    public static boolean pantallaCompleta;
    public LoginFrame() {
        initComponents();
        iniComplementLayout();
        iniSize();
        iniLocation();
        iniDiseños();
        pantallaMaximizada=false;
        pantallaCompleta= false;
        
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
        
        getContentPane().add(paneLogFondo, java.awt.BorderLayout.CENTER);
        getContentPane().add(paneHeaderLogin, java.awt.BorderLayout.PAGE_START);
        getContentPane().remove(panecontenedorPantallaNormal);
         //layout de header de la ventana
        paneHeaderLogin.setLayout(new BoxLayout(paneHeaderLogin, BoxLayout.X_AXIS));
        
        FlowLayout flowlayoutcontenedorPantallaNormal = new FlowLayout(FlowLayout.LEFT,0,0);
        panecontenedorPantallaNormal.setLayout(flowlayoutcontenedorPantallaNormal);
        panecontenedorPantallaNormal.add(lblPantallaNormal);
        
        
        FlowLayout flowlayoutHeaderOpciones = new FlowLayout(FlowLayout.RIGHT,0,0);
        
        
        paneHeaderOpciones.setLayout(flowlayoutHeaderOpciones);
        paneHeaderLogin.add(lblHeaderLogo);
        paneHeaderLogin.add(Box.createHorizontalGlue()); // Espaciador flexible
        paneHeaderLogin.add(paneHeaderOpciones);
        
        //layout de contenido de la ventana
        paneLogFondo.setLayout(new GridBagLayout());
        paneLogin.setLayout(null);
        
        btnLogLogin.setLayout(new CardLayout());
        
        
    }
    
     private void iniSize(){
        //tamaño de ventana
        this.setBounds(0,0,1100, 700);
        //tamaño del panel header
        paneHeaderLogin.setPreferredSize(new Dimension( 1, 40));
        panecontenedorPantallaNormal.setPreferredSize(new Dimension( 1, 40));
        lblPantallaNormal.setSize(new Dimension( 40, 40));
        lblHeaderLogo.setSize(new Dimension( 40, 40));
        lblCerrarVentana.setPreferredSize(new Dimension( 40, 40));
        lblMaximizar.setPreferredSize(new Dimension( 40, 40));
        lblMinimizar.setPreferredSize(new Dimension( 40, 40));
        lblPantallaCompleta.setPreferredSize(new Dimension( 40, 40));
        lblPantallaNormal.setPreferredSize(new Dimension( 40, 40));
        
        //tamaño del panel que contiene el login
        paneLogin.setPreferredSize(new Dimension( 870, 470));
        
            //tamaño de recursos dentro del panel login
            lblLogImg.setSize(new Dimension(435,470)); 

            lblLogBienvenida.setSize(new Dimension(189,48));
            
            lblUser.setSize(new Dimension(110,30));
            txtUser.setSize(new Dimension(285,30));
            
            lblClave.setSize(new Dimension(110,30));
            txtClave.setSize(new Dimension(285,30));
            
            btnLogLogin.setSize(new Dimension(285,40));
            
            
            
    }
     
    private void iniLocation(){
        //centrando ventana
        this.setLocationRelativeTo(null);
        
        //ubicacion de la imagen del login
        lblLogImg.setLocation(0, 0);
        
        //ubicacion del titulo 
        lblLogBienvenida.setLocation(558,40);
        
        //ubicacion de las cajas de texto y su icono
        lblUser.setLocation(510,145);
        txtUser.setLocation(510,180);
            
        lblClave.setLocation(510,245);
        txtClave.setLocation(510,280);
        
        //ubicacion boton
        btnLogLogin.setLocation(510,380);
        
    }
   
    private void iniDiseños(){
        //iniciar imagen del login 
        redimencionarImagenen(lblLogImg,"/img/login.jpg");
        
        //inicaiar imagenes del Header de la ventana.
        redimencionarImagenen(lblHeaderLogo,"/img/logo.png");
        
        //diseño de usuario y clave
        txtUser.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,Color.BLACK));
        txtClave.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,Color.BLACK));
        
        lblTitulobtn.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblCerrarVentana.setVerticalAlignment(SwingConstants.CENTER);
        lblMaximizar.setVerticalAlignment(SwingConstants.CENTER);
        lblMinimizar.setVerticalAlignment(SwingConstants.CENTER);
        lblPantallaCompleta.setVerticalAlignment(SwingConstants.CENTER);
        lblPantallaNormal.setVerticalAlignment(SwingConstants.CENTER);
                
        lblCerrarVentana.setHorizontalAlignment(SwingConstants.CENTER);
        lblMaximizar.setHorizontalAlignment(SwingConstants.CENTER);
        lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
        lblPantallaCompleta.setHorizontalAlignment(SwingConstants.CENTER);
        lblPantallaNormal.setHorizontalAlignment(SwingConstants.CENTER);
                
        
        
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
        lblMaximizar = new javax.swing.JLabel();
        lblPantallaCompleta = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        paneLogFondo = new javax.swing.JPanel();
        paneLogin = new javax.swing.JPanel();
        lblLogImg = new javax.swing.JLabel();
        lblLogBienvenida = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        btnLogLogin = new javax.swing.JPanel();
        lblTitulobtn = new javax.swing.JLabel();
        panecontenedorPantallaNormal = new javax.swing.JPanel();
        lblPantallaNormal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        paneHeaderLogin.setBackground(new java.awt.Color(25, 34, 143));
        paneHeaderLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paneHeaderLoginMouseDragged(evt);
            }
        });
        paneHeaderLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneHeaderLoginMousePressed(evt);
            }
        });

        lblHeaderLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        paneHeaderOpciones.setBackground(new java.awt.Color(27, 39, 187));
        paneHeaderOpciones.setOpaque(false);

        lblCerrarVentana.setBackground(new java.awt.Color(255, 58, 97));
        lblCerrarVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarVentana.png"))); // NOI18N
        lblCerrarVentana.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        lblMaximizar.setBackground(new java.awt.Color(72, 84, 247));
        lblMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expandirVentana.png"))); // NOI18N
        lblMaximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMaximizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblMaximizarMouseMoved(evt);
            }
        });
        lblMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMaximizarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMaximizarMouseExited(evt);
            }
        });

        lblPantallaCompleta.setBackground(new java.awt.Color(72, 84, 247));
        lblPantallaCompleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantallaCompleta.png"))); // NOI18N
        lblPantallaCompleta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblPantallaCompleta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblPantallaCompletaMouseMoved(evt);
            }
        });
        lblPantallaCompleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPantallaCompletaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPantallaCompletaMouseExited(evt);
            }
        });

        lblMinimizar.setBackground(new java.awt.Color(72, 84, 247));
        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png"))); // NOI18N
        lblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMinimizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseMoved(evt);
            }
        });
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paneHeaderOpcionesLayout = new javax.swing.GroupLayout(paneHeaderOpciones);
        paneHeaderOpciones.setLayout(paneHeaderOpcionesLayout);
        paneHeaderOpcionesLayout.setHorizontalGroup(
            paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneHeaderOpcionesLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(lblPantallaCompleta)
                .addGap(27, 27, 27)
                .addComponent(lblMinimizar)
                .addGap(18, 18, 18)
                .addComponent(lblMaximizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrarVentana)
                .addGap(48, 48, 48))
        );
        paneHeaderOpcionesLayout.setVerticalGroup(
            paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHeaderOpcionesLayout.createSequentialGroup()
                .addGroup(paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMinimizar)
                    .addGroup(paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPantallaCompleta)
                        .addGroup(paneHeaderOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMaximizar)
                            .addComponent(lblCerrarVentana))))
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
                .addGap(16, 16, 16)
                .addGroup(paneHeaderLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeaderLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneHeaderOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        paneLogFondo.setBackground(new java.awt.Color(72, 84, 247));
        paneLogFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 34, 143)));

        paneLogin.setBackground(new java.awt.Color(255, 255, 255));
        paneLogin.setPreferredSize(new java.awt.Dimension(1006, 394));

        lblLogImg.setBackground(new java.awt.Color(204, 204, 204));
        lblLogImg.setOpaque(true);

        lblLogBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblLogBienvenida.setText("Bienvenido");

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        lblUser.setText("Usuario :");

        lblClave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clave.png"))); // NOI18N
        lblClave.setText("Contraseña :");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtClave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtClave.setToolTipText("");
        txtClave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnLogLogin.setBackground(new java.awt.Color(72, 84, 247));
        btnLogLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLogLoginMouseMoved(evt);
            }
        });
        btnLogLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogLoginMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogLoginMouseExited(evt);
            }
        });

        lblTitulobtn.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblTitulobtn.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulobtn.setText("Acceder");

        javax.swing.GroupLayout btnLogLoginLayout = new javax.swing.GroupLayout(btnLogLogin);
        btnLogLogin.setLayout(btnLogLoginLayout);
        btnLogLoginLayout.setHorizontalGroup(
            btnLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogLoginLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblTitulobtn)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        btnLogLoginLayout.setVerticalGroup(
            btnLogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLogLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulobtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout paneLoginLayout = new javax.swing.GroupLayout(paneLogin);
        paneLogin.setLayout(paneLoginLayout);
        paneLoginLayout.setHorizontalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogImg, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtClave)
                    .addComponent(txtUser)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClave)
                    .addComponent(btnLogLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneLoginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblLogBienvenida)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        paneLoginLayout.setVerticalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblLogBienvenida)
                .addGap(52, 52, 52)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLoginLayout.createSequentialGroup()
                .addComponent(lblLogImg, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneLogFondoLayout = new javax.swing.GroupLayout(paneLogFondo);
        paneLogFondo.setLayout(paneLogFondoLayout);
        paneLogFondoLayout.setHorizontalGroup(
            paneLogFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLogFondoLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(paneLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneLogFondoLayout.setVerticalGroup(
            paneLogFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLogFondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(paneLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panecontenedorPantallaNormal.setBackground(new java.awt.Color(72, 84, 247));

        lblPantallaNormal.setBackground(new java.awt.Color(12, 25, 202));
        lblPantallaNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantallaNormal.png"))); // NOI18N
        lblPantallaNormal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblPantallaNormal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblPantallaNormalMouseMoved(evt);
            }
        });
        lblPantallaNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPantallaNormalMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPantallaNormalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panecontenedorPantallaNormalLayout = new javax.swing.GroupLayout(panecontenedorPantallaNormal);
        panecontenedorPantallaNormal.setLayout(panecontenedorPantallaNormalLayout);
        panecontenedorPantallaNormalLayout.setHorizontalGroup(
            panecontenedorPantallaNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panecontenedorPantallaNormalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPantallaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1080, Short.MAX_VALUE))
        );
        panecontenedorPantallaNormalLayout.setVerticalGroup(
            panecontenedorPantallaNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panecontenedorPantallaNormalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblPantallaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panecontenedorPantallaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneHeaderLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(paneLogFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneHeaderLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panecontenedorPantallaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneLogFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        paneLogFondo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogLoginMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogLoginMouseMoved
        // TODO add your handling code here:
        
        btnLogLogin.setBackground(new Color(53,63,195));
    }//GEN-LAST:event_btnLogLoginMouseMoved

    private void btnLogLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogLoginMouseExited
        // TODO add your handling code here:
        btnLogLogin.setBackground(new Color(72,84,247));
    }//GEN-LAST:event_btnLogLoginMouseExited

    private void btnLogLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogLoginMouseClicked
        // TODO add your handling code here:
        Logueo();
    }//GEN-LAST:event_btnLogLoginMouseClicked

    private void lblCerrarVentanaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseMoved
        // TODO add your handling code here:
        lblCerrarVentana.setOpaque(true);
        lblCerrarVentana.repaint();
    }//GEN-LAST:event_lblCerrarVentanaMouseMoved

    private void lblCerrarVentanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseExited
        // TODO add your handling code here:
        lblCerrarVentana.setOpaque(false);
        lblCerrarVentana.repaint();
    }//GEN-LAST:event_lblCerrarVentanaMouseExited

    private void lblMaximizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizarMouseMoved
        // TODO add your handling code here:
        lblMaximizar.setOpaque(true);
        lblMaximizar.repaint();
    }//GEN-LAST:event_lblMaximizarMouseMoved

    private void lblMaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizarMouseExited
        // TODO add your handling code here:
        lblMaximizar.setOpaque(false);
        lblMaximizar.repaint();
    }//GEN-LAST:event_lblMaximizarMouseExited

    private void lblMinimizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseMoved
        // TODO add your handling code here:
        lblMinimizar.setOpaque(true);
        lblMinimizar.repaint();
    }//GEN-LAST:event_lblMinimizarMouseMoved

    private void lblMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseExited
        // TODO add your handling code here:
        lblMinimizar.setOpaque(false);
        lblMinimizar.repaint();
    }//GEN-LAST:event_lblMinimizarMouseExited

    private void lblPantallaCompletaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaCompletaMouseMoved
        // TODO add your handling code here:
        lblPantallaCompleta.setOpaque(true);
        lblPantallaCompleta.repaint();
    }//GEN-LAST:event_lblPantallaCompletaMouseMoved

    private void lblPantallaCompletaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaCompletaMouseExited
        // TODO add your handling code here:
        lblPantallaCompleta.setOpaque(false);
        lblPantallaCompleta.repaint();
    }//GEN-LAST:event_lblPantallaCompletaMouseExited

    private void lblCerrarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseClicked
        // TODO add your handling code here:
        
        ModalVerificar M = new ModalVerificar();
        JDialog dialog = new JDialog(M, "Mi diálogo", true); // true indica que es modal
        dialog.setContentPane(M.getContentPane()); // agregamos el contenido del JFrame al JDialog
        dialog.setSize(new Dimension(400,200)); // ajustamos el tamaño del JDialog al del JFrame
        dialog.setUndecorated(true);
        dialog.setLocationRelativeTo(null); // centra el dialogo en la pantalla
        dialog.setVisible(true);
        
    }//GEN-LAST:event_lblCerrarVentanaMouseClicked

    private void lblMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizarMouseClicked
        // TODO add your handling code here:
        
         if (pantallaMaximizada) {
            setSize(1100, 700);
            setLocationRelativeTo(null);
            pantallaMaximizada = false;
            lblMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expandirVentana.png")));
            
        } else {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = env.getMaximumWindowBounds();

            setBounds(bounds);
            pantallaMaximizada = true;
            lblMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizarTamaño.png")));
            
        }
    }//GEN-LAST:event_lblMaximizarMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        // TODO add your handling code here:
        setState(ICONIFIED);
        
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblPantallaCompletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaCompletaMouseClicked
        // TODO add your handling code here:
        getContentPane().remove(paneHeaderLogin);
        getContentPane().add(panecontenedorPantallaNormal, java.awt.BorderLayout.PAGE_START);
        pantallaCompleta=true;
        paneLogFondo.setBorder(null);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
            device.setFullScreenWindow(this);
           
        }
         
    }//GEN-LAST:event_lblPantallaCompletaMouseClicked

    private void lblPantallaNormalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaNormalMouseMoved
        // TODO add your handling code here:
        lblPantallaNormal.setOpaque(true);
        lblPantallaNormal.repaint();
    }//GEN-LAST:event_lblPantallaNormalMouseMoved

    private void lblPantallaNormalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaNormalMouseExited
        // TODO add your handling code here:
        lblPantallaNormal.setOpaque(false);
        lblPantallaNormal.repaint();
    }//GEN-LAST:event_lblPantallaNormalMouseExited

    private void lblPantallaNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaNormalMouseClicked
        // TODO add your handling code here:
        getContentPane().remove(panecontenedorPantallaNormal);
        getContentPane().add(paneHeaderLogin, java.awt.BorderLayout.PAGE_START);
        pantallaCompleta=false;
        LineBorder borde = new LineBorder(new Color(25, 34, 143), 1);
        paneLogFondo.setBorder(borde);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setExtendedState(JFrame.NORMAL);
        setUndecorated(true);
        device.setFullScreenWindow(this);
        
    }//GEN-LAST:event_lblPantallaNormalMouseClicked
    int xMouse,yMouse;
    private void paneHeaderLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHeaderLoginMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
        
    }//GEN-LAST:event_paneHeaderLoginMousePressed

    private void paneHeaderLoginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHeaderLoginMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_paneHeaderLoginMouseDragged
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnLogLogin;
    private javax.swing.JLabel lblCerrarVentana;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblHeaderLogo;
    private javax.swing.JLabel lblLogBienvenida;
    private javax.swing.JLabel lblLogImg;
    private javax.swing.JLabel lblMaximizar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblPantallaCompleta;
    private javax.swing.JLabel lblPantallaNormal;
    private javax.swing.JLabel lblTitulobtn;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel paneHeaderLogin;
    private javax.swing.JPanel paneHeaderOpciones;
    private javax.swing.JPanel paneLogFondo;
    private javax.swing.JPanel paneLogin;
    private javax.swing.JPanel panecontenedorPantallaNormal;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    public void Logueo(){
        String usuario = txtUser.getText();
        String contraseña = String.valueOf(txtClave.getPassword());
        
        Map<String, Object> response = LoginCon.LoguearUsuario(usuario, contraseña);
        
        
        boolean success = (boolean) response.get("success");
        String message = (String) response.get("message");
        if(success){
            sesionUsuario=LoginCon.obtenerUsuarioLogueado();
            SistemaFrame Sistema= new SistemaFrame();
            Sistema.setVisible(true); 
            setVisible(false);
        }
        else{
            ModalError modal = new ModalError(message);
            JDialog dialogError = new JDialog(modal, "Mi diálogo", true); // true indica que es modal
            dialogError.setContentPane(modal.getContentPane()); // agregamos el contenido del JFrame al JDialog
            dialogError.setSize(new Dimension(300, 180)); // ajustamos el tamaño del JDialog al del JFrame
            dialogError.setUndecorated(true);
            dialogError.setLocationRelativeTo(null); // centra el dialogo en la pantalla
            dialogError.setVisible(true);
        }
    }
    public void actualizarSesion(){
        LoginCon.ActualizarSesionUsuario();
        sesionUsuario=LoginCon.obtenerUsuarioLogueado();
    }

}
