package vista;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controlador.Controlador;

public class VFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelPrincipal pp;
	//private Barra_menu menu_barra;
	private Controlador ctrl;
	private int ancho,alto;
	
    public VFrame(Controlador c){
    	//System.out.println("   iniciando Constructor VFrame");
    	ctrl=c;
    	confi_ini();
    	crearContenido();
    	confi_fin();
    	//System.out.println("   Terminado la iniciacion del constructor VFrame");
    }
    public PanelPrincipal getpp() {		    	return pp;    }
	public void setVentanaPrincipal(PanelPrincipal vpp) {		this.pp = vpp;}
	private void confi_ini() {
    	ancho=1280;
    	alto=720;
    	setLayout(null);
    	setSize(ancho,alto);
	   	setLocationRelativeTo(null);
	   	setTitle("Simulador Hotel");
	   	getRootPane().setWindowDecorationStyle(8);
	   	setMinimumSize(new Dimension(alto-430,alto-220));
	   	setUndecorated(true);//quita el borde de ventana
	   	setAlwaysOnTop(false);//permitir segundo plano
	   	//setCursor(0);
	   	//crea icono de aplicacion
	   	ImageIcon icono=new ImageIcon(getClass().getResource("/imagenes/icono_00.png"));
	   	setIconImage(icono.getImage());
	   	//System.out.println("    configuracion Inicial terminado de VFrame");
	}
    private void crearContenido() {
		//menu_barra=new Barra_menu(this);
		//setJMenuBar(menu_barra);
    	//System.out.println("    creando pp en VFrame");
    	pp=new PanelPrincipal(ctrl,this);
    	//System.out.println("    creado pp en VFrame");
    	//ctrl.prueba("VFrame");
		add(pp);	
	}
	private void confi_fin() {
		//System.out.println("    configuracion final de VFrame comenzando");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//System.out.println("    configuracion final de VFrame terminado");
	}
}
