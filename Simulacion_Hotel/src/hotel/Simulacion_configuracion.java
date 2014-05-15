package hotel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Simulacion_configuracion extends JPanel{
	private static final long serialVersionUID = 1L;
	private Simulacion simulador;
    public Simulacion_configuracion(Simulacion s){
        simulador=s;
        confi_ini();
        crearCont();
        confi_fin();
    }
    private void crearCont() {
		JButton boton;
		JLabel lab;
		
		lab=new JLabel("Precio "+"\n" +"Cuartos dobles");
		add(lab);
		boton=new JButton("Boton1");
		add(boton);
		
		lab=new JLabel("Precio Suit");
		add(lab);
		boton=new JButton("Boton2");
		add(boton);
		
		lab=new JLabel("precio 3");
		add(lab);
		boton=new JButton("Boton3");
		add(boton);
		
		lab=new JLabel("Numero de suit 1");
		add(lab);
		boton=new JButton("Boton4");
		add(boton);
		
		lab=new JLabel("Numero de habitaciones2");
		add(lab);
		boton=new JButton("Boton5");
		add(boton);

		lab=new JLabel("Numero de habitaciones3");
		add(lab);
		boton=new JButton("Boton6");
		add(boton);
		
		lab=new JLabel("Temporada");
		add(lab);
		boton=new JButton("Boton7");
		add(boton);
		
		lab=new JLabel("Tiempo de simulacion");
		add(lab);
		boton=new JButton("Boton8");
		add(boton);
		
		lab=new JLabel("Tiempo de simulacion");
		add(lab);
		JSlider sli=new JSlider();
		add(sli);
		
		lab=new JLabel("Tiempo de simulacion");
		add(lab);
		boton=new JButton("Boton10");
		add(boton);
	}
	private void confi_fin() {
		setVisible(true);
	}
	private void confi_ini() {
		setLayout(new GridLayout(12,2));
		cambiar_tam();
		
	}
	private void cambiar_tam(){
		setBounds((int)(simulador.getWidth()*1.0*4/5),100,
				(int)(simulador.getWidth()*(1.0/5)-10),(int)(simulador.getHeight()*(1.0*7/8)));
	}
	public void paintComponent(Graphics g){
		Dimension tam=simulador.getSize();
		cambiar_tam();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_05.jpg"));
    	g.drawImage(imagen.getImage(),0,0,(int)tam.getWidth(),(int)tam.getHeight(),null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
}