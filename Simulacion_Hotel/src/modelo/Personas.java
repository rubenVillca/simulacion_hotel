package modelo;

import vista.PAnimacion;

public class Personas extends Thread{
	protected int nroPersonas;
	protected PAnimacion pA;
	protected int vel;
	protected boolean pause;
	public Personas(PAnimacion va,int n,int vel){
		pA=va;
		nroPersonas=n;
		this.vel=vel;
		pause=true;
	}
	public void setVel(int v){		vel=v;	}
}
