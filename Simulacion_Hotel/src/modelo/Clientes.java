package modelo;

import vista.PAnimacion;

public class Clientes{
	private static final long serialVersionUID = 1L;
	private int velocidad;
	protected PAnimacion vA;
	private Clientes1 cls1;
	private Clientes2 cls2;
	private Clientes3 cls3;
	private Clientes4 cls4;
	
	public Clientes(PAnimacion va,int c1,int c2,int c3,int c4,int vel,int dias,int temporada){
		vA=va;
		velocidad=vel;
		cls1=new Clientes1(vA, c1,velocidad,dias,temporada);
		cls2=new Clientes2(va, c2,velocidad,dias,temporada);
		cls3=new Clientes3(va, c3,velocidad,dias,temporada);
		cls4=new Clientes4(va, c4,velocidad,dias,temporada);
	}
	public void run(){
		cls1.start();
		cls2.start();
   		cls3.start();
		cls4.start();
	}
	public void setStop(){
		cls1.setStop();
		cls2.setStop();
		cls3.setStop();
		cls4.setStop();
	}
	public void setPause(){
		cls1.setPause();
		cls2.setPause();
		cls3.setPause();
		cls4.setPause();
	}
	public void setVel(int vel){
		cls1.setVel(vel);
		cls2.setVel(vel);
		cls3.setVel(vel);
		cls4.setVel(vel);
	}
	public int getNroClientes(){
		int res=0;
		res+=cls1.getClientes();
		res+=cls2.getClientes();
		res+=cls3.getClientes();
		res+=cls4.getClientes();
		return res;
	}
}
