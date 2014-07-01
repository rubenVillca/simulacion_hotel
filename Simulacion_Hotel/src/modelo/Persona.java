package modelo;

import vista.PAnimacion;

public class Persona extends Thread{
	protected int dia;
	protected PAnimacion pA;
	protected int vel;
	protected boolean pause;
	protected boolean stopp;
	public Persona(PAnimacion va,int d,int vel){
		pA=va;
		dia=d;
		this.vel=vel;
		pause=false;
		stopp=false;
	}
	public void setVel(int v){		vel=v;	}
}