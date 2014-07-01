package modelo;

import vista.PAnimacion;

public class EmplServicios extends Empl{
	@SuppressWarnings("unused")
	private int habitacionesHasignadas;
	public EmplServicios(PAnimacion v,int nroEmp,int habAsignadas,int vel){
		super(v,nroEmp,vel);
		habitacionesHasignadas=habAsignadas;
	}
}
