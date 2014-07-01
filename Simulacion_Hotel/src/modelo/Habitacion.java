package modelo;

public class Habitacion extends Thread{
	protected int precio;   //precio en Dolares
	protected int habDisponibles;
	protected int habOcupadas;
	protected int noAtendidos;
	public Habitacion(int prcio,int hab){
		precio=prcio;
		habDisponibles=hab;
		habOcupadas=0;
		noAtendidos=0;
	}
	public void setPrecio(int precio) {						this.precio = precio;	}
	public void setNroHabitaciones(int nroHabitaciones) {	this.habDisponibles = nroHabitaciones;	}
	public void setHabOcupadas(int habOcupadas) {			this.habOcupadas = habOcupadas;	}
	public void setNoAtendidos(int noAtendidos) {			this.noAtendidos = noAtendidos;	}
	
	public int getDemanda() {			return habOcupadas+noAtendidos;	}
	public int getRegistrados() {		return habOcupadas;	}
	public int getNoRegistrados(){		return noAtendidos;	}
	public int getNroHab(){ 			return habDisponibles; 		}
	public void setRegistrar(int clientes,int dia){
		if(habOcupadas<habDisponibles){
			habOcupadas=habOcupadas+1;
		}else{
			noAtendidos=noAtendidos+1;
		}
	}
	public int calcularIngresos(){		return precio*habOcupadas;	}
	public int getHabCrear(){
		return 7;
	}
}
