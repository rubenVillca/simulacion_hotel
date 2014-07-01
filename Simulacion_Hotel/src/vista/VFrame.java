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
    	ctrl=c;
    	confi_ini();
    	crearContenido();
    	confi_fin();
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
		//setContentPane(getContentPan());
	   	//setCursor(0);
	   	//crea icono de aplicacion
	   	ImageIcon icono=new ImageIcon(getClass().getResource("/imagenes/hotel_1.png"));
	   	setIconImage(icono.getImage());
	}
	/*private JPanel getContentPan(){
		JPanel res=new JPanel();
		JLabel cont=new JLabel();
		cont.setBounds(0,0,ancho/2,alto);
		cont.setIcon(new ImageIcon(this.getClass().getResource("/margenes/tunnig.png")));
		res.setLayout(null);
		res.add(cont,null);
		return res;
	}*/
    private void crearContenido() {
		//menu_barra=new Barra_menu(this);
		//setJMenuBar(menu_barra);
    	pp=new PanelPrincipal(ctrl,this);
    	//ctrl.prueba("VFrame");
		add(pp);	
	}
	private void confi_fin() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
