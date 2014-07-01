package controlador;

import javax.swing.JProgressBar;

import modelo.Hotel;
import modelo.Progreso;

import vista.PConfiguracion;
import vista.VIntroduccion;
import vista.VFrame;
import vista.VTabla;

public class Controlador {
	private VFrame frame;
	private Hotel hotel;
	private boolean pause,stop;
	private Progreso proc;
	
	public Controlador(){
		inicializar();
	}
	private void inicializar() {
		pause=false;
		stop=true;
		hotel=new Hotel();
		
		frame=new VFrame(this);
		
		hotel.setpp(frame.getpp().getPA());
		frame.setVisible(false);
		VIntroduccion intro=new VIntroduccion(frame);
	    try {
	    	Thread.sleep(1000);
	    	intro.dispose();
	    	frame.setVisible(true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void play() {
		if(!pause&&stop){
			stop=false;
			pause=false;
			PConfiguracion confi=frame.getpp().getP_confi();
			confi.deshabilitar();
			frame.getpp().getP_botones().botones_play();
			
			hotel.setNroHab1(confi.getNroHab1());
			hotel.setNroHab2(confi.getNroHab2());
			hotel.setNroHab3(confi.getNroHab3());
			hotel.setNroHab4(confi.getNroHab4());
			
			hotel.setPrecioHab1(confi.getPrecio1());
			hotel.setPrecioHab2(confi.getPrecio2());
			hotel.setPrecioHab3(confi.getPrecio3());
			hotel.setPrecioHab4(confi.getPrecio4());
			
			hotel.setDemanda1(confi.getDemanda1());
			hotel.setDemanda2(confi.getDemanda2());
			hotel.setDemanda3(confi.getDemanda3());
			hotel.setDemanda4(confi.getDemanda4());
			
			hotel.setTemporada(confi.getTemporada());
			hotel.setTiempoSim(confi.getTiempo());
			hotel.setVelocidad(confi.getVel());
			
			hotel.run();
		}else
			if(pause){
				pause=false;
				hotel.run();
			}
	}
	public void setPause() {
		pause=true;
		stop=false;
		frame.getpp().getP_confi().habilitar();
		frame.getpp().getP_botones().botones_pause();
		hotel.setPause();
		proc.setPause();
	}
	public void setStop() {
		stop=true;
		pause=false;
		frame.getpp().getP_confi().habilitar();
		frame.getpp().getP_botones().botones_stop();
		proc.setStop();
		hotel.setStop();
	}
	public void generarTabla() {
		VTabla tabla=new VTabla(hotel);
		tabla.llenar();
	}
	public Hotel getHotel() {
		if(hotel==null)
			System.out.println("Retorna el hotel del controlador ESTA VACIO");
		return hotel;	
	}
	public void progreso(int  t,JProgressBar p){
		proc=new Progreso(t,p,this);
		proc.setVel(hotel.getVelocidad());
		proc.start();		
	}	
}
