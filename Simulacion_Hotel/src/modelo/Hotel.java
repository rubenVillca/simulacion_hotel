package modelo;

import distribuciones.DistribucionUniforme;
import vista.PAnimacion;

public class Hotel {
	private EmplServicios emplServ;
	private EmplAdministracion emplAdmin;
	private Clientes clientes;
	//private Servicio servicio;
	private int nSuit,nSimple,nDoble;
	private int pSuit,pSimple,pDoble;
	private Habitacion3 habSuit;
	private Habitacion2 habDoble;
	private Habitacion1 habSimple;
	private Fecha fechaIni;
	private int tiempoSim;    //tiempo en horas
	private int velocidad;
	private PAnimacion pA;
	private Peatones peatones;
	private int demanda1;
	private int demanda2;
	private int demanda3;
	//private boolean pause;
	//private Controlador ctrl;
	
	public Hotel(){
		//ctrl=c;
		//pause=true;
	}
	public void run() {
		inicializar();
		clientes.run();
		//emplAdmin.start();
		//emplServ.start();
		//habDoble.start();
		//habSimple.start();
		//habSuit.start();
		//peatones.start();
	}
	private void inicializar(){
		habDoble=new Habitacion2(pDoble, nDoble);
		habSimple=new Habitacion1(pSimple,nSimple);
		habSuit=new Habitacion3(pSuit, nSuit);
		
		//emplServ=new EmplServicios(panelAnimacion,15,15);
		//emplAdmin=new EmplAdministracion(panelAnimacion,13);
		DistribucionUniforme du=new DistribucionUniforme();
		du.generar(nDoble, 8);
		int a=(int)(du.getValor()*500);
		int b=(int)(du.getValor()*500);
		int c=(int)(du.getValor()*500);
		clientes=new Clientes(pA,a,b,c,velocidad);
		peatones=new Peatones(pA,25,velocidad);
	}
	public void pause(boolean b) {
		System.out.println("Implementar Pause  "+b);
		//pause=b;
		//clientes.pause(pause);
		//peatones.setPause(b);
		//clientes.pause(b);
		//emplAdmin.setPause(b);
		//emplServ.setPause(b);
	}
	//@SuppressWarnings("deprecation")
	public void stop() {
		clientes.stop();
		//emplAdmin.stop();
		//emplServ.stop();
		//habDoble.stop();
		//habSimple.stop();
		//habSuit.stop();
	}
	public void setNroHabSimples(int nroHab1) {		nSimple=nroHab1;}
	public void setNroHabSuit(int nroHab3) {		nSuit=nroHab3;	}
	public void setNroHabDobles(int nroHab2) {		nDoble=nroHab2;	}
	public void setPrecioHabSimple(int precio1) {	pSimple=precio1;}
	public void setPrecioHabDoble(int precio2) {	pDoble=precio2;	}
	public void setPrecioHabSuit(int precio3) {		pSuit=precio3;	}
	public void setVelocidad(int vel) {				velocidad=vel;	}
	public void setTiempoSim(int tiempo) {			tiempoSim=tiempo;}
	public void setFechaIni(Fecha fecha) {			fechaIni=fecha;	}
	public void registrar(int i) {		
		pA.getPP().getCtrl().registrar(i);
		//System.out.println("Registrar Hotel");
	}
	public EmplServicios getEmplServ() {			return emplServ;	}
	public EmplAdministracion getEmplAdmin() {		return emplAdmin;	}
	public Clientes getClientes() {					return clientes;	}
	public int getnSuit() {							return nSuit;	}
	public int getnSimple() {						return nSimple;	}
	public int getnDoble(){							return nDoble;	}
	public int getpSuit() {							return pSuit;	}
	public int getpSimple() {						return pSimple;	}
	public int getpDoble() {						return pDoble;	}
	public Habitacion3 getHabSuit() {				return habSuit;	}
	public Habitacion2 getHabDoble() {				return habDoble;	}
	public Habitacion1 getHabSimple() {				return habSimple;	}
	public Fecha getFechaIni() {					return fechaIni;	}
	public int getTiempoSim() {						return tiempoSim;	}
	public int getVelocidad() {						return velocidad;	}
	public PAnimacion getPanelAnimacion() {			return pA;	}
	//public VPanelPrincipal getVpp() {				return vpp;	}
	public Peatones getPeatones() {					return peatones;	}
	public void prueba(String string) {
		//System.out.println("Ha pasado el "+string+" la prueba de hotel");
	}
	public void setpp(PAnimacion pa) {		this.pA=pa;	}
}