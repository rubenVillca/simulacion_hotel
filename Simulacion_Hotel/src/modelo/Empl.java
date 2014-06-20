package modelo;

import vista.PAnimacion;

public class Empl extends Persona{
	protected int sueldoHora;
	protected Horario Horario;
	public 	Empl(PAnimacion va,int nroEmp,int vel){
		super(va,nroEmp,vel);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
