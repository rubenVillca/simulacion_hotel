package modelo;

import vista.PAnimacion;

public class Clientes{
	private static final long serialVersionUID = 1L;
	private Clientes1 clientes1;
	private Clientes2 clientes2;
	private Clientes3 clientes3;
	public Clientes(PAnimacion va,int nroClSimp,int nroClDobl,int nroClSuit,int vel){
		clientes1=new Clientes1(va, nroClSimp,vel);
		clientes2=new Clientes2(va, nroClDobl,vel);
		clientes3=new Clientes3(va, nroClSuit,vel);
	}
	public void run(){
		//clientes1.pause(false);
		clientes1.start();
		//clientes2.pause(false);
   		//clientes2.start();
   		//clientes3.pause(false);
   		//clientes3.start();
	}
	public void stop(){}
	public void pause(boolean p){
		clientes1.pause(p);
		//clientes2.setpause();
		//clientes3.setpause();
	}
	public void setVel(int vel){
		//vel*=10*20;  controlador para parar
		clientes1.setVel(vel);
		clientes2.setVel(vel);
		clientes3.setVel(vel);
	}
	public int getNroClientes(){
		int res=0;
		res+=clientes1.getClientes();
		res+=clientes2.getClientes();
		res+=clientes3.getClientes();
		return res;
	}
}
