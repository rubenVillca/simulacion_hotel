package hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Barra_menu extends JMenuBar implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu archivo;
	private JMenuItem abrir,guardar,salir;
	private JMenu configuracion;
	private JMenuItem cambiar_precio,cambiar_secretrias,pausa,stop,iniciar,restablecer;
	private JMenu ayuda;
	private JMenuItem creadores,manual_usuario;
	@SuppressWarnings("unused")
	private Ventana_principal p;
    public Barra_menu(Ventana_principal p){
    	this.p=p;
    	inicializar();
    }
	private void inicializar() {
		
		archivo=new JMenu("Archivo");
		abrir=new JMenuItem("Abrir Configuracion");
		guardar=new JMenuItem("Guardar Estadisticas");
		salir=new JMenuItem("Cerrar");
		salir.addActionListener(this);
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(salir);
		add(archivo);
		
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
		add(configuracion);
		
		ayuda=new JMenu("Ayuda");
		creadores=new JMenuItem("Creadores del Simulador");
		creadores.addActionListener(this);
		manual_usuario=new JMenuItem("Manual de Usuario");
		ayuda.add(creadores);
		ayuda.add(manual_usuario);
		add(ayuda);
		
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
