package modelo;

import javax.swing.ImageIcon;
import vista.PAnimacion;

public class Cliente1 extends Cliente{
private static final long serialVersionUID = 1L;
	
	public Cliente1(int i,int x,int y,int velocidad,PAnimacion vA){
		super(i,x,y,velocidad,vA);
		n=9;
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
		vA.getHotel().registrar(1,1,dia);
	}
}