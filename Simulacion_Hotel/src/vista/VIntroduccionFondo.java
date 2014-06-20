package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VIntroduccionFondo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Introduccion intro;
	public VIntroduccionFondo(){
		setLayout(null);
		setVisible(true);
	}
	public void paintComponent(Graphics g){
		Dimension tam=getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/hotel_portales.jpg"));
    	g.drawImage(imagen.getImage(),0,0,(int)tam.getWidth(),(int)tam.getHeight(),null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
}
