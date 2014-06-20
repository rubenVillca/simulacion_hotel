package modelo;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import controlador.Controlador;

public class Progreso extends Thread{
	private int tiempo;
	private JProgressBar progreso;
	private int vel;
	private Controlador ctrl;
	public Progreso(int t,JProgressBar p,Controlador c,int v){
		tiempo=t;
		progreso=p;
		ctrl=c;
	//	vel=v*10; // un dia == 10 segundos
	}
	public void run(){
		//System.out.println("iniciado");
		for(int i=0;i<=100;i++){
			try {		Thread.sleep(vel);		} 
			catch (InterruptedException e) {		e.printStackTrace();		}
			//System.out.println(i);
			progreso.setValue(i);
		}
		//JOptionPane.showMessageDialog(null, "Terminado");
		ctrl.stopSimulacion();
		ctrl.generarTabla();
	}
	public int getTiempo() {		return tiempo;	}
	public void setTiempo(int tiempo) {	this.tiempo = tiempo;	}
	public JProgressBar getProgreso() {		return progreso;	}
	public void setProgreso(JProgressBar progreso) {		this.progreso = progreso;	}
	public int getVel() {		return vel;	}
	public void setVel(int vel) {
		this.vel = (tiempo*100)/(24*vel);
	}
}
