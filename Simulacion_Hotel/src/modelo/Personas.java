package modelo;

import vista.PAnimacion;

public class Personas extends Thread{
	protected int demandaMedia;
	protected PAnimacion pA;
	protected int vel;
	protected boolean pause;
	protected boolean stopp;
	protected int demandaDia;
	protected int temporada;
	
	public Personas(PAnimacion va,int n,int vel,int temp){
		pA=va;
		demandaMedia=n;
		this.vel=vel;
		pause=false;
		stopp=false;
		temporada=temp;
	}
	public void setVel(int v){		vel=v;		}
	public void setPause(){			pause=true;	}
	public void setStop(){			stopp=true;	}
}
