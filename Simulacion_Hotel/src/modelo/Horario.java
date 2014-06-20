package modelo;

public class Horario {
	private int horaIngreso;
	private int horaEgreso;
	public Horario(){}
	public Horario(int ing,int egr){
		horaIngreso=ing;
		horaEgreso=egr;
	}
	public String toString(){
		if(horaEgreso>0&&horaIngreso>0)
			return horaIngreso+":"+horaEgreso;
		else
			return "";
	}
	public int getTiempoTrabajoDia(){
		return horaEgreso-horaIngreso;
	}
}
