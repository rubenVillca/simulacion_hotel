package distribuciones;

public class DistribucionMedia {
private double valorGenerado= 0.0;
public DistribucionMedia()
{
	}

public void generar(double media , double desvio){
     GeneradorCongruencialMixto generadorCon = new GeneradorCongruencialMixto();
     double valorAux1 = generadorCon.numeroAleatorio();
     double z = Math.abs(Math.sqrt(-2*Math.log(valorAux1))*Math.sin(2*Math.PI*Math.log(valorAux1)));
	 double aux = (z*desvio) + media;
     String res = ""+aux;
	 //System.out.println(z);

	//Evitar q salga error NaN por la raiz negativa
	 if(res.equalsIgnoreCase("NaN")){
        generar(media, desvio);
	 }
        else {
	  valorGenerado =aux;
        }
}
public double getValor(){
	
	return valorGenerado;
}
public static void main(String[]args)
{
	
DistribucionMedia GenMedia = new DistribucionMedia();
GenMedia.generar(10, .95);
double res2 = GenMedia.getValor();
System.out.println(res2);

/*	Double res = Math.sqrt(-1);
	res = res +12;
	System.out.println(res);
*/
}
}
