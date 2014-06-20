package controlador;

import javax.swing.JProgressBar;

import graficas.Barra;
import graficas.Torta;

import modelo.Hotel;
import modelo.Progreso;

import vista.PConfiguracion;
import vista.VIntroduccion;
import vista.VFrame;
import vista.VTabla;

public class Controlador {
	private VFrame frame;
	private Hotel hotel;
	private boolean pause;
	
	public Controlador(){
		//System.out.println(" iniciando constructor controlador");
		inicializar();
		//System.out.println(" constructor controlador Terminado\n");
	}
	private void inicializar() {
		//pause=true;
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
		//pause=false;
		if(pause==false){
			//ventana.getVentanaPrincipal().getP_confi().deshabilitar();
			PConfiguracion confi=frame.getpp().getP_confi();
			confi.deshabilitar();
			
			hotel.setNroHabSimples(confi.getNroHab1());
			hotel.setNroHabDobles(confi.getNroHab2());
			hotel.setNroHabSuit(confi.getNroHab3());
			
			hotel.setPrecioHabSimple(confi.getPrecio1());
			hotel.setPrecioHabDoble(confi.getPrecio2());
			hotel.setPrecioHabSuit(confi.getPrecio3());
			
			hotel.setFechaIni(confi.getFecha());
			hotel.setTiempoSim(confi.getTiempo());
			hotel.setVelocidad(confi.getVel());
			//hotel.pause(false);
			hotel.run();
		}
	}
	public void pause() {
		frame.getpp().getP_confi().habilitar();
		hotel.pause(true);
	}
	public void stopSimulacion() {
		frame.getpp().getP_confi().habilitar();
		hotel.stop();
	}
	public void generarTabla() {
		VTabla tabla=new VTabla(hotel);
		tabla.llenar();
	}
	public void generarGraficas() {
		new Barra("Tabla",45,78);
		new Torta("Torta", 45, 50);	
	}
	private int calcularIngresos(){		return 0;	}
	private int calcularEgresos(){		return 0;	}
	public int calcularUtilidad(){		return calcularIngresos()-calcularEgresos();	}
	public Hotel getHotel() {
		if(hotel==null)
			System.out.println("Retorna el hotel del controlador ESTA VACIO");
		return hotel;	}
	public void registrar(int cliente) {		
		System.out.println("Registrado cliente "+cliente+" en Controlador");	
	}
	public void progreso(int  t,JProgressBar p){
		Progreso proc=new Progreso(t,p,this,hotel.getVelocidad());
		proc.setVel(hotel.getVelocidad());
		proc.start();		
	}
	public void prueba(String res) {
		System.out.println("Este prueba que el Controlador Pasa a "+res);
	}
	
}
