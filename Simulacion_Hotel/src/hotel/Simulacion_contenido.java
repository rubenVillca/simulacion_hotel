package hotel;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Simulacion_contenido extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Simulacion simu;
	private ImageIcon imagenCliente;
	private JLabel cliente;
    public Simulacion_contenido(Simulacion s){
    	this.simu=s;
    	confi_ini();
    	inicializar();
    	dibujarContenido();    	
    	confi_fin();
    }
    public void paintComponent(Graphics g){
    	cambiar_tam();
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_contenido_00.jpg"));
    	g.drawImage(imagen.getImage(),0,0,(int)getWidth(),(int)getHeight(),null);
    	setOpaque(false);

    	super.paintComponent(g);
    }
    private void dibujarContenido() {
		imagenCliente=new ImageIcon(getClass().getResource("/imagenes/icono_00.png"));
	    cliente=new JLabel(imagenCliente);
	    cliente.setBounds(15,200,100,200);
	    add(cliente);
	}
	private void cambiar_tam(){
    	setBounds(10,100,
    			4*((int)simu.getWidth()/5-3),(int)(simu.getHeight()*(1.0*7/8)));
    }
	private void confi_ini() {
       	setLayout(null);
       	cambiar_tam();
	}
	private void inicializar() {
		cliente=new JLabel();
	}
	private void confi_fin() {
		setVisible(true);
	}
}
