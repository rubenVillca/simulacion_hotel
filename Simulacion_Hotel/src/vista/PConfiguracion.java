package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PConfiguracion extends JPanel{
	private static final long serialVersionUID = 1L;
	private PanelPrincipal pp;
	private JTextField precio1,precio2,precio3,precio4;
	private JComboBox<String> temporada;
	private JSlider velocidad;
	private JSpinner nroHab1,nroHab2,nroHab3,nroHab4,tiempoSim;
	private JSpinner demanda1,demanda2,demanda3,demanda4;
    public PConfiguracion(PanelPrincipal vpp){
        pp=vpp;
        confi_ini();
        crearCont();
        confi_fin();
    }
    private void confi_ini() {
		//setLayout(new GridLayout(20,2,5,15));
    	setLayout(null);
		this.setBackground(new Color(0,0,0));
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
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,102,102));
		lab.setBounds(15,15,150,15);
		add(lab);
		lab=new JLabel("Cambios");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,102,102));
		lab.setBounds(170,15,250,15);
		add(lab);
		
		lab=new JLabel("Precio Simple");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,50,150,15);
		add(lab);
		precio1=new JTextField();
		precio1.setText("25");
		precio1.setFont(new Font("Lucida Calligraphy", 1, 14));
		precio1.setForeground(new Color(153,204,0));
		precio1.setBounds(190,50,40,18);
		add(precio1);
		
		lab=new JLabel("Precio Estandar");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,75,150,15);
		add(lab);
		precio2=new JTextField();
		precio2.setText("50");
		precio2.setFont(new Font("Lucida Calligraphy", 1, 14));
		precio2.setForeground(new Color(153,204,0));
		precio2.setBounds(190,75,40,18);
		add(precio2);
		
		lab=new JLabel("Precio Matrimonial");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,100,180,15);
		add(lab);
		precio3=new JTextField();
		precio3.setText("75");
		precio3.setFont(new Font("Lucida Calligraphy", 1, 14));
		precio3.setForeground(new Color(153,204,0));
		precio3.setBounds(190,100,40,18);
		add(precio3);
		
		lab=new JLabel("Precio Ejecutiva");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,125,150,15);
		add(lab);
		precio4=new JTextField();
		precio4.setText("100");
		precio4.setFont(new Font("Lucida Calligraphy", 1, 14));
		precio4.setForeground(new Color(153,204,0));
		precio4.setBounds(190,125,40,18);
		add(precio4);
		
		lab=new JLabel("Demanda 1");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,150,150,15);
		add(lab);
		demanda1=new JSpinner();
		demanda1.setModel(new SpinnerNumberModel(12, 1,10000,1 ));
		demanda1.setBounds(190,150,40,18);
		add(demanda1);
		
		lab=new JLabel("Demanda 2");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,175,150,15);
		add(lab);
		demanda2=new JSpinner();
		demanda2.setModel(new SpinnerNumberModel(10, 1,10000,1 ));
		demanda2.setBounds(190,175,40,18);
		add(demanda2);

		lab=new JLabel("Demanda 3");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,200,150,15);
		add(lab);
		demanda3=new JSpinner();
		demanda3.setModel(new SpinnerNumberModel(10, 1,10000,1 ));
		demanda3.setBounds(190,200,40,18);
		add(demanda3);
		
		lab=new JLabel("Demanda 4");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,225,150,15);
		add(lab);
		demanda4=new JSpinner();
		demanda4.setModel(new SpinnerNumberModel(10, 1,10000,1 ));
		demanda4.setBounds(190,225,40,18);
		add(demanda4);
		
		lab=new JLabel("Habitacion 1");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,250,150,15);
		add(lab);
		nroHab1=new JSpinner();
		nroHab1.setModel(new SpinnerNumberModel(10, 1,10000,1 ));
		nroHab1.setBounds(190,250,40,18);
		add(nroHab1);
		
		lab=new JLabel("Habitacion 2");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,275,150,15);
		add(lab);
		nroHab2=new JSpinner();
		nroHab2.setModel(new SpinnerNumberModel(12, 1,10000,1 ));
		nroHab2.setBounds(190,275,40,18);
		add(nroHab2);
		
		lab=new JLabel("Habitacion 3");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,300,150,15);
		add(lab);
		nroHab3=new JSpinner();
		nroHab3.setModel(new SpinnerNumberModel(15, 1,10000,1 ));
		nroHab3.setBounds(190,300,40,18);
		add(nroHab3);
		
		lab=new JLabel("Habitacion 4");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,325,150,15);
		add(lab);
		nroHab4=new JSpinner();
		nroHab4.setModel(new SpinnerNumberModel(8, 1,10000,1 ));
		nroHab4.setBounds(190,325,40,18);
		add(nroHab4);
		
		lab=new JLabel("Temporada");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,350,150,15);
		add(lab);
		temporada=new JComboBox<String>();
		String[] res=new String[]{"Alta","Media","Baja"};
		temporada.setModel(new DefaultComboBoxModel<String>(res));
		temporada.setBounds(185,350,60,18);
		add(temporada);
		
		lab=new JLabel("Tiempo simulacion");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,375,180,15);
		add(lab);
		tiempoSim=new JSpinner();
		tiempoSim.setModel(new SpinnerNumberModel(5,1,500,1));
		tiempoSim.setBounds(190,375,40,18);
		add(tiempoSim);
		
		lab=new JLabel("Velocidad Simulacion");
		lab.setFont(new Font("Lucida Calligraphy", 1, 14));
		lab.setForeground(new Color(0,204,204));
		lab.setBounds(15,400,200,15);
		add(lab);
		velocidad=new JSlider(1,100,5);
		//velocidad.setOrientation(1);//horizontal
		//velocidad.setPaintTicks(true);
		velocidad.setPaintLabels(true);
		//velocidad.setPaintTrack(true);
		velocidad.setOpaque(false);
		velocidad.setBounds(10,425,200,15);
		add(velocidad);
		
		/*lab=new JLabel("Precios Limpieza");
		add(lab);
		
		lab=new JLabel("Precios Comida");
		add(lab);*/
		
	}
	private void confi_fin() {		setVisible(true);	}
	/*public void paintComponent(Graphics g){
		//Dimension tam=pp.getSize();
		cambiar_tam();
        //ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_03" +".jpg"));
    	//g.drawImage(imagen.getImage(),0,0,(int)tam.getWidth(),(int)tam.getHeight(),null);
    	setOpaque(false);
    	super.paintComponent(g);
    }*/
	public void habilitar(){
		precio1.setEnabled(true);
		precio2.setEnabled(true);
		precio3.setEnabled(true);
		precio4.setEnabled(true);
		
		nroHab1.setEnabled(true);
		nroHab2.setEnabled(true);
		nroHab3.setEnabled(true);
		nroHab4.setEnabled(true);
		
		demanda1.setEnabled(true);
		demanda2.setEnabled(true);
		demanda3.setEnabled(true);
		demanda4.setEnabled(true);
		
		temporada.setEnabled(true);
		tiempoSim.setEnabled(true);
	}
	public void deshabilitar(){
		precio1.setEnabled(false);
		precio2.setEnabled(false);
		precio3.setEnabled(false);
		precio4.setEnabled(false);
		
		nroHab1.setEnabled(false);
		nroHab2.setEnabled(false);
		nroHab3.setEnabled(false);
		nroHab4.setEnabled(false);
		
		demanda1.setEnabled(false);
		demanda2.setEnabled(false);
		demanda3.setEnabled(false);
		demanda4.setEnabled(false);
		
		temporada.setEnabled(false);
		tiempoSim.setEnabled(false);
	}
	public int getPrecio1() {
		if(precio1.getText().equals("")||precio1.getText().equals(null)||precio1.getText().equals("\n")||precio1.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio1.getText());
	}
	public void setPrecio1(double precio1) {		this.precio1.setText(""+precio1);	}
	
	public int getPrecio2() {
		if(precio2.getText().equals("")||precio2.getText().equals(null)||precio2.getText().equals("\n")||precio2.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio2.getText());
	}
	public void setPrecio2(double precio2) {		this.precio2.setText(""+precio2);}
	
	public int getPrecio3() {
		if(precio3.getText().equals("")||precio3.getText().equals(null)||precio3.getText().equals("\n")||precio3.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio3.getText());
	}
	public void setPrecio3(double precio3) {		this.precio3.setText(""+precio3);	}
	
	public int getPrecio4() {
		if(precio4.getText().equals("")||precio4.getText().equals(null)||precio4.getText().equals("\n")||precio4.getText().equals(" "))
			return 0;
		else
			return Integer.parseInt(precio4.getText());
	}
	public void setPrecio4(double precio4) {		this.precio4.setText(""+precio4);	}
	
	public int getNroHab1() {       return (Integer) nroHab1.getValue();	}
	public void setNroHab1(int hab1) {		this.nroHab1.setValue(""+hab1);	}
	
	public int getNroHab2() {		return (Integer) nroHab2.getValue();	}
	public void setNroHab2(int hab2) {		this.nroHab2.setValue(""+hab2);	}
	
	public int getNroHab3() {		return (Integer) nroHab3.getValue();	}
	public void setNroHab3(int hab3) {		this.nroHab3.setValue(""+hab3);	}
	
	public int getNroHab4() {		return (Integer) nroHab4.getValue();	}
	public void setNroHab4(int hab4) {		this.nroHab4.setValue(""+hab4);	}
	
	public int getDemanda1(){ 		return (Integer)demanda1.getValue();	}
	public void setDemanda1(int d1){		this.demanda1.setValue(d1);		}
	
	public int getDemanda2(){ 		return (Integer)demanda2.getValue();	}
	public void setDemanda2(int d2){		this.demanda2.setValue(d2);		}
	
	public int getDemanda3(){ 		return (Integer)demanda3.getValue();	}
	public void setDemanda3(int d3){		this.demanda3.setValue(d3);		}
	
	public int getDemanda4(){ 		return (Integer)demanda4.getValue();	}
	public void setDemanda4(int d4){		this.demanda4.setValue(d4);		}
	
	public int getTemporada(){		return (Integer)(temporada.getSelectedIndex())+1;}
	public void setTemporada(int temp){		temporada.setSelectedIndex(temp);		}
	
	public int getVel() {			return velocidad.getValue();			}
	public void setVel(int vel){		    velocidad.setValue(vel);		}
	
	public int getTiempo() {		return (Integer)tiempoSim.getValue();	}
	public void setTiempo(int t){  			tiempoSim.setValue(t);			}
}