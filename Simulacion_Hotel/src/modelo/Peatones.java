package modelo;

import vista.PAnimacion;

public class Peatones extends Personas{
	public Peatones(PAnimacion v,int nroPers,int vel) {
		super(v,nroPers,vel);
	}
	public void run(){
		int x=-50;
		int y=pA.getHeight()-170;
	   	for(int i=1;i<nroPersonas;i++){
	   		int vel=(int)(Math.random()*125);
	   		Peaton peaton=new Peaton(i,x,y,vel,pA);
	   		peaton.start();
	   		vel=(int)(Math.random()*1255);
	   		try {
				Thread.sleep(vel);//tiempo que tarda un peaton despues de otro
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	   	}
	}
}
