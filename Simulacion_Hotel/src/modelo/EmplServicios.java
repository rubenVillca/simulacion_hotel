package modelo;

import vista.PAnimacion;

public class EmplServicios extends Empl{
	private int habitacionesHasignadas;
	public EmplServicios(PAnimacion v,int nroEmp,int habAsignadas,int vel){
		super(v,nroEmp,vel);
		habitacionesHasignadas=habAsignadas;
	}
	public void run(){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Empleado de servicios de limpieza");
	}
}
