package modelo;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	public Fecha(int d,int m,int a){
		dia=d;
		mes=m;
		anio=a;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String toString(){
		return dia+"-"+mes+"-"+anio;
	}
}
