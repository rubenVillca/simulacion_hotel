package hotel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_botones extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public Panel_botones(Dimension tam){
    	confi_ini(tam.width,tam.height);
    	inicializar();
    	confi_fin();
    }
	private void confi_ini(int x,int y) {
		setLayout(null);
		setBounds(0, 0,x,50);
	}
	public void paintComponent(Graphics g){
    	Dimension tam=getSize();
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_01.jpg"));
    	g.drawImage(imagen.getImage(),10,10,tam.width-20,tam.height,null);
    	setOpaque(false);
    	super.paintComponent(g);
    }
	private void inicializar() {
		int x =getSize().width;
		int y=getSize().height;
		ImageIcon icono_boton;
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/icono_play_01.png"));
		JButton boton_play=new JButton(icono_boton);
		boton_play.setBounds(x/4-10,y/2-5,35,17);
		add(boton_play);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/icono_stop_00.png"));
		JButton boton_pause=new JButton(icono_boton);
		boton_pause.setBounds(x/4+40, y/2-5,35,17);
		add(boton_pause);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/icono_stop_00.png"));
		JButton boton_stop=new JButton(icono_boton);
		boton_stop.setBounds(x/4+90, y/2-5,35,17);
		add(boton_stop);
	}
	private void confi_fin() {
		setVisible(true);
	}
}
