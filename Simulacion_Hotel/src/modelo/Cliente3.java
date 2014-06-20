package modelo;

import javax.swing.ImageIcon;
import vista.PAnimacion;

public class Cliente3 extends Cliente{
private static final long serialVersionUID = 1L;
	public Cliente3(int i,int x,int y,int velocidad,PAnimacion vA){
		super(i,x,y,velocidad,vA);
		direccion=(int)(Math.random()*10)%2==0;
		if(direccion)
			cliente.setIcon(new ImageIcon(getClass().getResource("/peaton" +"/gente_"+n+"d.gif")));
		else
			cliente.setIcon(new ImageIcon(getClass().getResource("/peaton" +"/gente_"+n+"i.gif")));
		vA.add(cliente);
	}
	@Override
	public void run() {
		super.run();
		//vA.getHotel().registrar(3);
	}
	public void setVel(int vel) {
		this.vel=vel;	
	}
}