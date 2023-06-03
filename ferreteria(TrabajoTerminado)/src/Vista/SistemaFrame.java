/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import static Vista.LoginFrame.sesionUsuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author enriq
 */
public final class SistemaFrame extends javax.swing.JFrame {

    /**
     * Creates new form plantillaResponsive
     * 
     */
    private String opSeleccionada="Escritorio";
    private boolean menu=true; 
    public SistemaFrame() {
        initComponents();
        iniComplementLayout();
        iniSize();
        iniLocation();
        iniDiseños();
        InicializarRelog();
        PermisosPorRol((String) LoginFrame.sesionUsuario.get("rol"));
        cargarDatosUsuario();
        
        
        
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
        getContentPane().setLayout(new BorderLayout());
        
        paneContenidoVentana.setLayout(new BorderLayout());
        
         //layout de header de la ventana
        paneHeader.setLayout(new BoxLayout(paneHeader, BoxLayout.X_AXIS));
        
        FlowLayout flowlayoutcontenedorPantallaNormal = new FlowLayout(FlowLayout.RIGHT,0,0);
        panecontenedorPantallaNormal.setLayout(flowlayoutcontenedorPantallaNormal);
        panecontenedorPantallaNormal.add(lblPantallaNormal);
        
        
        FlowLayout flowlayoutHeaderOpciones = new FlowLayout(FlowLayout.RIGHT,0,0);
        
        
        paneHeaderOpciones.setLayout(flowlayoutHeaderOpciones);
        paneHeader.add(lblHeaderLogo);
        paneHeader.add(Box.createHorizontalGlue()); // Espaciador flexible
        paneHeader.add(paneHeaderOpciones);
        
        //Layout contenido de ventana
        paneMenu.setLayout(new BoxLayout(paneMenu, BoxLayout.Y_AXIS));
        
        paneEmpresa.setAlignmentX(CENTER_ALIGNMENT);
        lbllineaTitulo.setAlignmentX(CENTER_ALIGNMENT);
        paneEscritorio.setAlignmentX(CENTER_ALIGNMENT);
        panePerfil.setAlignmentX(CENTER_ALIGNMENT);
        lbllinea1.setAlignmentX(CENTER_ALIGNMENT);
        paneUsuarios.setAlignmentX(CENTER_ALIGNMENT);
        paneArticulos.setAlignmentX(CENTER_ALIGNMENT);
        paneAlmacen.setAlignmentX(CENTER_ALIGNMENT);
        paneProveedores.setAlignmentX(CENTER_ALIGNMENT);
        paneCatMar.setAlignmentX(CENTER_ALIGNMENT);
        paneCompras.setAlignmentX(CENTER_ALIGNMENT);
        paneVentas.setAlignmentX(CENTER_ALIGNMENT);
        paneReportes.setAlignmentX(CENTER_ALIGNMENT);
        paneFacturacion.setAlignmentX(CENTER_ALIGNMENT);
        lbllinea2.setAlignmentX(CENTER_ALIGNMENT);
        paneCerrar.setAlignmentX(CENTER_ALIGNMENT);
        paneSalir.setAlignmentX(CENTER_ALIGNMENT);
        paneEspacioVacio1.setAlignmentX(CENTER_ALIGNMENT);
        lblAccionBarra.setAlignmentX(CENTER_ALIGNMENT);
        paneEspacioVacio2.setAlignmentX(CENTER_ALIGNMENT);
        //FlowLayout flowlayoutMenu = new FlowLayout(FlowLayout.CENTER,0,0);
        //paneMenu.setLayout(flowlayoutMenu);
        paneMenu.add(paneEmpresa);
        paneMenu.add(lbllineaTitulo);
        paneMenu.add(paneEscritorio);
        paneMenu.add(panePerfil);
        paneMenu.add(lbllinea1);
        paneMenu.add(paneUsuarios);
        paneMenu.add(paneArticulos);
        paneMenu.add(paneAlmacen);
        paneMenu.add(paneReportes);
        paneMenu.add(paneProveedores);
        paneMenu.add(paneCatMar);
        paneMenu.add(paneCompras);
        paneMenu.add(paneVentas);
        paneMenu.add(paneFacturacion);
        paneMenu.add(lbllinea2);
        paneMenu.add(paneCerrar);
        paneMenu.add(paneSalir);
        paneMenu.add(paneEspacioVacio1);
        paneMenu.add(lblAccionBarra);
        paneMenu.add(paneEspacioVacio2);
        FlowLayout flowlayoutTituloMenu = new FlowLayout(FlowLayout.CENTER,5,20);
            paneEmpresa.setLayout(flowlayoutTituloMenu);
            
         FlowLayout flowlayoutOptionMenu = new FlowLayout(FlowLayout.LEFT,20,10);
            paneEscritorio.setLayout(flowlayoutOptionMenu);
            panePerfil.setLayout(flowlayoutOptionMenu);

            paneUsuarios.setLayout(flowlayoutOptionMenu);
            paneArticulos.setLayout(flowlayoutOptionMenu);
            paneAlmacen.setLayout(flowlayoutOptionMenu);
            paneProveedores.setLayout(flowlayoutOptionMenu);
            paneCatMar.setLayout(flowlayoutOptionMenu);
            paneCompras.setLayout(flowlayoutOptionMenu);
            paneVentas.setLayout(flowlayoutOptionMenu);
            paneReportes.setLayout(flowlayoutOptionMenu);
            paneFacturacion.setLayout(flowlayoutOptionMenu);

            paneCerrar.setLayout(flowlayoutOptionMenu);
            paneSalir.setLayout(flowlayoutOptionMenu);
            paneEspacioVacio1.setLayout(null);

            paneEspacioVacio2.setLayout(null);
            
        paneInfConte.setLayout(new BorderLayout());
        paneInfo.setLayout(new BoxLayout(paneInfo, BoxLayout.X_AXIS));
        
        FlowLayout flowlayoutContDataUser = new FlowLayout(FlowLayout.RIGHT,20,15);
        paneContDataUser.setLayout(flowlayoutContDataUser);
        paneContReloj.setLayout(null);
        paneInfo.add(paneContReloj);
        paneInfo.add(Box.createHorizontalGlue()); // Espaciador flexible
        paneInfo.add(paneContDataUser);
        
        paneInfConte.add(paneInfo, java.awt.BorderLayout.PAGE_START);
        paneCentral.setLayout(new CardLayout());
        paneInfConte.add(paneCentral, java.awt.BorderLayout.CENTER);
        
        panelEscritorio escritorio= new panelEscritorio();
        paneCentral.add(escritorio.obtenerPanel());
   
        
        paneInfConte.remove(panecontenedorPantallaNormal);
        paneContenidoVentana.add(paneMenu, java.awt.BorderLayout.LINE_START);
        paneContenidoVentana.add(paneInfConte, BorderLayout.CENTER);
        
        getContentPane().add(paneHeader, BorderLayout.PAGE_START);
        getContentPane().add(paneContenidoVentana, BorderLayout.CENTER);
        
        
      

    }
    
     private void iniSize(){
        //tamaño de ventana
        this.setBounds(0,0,1400, 900);
        
        //tamaño del panel header
        paneHeader.setPreferredSize(new Dimension( 1, 40));
        panecontenedorPantallaNormal.setPreferredSize(new Dimension( 1, 40));
        lblPantallaNormal.setSize(new Dimension( 40, 40));
        lblHeaderLogo.setSize(new Dimension( 40, 40));
        lblCerrarVentana.setPreferredSize(new Dimension( 40, 40));
        lblMaximizar.setPreferredSize(new Dimension( 40, 40));
        lblMinimizar.setPreferredSize(new Dimension( 40, 40));
        lblPantallaCompleta.setPreferredSize(new Dimension( 40, 40));
        lblPantallaNormal.setPreferredSize(new Dimension( 40, 40));
        
        //tamaño del panel de informacion 
        paneInfo.setPreferredSize(new Dimension( 1, 90));
            //tamaño de los conponentes del panel de imformacion
            paneContDataUser.setPreferredSize(new Dimension( 400, 90));
                lblImgPerfil.setPreferredSize(new Dimension( 60, 60));
                lblSeparador.setPreferredSize(new Dimension( 3, 25));
                
            paneContReloj.setPreferredSize(new Dimension( 100, 90));
                //lblReloj.setSize(300,60);
                
        //tamaño del panel de Menu
        paneMenu.setPreferredSize(new Dimension( 260, 1));
            //tamaño de los conponentes del panel de Menu
            paneEmpresa.setPreferredSize(new Dimension( 260, 120));
                lblLogoEmpresa.setPreferredSize(new Dimension( 80, 75));
                lblNomEmpresa.setPreferredSize(new Dimension( 160, 70));
                
            lbllineaTitulo.setPreferredSize(new Dimension( 0, 36));
            
            paneEscritorio.setPreferredSize(new Dimension( 0, 45));
            panePerfil.setPreferredSize(new Dimension( 0, 45));
            lbllinea1.setPreferredSize(new Dimension( 0, 36));
            
            paneUsuarios.setPreferredSize(new Dimension( 0, 45));
            paneArticulos.setPreferredSize(new Dimension( 0, 45));
            paneAlmacen.setPreferredSize(new Dimension( 0, 45));
            paneProveedores.setPreferredSize(new Dimension( 0, 45));
            paneCatMar.setPreferredSize(new Dimension( 0, 45));
            paneCompras.setPreferredSize(new Dimension( 0, 45));
            paneVentas.setPreferredSize(new Dimension( 0, 45));
            paneReportes.setPreferredSize(new Dimension( 0, 45));
            paneFacturacion.setPreferredSize(new Dimension( 0, 45));
            lbllinea2.setPreferredSize(new Dimension( 0, 36));
            
            paneCerrar.setPreferredSize(new Dimension( 0, 45));
            paneSalir.setPreferredSize(new Dimension( 0, 45));
            
            paneEspacioVacio1.setPreferredSize(new Dimension( 0, 90));
            lblAccionBarra.setPreferredSize(new Dimension( 50, 50));
            paneEspacioVacio2.setPreferredSize(new Dimension( 0, 180));
        //tamaño del panel de contenido
        //paneContenido.setPreferredSize(new Dimension( 1, 1));    
        
    }
     
    private void iniLocation(){
        //centrando ventana
        this.setLocationRelativeTo(null);
        
        
        
        //diseño de contenido
        lblReloj.setLocation(25,15);
        
    }
   
    
    private void iniDiseños(){
        
        //centrar elementos del header
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
         //inicaiar imagenes del Header de la ventana.
        redimencionarImagenen(lblHeaderLogo,"/img/logo.png");
        
        //redimencinar la imagen del perfil
        redimencionarImagenen(lblImgPerfil,"/img/imgPerfil.png");
        redimencionarImagenen(lblLogoEmpresa,"/img/logoGrande.png");
        
        lblNomEmpresa.setVerticalAlignment(SwingConstants.BOTTOM);
    }
    
    
    public void accionBarraMenu(){
        
        if(menu){
            paneMenu.setPreferredSize(new Dimension( 100, 1));
            paneMenu.revalidate();
            lblNomEmpresa.setEnabled(false);
            lblEscritorio.setEnabled(false);
            lblPerfil.setEnabled(false);
            lblUsuario.setEnabled(false);
            lblArticulos.setEnabled(false);
            lblAlmacen.setEnabled(false);
            lblProveedor.setEnabled(false);
            lblCatMar.setEnabled(false);
            lblCompras.setEnabled(false);
            lblVentas.setEnabled(false);
            lblReportes.setEnabled(false);
            lblFacturacion.setEnabled(false);
            lblCerrar.setEnabled(false);
            lblSalir.setEnabled(false);
            
            paneEmpresa.remove(lblNomEmpresa);
            
            paneEscritorio.remove(lblEscritorio);
            panePerfil.remove(lblPerfil);
            
            paneUsuarios.remove(lblUsuario);
            paneArticulos.remove(lblArticulos);
            paneAlmacen.remove(lblAlmacen);
            paneProveedores.remove(lblProveedor);
            paneCatMar.remove(lblCatMar);
            paneCompras.remove(lblCompras);
            paneVentas.remove(lblVentas);
            paneReportes.remove(lblReportes);
            paneFacturacion.remove(lblFacturacion);
            
            paneCerrar.remove(lblCerrar);
            paneSalir.remove(lblSalir);
            
            FlowLayout flowlayoutOption = new FlowLayout(FlowLayout.CENTER,0,10);
            paneEscritorio.setLayout(flowlayoutOption);
            panePerfil.setLayout(flowlayoutOption);

            paneUsuarios.setLayout(flowlayoutOption);
            paneArticulos.setLayout(flowlayoutOption);
            paneAlmacen.setLayout(flowlayoutOption);
            paneProveedores.setLayout(flowlayoutOption);
            paneCatMar.setLayout(flowlayoutOption);
            paneCompras.setLayout(flowlayoutOption);
            paneVentas.setLayout(flowlayoutOption);
            paneReportes.setLayout(flowlayoutOption);
            paneFacturacion.setLayout(flowlayoutOption);

            paneCerrar.setLayout(flowlayoutOption);
            paneSalir.setLayout(flowlayoutOption);
           
            lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expandirBarra.png")));
            
            lbllineaTitulo.setText("__________________");
            lbllinea1.setText("__________________");
            lbllinea2.setText("__________________");
            menu=false;
            
        }
        else{
            paneMenu.setPreferredSize(new Dimension( 260, 1));
            paneMenu.revalidate();
            lblNomEmpresa.setEnabled(true);
            lblEscritorio.setEnabled(true);
            lblPerfil.setEnabled(true);
            lblUsuario.setEnabled(true);
            lblArticulos.setEnabled(true);
            lblAlmacen.setEnabled(true);
            lblProveedor.setEnabled(true);           
            lblCatMar.setEnabled(true);
            lblCompras.setEnabled(true);
            lblVentas.setEnabled(true);
            lblReportes.setEnabled(true);
            lblFacturacion.setEnabled(true);
            lblCerrar.setEnabled(true);
            lblSalir.setEnabled(true);
            
            paneEmpresa.add(lblNomEmpresa);
            
            paneEscritorio.add(lblEscritorio);
            panePerfil.add(lblPerfil);
            
            paneUsuarios.add(lblUsuario);
            paneArticulos.add(lblArticulos);
            paneAlmacen.add(lblAlmacen);
            paneProveedores.add(lblProveedor);
            paneCatMar.add(lblCatMar);
            paneCompras.add(lblCompras);
            paneVentas.add(lblVentas);
            paneReportes.add(lblReportes);
            paneFacturacion.add(lblFacturacion);
            
            paneCerrar.add(lblCerrar);
            paneSalir.add(lblSalir);
            
            FlowLayout flowlayoutOption = new FlowLayout(FlowLayout.LEFT,20,10);
            paneEscritorio.setLayout(flowlayoutOption);
            panePerfil.setLayout(flowlayoutOption);

            paneUsuarios.setLayout(flowlayoutOption);
            paneArticulos.setLayout(flowlayoutOption);
            paneAlmacen.setLayout(flowlayoutOption);
            paneProveedores.setLayout(flowlayoutOption);
            paneCatMar.setLayout(flowlayoutOption);
            paneCompras.setLayout(flowlayoutOption);
            paneVentas.setLayout(flowlayoutOption);
            paneReportes.setLayout(flowlayoutOption);
            paneFacturacion.setLayout(flowlayoutOption);

            paneCerrar.setLayout(flowlayoutOption);
            paneSalir.setLayout(flowlayoutOption);
           
            lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contraerBarra.png")));
            
            lbllineaTitulo.setText("_______________________________________________");
            lbllinea1.setText("_______________________________________________");
            lbllinea2.setText("_______________________________________________");
            menu=true;
        }
    }
    
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneContenidoVentana = new javax.swing.JPanel();
        paneInfConte = new javax.swing.JPanel();
        paneInfo = new javax.swing.JPanel();
        paneContDataUser = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        lblSeparador = new javax.swing.JLabel();
        lblNomUser = new javax.swing.JLabel();
        lblImgPerfil = new javax.swing.JLabel();
        paneContReloj = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        panecontenedorPantallaNormal = new javax.swing.JPanel();
        lblPantallaNormal = new javax.swing.JLabel();
        paneCentral = new javax.swing.JPanel();
        paneMenu = new javax.swing.JPanel();
        paneEmpresa = new javax.swing.JPanel();
        lblLogoEmpresa = new javax.swing.JLabel();
        lblNomEmpresa = new javax.swing.JLabel();
        panePerfil = new javax.swing.JPanel();
        lblPerfil = new javax.swing.JLabel();
        lblIconPerfil = new javax.swing.JLabel();
        paneEscritorio = new javax.swing.JPanel();
        lblIconEscritorio = new javax.swing.JLabel();
        lblEscritorio = new javax.swing.JLabel();
        paneArticulos = new javax.swing.JPanel();
        lblIconArticulos = new javax.swing.JLabel();
        lblArticulos = new javax.swing.JLabel();
        paneCompras = new javax.swing.JPanel();
        lblIconCompras = new javax.swing.JLabel();
        lblCompras = new javax.swing.JLabel();
        paneVentas = new javax.swing.JPanel();
        lblVentas = new javax.swing.JLabel();
        lblIconVentas = new javax.swing.JLabel();
        paneProveedores = new javax.swing.JPanel();
        lblIconProveedor = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lbllinea2 = new javax.swing.JLabel();
        paneCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        lblIconCerrar = new javax.swing.JLabel();
        paneSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        lblIconSalir = new javax.swing.JLabel();
        paneCatMar = new javax.swing.JPanel();
        lblIconCatMar = new javax.swing.JLabel();
        lblCatMar = new javax.swing.JLabel();
        lbllinea1 = new javax.swing.JLabel();
        paneUsuarios = new javax.swing.JPanel();
        lblIconUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        paneReportes = new javax.swing.JPanel();
        lblReportes = new javax.swing.JLabel();
        lblIconReportes = new javax.swing.JLabel();
        paneFacturacion = new javax.swing.JPanel();
        lblFacturacion = new javax.swing.JLabel();
        lblIconFacturacion = new javax.swing.JLabel();
        lbllineaTitulo = new javax.swing.JLabel();
        paneEspacioVacio1 = new javax.swing.JPanel();
        paneEspacioVacio2 = new javax.swing.JPanel();
        lblAccionBarra = new javax.swing.JLabel();
        paneAlmacen = new javax.swing.JPanel();
        lblIconAlmacen = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        paneHeader = new javax.swing.JPanel();
        lblHeaderLogo = new javax.swing.JLabel();
        paneHeaderOpciones = new javax.swing.JPanel();
        lblCerrarVentana = new javax.swing.JLabel();
        lblMaximizar = new javax.swing.JLabel();
        lblPantallaCompleta = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        paneContenidoVentana.setBackground(new java.awt.Color(204, 204, 204));
        paneContenidoVentana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 34, 143)));

        paneInfConte.setBackground(new java.awt.Color(153, 153, 153));

        paneInfo.setBackground(new java.awt.Color(72, 84, 247));

        paneContDataUser.setOpaque(false);

        lblRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setText("Rol");

        lblSeparador.setBackground(new java.awt.Color(255, 255, 255));
        lblSeparador.setForeground(new java.awt.Color(255, 255, 255));
        lblSeparador.setOpaque(true);

        lblNomUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNomUser.setForeground(new java.awt.Color(255, 255, 255));
        lblNomUser.setText("Nombre ");
        lblNomUser.setToolTipText("");

        lblImgPerfil.setBackground(new java.awt.Color(233, 231, 231));
        lblImgPerfil.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        lblImgPerfil.setOpaque(true);

        javax.swing.GroupLayout paneContDataUserLayout = new javax.swing.GroupLayout(paneContDataUser);
        paneContDataUser.setLayout(paneContDataUserLayout);
        paneContDataUserLayout.setHorizontalGroup(
            paneContDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContDataUserLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(lblRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNomUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImgPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneContDataUserLayout.setVerticalGroup(
            paneContDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContDataUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneContDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContDataUserLayout.createSequentialGroup()
                        .addGroup(paneContDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomUser)
                            .addComponent(lblRol)
                            .addComponent(lblSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGap(14, 14, 14))
        );

        paneContReloj.setOpaque(false);

        lblReloj.setBackground(new java.awt.Color(0, 0, 0));
        lblReloj.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(255, 255, 255));
        lblReloj.setText("00:00:00 p. m.");
        lblReloj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        lblReloj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblReloj.setOpaque(true);

        javax.swing.GroupLayout paneContRelojLayout = new javax.swing.GroupLayout(paneContReloj);
        paneContReloj.setLayout(paneContRelojLayout);
        paneContRelojLayout.setHorizontalGroup(
            paneContRelojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContRelojLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblReloj)
                .addGap(14, 14, 14))
        );
        paneContRelojLayout.setVerticalGroup(
            paneContRelojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContRelojLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneInfoLayout = new javax.swing.GroupLayout(paneInfo);
        paneInfo.setLayout(paneInfoLayout);
        paneInfoLayout.setHorizontalGroup(
            paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(paneContReloj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(paneContDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneInfoLayout.setVerticalGroup(
            paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(paneContReloj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneContDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panecontenedorPantallaNormal.setBackground(new java.awt.Color(229, 238, 255));

        lblPantallaNormal.setBackground(new java.awt.Color(221, 221, 221));
        lblPantallaNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantallaNormalN.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panecontenedorPantallaNormalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPantallaNormal)
                .addContainerGap())
        );
        panecontenedorPantallaNormalLayout.setVerticalGroup(
            panecontenedorPantallaNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panecontenedorPantallaNormalLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblPantallaNormal)
                .addContainerGap())
        );

        paneCentral.setBackground(new java.awt.Color(229, 238, 255));

        javax.swing.GroupLayout paneCentralLayout = new javax.swing.GroupLayout(paneCentral);
        paneCentral.setLayout(paneCentralLayout);
        paneCentralLayout.setHorizontalGroup(
            paneCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        paneCentralLayout.setVerticalGroup(
            paneCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneInfConteLayout = new javax.swing.GroupLayout(paneInfConte);
        paneInfConte.setLayout(paneInfConteLayout);
        paneInfConteLayout.setHorizontalGroup(
            paneInfConteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInfConteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneInfConteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(paneCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panecontenedorPantallaNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        paneInfConteLayout.setVerticalGroup(
            paneInfConteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInfConteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panecontenedorPantallaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paneMenu.setBackground(new java.awt.Color(75, 75, 75));

        paneEmpresa.setOpaque(false);

        lblLogoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoGrande.png"))); // NOI18N

        lblNomEmpresa.setFont(new java.awt.Font("SimSun", 1, 30)); // NOI18N
        lblNomEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblNomEmpresa.setText("AcerosIca");

        javax.swing.GroupLayout paneEmpresaLayout = new javax.swing.GroupLayout(paneEmpresa);
        paneEmpresa.setLayout(paneEmpresaLayout);
        paneEmpresaLayout.setHorizontalGroup(
            paneEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneEmpresaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblLogoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomEmpresa)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        paneEmpresaLayout.setVerticalGroup(
            paneEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomEmpresa))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panePerfil.setBackground(new java.awt.Color(59, 59, 59));
        panePerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panePerfil.setOpaque(false);
        panePerfil.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panePerfilMouseMoved(evt);
            }
        });
        panePerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panePerfilMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panePerfilMouseExited(evt);
            }
        });

        lblPerfil.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lblPerfil.setText("Perfil");

        lblIconPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil.png"))); // NOI18N

        javax.swing.GroupLayout panePerfilLayout = new javax.swing.GroupLayout(panePerfil);
        panePerfil.setLayout(panePerfilLayout);
        panePerfilLayout.setHorizontalGroup(
            panePerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panePerfilLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(lblIconPerfil)
                .addGap(18, 18, 18)
                .addComponent(lblPerfil)
                .addGap(131, 131, 131))
        );
        panePerfilLayout.setVerticalGroup(
            panePerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panePerfilLayout.createSequentialGroup()
                        .addComponent(lblIconPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panePerfilLayout.createSequentialGroup()
                        .addComponent(lblPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))))
        );

        paneEscritorio.setBackground(new java.awt.Color(59, 59, 59));
        paneEscritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneEscritorio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneEscritorioMouseMoved(evt);
            }
        });
        paneEscritorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneEscritorioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneEscritorioMouseExited(evt);
            }
        });

        lblIconEscritorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/medidor.png"))); // NOI18N

        lblEscritorio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblEscritorio.setForeground(new java.awt.Color(255, 255, 255));
        lblEscritorio.setText("Escritorio");

        javax.swing.GroupLayout paneEscritorioLayout = new javax.swing.GroupLayout(paneEscritorio);
        paneEscritorio.setLayout(paneEscritorioLayout);
        paneEscritorioLayout.setHorizontalGroup(
            paneEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneEscritorioLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(lblIconEscritorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEscritorio)
                .addGap(104, 104, 104))
        );
        paneEscritorioLayout.setVerticalGroup(
            paneEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblIconEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        paneArticulos.setBackground(new java.awt.Color(59, 59, 59));
        paneArticulos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneArticulos.setOpaque(false);
        paneArticulos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneArticulosMouseMoved(evt);
            }
        });
        paneArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneArticulosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneArticulosMouseExited(evt);
            }
        });

        lblIconArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/articulo.png"))); // NOI18N

        lblArticulos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblArticulos.setForeground(new java.awt.Color(255, 255, 255));
        lblArticulos.setText("Articulos");

        javax.swing.GroupLayout paneArticulosLayout = new javax.swing.GroupLayout(paneArticulos);
        paneArticulos.setLayout(paneArticulosLayout);
        paneArticulosLayout.setHorizontalGroup(
            paneArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneArticulosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIconArticulos)
                .addGap(32, 32, 32)
                .addComponent(lblArticulos)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        paneArticulosLayout.setVerticalGroup(
            paneArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneArticulosLayout.createSequentialGroup()
                        .addComponent(lblArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addComponent(lblIconArticulos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        paneCompras.setBackground(new java.awt.Color(59, 59, 59));
        paneCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneCompras.setOpaque(false);
        paneCompras.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneComprasMouseMoved(evt);
            }
        });
        paneCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneComprasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneComprasMouseExited(evt);
            }
        });

        lblIconCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compras.png"))); // NOI18N

        lblCompras.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCompras.setForeground(new java.awt.Color(255, 255, 255));
        lblCompras.setText("Compras");

        javax.swing.GroupLayout paneComprasLayout = new javax.swing.GroupLayout(paneCompras);
        paneCompras.setLayout(paneComprasLayout);
        paneComprasLayout.setHorizontalGroup(
            paneComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneComprasLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblIconCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCompras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneComprasLayout.setVerticalGroup(
            paneComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneComprasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(paneComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        paneVentas.setBackground(new java.awt.Color(59, 59, 59));
        paneVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneVentas.setOpaque(false);
        paneVentas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneVentasMouseMoved(evt);
            }
        });
        paneVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneVentasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneVentasMouseExited(evt);
            }
        });

        lblVentas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas.setText("Ventas");

        lblIconVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas.png"))); // NOI18N

        javax.swing.GroupLayout paneVentasLayout = new javax.swing.GroupLayout(paneVentas);
        paneVentas.setLayout(paneVentasLayout);
        paneVentasLayout.setHorizontalGroup(
            paneVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVentasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIconVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVentas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneVentasLayout.setVerticalGroup(
            paneVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneVentasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblIconVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        paneProveedores.setBackground(new java.awt.Color(59, 59, 59));
        paneProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneProveedores.setOpaque(false);
        paneProveedores.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneProveedoresMouseMoved(evt);
            }
        });
        paneProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneProveedoresMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneProveedoresMouseExited(evt);
            }
        });

        lblIconProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proveedores.png"))); // NOI18N

        lblProveedor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedor.setText("Proveedores");

        javax.swing.GroupLayout paneProveedoresLayout = new javax.swing.GroupLayout(paneProveedores);
        paneProveedores.setLayout(paneProveedoresLayout);
        paneProveedoresLayout.setHorizontalGroup(
            paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneProveedoresLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(lblIconProveedor)
                .addGap(18, 18, 18)
                .addComponent(lblProveedor)
                .addGap(87, 87, 87))
        );
        paneProveedoresLayout.setVerticalGroup(
            paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProveedoresLayout.createSequentialGroup()
                .addGroup(paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        lbllinea2.setBackground(new java.awt.Color(255, 255, 255));
        lbllinea2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbllinea2.setForeground(new java.awt.Color(255, 255, 255));
        lbllinea2.setText("_______________________________________________");

        paneCerrar.setBackground(new java.awt.Color(59, 59, 59));
        paneCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneCerrar.setOpaque(false);
        paneCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneCerrarMouseMoved(evt);
            }
        });
        paneCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneCerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneCerrarMouseExited(evt);
            }
        });

        lblCerrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrar.setText("Cerrar Sesion");

        lblIconCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CerrarSesion.png"))); // NOI18N

        javax.swing.GroupLayout paneCerrarLayout = new javax.swing.GroupLayout(paneCerrar);
        paneCerrar.setLayout(paneCerrarLayout);
        paneCerrarLayout.setHorizontalGroup(
            paneCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneCerrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCerrar)
                .addGap(76, 76, 76))
        );
        paneCerrarLayout.setVerticalGroup(
            paneCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblIconCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        paneSalir.setBackground(new java.awt.Color(59, 59, 59));
        paneSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneSalir.setOpaque(false);
        paneSalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneSalirMouseMoved(evt);
            }
        });
        paneSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneSalirMouseExited(evt);
            }
        });

        lblSalir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir.setText("Salir");

        lblIconSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N

        javax.swing.GroupLayout paneSalirLayout = new javax.swing.GroupLayout(paneSalir);
        paneSalir.setLayout(paneSalirLayout);
        paneSalirLayout.setHorizontalGroup(
            paneSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSalir)
                .addGap(76, 76, 76))
        );
        paneSalirLayout.setVerticalGroup(
            paneSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblIconSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        paneCatMar.setBackground(new java.awt.Color(59, 59, 59));
        paneCatMar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneCatMar.setOpaque(false);
        paneCatMar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneCatMarMouseMoved(evt);
            }
        });
        paneCatMar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneCatMarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneCatMarMouseExited(evt);
            }
        });

        lblIconCatMar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categoria.png"))); // NOI18N

        lblCatMar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCatMar.setForeground(new java.awt.Color(255, 255, 255));
        lblCatMar.setText("Categoria/Marca");

        javax.swing.GroupLayout paneCatMarLayout = new javax.swing.GroupLayout(paneCatMar);
        paneCatMar.setLayout(paneCatMarLayout);
        paneCatMarLayout.setHorizontalGroup(
            paneCatMarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneCatMarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblIconCatMar)
                .addGap(29, 29, 29)
                .addComponent(lblCatMar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneCatMarLayout.setVerticalGroup(
            paneCatMarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCatMar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paneCatMarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconCatMar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbllinea1.setBackground(new java.awt.Color(255, 255, 255));
        lbllinea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbllinea1.setForeground(new java.awt.Color(255, 255, 255));
        lbllinea1.setText("_______________________________________________");

        paneUsuarios.setBackground(new java.awt.Color(59, 59, 59));
        paneUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneUsuarios.setOpaque(false);
        paneUsuarios.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneUsuariosMouseMoved(evt);
            }
        });
        paneUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneUsuariosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneUsuariosMouseExited(evt);
            }
        });

        lblIconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarios.png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuarios");

        javax.swing.GroupLayout paneUsuariosLayout = new javax.swing.GroupLayout(paneUsuarios);
        paneUsuarios.setLayout(paneUsuariosLayout);
        paneUsuariosLayout.setHorizontalGroup(
            paneUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario)
                .addGap(110, 110, 110))
        );
        paneUsuariosLayout.setVerticalGroup(
            paneUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneUsuariosLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(paneUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        paneReportes.setBackground(new java.awt.Color(59, 59, 59));
        paneReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneReportes.setOpaque(false);
        paneReportes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneReportesMouseMoved(evt);
            }
        });
        paneReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneReportesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneReportesMouseExited(evt);
            }
        });

        lblReportes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblReportes.setForeground(new java.awt.Color(255, 255, 255));
        lblReportes.setText("Reportes");

        lblIconReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portapapeles.png"))); // NOI18N

        javax.swing.GroupLayout paneReportesLayout = new javax.swing.GroupLayout(paneReportes);
        paneReportes.setLayout(paneReportesLayout);
        paneReportesLayout.setHorizontalGroup(
            paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneReportesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIconReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReportes)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        paneReportesLayout.setVerticalGroup(
            paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneReportesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblIconReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        paneFacturacion.setBackground(new java.awt.Color(59, 59, 59));
        paneFacturacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneFacturacion.setOpaque(false);
        paneFacturacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneFacturacionMouseMoved(evt);
            }
        });
        paneFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneFacturacionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneFacturacionMouseExited(evt);
            }
        });

        lblFacturacion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblFacturacion.setForeground(new java.awt.Color(255, 255, 255));
        lblFacturacion.setText("Facturacion");

        lblIconFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Factura.png"))); // NOI18N

        javax.swing.GroupLayout paneFacturacionLayout = new javax.swing.GroupLayout(paneFacturacion);
        paneFacturacion.setLayout(paneFacturacionLayout);
        paneFacturacionLayout.setHorizontalGroup(
            paneFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFacturacionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIconFacturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFacturacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneFacturacionLayout.setVerticalGroup(
            paneFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFacturacionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblIconFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lbllineaTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lbllineaTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbllineaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbllineaTitulo.setText("_______________________________________________");

        paneEspacioVacio1.setOpaque(false);

        javax.swing.GroupLayout paneEspacioVacio1Layout = new javax.swing.GroupLayout(paneEspacioVacio1);
        paneEspacioVacio1.setLayout(paneEspacioVacio1Layout);
        paneEspacioVacio1Layout.setHorizontalGroup(
            paneEspacioVacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        paneEspacioVacio1Layout.setVerticalGroup(
            paneEspacioVacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        paneEspacioVacio2.setOpaque(false);

        javax.swing.GroupLayout paneEspacioVacio2Layout = new javax.swing.GroupLayout(paneEspacioVacio2);
        paneEspacioVacio2.setLayout(paneEspacioVacio2Layout);
        paneEspacioVacio2Layout.setHorizontalGroup(
            paneEspacioVacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        paneEspacioVacio2Layout.setVerticalGroup(
            paneEspacioVacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contraerBarra.png"))); // NOI18N
        lblAccionBarra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblAccionBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblAccionBarraMouseMoved(evt);
            }
        });
        lblAccionBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAccionBarraMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAccionBarraMouseExited(evt);
            }
        });

        paneAlmacen.setBackground(new java.awt.Color(59, 59, 59));
        paneAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneAlmacen.setOpaque(false);
        paneAlmacen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                paneAlmacenMouseMoved(evt);
            }
        });
        paneAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneAlmacenMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneAlmacenMouseExited(evt);
            }
        });

        lblIconAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacenB.png"))); // NOI18N

        lblAlmacen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        lblAlmacen.setText("Almacen");

        javax.swing.GroupLayout paneAlmacenLayout = new javax.swing.GroupLayout(paneAlmacen);
        paneAlmacen.setLayout(paneAlmacenLayout);
        paneAlmacenLayout.setHorizontalGroup(
            paneAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlmacenLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIconAlmacen)
                .addGap(32, 32, 32)
                .addComponent(lblAlmacen)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        paneAlmacenLayout.setVerticalGroup(
            paneAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneAlmacenLayout.createSequentialGroup()
                        .addComponent(lblAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addComponent(lblIconAlmacen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout paneMenuLayout = new javax.swing.GroupLayout(paneMenu);
        paneMenu.setLayout(paneMenuLayout);
        paneMenuLayout.setHorizontalGroup(
            paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(paneMenuLayout.createSequentialGroup()
                .addGroup(paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneMenuLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(paneArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(paneUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneCatMar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(paneVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneMenuLayout.createSequentialGroup()
                        .addGroup(paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(paneEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneMenuLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lbllineaTitulo))
                                    .addComponent(paneEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lbllinea2))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(paneSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(paneEspacioVacio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paneEspacioVacio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(lblAccionBarra))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(paneAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paneProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(paneMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(paneReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(paneMenuLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lbllinea1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneMenuLayout.setVerticalGroup(
            paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(paneEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbllineaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lbllinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(paneProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneCatMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(paneFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbllinea2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneEspacioVacio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAccionBarra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneEspacioVacio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        lbllinea1.getAccessibleContext().setAccessibleName("_______");

        javax.swing.GroupLayout paneContenidoVentanaLayout = new javax.swing.GroupLayout(paneContenidoVentana);
        paneContenidoVentana.setLayout(paneContenidoVentanaLayout);
        paneContenidoVentanaLayout.setHorizontalGroup(
            paneContenidoVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContenidoVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneInfConte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        paneContenidoVentanaLayout.setVerticalGroup(
            paneContenidoVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContenidoVentanaLayout.createSequentialGroup()
                .addComponent(paneInfConte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 607, Short.MAX_VALUE))
            .addGroup(paneContenidoVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        paneHeader.setBackground(new java.awt.Color(25, 34, 143));
        paneHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paneHeaderMouseDragged(evt);
            }
        });
        paneHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneHeaderMousePressed(evt);
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

        javax.swing.GroupLayout paneHeaderLayout = new javax.swing.GroupLayout(paneHeader);
        paneHeader.setLayout(paneHeaderLayout);
        paneHeaderLayout.setHorizontalGroup(
            paneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblHeaderLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneHeaderOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        paneHeaderLayout.setVerticalGroup(
            paneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeaderLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneHeaderOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneContenidoVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneContenidoVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paneUsuariosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUsuariosMouseMoved
        
        // TODO add your handling code here:
        paneUsuarios.setOpaque(true);
        paneUsuarios.repaint();
    }//GEN-LAST:event_paneUsuariosMouseMoved

    private void paneUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUsuariosMouseExited
        // TODO add your handling code here:
        
        if(opSeleccionada.equals("Usuarios")){
            paneUsuarios.setOpaque(true);
        }
        else{
            paneUsuarios.setOpaque(false);
        }
        paneUsuarios.repaint();
    }//GEN-LAST:event_paneUsuariosMouseExited

    private void paneVentasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneVentasMouseMoved
        // TODO add your handling code here:
        paneVentas.setOpaque(true);
        paneVentas.repaint();
    }//GEN-LAST:event_paneVentasMouseMoved

    private void paneVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneVentasMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        //paneVentas.setOpaque(false);
        //paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Ventas";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelVentas ventas =new panelVentas();
        paneCentral.add(ventas.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
        
    }//GEN-LAST:event_paneVentasMouseClicked

    private void paneVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneVentasMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Ventas")){
            paneVentas.setOpaque(true);
        }
        else{
            paneVentas.setOpaque(false);
        }
        paneVentas.repaint();
    }//GEN-LAST:event_paneVentasMouseExited

    private void paneCatMarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneCatMarMouseMoved
        // TODO add your handling code here:
        paneCatMar.setOpaque(true);
        paneCatMar.repaint();
    }//GEN-LAST:event_paneCatMarMouseMoved

    private void paneCatMarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneCatMarMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        //paneCatMar.setOpaque(false);
        //paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="CatMar";
        
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelCategoriaMarca CatMar =new panelCategoriaMarca();
        paneCentral.add(CatMar.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneCatMarMouseClicked

    private void paneCatMarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneCatMarMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("CatMar")){
            paneCatMar.setOpaque(true);
        }
        else{
            paneCatMar.setOpaque(false);
        }
        paneCatMar.repaint();
        
    }//GEN-LAST:event_paneCatMarMouseExited

    private void paneArticulosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneArticulosMouseMoved
        // TODO add your handling code here:
        paneArticulos.setOpaque(true);
        paneArticulos.repaint();
        
    }//GEN-LAST:event_paneArticulosMouseMoved

    private void paneArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneArticulosMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        //paneArticulos.setOpaque(false);
        //paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Articulos";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelArticulos Articulos =new panelArticulos();
        paneCentral.add(Articulos.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
        
    }//GEN-LAST:event_paneArticulosMouseClicked

    private void paneArticulosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneArticulosMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Articulos")){
            paneArticulos.setOpaque(true);
        }
        else{
            paneArticulos.setOpaque(false);
        }
        paneArticulos.repaint();
    }//GEN-LAST:event_paneArticulosMouseExited

    private void paneCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneCerrarMouseMoved
        // TODO add your handling code here:
        paneCerrar.setOpaque(true);
        paneCerrar.repaint();
    }//GEN-LAST:event_paneCerrarMouseMoved

    private void paneCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneCerrarMouseClicked
        // TODO add your handling code here:
        LoginFrame Login= new LoginFrame();
        Login.setVisible(true); 
        setVisible(false);
       
    }//GEN-LAST:event_paneCerrarMouseClicked

    private void paneCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneCerrarMouseExited
        // TODO add your handling code here:
        paneCerrar.setOpaque(false);
        paneCerrar.repaint();
    }//GEN-LAST:event_paneCerrarMouseExited

    private void paneEscritorioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneEscritorioMouseMoved
        // TODO add your handling code here:
        paneEscritorio.setOpaque(true);
        paneEscritorio.repaint();
    }//GEN-LAST:event_paneEscritorioMouseMoved

    private void paneEscritorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneEscritorioMouseClicked
        // TODO add your handling code here:
        //paneEscritorio.setOpaque(false);
        //paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Escritorio";
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelEscritorio Escritorio =new panelEscritorio();
        paneCentral.add(Escritorio.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneEscritorioMouseClicked

    private void paneEscritorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneEscritorioMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Escritorio")){
            paneEscritorio.setOpaque(true);
        }
        else{
            paneEscritorio.setOpaque(false);
        }
        paneEscritorio.repaint();
    }//GEN-LAST:event_paneEscritorioMouseExited

    private void paneProveedoresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProveedoresMouseMoved
        // TODO add your handling code here:
        paneProveedores.setOpaque(true);
        paneProveedores.repaint();
    }//GEN-LAST:event_paneProveedoresMouseMoved

    private void paneProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProveedoresMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        //paneProveedores.setOpaque(false);
        //paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Proveedores";
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelProveedores proveedores =new panelProveedores();
        paneCentral.add(proveedores.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneProveedoresMouseClicked

    private void paneProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProveedoresMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Proveedores")){
            paneProveedores.setOpaque(true);
        }
        else{
            paneProveedores.setOpaque(false);
        }
        paneProveedores.repaint();
    }//GEN-LAST:event_paneProveedoresMouseExited

    private void paneComprasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneComprasMouseMoved
        // TODO add your handling code here:
        paneCompras.setOpaque(true);
        paneCompras.repaint();
    }//GEN-LAST:event_paneComprasMouseMoved

    private void paneComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneComprasMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        //paneCompras.setOpaque(false);
        //paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Compras";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelCompras compras =new panelCompras();
        paneCentral.add(compras.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneComprasMouseClicked

    private void paneComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneComprasMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Compras")){
            paneCompras.setOpaque(true);
        }
        else{
            paneCompras.setOpaque(false);
        }
        paneCompras.repaint();
    }//GEN-LAST:event_paneComprasMouseExited

    private void paneSalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneSalirMouseMoved
        // TODO add your handling code here:
        paneSalir.setOpaque(true);
        paneSalir.repaint();
    }//GEN-LAST:event_paneSalirMouseMoved

    private void paneSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneSalirMouseClicked
        // TODO add your handling code here:
        
       ModalVerificar modal = new ModalVerificar();
        JDialog dialogVerificar = new JDialog(modal, "Mi diálogo", true); // true indica que es modal
        dialogVerificar.setContentPane(modal.getContentPane()); // agregamos el contenido del JFrame al JDialog
        dialogVerificar.setSize(new Dimension(400,200)); // ajustamos el tamaño del JDialog al del JFrame
        dialogVerificar.setUndecorated(true);
        dialogVerificar.setLocationRelativeTo(null); // centra el dialogo en la pantalla
        dialogVerificar.setVisible(true);
        
    }//GEN-LAST:event_paneSalirMouseClicked

    private void paneSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneSalirMouseExited
        // TODO add your handling code here:
        paneSalir.setOpaque(false);
        paneSalir.repaint();
    }//GEN-LAST:event_paneSalirMouseExited

    private void paneReportesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneReportesMouseMoved
        // TODO add your handling code here:
        paneReportes.setOpaque(true);
        paneReportes.repaint();
    }//GEN-LAST:event_paneReportesMouseMoved

    private void paneReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneReportesMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        //paneReportes.setOpaque(false);
        //paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        
        opSeleccionada="Reportes";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelReportes reportes =new panelReportes();
        paneCentral.add(reportes.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneReportesMouseClicked

    private void paneReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneReportesMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Reportes")){
            paneReportes.setOpaque(true);
        }
        else{
            paneReportes.setOpaque(false);
        }
        paneReportes.repaint();
    }//GEN-LAST:event_paneReportesMouseExited

    private void paneFacturacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneFacturacionMouseMoved
        // TODO add your handling code here:
        paneFacturacion.setOpaque(true);
        paneFacturacion.repaint();
    }//GEN-LAST:event_paneFacturacionMouseMoved

    private void paneFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneFacturacionMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        //paneFacturacion.setOpaque(false);
        //paneFacturacion.repaint();
        opSeleccionada="Facturacion";
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelFacturacion facturacion =new panelFacturacion();
        paneCentral.add(facturacion.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneFacturacionMouseClicked

    private void paneFacturacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneFacturacionMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Facturacion")){
            paneFacturacion.setOpaque(true);
        }
        else{
            paneFacturacion.setOpaque(false);
        }
        paneFacturacion.repaint();
    }//GEN-LAST:event_paneFacturacionMouseExited

    private void paneUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUsuariosMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        //paneUsuarios.setOpaque(false);
        //paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Usuarios";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelUsuarios Usuarios =new panelUsuarios();
        paneCentral.add(Usuarios.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneUsuariosMouseClicked

    private void panePerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panePerfilMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Perfil")){
            panePerfil.setOpaque(true);
        }
        else{
            panePerfil.setOpaque(false);
        }
        panePerfil.repaint();
    }//GEN-LAST:event_panePerfilMouseExited

    private void panePerfilMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panePerfilMouseMoved
        // TODO add your handling code here:
        panePerfil.setOpaque(true);
        panePerfil.repaint();
    }//GEN-LAST:event_panePerfilMouseMoved

    private void lblAccionBarraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccionBarraMouseMoved
        // TODO add your handling code here:
        if(menu){
            lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selecContraerBarra.png")));
        }else{
            lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selecExpandirBarra.png")));
        }
    }//GEN-LAST:event_lblAccionBarraMouseMoved

    private void lblAccionBarraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccionBarraMouseExited
        // TODO add your handling code here:
        if(menu){
            lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contraerBarra.png")));
        }else{
            lblAccionBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expandirBarra.png")));
        }
        
    }//GEN-LAST:event_lblAccionBarraMouseExited

    private void lblAccionBarraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccionBarraMouseClicked
        // TODO add your handling code here:
        accionBarraMenu();
    }//GEN-LAST:event_lblAccionBarraMouseClicked

    private void lblCerrarVentanaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseMoved
        // TODO add your handling code here:
        lblCerrarVentana.setOpaque(true);
        lblCerrarVentana.repaint();
    }//GEN-LAST:event_lblCerrarVentanaMouseMoved

    private void lblCerrarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarVentanaMouseClicked
        // TODO add your handling code here:

        //this.dispose(); // Cierra la ventana
        //this.setVisible(false); // Oculta la ventana
        //modal.setVisible(true);
        // true indica que es modal
        ModalVerificar modal = new ModalVerificar();
        JDialog dialog = new JDialog(modal, "Mi diálogo", true); // true indica que es modal
        dialog.setContentPane(modal.getContentPane()); // agregamos el contenido del JFrame al JDialog
        dialog.setSize(new Dimension(400,200)); // ajustamos el tamaño del JDialog al del JFrame
        dialog.setUndecorated(true);
        dialog.setLocationRelativeTo(null); // centra el dialogo en la pantalla
        dialog.setVisible(true);

    }//GEN-LAST:event_lblCerrarVentanaMouseClicked

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

    private void lblMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizarMouseClicked
        // TODO add your handling code here:

        if (LoginFrame.pantallaMaximizada) {
            setSize(1400, 900);
            setLocationRelativeTo(null);
            LoginFrame.pantallaMaximizada = false;
            lblMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expandirVentana.png")));
            
        } else {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = env.getMaximumWindowBounds();

            setBounds(bounds);
            LoginFrame.pantallaMaximizada = true;
            lblMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizarTamaño.png")));
            
        }
        
        
    }//GEN-LAST:event_lblMaximizarMouseClicked

    private void lblMaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizarMouseExited
        // TODO add your handling code here:
        lblMaximizar.setOpaque(false);
        lblMaximizar.repaint();
    }//GEN-LAST:event_lblMaximizarMouseExited

    private void lblPantallaCompletaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaCompletaMouseMoved
        // TODO add your handling code here:
        lblPantallaCompleta.setOpaque(true);
        lblPantallaCompleta.repaint();
    }//GEN-LAST:event_lblPantallaCompletaMouseMoved

    private void lblPantallaCompletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaCompletaMouseClicked
        // TODO add your handling code here:
        paneContenidoVentana.setBorder(null);
        getContentPane().remove(paneHeader);
        paneInfConte.add(panecontenedorPantallaNormal, java.awt.BorderLayout.PAGE_END);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
            device.setFullScreenWindow(this);
            
        }

    }//GEN-LAST:event_lblPantallaCompletaMouseClicked

    private void lblPantallaCompletaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaCompletaMouseExited
        // TODO add your handling code here:
        lblPantallaCompleta.setOpaque(false);
        lblPantallaCompleta.repaint();
    }//GEN-LAST:event_lblPantallaCompletaMouseExited

    private void lblMinimizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseMoved
        // TODO add your handling code here:
        lblMinimizar.setOpaque(true);
        lblMinimizar.repaint();
    }//GEN-LAST:event_lblMinimizarMouseMoved

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        // TODO add your handling code here:
        setState(ICONIFIED);

    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseExited
        // TODO add your handling code here:
        lblMinimizar.setOpaque(false);
        lblMinimizar.repaint();
    }//GEN-LAST:event_lblMinimizarMouseExited

    private void paneHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHeaderMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_paneHeaderMouseDragged
    int xMouse,yMouse;
    private void paneHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHeaderMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();

    }//GEN-LAST:event_paneHeaderMousePressed

    private void lblPantallaNormalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaNormalMouseMoved
        // TODO add your handling code here:
        lblPantallaNormal.setOpaque(true);
        lblPantallaNormal.repaint();
    }//GEN-LAST:event_lblPantallaNormalMouseMoved

    private void lblPantallaNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaNormalMouseClicked
        // TODO add your handling code here:
        LineBorder borde = new LineBorder(new Color(25, 34, 143), 1);
        paneContenidoVentana.setBorder(borde);
        getContentPane().add(paneHeader, java.awt.BorderLayout.PAGE_START);
        paneInfConte.remove(panecontenedorPantallaNormal);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setExtendedState(JFrame.NORMAL);
        setUndecorated(true);
        device.setFullScreenWindow(this);
       
    }//GEN-LAST:event_lblPantallaNormalMouseClicked

    private void lblPantallaNormalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPantallaNormalMouseExited
        // TODO add your handling code here:
        lblPantallaNormal.setOpaque(false);
        lblPantallaNormal.repaint();
    }//GEN-LAST:event_lblPantallaNormalMouseExited

    private void panePerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panePerfilMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        //panePerfil.setOpaque(false);
        //panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        paneAlmacen.setOpaque(false);
        paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Perfil";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelPerfil perfil =new panelPerfil();
        paneCentral.add(perfil.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_panePerfilMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(LoginFrame.pantallaMaximizada){
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = env.getMaximumWindowBounds();

            setBounds(bounds);
            lblMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizarTamaño.png")));
        }
        if(LoginFrame.pantallaCompleta){
            getContentPane().remove(paneHeader);
            paneInfConte.add(panecontenedorPantallaNormal, java.awt.BorderLayout.PAGE_END);

            GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            if (device.isFullScreenSupported()) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setUndecorated(true);
                device.setFullScreenWindow(this);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void paneAlmacenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneAlmacenMouseMoved
        // TODO add your handling code here:
        paneAlmacen.setOpaque(true);
        paneAlmacen.repaint();
    }//GEN-LAST:event_paneAlmacenMouseMoved

    private void paneAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneAlmacenMouseClicked
        // TODO add your handling code here:
        paneEscritorio.setOpaque(false);
        paneEscritorio.repaint();
        panePerfil.setOpaque(false);
        panePerfil.repaint();
        paneUsuarios.setOpaque(false);
        paneUsuarios.repaint();
        paneArticulos.setOpaque(false);
        paneArticulos.repaint();
        //paneAlmacen.setOpaque(false);
        //paneAlmacen.repaint();
        paneProveedores.setOpaque(false);
        paneProveedores.repaint();
        paneCatMar.setOpaque(false);
        paneCatMar.repaint();
        paneCompras.setOpaque(false);
        paneCompras.repaint();
        paneVentas.setOpaque(false);
        paneVentas.repaint();
        paneReportes.setOpaque(false);
        paneReportes.repaint();
        paneFacturacion.setOpaque(false);
        paneFacturacion.repaint();
        opSeleccionada="Almacen";
        
        paneCentral.remove(0); // Eliminar el componente actual en el centro
        panelAlmacen almacen =new panelAlmacen();
        paneCentral.add(almacen.obtenerPanel());
        paneCentral.revalidate(); // Actualizar el contenedor
        paneCentral.repaint();
    }//GEN-LAST:event_paneAlmacenMouseClicked

    private void paneAlmacenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneAlmacenMouseExited
        // TODO add your handling code here:
        if(opSeleccionada.equals("Almacen")){
            paneAlmacen.setOpaque(true);
        }
        else{
            paneAlmacen.setOpaque(false);
        }
        paneAlmacen.repaint();
    }//GEN-LAST:event_paneAlmacenMouseExited

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
            java.util.logging.Logger.getLogger(SistemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaFrame().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAccionBarra;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblArticulos;
    private javax.swing.JLabel lblCatMar;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblCerrarVentana;
    private javax.swing.JLabel lblCompras;
    private javax.swing.JLabel lblEscritorio;
    private javax.swing.JLabel lblFacturacion;
    private javax.swing.JLabel lblHeaderLogo;
    private javax.swing.JLabel lblIconAlmacen;
    private javax.swing.JLabel lblIconArticulos;
    private javax.swing.JLabel lblIconCatMar;
    private javax.swing.JLabel lblIconCerrar;
    private javax.swing.JLabel lblIconCompras;
    private javax.swing.JLabel lblIconEscritorio;
    private javax.swing.JLabel lblIconFacturacion;
    private javax.swing.JLabel lblIconPerfil;
    private javax.swing.JLabel lblIconProveedor;
    private javax.swing.JLabel lblIconReportes;
    private javax.swing.JLabel lblIconSalir;
    private javax.swing.JLabel lblIconUsuario;
    private javax.swing.JLabel lblIconVentas;
    private javax.swing.JLabel lblImgPerfil;
    private javax.swing.JLabel lblLogoEmpresa;
    private javax.swing.JLabel lblMaximizar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblNomEmpresa;
    private javax.swing.JLabel lblNomUser;
    private javax.swing.JLabel lblPantallaCompleta;
    private javax.swing.JLabel lblPantallaNormal;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblSeparador;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel lbllinea1;
    private javax.swing.JLabel lbllinea2;
    private javax.swing.JLabel lbllineaTitulo;
    private javax.swing.JPanel paneAlmacen;
    private javax.swing.JPanel paneArticulos;
    private javax.swing.JPanel paneCatMar;
    private javax.swing.JPanel paneCentral;
    private javax.swing.JPanel paneCerrar;
    private javax.swing.JPanel paneCompras;
    private javax.swing.JPanel paneContDataUser;
    private javax.swing.JPanel paneContReloj;
    private javax.swing.JPanel paneContenidoVentana;
    private javax.swing.JPanel paneEmpresa;
    private javax.swing.JPanel paneEscritorio;
    private javax.swing.JPanel paneEspacioVacio1;
    private javax.swing.JPanel paneEspacioVacio2;
    private javax.swing.JPanel paneFacturacion;
    private javax.swing.JPanel paneHeader;
    private javax.swing.JPanel paneHeaderOpciones;
    private javax.swing.JPanel paneInfConte;
    private javax.swing.JPanel paneInfo;
    private javax.swing.JPanel paneMenu;
    private javax.swing.JPanel panePerfil;
    private javax.swing.JPanel paneProveedores;
    private javax.swing.JPanel paneReportes;
    private javax.swing.JPanel paneSalir;
    private javax.swing.JPanel paneUsuarios;
    private javax.swing.JPanel paneVentas;
    private javax.swing.JPanel panecontenedorPantallaNormal;
    // End of variables declaration//GEN-END:variables


    private void InicializarRelog(){
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
            String time = formatter.format(now);
            lblReloj.setText(time);
        });
        timer.setRepeats(true);
        timer.start();
    }
    private void desactivarOpcion(JPanel opcion){
        opcion.setEnabled(false);
        paneMenu.remove(opcion);
    }
    private void PermisosPorRol(String rol){
        switch(rol){
            case "Supervisor":
                
                break;
            case "EmpleadoCompras":
                desactivarOpcion(paneUsuarios);
                desactivarOpcion(paneArticulos);
                desactivarOpcion(paneAlmacen);
                desactivarOpcion(paneReportes);
                desactivarOpcion(paneVentas);
                desactivarOpcion(paneFacturacion);
                break;
            case "EmpleadoVentas":
                desactivarOpcion(paneUsuarios);
                desactivarOpcion(paneArticulos);
                desactivarOpcion(paneAlmacen);
                desactivarOpcion(paneProveedores);
                desactivarOpcion(paneCatMar);
                desactivarOpcion(paneCompras);
                desactivarOpcion(paneReportes);
                break; 
            case "EmpleadoAlmacen":
                desactivarOpcion(paneUsuarios);
                desactivarOpcion(paneProveedores);
                desactivarOpcion(paneCatMar);
                desactivarOpcion(paneCompras);
                desactivarOpcion(paneReportes);
                desactivarOpcion(paneVentas);
                desactivarOpcion(paneFacturacion);
                break; 
        }
    }
    private void cargarDatosUsuario(){
        lblNomUser.setText((String) LoginFrame.sesionUsuario.get("nombre"));
        lblRol.setText((String) LoginFrame.sesionUsuario.get("rol"));
    }
    
}

