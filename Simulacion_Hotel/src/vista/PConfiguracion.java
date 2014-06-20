package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import modelo.Fecha;

public class PConfiguracion extends JPanel{
	private static final long serialVersionUID = 1L;
	private PanelPrincipal pp;
	private JTextField precio1,precio2,precio3;
	private JTextField fecha;
	private JSlider velocidad;
	private JSpinner nroHab1,nroHab2,nroHab3,tiempoSim;
	private JSpinner demanda1,demanda2,demanda3;
    public PConfiguracion(PanelPrincipal vpp){
        pp=vpp;
        confi_ini();
        crearCont();
        confi_fin();
        pp.prueba("VConfiguracion");
    }
    private void confi_ini() {
		setLayout(new GridLayout(15,2,5,22));
		cambiar_tam();
	}
    private void cambiar_tam(){
		int posX=(int)(pp.getWidth()*1.0*4/5);
		int posY=100;
		int tamX=(int)(pp.getWidth()*(1.0/5)-10);
		int tamY=(int)(pp.getHeight()*(1.0*7/8));
		setBounds(posX,posY,tamX,tamY);
	}
    private void crearCont() {
		JLabel lab;
		
		lab=new JLabel("Etiquetas");
		add(lab);
		lab=new JLabel("Cambios");
		add(lab);
		
		lab=new JLabel("Precio Simple");
		add(lab);
		precio1=new JTextField();
		add(precio1);
		
		lab=new JLabel("Precio Doble");	
		add(lab);
		precio2=new JTextField();
		add(precio2);
		
		lab=new JLabel("Precio Suit");
		add(lab);
		precio3=new JTextField();
		add(precio3);
		
		lab=new JLabel("Demanda Habs Simple");
		add(lab);
		demanda1=new JSpinner();
		demanda1.setModel(new SpinnerNumberModel(1, 1,200,1 ));
		add(demanda1);
		
		lab=new JLabel("Demanda Habs Doble");
		add(lab);
		demanda2=new JSpinner();
		demanda2.setModel(new SpinnerNumberModel(1, 1,500,1 ));
		add(demanda2);

		lab=new JLabel("Demanda Habs Suit");
		add(lab);
		demanda3=new JSpinner();
		demanda3.setModel(new SpinnerNumberModel(2, 2,1000,1 ));
		add(demanda3);
		
		lab=new JLabel("Habitaciones Simples");
		add(lab);
		nroHab1=new JSpinner();
		nroHab1.setModel(new SpinnerNumberModel(2, 2,1000,1 ));
		add(nroHab1);
		
		lab=new JLabel("Habitaciones Dobles");
		add(lab);
		nroHab2=new JSpinner();
		nroHab2.setModel(new SpinnerNumberModel(2, 2,1000,1 ));
		add(nroHab2);
		
		lab=new JLabel("Habitaciones Suit");
		add(lab);
		nroHab3=new JSpinner();
		nroHab3.setModel(new SpinnerNumberModel(2, 2,1000,1 ));
		add(nroHab3);
		
		lab=new JLabel("Fecha Inicio");
		add(lab);
		fecha=new JTextField();
		add(fecha);
		
		lab=new JLabel("Tiempo simulacion");
		add(lab);
		tiempoSim=new JSpinner();
		tiempoSim.setModel(new SpinnerNumberModel(50,1,500,1));
		add(tiempoSim);
		
		lab=new JLabel("Velocidad Simulacion");
		add(lab);
		velocidad=new JSlider(1,100,5);
		//velocidad.setOrientation(1);//horizontal
		//velocidad.setPaintTicks(true);
		//velocidad.setPaintLabels(true);
		//velocidad.setPaintTrack(true);
		velocidad.setOpaque(false);
		add(velocidad);
		
		/*lab=new JLabel("Precios Limpieza");
		add(lab);
		
		lab=new JLabel("Precios Comida");
		add(lab);*/
		
	}
	private void confi_fin() {		setVisible(true);	}
	public void paintComponent(Graphics g){
		Dimension tam=pp.getSize();
		cambiar_tam();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_03" +".jpg"));
    	g.drawImage(imagen.getImage(),0,0,(int)tam.getWidth(),(int)tam.getHeight(),null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
	public void habilitar(){
		precio1.setEnabled(true);
		precio2.setEnabled(true);
		precio3.setEnabled(true);
		
		nroHab1.setEnabled(true);
		nroHab2.setEnabled(true);
		nroHab3.setEnabled(true);
		
		demanda1.setEnabled(true);
		demanda2.setEnabled(true);
		demanda3.setEnabled(true);
		
		fecha.setEnabled(true);
		tiempoSim.setEnabled(true);
	}
	public void deshabilitar(){
		precio1.setEnabled(false);
		precio2.setEnabled(false);
		precio3.setEnabled(false);
		
		nroHab1.setEnabled(false);
		nroHab2.setEnabled(false);
		nroHab3.setEnabled(false);
		
		demanda1.setEnabled(false);
		demanda2.setEnabled(false);
		demanda3.setEnabled(false);
		
		fecha.setEditable(false);
		tiempoSim.setEnabled(false);
	}
	public int getPrecio1() {
		if(precio1.getText().equals("")||precio1.getText().equals(null)||precio1.getText().equals("\n")||precio1.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio1.getText());
	}
	public void setPrecio1(JTextField precio1) {		this.precio1 = precio1;	}
	
	public int getPrecio2() {
		if(precio2.getText().equals("")||precio2.getText().equals(null)||precio2.getText().equals("\n")||precio2.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio2.getText());
	}
	public void setPrecio2(JTextField precio2) {		this.precio2 = precio2;	}
	
	public int getPrecio3() {
		if(precio3.getText().equals("")||precio3.getText().equals(null)||precio3.getText().equals("\n")||precio3.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio3.getText());
	}
	public void setPrecio3(JTextField precio3) {		this.precio3 = precio3;	}
	
	public int getNroHab1() {		return (Integer) nroHab1.getValue();	}
	public void setNroHab1(JSpinner nroHab1) {		this.nroHab1 = nroHab1;	}
	public int getNroHab2() {		return (Integer) nroHab2.getValue();	}
	public void setNroHab2(JSpinner nroHab2) {		this.nroHab2 = nroHab2;	}
	public int getNroHab3() {		return (Integer) nroHab3.getValue();	}
	public void setNroHab3(JSpinner nroHab3) {		this.nroHab3 = nroHab3;	}
	public int getVel() {		return velocidad.getValue();	}
	public Fecha getFecha() {		return new Fecha(15, 1, 2000);	}
	public int getTiempo() {		return (Integer)tiempoSim.getValue();	}
}