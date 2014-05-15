package hotel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Simulacion extends JPanel {
	private static final long serialVersionUID = 1L;
	private Simulacion_botones p_botones;
	private Simulacion_contenido p_contenido;
	private Simulacion_configuracion p_confi;
	private Ventana_principal ventana_p;
	public Simulacion(Ventana_principal v){
	   ventana_p=v;
	   confi_ini();
	   inicializar();
	   confi_fin();
	}
    private void confi_ini() {
    	setLayout(null);
		//setBounds(10,10, 1240,640);
		
		cambiarTam();
	}
    private void cambiarTam(){
    	Dimension tam=ventana_p.getSize();
    	setSize((int)tam.getSize().getWidth()-0,(int)tam.getSize().getHeight()-20);
    	
    }
    public void paintComponent(Graphics g){
    	cambiarTam();
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_04.jpg"));
    	g.drawImage(imagen.getImage(),0,0,(int)getSize().getWidth(),getSize().height,null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
	private void inicializar() {
		p_botones=new Simulacion_botones(this);
		add(p_botones);
		p_contenido=new Simulacion_contenido(this);
		add(p_contenido);
		p_confi=new Simulacion_configuracion(this);
		add(p_confi);
	}
    private void confi_fin() {
	     setVisible(true);	
	}
	public int get_ancho_conBot() {
		return p_botones.getWidth();
	}
}