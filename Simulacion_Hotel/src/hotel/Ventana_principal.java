package hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana_principal extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel menu_ini;
	private JMenuBar menu_barra;
	private JMenu archivo;
	private JMenuItem abrir,guardar,salir;
	private JMenu configuracion;
	private JMenuItem cambiar_precio,cambiar_secretrias,pausa,stop,iniciar,restablecer;
	private JMenu ayuda;
	private JMenuItem creadores,manual_usuario;
    public Ventana_principal(){
    	confi_ini();
    	inicializar();
    	confi_fin();
    }
    private void confi_ini() {
    	setLayout(null);
	   	setBounds(0,0,1280,720);
	   	setTitle("Simulador Hotel");
	   	//setUndecorated(true);//quita el borde de ventana
	   	setAlwaysOnTop(false);//permitir segundo plano
	   	//crea icono de aplicacion
	   	ImageIcon icono=new ImageIcon(getClass().getResource("/imagenes/icono_00.png"));
	   	setIconImage(icono.getImage());
	   	crear_barra_menu();
	   	crear_contenido();
	   	crear_botones();
	}
	private void crear_barra_menu() {
		menu_barra=new JMenuBar();
		
		archivo=new JMenu("Archivo");
		abrir=new JMenuItem("Abrir Configuracion");
		guardar=new JMenuItem("Guardar Estadisticas");
		salir=new JMenuItem("Cerrar");
		salir.addActionListener(this);
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(salir);
		menu_barra.add(archivo);
		
		configuracion=new JMenu("Configuracion");
		cambiar_precio=new JMenuItem("Cambiar precios de Habitacion");
		cambiar_secretrias=new JMenuItem("Cambiar numero de Secretarias");
		pausa=new JMenuItem("Pausa");
		stop=new JMenuItem("Detener Simulacion");
		iniciar=new JMenuItem("Iniciar Simulacion");
		restablecer=new JMenuItem("REstablecer Valores Iniciales");
		configuracion.add(cambiar_precio);
		configuracion.add(cambiar_secretrias);
		configuracion.add(pausa);
		configuracion.add(stop);
		configuracion.add(iniciar);
		configuracion.add(restablecer);
		menu_barra.add(configuracion);
		
		ayuda=new JMenu("Ayuda");
		creadores=new JMenuItem("Creadores del Simulador");
		creadores.addActionListener(this);
		manual_usuario=new JMenuItem("Manual de Usuario");
		ayuda.add(creadores);
		ayuda.add(manual_usuario);
		menu_barra.add(ayuda);
		
		setJMenuBar(menu_barra);
	}
	private void crear_contenido() {
		
	}
	private void crear_botones() {
		
	}
	private void inicializar() {
		menu_ini=new Menu_inicio();
		add(menu_ini);
	}
	private void confi_fin() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion=e.getActionCommand().toLowerCase();
		if(accion.equals("cerrar"))
		    System.exit(0);
		if(accion.equals("creadores del simulador"))
			JOptionPane.showMessageDialog(null, "Creadores:");
	}
}
