package modelo;

import java.util.Date;
import javax.swing.JLabel;
import vista.PAnimacion;

public abstract class Cliente extends Persona{
private static final long serialVersionUID = 1L;
	protected JLabel cliente;
	protected PAnimacion vA;
	protected int n;
	protected String horaLlegada;
	protected Date fechaLlegada;
	protected int tiempoEstadia;  //tiempo en horas
	protected boolean direccion;
	protected int posX,posY,vel;
	
	public Cliente(int i,int x,int y,int velocidad,PAnimacion vA){
		super(vA, i, velocidad);
		posX=x;
		posY=y;
		vel=(100-velocidad);
		this.vA=vA;
		cliente=new JLabel();
		n=1+(int)(Math.random()*23);
	}
	//cambia de posicion avanza la persona
	public void run(){
		//if(!pause){
			//System.out.println("Cliente corriendo...");
			if(direccion){
				for(int i=0;i<390;i++){
					posX+=2;
					cliente.setBounds(posX, posY, 150, 150);//desplazamiento de persona
					try {		Thread.sleep(vel);			}//tiempo que la persona tarda en moverse de pixel en pixel 
					catch (InterruptedException e) { e.printStackTrace();		}
				}
			}else{
				posX=vA.getWidth();
				for(int i=0;i<120;i++){
					posX-=2;
					cliente.setBounds(posX, posY, 150, 150);
					try {					Thread.sleep(vel);				} 
					catch (InterruptedException e) {	e.printStackTrace();}
				}
			} 
			
			try {	Thread.sleep(vel*10);	} 
			catch (InterruptedException e) {	e.printStackTrace();	}
			cliente.setVisible(false);
		// }
	}
	public void setPause(){		pause=true;	}
}