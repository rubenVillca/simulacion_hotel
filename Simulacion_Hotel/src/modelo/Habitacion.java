package modelo;

public class Habitacion extends Thread{
	protected int precio;   //precio en Dolares
	protected int nroHabitaciones;
	protected int habOcupadas;
	public Habitacion(int prcio,int hab){
		precio=prcio;
		nroHabitaciones=hab;
	}
}
