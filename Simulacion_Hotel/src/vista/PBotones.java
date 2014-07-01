package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controlador.Controlador;

public class PBotones extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	private JLabel botonPlay,botonPause,botonStop,botonEst,botonAcerca,botonExit;
	protected JProgressBar progreso;
	private PanelPrincipal pp;
    public PBotones(Controlador c,PanelPrincipal vp){
    	ctrl=c;
    	pp=vp;
    	confi_ini();
    	inicializar();
    	confi_fin();
    }
	private void confi_ini() {
		//setLayout(null);
		cambiarTam();
		setBackground(Color.DARK_GRAY);
	}
	private void cambiarTam(){
		setLayout(new FlowLayout(0,pp.getWidth()/25,10));
		setBounds(0,0,pp.getWidth(),100);
	}
	/*public void paintComponent(Graphics g){
		cambiarTam();
    	//ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_botones_00.png"));
    	//g.drawImage(imagen.getImage(),10,10,(int)getWidth()-20,(int)getHeight(),null);
    	//inicializar(g);
    	//setOpaque(false);
    	super.paintComponent(g);
    }*/
	private void inicializar() {
		ImageIcon icono_boton;
		int x=(int)getSize().getWidth();
		int y=(int)getSize().getHeight();
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/play.png"));
		botonPlay=new JLabel(icono_boton);
		botonPlay.setBounds(x/2-10,y/2,35,17);
		botonPlay.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//botones_play();
				ctrl.play();
				ctrl.progreso(ctrl.getHotel().getTiempoSim(), progreso); //barra de progreso
			}
			@Override
			public void mousePressed(MouseEvent arg0) {			}
			@Override
			public void mouseExited(MouseEvent arg0) {			}
			@Override
			public void mouseEntered(MouseEvent arg0) {			}
			@Override
			public void mouseClicked(MouseEvent arg0) {			}
		});
		add(botonPlay);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/pause.png"));
		botonPause=new JLabel(icono_boton);
		botonPause.setEnabled(false);
		botonPause.setBounds(x/2+40, y/2,35,17);
		botonPause.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//botones_pause();
				ctrl.setPause();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {			}
			@Override
			public void mouseExited(MouseEvent arg0) {			}
			@Override
			public void mouseEntered(MouseEvent arg0) {			}
			@Override
			public void mouseClicked(MouseEvent arg0) {			}
		});
		add(botonPause);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/stop.png"));
		botonStop=new JLabel(icono_boton);
		botonStop.setEnabled(false);
		botonStop.setBounds(x/2+90, y/2,35,17);
		botonStop.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//botones_stop();
				ctrl.setStop();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {			}
			@Override
			public void mouseExited(MouseEvent arg0) {			}
			@Override
			public void mouseEntered(MouseEvent arg0) {			}
			@Override
			public void mouseClicked(MouseEvent arg0) {			}
		});
		add(botonStop);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/estadistica.png"));
		botonEst=new JLabel(icono_boton);
		botonEst.setBounds(x/2+150,y/2,35,17);
		botonEst.setEnabled(false);
		botonEst.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				ctrl.generarTabla();
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {			}
			@Override
			public void mouseEntered(MouseEvent arg0) {			}
			@Override
			public void mouseExited(MouseEvent arg0) {			}
			@Override
			public void mousePressed(MouseEvent arg0) {			}
		});
		add(botonEst);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/acerca.png"));
		botonAcerca=new JLabel(icono_boton);
		botonAcerca.setBounds(x/2+200,y/2,35,17);
		botonAcerca.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Grupo Integrado por:\n-Chacón Paichucama Edson Darío\n-Villca Fernández Rubén\n-Arévalo López Rosa \n-Mendoza Mamani Orlando\n-Cardozo José Antonio\n");
			}
			@Override
			public void mousePressed(MouseEvent arg0) {			}
			@Override
			public void mouseExited(MouseEvent arg0) {			}
			@Override
			public void mouseEntered(MouseEvent arg0) {			}
			@Override	
			public void mouseClicked(MouseEvent arg0) {			}
		});
		add(botonAcerca);
		
		icono_boton=new ImageIcon(getClass().getResource("/imagenes/exit.png"));
		botonExit=new JLabel(icono_boton);
		botonExit.setBounds(x/2+200,y/2,35,17);
		botonExit.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {			}
			@Override
			public void mouseExited(MouseEvent arg0) {			}
			@Override
			public void mouseEntered(MouseEvent arg0) {			}
			@Override
			public void mouseClicked(MouseEvent arg0) {			}
		});
		add(botonExit);
		
		progreso=new JProgressBar();
		progreso.setEnabled(true);
		add(progreso);
	}
	/*protected void procesar() {
		Proceso proc=new Proceso(ctrl.getHotel().getTiempoSim(),progreso);
		proc.start();
	}*/
	private void confi_fin() {
		setVisible(true);
	}
	public Controlador getCtrl() {		return ctrl;	}
	public JLabel getBotonPlay() {		return botonPlay;	}
	public JLabel getBotonPause() {		return botonPause;	}
	public JLabel getBotonStop() {		return botonStop;	}
	public JLabel getBotonEst() {		return botonEst;	}
	public JLabel getBotonAcerca() {		return botonAcerca;	}
	public JLabel getBotonExit() {		return botonExit;	}
	public JProgressBar getProgreso() {		return progreso;	}
	public PanelPrincipal getvPrinc() {		return pp;	}
	public void botones_play(){
		botonPlay.setEnabled(false);
		botonEst.setEnabled(false);
		botonPause.setEnabled(true);
		botonStop.setEnabled(true);
	}
	public void botones_stop(){
		botonStop.setEnabled(false);
		botonPlay.setEnabled(true);
		botonPause.setEnabled(false);
		botonEst.setEnabled(true);
		progreso.setValue(0);
	}
	public void botones_pause(){
		botonPause.setEnabled(false);
		botonPlay.setEnabled(true);
		botonStop.setEnabled(true);
		botonEst.setEnabled(true);
	}
}