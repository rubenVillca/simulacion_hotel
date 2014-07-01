package vista;

import graficas.Barra;
import graficas.Torta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Hotel;

public class VTabla extends JDialog{

	private static final long serialVersionUID = 1L;
	private JButton aceptar,grafico_barra,grafico_torta;
	private DefaultTableModel modeloTabla;
	private JLabel habN1,habN2,habN3,habN4;
	
	//private JTableHeader cabeceraTabla;
	private String columnasTabla[];
	private JTable tabla;
	private JScrollPane scroll;
	private JLabel titulo;
	private Hotel hotel;
	@SuppressWarnings("unused")
	private Barra barra;
	@SuppressWarnings("unused")
	private Torta torta;
	
	public VTabla(){
		confIni();
		insertarContenido();
		crearTabla();
		crearBoton();
		confFin();
	}
	public VTabla(Hotel h){
		hotel=h;
		confIni();
		insertarContenido();
		crearTabla();
		crearBoton();
		confFin();
	}
	private void confIni(){
    	setLayout(null);
    	setUndecorated(true);
    	getRootPane().setWindowDecorationStyle(2);
    	setTitle("Tabla 1");
    	setSize(1200, 600);
    	this.getContentPane().setBackground(Color.BLACK);
    }
	private void insertarContenido() {
		titulo=new JLabel("Resultados de la simulacion");
		titulo.setBounds(10,15,500,30);
		titulo.setFont(new Font("Lucida Calligraphy", 1, 24));
		titulo.setForeground(new Color(0,102,102));
		add(titulo);		
	}
    private void crearTabla(){
    	columnasTabla=new String[]{"Dia","Dem1","Dem2","Dem3","Dem4",
    							   "HabOcup1","HabOcup2","HabOcup3","HabOcup4",
    							   "NAtend1","NAtend2","NAtend3","NAtend4",
    							   "Ingr1","Ingr2","Ingr3","Ingr4"};
    								//,"HabReq1","HabReq2","HabReq3","HabReq4"};
    	modeloTabla=new DefaultTableModel(new Object[0][],columnasTabla);
    	tabla=new JTable(modeloTabla);
    	tabla.setBounds(0, 0,	getWidth()-40,getHeight()-100);
    	tabla.setEnabled(false);
    	scroll=new JScrollPane(tabla);
    	scroll.setBounds(10, 150,getWidth()-40,getHeight()-250);
    	add(scroll);
    }
    public void llenar(){
    	for(int i=0;i<hotel.getTiempoSim();i++){
    		modeloTabla.addRow(new Object[]{Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class});
    		tabla.setValueAt(i+1, i, 0);
    		tabla.setValueAt(hotel.getHab1(i).getDemanda(), i, 1);
    		tabla.setValueAt(hotel.getHab2(i).getDemanda(), i, 2);
    		tabla.setValueAt(hotel.getHab3(i).getDemanda(), i, 3);
    		tabla.setValueAt(hotel.getHab4(i).getDemanda(), i, 4);
    		tabla.setValueAt(hotel.getHab1(i).getRegistrados(), i, 5);
    		tabla.setValueAt(hotel.getHab2(i).getRegistrados(), i, 6);
    		tabla.setValueAt(hotel.getHab3(i).getRegistrados(), i, 7);
    		tabla.setValueAt(hotel.getHab4(i).getRegistrados(), i, 8);
    		tabla.setValueAt(hotel.getHab1(i).getNoRegistrados(), i, 9);
    		tabla.setValueAt(hotel.getHab2(i).getNoRegistrados(), i, 10);
    		tabla.setValueAt(hotel.getHab3(i).getNoRegistrados(), i, 11);
    		tabla.setValueAt(hotel.getHab4(i).getNoRegistrados(), i, 12);
    		//tabla.setValueAt(hotel.getEmpleados(), i, 17);
    		tabla.setValueAt(hotel.calcularIngresos1(i), i, 13);
    		tabla.setValueAt(hotel.calcularIngresos2(i), i, 14);
    		tabla.setValueAt(hotel.calcularIngresos3(i), i, 15);
    		tabla.setValueAt(hotel.calcularIngresos4(i), i, 16);
    		/*tabla.setValueAt(hotel.getHab1(i).getHabCrear(), i, 22);
    		tabla.setValueAt(hotel.getHab2(i).getHabCrear(), i, 23);
    		tabla.setValueAt(hotel.getHab3(i).getHabCrear(), i, 24);
    		tabla.setValueAt(hotel.getHab4(i).getHabCrear(), i, 25);*/
    		habN1=new JLabel("Habitaciones Simples a construir: "+hotel.getnHabNec1());
    		habN1.setBounds(100,35 ,600 ,30);
    		habN1.setFont(new Font("Lucida Calligraphy", 1, 12));
    		habN1.setForeground(new Color(153,204,0));
    		add(habN1);
    		
    		habN2=new JLabel("Habitaciones Dobles Estandar a construir: "+hotel.getnHabNec2());
    		habN2.setBounds(100,60 ,600 ,30);
    		habN2.setFont(new Font("Lucida Calligraphy", 1, 12));
    		habN2.setForeground(new Color(153,204,0));
    		add(habN2);
    		
    		habN3=new JLabel("Habitaciones Dobles Matrimoniales a construir: "+hotel.getnHabNec3());
    		habN3.setBounds(100,85 ,600 ,30);
    		habN3.setFont(new Font("Lucida Calligraphy", 1, 12));
    		habN3.setForeground(new Color(153,204,0));
    		add(habN3);
    		
    		habN4=new JLabel("Habitaciones Ejecutivas a construir: "+hotel.getnHabNec4());
    		habN4.setBounds(100,110 ,600 ,30);
    		habN4.setFont(new Font("Lucida Calligraphy", 1, 12));
    		habN4.setForeground(new Color(153,204,0));
    		add(habN4);
    	}
    }
    private void crearBoton(){
    	aceptar=new JButton("Aceptar");
    	aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
    	aceptar.setBounds(this.getWidth()/3, this.getHeight()-80, 80, 25);
    	add(aceptar);
    	
    	grafico_torta=new JButton("Ver Graficas en Torta");
    	grafico_torta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				torta=new Torta("Graficas Estadisticas Torta Hotel Portales",
										hotel.getTotalClientesAtendidos1(),
										hotel.getTotalClientesNAtendidos1(),
										hotel.getTotalClientesAtendidos2(),
										hotel.getTotalClientesNAtendidos2(),
										hotel.getTotalClientesAtendidos3(),
										hotel.getTotalClientesNAtendidos3(),
										hotel.getTotalClientesAtendidos4(),
										hotel.getTotalClientesNAtendidos4()
										);
			}
		});
    	grafico_torta.setBounds(this.getWidth()/2-80, this.getHeight()-80, 250, 25);
    	add(grafico_torta);
    	
    	grafico_barra=new JButton("Ver Graficas Barras");
    	grafico_barra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				barra=new Barra("Graficas Estadisticas en Barra Hotel Portales",
										hotel.getTotalClientesAtendidos1(),
										hotel.getTotalClientesNAtendidos1(),
										hotel.getTotalClientesAtendidos2(),
										hotel.getTotalClientesNAtendidos2(),
										hotel.getTotalClientesAtendidos3(),
										hotel.getTotalClientesNAtendidos3(),
										hotel.getTotalClientesAtendidos4(),
										hotel.getTotalClientesNAtendidos4()
										);
			}
		});
    	grafico_barra.setBounds(this.getWidth()/2+200, this.getHeight()-80, 150, 25);
    	add(grafico_barra);
    }
    private void confFin(){
    	setVisible(true);
    }
    public static void main(String[] args){
    	new VTabla();
    }
}

