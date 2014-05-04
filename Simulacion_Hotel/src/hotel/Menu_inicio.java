package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu_inicio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel_botones p_botones;
	private Panel_contenido p_contenido;
	public Menu_inicio(){
	   confi_ini();
	   inicializar();
	   confi_fin();
	}
    private void confi_ini() {
    	setLayout(null);
		setBounds(10,10, 1240,640);
		setBackground(new Color(15458));
	}
    public void paintComponent(Graphics g){
    	Dimension tam=getSize();
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_05.jpg"));
    	g.drawImage(imagen.getImage(),0,0,tam.width,tam.height,null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
	private void inicializar() {
		p_botones=new Panel_botones(getSize());
		add(p_botones);
		p_contenido=new Panel_contenido(getSize());
		add(p_contenido);
	}
    private void confi_fin() {
	     setVisible(true);	
	}
}
