package modelo;

public class Habitacion2 extends Habitacion{
	public Habitacion2(int prcio,int nroHab){
		super(prcio, nroHab);
	}
	public void run(){
		//while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Habitacion Doble");
		//}
	}
}
