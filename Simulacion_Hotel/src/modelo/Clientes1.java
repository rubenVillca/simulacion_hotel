package modelo;

import java.util.ArrayList;

import distribuciones.DistribucionMedia;
import vista.PAnimacion;

public class Clientes1 extends Personas{
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente1> clientes1;
	private int dias;
	
	public Clientes1(PAnimacion va,int cl1,int vel,int dias,int temporada){
		super(va,cl1,vel,temporada);
		this.dias=dias;
		clientes1=new ArrayList<Cliente1>();
	}
	public void run(){
		//pause=false;
		int posx=0;
		int posy=pA.getHeight()-215;
		DistribucionMedia disMedia=new DistribucionMedia();
		while(!pause){
			for(int dia=0;dia<dias;dia++){// para los dias de la simulacion
					int velcxd=0;
					double desvio;
					switch (temporada) {
						case 1:	desvio= demandaMedia*Temporada.alta1;		break;
						case 2:	desvio= demandaMedia*Temporada.media1;		break;
						case 3: desvio= demandaMedia*Temporada.baja1;		break;
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
				   		Cliente1 cliente1=new Cliente1(dia,posx,posy,vel,pA);
				   		cliente1.start();
				   		try {  Thread.sleep(velcxd);  //tiempo que hay entre clientes en un dia
						} catch (InterruptedException e) {	e.printStackTrace();						}
						clientes1.add(cliente1);	
				   	}
				   	if(stopp){
						stopp=false;
						break;
					}
				   	System.out.println("dia "+(dia+1));
				   	/*try {		Thread.sleep(10000);		} //clientes que pasa de unn dia a otro
				    catch (InterruptedException e) {	e.printStackTrace();   }*/
			}
			break;
		}	
	}
	public int getClientes() {		return clientes1.size();	}
	public void setVel(int velocid) {
		for(Cliente1 c1: clientes1){
			c1.setVel(velocid);
			System.out.println("Cambiar velocidad Clientes1");
		}
	}
	public void setPause() {
		pause=true;
		for(Cliente1 c1:clientes1)
			c1.setPause();
	}
	public void setStop() {
		stopp=true;
		for(Cliente1 c1: clientes1)
			c1.setStop();
	}
}