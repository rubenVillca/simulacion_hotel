package modelo;

import java.util.ArrayList;

import vista.PAnimacion;

public class Hotel {
	private EmplServicios emplServ;
	private EmplAdministracion emplAdmin;
	private Clientes clientes;
	private int nHab1,nHab2,nHab3,nHab4;
	private int precio1,precio2,precio3,precio4;
	private Habitacion4 hab4;
	private Habitacion3 hab3;
	private Habitacion2 hab2;
	private Habitacion1 hab1;
	private ArrayList<Habitacion1> lhab1;
	private ArrayList<Habitacion2> lhab2;
	private ArrayList<Habitacion3> lhab3;
	private ArrayList<Habitacion4> lhab4;
	private int temporada;
	private int dias;    //tiempo en dias
	private int velocidad;
	private PAnimacion pA;
	private Peatones peatones;
	private int demanda1;
	private int demanda2;
	private int demanda3;
	private int demanda4;
	//private boolean pause;
	
	public Hotel(){}
	
	public void run() {
		inicializar();
		clientes.run();
		//peatones.start();
	}
	private void inicializar(){
		lhab1=new ArrayList<Habitacion1>();
		hab1=new Habitacion1(precio1,nHab1);
		lhab1.add(hab1);
		
		lhab2=new ArrayList<Habitacion2>();
		hab2=new Habitacion2(precio2, nHab2);
		lhab2.add(hab2);
		
		lhab3=new ArrayList<Habitacion3>();
		hab3=new Habitacion3(precio3, nHab3);
		lhab3.add(hab3);
		
		lhab4=new ArrayList<Habitacion4>();
		hab4=new Habitacion4(precio4, nHab4);
		lhab4.add(hab4);
		
		//emplServ=new EmplServicios(panelAnimacion,15,15);
		//emplAdmin=new EmplAdministracion(panelAnimacion,13);
		/*DistribucionUniforme du=new DistribucionUniforme();
		du.generar(nHab1, 8);*/
		clientes=new Clientes(pA,demanda1,demanda2,demanda3,demanda4,velocidad,dias,temporada);
		peatones=new Peatones(pA,25,velocidad);
	}
	public void setPause() {
		clientes.setPause();
		peatones.setPause();
	}
	public void setStop() {
		clientes.setStop();
		peatones.setStop();
	}
	public void setNroHab1(int nroHab1) {		nHab1=nroHab1;}
	public void setNroHab2(int nroHab2) {		nHab2=nroHab2;	}
	public void setNroHab3(int nroHab3) {		nHab3=nroHab3;	}
	public void setNroHab4(int nroHab4) {		nHab4=nroHab4;	}
	
	public void setPrecioHab1(int precio1) {	this.precio1=precio1;}
	public void setPrecioHab2(int precio2) {	this.precio2=precio2;	}
	public void setPrecioHab3(int precio3) {	this.precio3=precio3;	}
	public void setPrecioHab4(int precio4) {	this.precio4=precio4;	}
	
	public void setVelocidad(int vel) {			this.velocidad=vel;	}
	public void setTiempoSim(int tiempo) {		dias=tiempo;}
	public void setTemporada(int t) {			temporada=t;	}
	public void registrar(int nroClientes,int tipoCliente,int dia) {		
		//pA.getPP().getCtrl().registrar(i,estadia);
		switch (tipoCliente) {
			case 1:if(lhab1.size()>dia){ 
						lhab1.get(dia).setRegistrar(nroClientes,dia);
					}else{
						hab1=new Habitacion1(precio1,nHab1);
						hab1.setRegistrar(nroClientes,dia);
						lhab1.add(hab1);
					}
					break;
			case 2: if(lhab2.size()>dia){ 
						lhab2.get(dia).setRegistrar(nroClientes,dia);
					}else{
						hab2=new Habitacion2(precio2,nHab2);
						hab2.setRegistrar(nroClientes,dia);
						lhab2.add(hab2);
					}
					break;
			case 3: if(lhab3.size()>dia){ 
						lhab3.get(dia).setRegistrar(nroClientes,dia);
					}else{
						hab3=new Habitacion3(precio3,nHab3);
						hab3.setRegistrar(nroClientes,dia);
						lhab3.add(hab3);
					}
					break;
			case 4: if(lhab4.size()>dia){ 
						lhab4.get(dia).setRegistrar(nroClientes,dia);
					}else{
						hab4=new Habitacion4(precio4,nHab4);
						hab4.setRegistrar(nroClientes,dia);
						lhab4.add(hab4);
					}
					break;
			default:		System.out.println("Error habitacion invalida");	break;
		}
	}
	public EmplServicios getEmplServ() {			return emplServ;	}
	public EmplAdministracion getEmplAdmin() {		return emplAdmin;	}
	public Clientes getClientes() {					return clientes;	}
	
	public int getnHab4() {						return nHab4;	}
	public int getnHab1() {						return nHab1;	}
	public int getnHab2(){						return nHab2;	}
	public int getnHab3(){						return nHab3;	}
	
	public int getp4() {						return precio4;	}
	public int getp1() {						return precio1;	}
	public int getp2() {						return precio2;	}
	public int getp3() {						return precio3;	}
	
	public Habitacion4 getHab4(int nHabit) {				return lhab4.get(nHabit);	}
	public Habitacion3 getHab3(int nHabit) {				return lhab3.get(nHabit);	}
	public Habitacion2 getHab2(int nHabit) {				return lhab2.get(nHabit);	}
	public Habitacion1 getHab1(int nHabit) {				return lhab1.get(nHabit);	}
	
	public int getTemporada() {						return temporada;	}
	public int getTiempoSim() {						return dias;	}
	public int getVelocidad() {						return velocidad;	}
	public PAnimacion getPanelAnimacion() {			return pA;	}
	public Peatones getPeatones() {					return peatones;	}
	
	public void setpp(PAnimacion pa) {		this.pA=pa;	}
	
	public void setDemanda1(int d1) {		demanda1=d1;	}
	public void setDemanda2(int d2) {		demanda2=d2;	}
	public void setDemanda3(int d3) {		demanda3=d3;	}
	public void setDemanda4(int d4) {		demanda4=d4;	}

	public int getEmpleados() {
		return 10;
	}

	public int  calcularIngresos1(int d){		return lhab1.get(d).calcularIngresos();	}
	public int  calcularIngresos2(int d){		return lhab2.get(d).calcularIngresos();	}
	public int  calcularIngresos3(int d){		return lhab3.get(d).calcularIngresos();	}
	public int  calcularIngresos4(int d){		return lhab4.get(d).calcularIngresos();	}
	public int getTotalClientesAtendidos1() {
		int res=0;
		for(Habitacion1 h1:lhab1){
			res+=h1.getRegistrados();
		}
		return res;
	}
	public int getTotalClientesNAtendidos1() {
		int res=0;
		for(Habitacion1 h1:lhab1){
			res+=h1.getNoRegistrados();
		}
		return res;
	}
	
	public int getTotalClientesAtendidos2() {
		int res=0;
		for(Habitacion2 h2:lhab2){
			res+=h2.getRegistrados();
		}
		return res;
	}

	public int getTotalClientesNAtendidos2() {
		int res=0;
		for(Habitacion2 h2:lhab2){
			res+=h2.getNoRegistrados();
		}
		return res;
	}
	
	public int getTotalClientesAtendidos3() {
		int res=0;
		for(Habitacion3 h3:lhab3){
			res+=h3.getRegistrados();
		}
		return res;
	}
	public int getTotalClientesNAtendidos3() {
		int res=0;
		for(Habitacion3 h3:lhab3){
			res+=h3.getNoRegistrados();
		}
		return res;
	}
	
	public int getTotalClientesAtendidos4() {
		int res=0;
		for(Habitacion3 h3:lhab3){
			res+=h3.getRegistrados();
		}
		return res;
	}

	public int getTotalClientesNAtendidos4() {
		int res=0;
		for(Habitacion4 h4:lhab4){
			res+=h4.getNoRegistrados();
		}
		return res;
	}

	public int getnHabNec1() {
		int res=0;
		for(Habitacion h:lhab1){
			if(res<h.getNoRegistrados())
				res=h.getNoRegistrados();
		}
		return res;
	}
	public int getnHabNec2() {
		int res=0;
		for(Habitacion h:lhab2){
			if(res<h.getNoRegistrados())
				res=h.getNoRegistrados();
		}
		return res;
	}
	public int getnHabNec3() {
		int res=0;
		for(Habitacion h:lhab3){
			if(res<h.getNoRegistrados())
				res=h.getNoRegistrados();
		}
		return res;
	}
	public int getnHabNec4() {
		int res=0;
		for(Habitacion h:lhab4){
			if(res<h.getNoRegistrados())
				res=h.getNoRegistrados();
		}
		return res;
	}
}