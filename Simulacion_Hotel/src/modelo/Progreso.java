package modelo;

import javax.swing.JProgressBar;

import controlador.Controlador;

public class Progreso extends Thread{
	private int tiempo;
	private JProgressBar progreso;
	private int vel;
	private Controlador ctrl;
	private boolean pause,stop;
	
	public Progreso(int t,JProgressBar p,Controlador c){
		tiempo=t;
		progreso=p;
		ctrl=c;
	}
	public void run(){
		pause=stop=false;
		for(int i=0;i<=100;i++){
			if(pause==false&&stop==false){
				try {		Thread.sleep(vel);		} 
				catch (InterruptedException e) {		e.printStackTrace();		}
				progreso.setValue(i);
			}else
				if(stop==true)
					i=100;
				else
					--i;
		}
		try {		Thread.sleep(3000);		} 
		catch (InterruptedException e) {		e.printStackTrace();		}
		ctrl.setStop();
		ctrl.generarTabla();
	}
	public void setPause(){								pause=true;					}
	public void setStop(){								stop=true;					}
	public int getTiempo() {							return tiempo;				}
	public void setTiempo(int tiempo) {					this.tiempo = tiempo;		}
	public JProgressBar getProgreso() {					return progreso;			}
	public void setProgreso(JProgressBar progreso) {	this.progreso = progreso;	}
	public int getVel() {								return vel;					}
	//un dia es igual a 10 segundos
	public void setVel(int vel) {						this.vel = (tiempo*100);	}
}
