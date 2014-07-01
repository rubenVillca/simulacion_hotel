package modelo;

import java.util.ArrayList;

import distribuciones.DistribucionMedia;
import vista.PAnimacion;

public class Clientes3 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente3> clientes3;
	private int dias;
	
	public Clientes3(PAnimacion v,int nroClSuit,int vel,int d,int temp){
		super(v,nroClSuit,vel,temp);
		dias=d;
		clientes3=new ArrayList<Cliente3>();
	}
	public void run(){
		int posx=0;
		int posy=pA.getHeight()-210;
		DistribucionMedia disMedia=new DistribucionMedia();
		while(!pause){
			for(int dia=0;dia<dias;dia++){// para los dias de la simulacion
					int velcxd=0;
					double desvio;
					switch (temporada) {
						case 1:	desvio= demandaMedia*Temporada.alta3;		break;
						case 2:	desvio= demandaMedia*Temporada.media3;		break;
						case 3: desvio= demandaMedia*Temporada.baja3;		break;
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
				   		Cliente3 cliente3=new Cliente3(dia,posx,posy,vel,pA);
				   		cliente3.start();
				   		try {  Thread.sleep(velcxd);  //tiempo que hay entre clientes en un dia
						} catch (InterruptedException e) {	e.printStackTrace();						}
						clientes3.add(cliente3);	
				   	}
				   	if(stopp){
						stopp=false;
						break;
					}
			}
			break;
		}
	}
	public int getClientes() {		return clientes3.size();	}
	public void setVel(int vel) {
		for(Cliente3 c3: clientes3){
			c3.setVel(vel);
			System.out.println("Cambiar velocidad cliente3");
		}
	}
	public void pause(boolean b) {
		pause=b;
	}
	public void setStop() {
		stopp=true;
		for(Cliente3 c3: clientes3)
			c3.setStop();
	}
}
