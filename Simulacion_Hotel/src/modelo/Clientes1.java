package modelo;

import java.util.ArrayList;
import vista.PAnimacion;

public class Clientes1 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente1> clientes1;
	
	public Clientes1(PAnimacion va,int nroClSimp,int vel){
		super(va,nroClSimp,vel);
		clientes1=new ArrayList<Cliente1>();
	}
	public void run(){
		//pause=false;
		int posx=0;
		int posy=pA.getHeight()-215;
		//if(!pause){
		   	for(int i=1;i<nroPersonas;i++){
		   		int velCam=20+(int)(Math.random()*50/vel);//asigna velocidad de desplazamiento para una persona
		   		//System.out.println("Clientes1 corriendo..."+velCam);
		   		Cliente1 cliente1=new Cliente1(i,posx,posy,velCam,pA);
		   		cliente1.start();
		   		
		   		//velEntrClientes=(int)(Math.random()*11115);
		   		try {
					Thread.sleep(vel*200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				clientes1.add(cliente1);
		   	}
		//}	
	}
	public int getClientes() {		return clientes1.size();	}
	/*public void setVel(int velocid) {
		vel=0;
		for(Cliente1 c1: clientesSimple){
			c1.setVel(velocid);
			System.out.println("Cambiar velocidad Clientes1");
		}
	}*/
	public void pause(boolean paus) {
			pause=paus;
			for(Cliente1 c1:clientes1)
				c1.setPause(pause);
	}
}