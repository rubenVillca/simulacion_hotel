package vista;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Hotel;

public class PAnimacion extends JPanel{
	private static final long serialVersionUID = 1L;
	private PanelPrincipal pp;
	private Hotel hotel;
    public PAnimacion(PanelPrincipal vpp){
    	this.pp=vpp;
    	hotel=pp.getHotel();
    	confi_ini();
    	inicializar();
    	confi_fin();
    }
    private void confi_ini() {
       	setLayout(null);
       	cambiar_tam();
	}
    private void cambiar_tam(){	setBounds(0,100,4*((int)pp.getWidth()/5),(int)(pp.getHeight()*(1.0*7/8)));    }
    private void inicializar() { /*   	hotel=pp.getHotel();*/	}
	public void paintComponent(Graphics g){
    	cambiar_tam();
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/edificio11.jpg"));
    	g.drawImage(imagen.getImage(),0,0,(int)getWidth(),(int)getHeight(),null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
	private void confi_fin() {		setVisible(true);	}
	public void run(){				hotel.run();		}
	public void stop(){				hotel.setStop();	}
	public void pause(){			hotel.setPause();	}
	public PanelPrincipal getPanelP() {	return pp;		}
	public Hotel getHotel(){		return hotel;		}
	public PanelPrincipal getPP() {		return pp;		}
}
