package hotel;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana_principal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Simulacion simulacion;
	//private Barra_menu menu_barra;
	private int ancho,alto;
    public Ventana_principal(){
    	confi_ini();
    	crear_contenido();
    	confi_fin();
    }
    @SuppressWarnings("deprecation")
	private void confi_ini() {
    	ancho=1280;
    	alto=720;
    	setLayout(null);
    	setSize(ancho,alto);
	   	setLocationRelativeTo(null);
	   	setTitle("Simulador Hotel");
	   	setMinimumSize(new Dimension(800,500));
	   	setUndecorated(true);//quita el borde de ventana
	   	setAlwaysOnTop(false);//permitir segundo plano
	   	setCursor(12);
	   	//setOpacity(0.9f);
	   	
	   	//crea icono de aplicacion
	   	ImageIcon icono=new ImageIcon(getClass().getResource("/imagenes/icono_00.png"));
	   	setIconImage(icono.getImage());
	}
    private void crear_contenido() {
		//menu_barra=new Barra_menu(this);
		//setJMenuBar(menu_barra);
		
		simulacion=new Simulacion((Ventana_principal)this);
		add(simulacion);	
	}
	private void confi_fin() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
