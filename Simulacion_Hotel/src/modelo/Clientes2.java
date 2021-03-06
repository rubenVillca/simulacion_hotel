package modelo;

import java.util.ArrayList;

import distribuciones.DistribucionMedia;
import vista.PAnimacion;

public class Clientes2 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente2> clientes2;
	private int dias;
	
	public Clientes2(PAnimacion va,int nroClDob,int vel,int d,int temporada){
		super(va,nroClDob,vel,temporada);
		dias=d;
		clientes2=new ArrayList<Cliente2>();
	}
	public void run(){
		int posx=0;
		int posy=pA.getHeight()-205;
		DistribucionMedia disMedia=new DistribucionMedia();
		while(!pause){
			for(int dia=0;dia<dias;dia++){// para los dias de la simulacion
					int velcxd=0;
					double desvio;
					switch (temporada) {
						case 1:	desvio= demandaMedia*Temporada.alta2;		break;
						case 2:	desvio= demandaMedia*Temporada.media2;		break;
						case 3: desvio= demandaMedia*Temporada.baja2;		break;
						default:desvio=1.0;
							System.out.print("Error de Temporada"+temporada);		break;
					}
					disMedia.generar(demandaMedia, desvio);
					demandaDia=(int)(disMedia.getValor());
					if(demandaDia>0)
						velcxd=10000/demandaDia;
					else{
						demandaDia=1;
						velcxd=10000/demandaDia;
					}
					for(int persona=0;persona<demandaDia;persona++){//para la cantidad de clientes por dia
				   		if(stopp)		break;
				   		Cliente2 cliente2=new Cliente2(dia,posx,posy,vel,pA);
				   		cliente2.start();
				   		try {  Thread.sleep(velcxd);  //tiempo que hay entre clientes en un dia
						} catch (InterruptedException e) {	e.printStackTrace();						}
						clientes2.add(cliente2);	
				   	}
				   	if(stopp){
						stopp=false;
						break;
					}
			}
			break;
		}
	}
	public void setVel(int vel) {
		for(Cliente2 c2: clientes2){
			c2.setVel(vel);
			System.out.println("Cambio Velocidad cliente2");
		}
	}
	public int getClientes() {		return clientes2.size();	}
	public void pause(boolean b) {
		pause=b;
	}
	public void setStop() {
		stopp=true;
		for(Cliente2 c2: clientes2)
			c2.setStop();
	}
}
