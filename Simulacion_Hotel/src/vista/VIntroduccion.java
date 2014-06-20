package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;


public class VIntroduccion extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton aceptar,cancelar;
	private VFrame ventana;
	private VIntroduccionFondo fondoIntroduccion;
	public VIntroduccion(VFrame v){
		ventana=v;
		confi_ini();
		crear_contenido();
		confi_fin();
	}
	private void confi_ini() {
		setTitle("Simulador 1.0");
		setLayout(null);
		setUndecorated(true);
		//setLocationRelativeTo(null);
		//setLocation(null);
		setBounds(20,20,800,600);
		setLocationRelativeTo(null);
		setOpacity(0.5f);
	}
	private void crear_contenido() {
		fondoIntroduccion=new VIntroduccionFondo();
		fondoIntroduccion.setSize(getSize());
		
		aceptar=new JButton("Ingresar");
		aceptar.setBounds(320,500,120,20);
		aceptar.addActionListener(this);
		fondoIntroduccion.add(aceptar);
		
		cancelar=new JButton("Cancelar");
		cancelar.setBounds(450,500,120,20);
		cancelar.addActionListener(this);
		fondoIntroduccion.add(cancelar);
		
		
		add(fondoIntroduccion);
	}
	private void confi_fin() {
		setVisible(true);
		try {
			Thread.sleep(300);
		} catch (Exception e) {	}
		setOpacity(.9f);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String res=e.getActionCommand().toLowerCase();
		if(res.equals("cancelar"))
			System.exit(0);
		if(res.equals("ingresar"))
			ventana.setVisible(true);
		dispose();
	}
}