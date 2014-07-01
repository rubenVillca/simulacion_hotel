package modelo;

import javax.swing.JLabel;
import vista.PAnimacion;

public abstract class Cliente extends Persona{
private static final long serialVersionUID = 1L;
	protected JLabel cliente;
	protected PAnimacion vA;
	protected int n;
	protected String horaLlegada;
	protected int tiempoEstadia;  //tiempo en horas
	protected boolean direccion;
	protected int posX,posY,vel;
	
	public Cliente(int dia,int x,int y,int velocidad,PAnimacion vA){
		super(vA, dia, velocidad);
		posX=x-100;
		posY=y;
		vel=velocidad;
		this.vA=vA;
		cliente=new JLabel();
		//n=1+(int)(Math.random()*23);
	}
	//cambia de posicion avanza la persona
	public void run(){
		vel=(150-vel)/20;
		while(!pause){
			if(direccion){
				for(int i=0;i<430;i++){
					if(stopp){		break;			}
					posX+=2;
					cliente.setBounds(posX, posY, 150, 150);//desplazamiento de persona
					try {		Thread.sleep(vel);			}//tiempo que la persona tarda en moverse de pixel en pixel 
					catch (InterruptedException e) { e.printStackTrace();		}
				}
			}else{
				posX=vA.getWidth();
				for(int i=0;i<120;i++){
					if(stopp){						break;					}
					posX-=2;
					cliente.setBounds(posX, posY, 150, 150);
					try {					Thread.sleep(vel);				} 
					catch (InterruptedException e) {	e.printStackTrace();}
				}
			}
			try {	Thread.sleep(vel*10);	} 
			catch (InterruptedException e) {	e.printStackTrace();	}
			cliente.setVisible(false);
			pause=true;
		 }
	}
	public void setPause(){		pause=true;	}
	public void setStop() {		stopp=true;	}
	public void setVelocidad(int v){  vel=v;	}
}