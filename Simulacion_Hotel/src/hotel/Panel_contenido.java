package hotel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel_contenido extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public Panel_contenido(Dimension tam){
    	confi_ini(tam.width,tam.height);
    	inicializar();
    	confi_fin();
    }
    public void paintComponent(Graphics g){
    	Dimension tam=getSize();
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_02.jpg"));
    	g.drawImage(imagen.getImage(),0,0,tam.width,tam.height,null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
	private void confi_ini(int x,int y) {
       	setLayout(null);
       	setBounds(10, 70,x-20,y-70);
	}
	private void inicializar() {
		
	}
	private void confi_fin() {
		setVisible(true);
	}
}
