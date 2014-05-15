package hotel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana_principal ventana=new Ventana_principal();
		ventana.setVisible(false);
        new Introduccion(ventana);
		/*try {
				Thread.sleep(500);
	    } catch (InterruptedException e) {
				e.printStackTrace();
		}*/
		//ventana.setVisible(true);
	}
}