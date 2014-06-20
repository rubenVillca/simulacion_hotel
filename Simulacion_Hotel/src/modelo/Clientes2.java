package modelo;

import java.util.ArrayList;
import vista.PAnimacion;

public class Clientes2 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente2> clientesDoble;
	
	public Clientes2(PAnimacion va,int nroClDob,int vel){
		super(va,nroClDob,vel);
		clientesDoble=new ArrayList<Cliente2>();
	}
	public void run(){
		int x=0;
		int y=pA.getHeight()-205;
		for(int i=1;i<nroPersonas;i++){
	   		int veloc=(int)(Math.random()*vel)*500;
			Cliente2 cliente2=new Cliente2(i,x,y,vel,pA);
	   		cliente2.start();
	   		//vel=(int)(Math.random()*42115);
	   		try {					Thread.sleep((int)(veloc));			} 
	   		catch (InterruptedException e) {				e.printStackTrace();	}
			clientesDoble.add(cliente2);
	   	}
	}
	public void setVel(int vel) {
		for(Cliente2 c2: clientesDoble){
			c2.setVel(vel);
			System.out.println("Cambio Velocidad cliente2");
		}
	}
	public int getClientes() {		return clientesDoble.size();	}
	public void pause(boolean b) {
		pause=b;
	}
}
