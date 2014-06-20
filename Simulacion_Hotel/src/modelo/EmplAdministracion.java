package modelo;

import vista.PAnimacion;

public class EmplAdministracion extends Empl{
	
	
	public EmplAdministracion(PAnimacion v,int nroEmp,int vel){
		super(v,nroEmp,vel);
	}
	public void run(){
		//while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Empleado de administracion");
		//}
	}
}
