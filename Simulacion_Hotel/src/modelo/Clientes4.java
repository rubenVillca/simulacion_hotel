package modelo;

import java.util.ArrayList;

import distribuciones.DistribucionMedia;

import vista.PAnimacion;

public class Clientes4 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente4> clientes4;
	private int dias;
	
	public Clientes4(PAnimacion v,int nroClSuit,int vel,int d,int t){
		super(v,nroClSuit,vel,t);
		dias=d;
		clientes4=new ArrayList<Cliente4>();
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
						case 1:	desvio= demandaMedia*Temporada.alta4;		break;
						case 2:	desvio= demandaMedia*Temporada.media4;		break;
						case 3: desvio= demandaMedia*Temporada.baja4;		break;
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
				   		Cliente4 cliente4=new Cliente4(dia,posx,posy,vel,pA);
				   		cliente4.start();
				   		try {  Thread.sleep(velcxd);  //tiempo que hay entre clientes en un dia
						} catch (InterruptedException e) {	e.printStackTrace();						}
						clientes4.add(cliente4);	
				   	}
				   	if(stopp){
						stopp=false;
						break;
					}
				   	/*try {		Thread.sleep(10000);		} //clientes que pasa de unn dia a otro
				    catch (InterruptedException e) {	e.printStackTrace();   }*/
			}
			break;
		}
	}
	public int getClientes() {		return clientes4.size();	}
	public void setVel(int vel) {
		for(Cliente4 c4: clientes4){
			c4.setVel(vel);
			System.out.println("Cambiar velocidad cliente3");
		}
	}
	public void pause(boolean b) {
		pause=b;
	}
	public void setStop() {
		stopp=true;
		for(Cliente4 c4: clientes4)
			c4.setStop();
	}
}
