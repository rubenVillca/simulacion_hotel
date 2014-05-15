package hotel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Simulacion_botones extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Simulacion simu;
	private JLabel boton_play,boton_pause,boton_stop,boton_acerca,boton_exit;
	private JProgressBar progreso;
    public Simulacion_botones(Simulacion s){
    	this.simu=s;
    	confi_ini();
    	inicializar();
    	confi_fin();
    }
	private void confi_ini() {
		//setLayout(null);
		setLayout(new FlowLayout());
		cambiarTam();
		setBackground(Color.LIGHT_GRAY);
	}
	private void cambiarTam(){
		setBounds(0,0,simu.getWidth(),100);
		//setSize((int)tam.getWidth(),(int)simu.getHeight()/8);
	}
	public void paintComponent(Graphics g){
		cambiarTam();
    	//ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_botones_00.png"));
    	
    	//g.drawImage(imagen.getImage(),10,10,(int)getWidth()-20,(int)getHeight(),null);
    	//inicializar(g);
    	//setOpaque(false);
    	super.paintComponent(g);
    }
	private void inicializar() {
		ImageIcon icono_boton;
		int x=(int)getSize().getWidth();
		int y=(int)getSize().getHeight();
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/play.png"));
		boton_play=new JLabel(icono_boton);
		boton_play.setBounds(x/2-10,y/2,35,17);
		boton_play.addMouseListener(this);
		add(boton_play);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/pause.png"));
		boton_pause=new JLabel(icono_boton);
		boton_pause.setBounds(x/2+40, y/2,35,17);
		boton_pause.addMouseListener(this);
		add(boton_pause);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/stop.png"));
		boton_stop=new JLabel(icono_boton);
		boton_stop.setBounds(x/2+90, y/2,35,17);
		boton_stop.addMouseListener(this);
		add(boton_stop);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/estadistica.png"));
		boton_play=new JLabel(icono_boton);
		boton_play.setBounds(x/2+150,y/2,35,17);
		boton_play.addMouseListener(this);
		add(boton_play);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/acerca.png"));
		boton_acerca=new JLabel(icono_boton);
		boton_acerca.setBounds(x/2+200,y/2,35,17);
		boton_acerca.addMouseListener(this);
		add(boton_acerca);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/exit.png"));
		boton_exit=new JLabel(icono_boton);
		boton_exit.setBounds(x/2+200,y/2,35,17);
		boton_exit.addMouseListener(this);
		add(boton_exit);
		
		
		progreso=new JProgressBar();
		progreso.setValue(40);
		add(progreso);
	}
	private void confi_fin() {
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent m) {
		JOptionPane.showMessageDialog(null, "Hola Mundo");
		System.exit(0);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
