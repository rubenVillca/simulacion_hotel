package modelo;

import java.util.ArrayList;
import vista.PAnimacion;

public class Clientes3 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente3> clientesSuit;
	
	public Clientes3(PAnimacion v,int nroClSuit,int vel){
		super(v,nroClSuit,vel);
		clientesSuit=new ArrayList<Cliente3>();
	}
	public void run(){
		int x=0;
		int y=pA.getHeight()-210;
		for(int i=1;i<nroPersonas;i++){
	   		int veloc=(int)(Math.random()*85);
	   		Cliente3 cliente3=new Cliente3(i,x,y,veloc,pA);
	   		cliente3.start();
	   		//vel=(int)(Math.random()*15115);
	   		try {				Thread.sleep(vel*115);			} 
	   		catch (InterruptedException e) {			e.printStackTrace();}
			clientesSuit.add(cliente3);
	   	}
	}
	public int getClientes() {		return clientesSuit.size();	}
	public void setVel(int vel) {
		for(Cliente3 c3: clientesSuit){
			c3.setVel(vel);
			System.out.println("Cambiar velocidad cliente3");
		}
	}
	public void pause(boolean b) {
		pause=b;
	}
}
