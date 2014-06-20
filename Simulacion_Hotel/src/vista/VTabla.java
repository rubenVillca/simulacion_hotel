package vista;

import graficas.Barra;
import graficas.Torta;

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
	private JButton aceptar,graficos;
	private DefaultTableModel modeloTabla;
	//private JTableHeader cabeceraTabla;
	private String columnasTabla[];
	private JTable tabla;
	private JScrollPane scroll;
	private JLabel titulo;
	private Hotel hotel;
	private Barra barra;
	private Torta torta;
	
	public VTabla(Hotel h){
		hotel=h;
		confIni();
		insertarTitulo();
		crearTabla();
		crearBoton();
		confFin();
	}
	private void insertarTitulo() {
		titulo=new JLabel("Tabla ...");
		titulo.setBounds(150,15,100,30);
		add(titulo);
	}
	public VTabla(){
		confIni();
		insertarTitulo();
		crearTabla();
		crearBoton();
		confFin();
	}
    private void confIni(){
    	setLayout(null);
    	setUndecorated(true);
    	getRootPane().setWindowDecorationStyle(2);
    	setTitle("Tabla 1");
    	setSize(1000, 500);
    }
    private void crearTabla(){
    	columnasTabla=new String[]{"Nro","Mes","clientesTotal","Clientes HabSimple","ClientesHab Doble","ClientesHab Suit","empleados","ingresos","egresos","utilidad"};
    	modeloTabla=new DefaultTableModel(new Object[0][8],columnasTabla);
    	tabla=new JTable(modeloTabla);
    	tabla.setBounds(0, 0,	getWidth()-40,getHeight()-100);
    	scroll=new JScrollPane(tabla);
    	scroll.setBounds(10, 50,getWidth()-40,getHeight()-150);
    	add(scroll);
    }
    public void llenar(){
    	for(int i=0;i<5;i++){
    	//for(int i=0;i<hotel.getClientes().getNroClientes();i++){
    		modeloTabla.addRow(new Object[]{Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class});
    		tabla.setValueAt(i+1, i, 0);
    		tabla.setValueAt("hola  mundo", i, 1);
    		tabla.setValueAt("hola  mundo", i, 2);
    		tabla.setValueAt("hola  mundo", i, 3);
    		tabla.setValueAt("hola  mundo", i, 4);
    		tabla.setValueAt("hola  mundo", i, 5);
    		tabla.setValueAt("hola  mundo", i, 6);
    		tabla.setValueAt("hola  mundo", i, 7);
    		tabla.setValueAt("hola  mundo", i, 8);
    		tabla.setValueAt("hola  mundo", i, 9);
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
    	aceptar.setBounds(this.getWidth()/2-90, this.getHeight()-80, 80, 25);
    	add(aceptar);
    	
    	graficos=new JButton("Ver Graficas");
    	graficos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				barra=new Barra("Graficas Estadisticas Hotel Portales",15,15);
				torta=new Torta("Graficas Estadisticas Torta Hotel Portales", 50, 105);
			}
		});
    	graficos.setBounds(this.getWidth()/2+10, this.getHeight()-80, 150, 25);
    	add(graficos);
    }
    private void confFin(){
    	setVisible(true);
    }
    public static void main(String[] args){
    	new VTabla();
    }
}
