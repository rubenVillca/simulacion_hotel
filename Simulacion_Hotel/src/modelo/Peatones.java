package modelo;

import vista.PAnimacion;

public class Peatones extends Personas{
	public Peatones(PAnimacion v,int nroPers,int vel) {
		super(v,nroPers,vel,0);
	}
	public void run(){
		int x=-50;
		int y=pA.getHeight()-170;
	   	while(!stopp&&!pause){
	   		int velAvance=(101-vel)/15;
	   		Peaton peaton=new Peaton(2,x,y,velAvance,pA);
	   		peaton.start();
	   		int velPxP=(int)((601-vel)*Math.random());
	   		try {
				Thread.sleep(velPxP);//tiempo que tarda un peaton despues de otro
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	   	}
	}
	
}
