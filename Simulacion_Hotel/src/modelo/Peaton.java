package modelo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.PAnimacion;

public class Peaton extends Thread{
	private int n;
	private int posx,posy,vel;
	private PAnimacion vA;
	private JLabel peaton;
	private boolean direccion;
	public Peaton(int i,int xx,int yy,int velocidad,PAnimacion vA){
		n=i;
		posx=xx;
		posy=yy;
		vel=velocidad;
		this.vA=vA;
		peaton=new JLabel();
		n=1+(int)(Math.random()*23);
		direccion=(int)(Math.random()*10)%2==0;
		if(direccion)
			peaton.setIcon(new ImageIcon(getClass().getResource("/peaton" +"/gente_"+n+"d.gif")));
		else
			peaton.setIcon(new ImageIcon(getClass().getResource("/peaton" +"/gente_"+n+"i.gif")));
		vA.add(peaton);
	}
	@Override
	public void run() {
		//boolean direccion;
		if(direccion){
				for(int i=0;i<1280;i++){
				posx+=1;
				peaton.setBounds(posx, posy, 150, 150);
				try {
					Thread.sleep(vel);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else{
			posx=vA.getWidth();
			for(int i=0;i<1280;i++){
				posx-=1;
				peaton.setBounds(posx, posy, 150, 150);
				try {
					Thread.sleep(vel);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		peaton=null;
	}
	
}

