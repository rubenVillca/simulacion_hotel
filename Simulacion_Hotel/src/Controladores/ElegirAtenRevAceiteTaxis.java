package Controladores;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Generadores.*;
import ControladoresTeclas.*;

public class ElegirAtenRevAceiteTaxis extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double numeroConstante = 0;
	private double numeroExponencial = 0;
	private double numeroNormalDesvio = 0;
	private double numeroNormalMedia = 0;
	private double numeroParaTodos = 1;
	
	private JLabel titulo = new JLabel("Seleccione : ");
	private JLabel etiNormalMedia = new JLabel("Media:");
	private JLabel etiNormalDesvio = new JLabel("Desvio:");
	private JLabel etiExpoMedia = new JLabel("Media:");
	private JLabel etiConstante = new JLabel("Constante:");

	private  ButtonGroup Distribuciones = new ButtonGroup();
	private  JRadioButton radioNormal;
	private  JRadioButton radioExponencial;
	private  JRadioButton radioConstante;
	
	private  JTextField campoNormalMedia;
	private  JTextField campoNormalDesvio;
	private  JTextField campoExpoMedia;
	private  JTextField campoUniforme;
	
	private  JButton botonAceptar = new JButton("Aceptar");
	private  JButton botonCancelar = new JButton("Cancelar ");
	
	private boolean constante =false;
	private boolean exponencial = false;
	private boolean normal = false;
	
	private static ElegirAtenRevAceiteTaxis instancia ;
	
	private ImageIcon image = new ImageIcon("imagenes/atencionLlamada.gif");
	private Image icono = image.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
	
	public ElegirAtenRevAceiteTaxis(){
		setBounds(100, 100, 200, 300);
		getContentPane().setLayout(null);
		setTitle("Configurar Distribucion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ajusteComponentes();
		anidarComponentes();
		controlTeclas();
		anidarOyente();
		
		this.dispose();
		//Israel
		//setVisible(true);
		
		
	}
	public static ElegirAtenRevAceiteTaxis getInstancia(){
			if(instancia == null){
				instancia = new ElegirAtenRevAceiteTaxis();
			}
			return instancia;
	}
	
	public JTextField getCampoConstante() {
		return campoUniforme;
	}
	public void setCampoConstante(JTextField campoConstante) {
		this.campoUniforme = campoConstante;
	}
	public JTextField getCampoNormalMedia() {
		return campoNormalMedia;
	}
	public void setCampoNormalMedia(JTextField campoNormalMedia) {
		this.campoNormalMedia = campoNormalMedia;
	}
	public JTextField getCampoNormalDesvio() {
		return campoNormalDesvio;
	}
	public void setCampoNormalDesvio(JTextField campoNormalDesvio) {
		this.campoNormalDesvio = campoNormalDesvio;
	}
	public JTextField getCampoExpoMedia() {
		return campoExpoMedia;
	}
	public void setCampoExpoMedia(JTextField campoExpoMedia) {
		this.campoExpoMedia = campoExpoMedia;
	}
	public double getNumeroConstante() {
		return numeroConstante;
	}

	public void setNumeroConstante(double numeroConstante) {
		this.numeroConstante = numeroConstante;
		
	}

	public double getNumeroExponencial() {
		return numeroExponencial;
	}

	public void setNumeroExponencial(double numeroExponencial) {
		this.numeroExponencial = numeroExponencial;
	}

	public double getNumeroNormalDesvio() {
		return numeroNormalDesvio;
	}

	public void setNumeroNormalDesvio(double numeroNormalDesvio) {
		this.numeroNormalDesvio = numeroNormalDesvio;
	}

	public double getNumeroNormalMedia() {
		return numeroNormalMedia;
	}

	public void setNumeroNormalMedia(double numeroNormalMedia) {
		this.numeroNormalMedia = numeroNormalMedia;
	}

	public double getNumeroParaTodos() {
		return numeroParaTodos;
	}

	public void setNumeroParaTodos(double numeroParaTodos) {
		this.numeroParaTodos = numeroParaTodos;
		//System.out.println("El numero se cambio a:" + numeroParaTodos);
	}
	
	public boolean getConstanteBoolean() {
		return constante;
	}

	public void setConstanteBoolean(boolean constante) {
		this.constante = constante;
	}

	public boolean getExponencialBoolean() {
		return exponencial;
	}

	public void setExponencialBoolean(boolean exponencial) {
		this.exponencial = exponencial;
	}

	public boolean getNormalBoolean() {
		return normal;
	}

	public void setNormalBoolean(boolean normal) {
		this.normal = normal;
	}

	public void ajusteComponentes(){
		
		
		titulo.setBounds(50, 10, 100, 20);
		
		radioNormal = new JRadioButton("Normal (Minutos)");
		radioNormal.setBounds(5, 40, 150, 20);
		
		etiNormalMedia.setBounds(35, 65, 50, 20);
		etiNormalMedia.setEnabled(false);
		
		campoNormalMedia = new JTextField();
		campoNormalMedia.setBounds(80, 65, 50, 25);
		campoNormalMedia.setEnabled(false);
		
		etiNormalDesvio.setBounds(35, 90, 50, 20);
		etiNormalDesvio.setEnabled(false);
		
		campoNormalDesvio = new JTextField();
		campoNormalDesvio.setBounds(80, 90, 50, 25);
		campoNormalDesvio.setEnabled(false);
		
		radioExponencial = new JRadioButton("Exponencial (Minutos)");
		radioExponencial.setBounds(5, 125, 150, 20);
		
		etiExpoMedia.setBounds(35, 150, 50, 20);
		etiExpoMedia.setEnabled(false);
		
		campoExpoMedia = new JTextField();
		campoExpoMedia.setBounds(80, 150, 50, 25);
		campoExpoMedia.setEnabled(false);
		
		radioConstante = new JRadioButton("Constante (Minutos)");
		radioConstante.setBounds(5, 185, 150, 20);
		
		etiConstante.setBounds(35, 210, 50, 20);
		etiConstante.setEnabled(false);
		
		
		campoUniforme = new JTextField();
		campoUniforme.setBounds(80, 210, 50, 25);
		campoUniforme.setEnabled(false);
		
		
		botonAceptar.setBounds(0,240,190,30);
		botonAceptar.setEnabled(false);
			
	}
	public void controlTeclas(){
		campoUniforme.setDocument(new ControlTeclas());
		campoExpoMedia.setDocument(new ControlTeclas());
		campoNormalDesvio.setDocument(new ControlTeclas());
		campoNormalMedia.setDocument(new ControlTeclas());
	}
	public void anidarComponentes(){
		add(titulo);
		add(etiExpoMedia);
		add(etiNormalDesvio);
		add(etiNormalMedia);
		add(etiConstante);
		
		
		
		Distribuciones.add(radioConstante);
		Distribuciones.add(radioExponencial);
		Distribuciones.add(radioNormal);
		
		add(radioExponencial);
		add(radioNormal);
		add(radioConstante);
		
		add(campoExpoMedia);
		add(campoNormalDesvio);
		add(campoNormalMedia);
		add(campoUniforme);
		
		add(botonAceptar);
	}
	public void anidarOyente(){
		ElegirAtenRevAceiteTaxis.Oyente oyente = new ElegirAtenRevAceiteTaxis.Oyente();
		botonAceptar.addActionListener(oyente);
		
		radioNormal.addChangeListener(oyente);
		radioConstante.addChangeListener(oyente);
		radioExponencial.addChangeListener(oyente);
		
		
	}
	public void cerrar(){
		this.dispose();
	}
	public class Oyente implements ActionListener,ChangeListener {
		public void actionPerformed(ActionEvent e) {
			if(radioNormal.isSelected()){
				ElegirAtenRevAceiteTaxis.getInstancia().setNumeroNormalDesvio(Double.parseDouble(campoNormalDesvio.getText()));
				ElegirAtenRevAceiteTaxis.getInstancia().setNumeroNormalMedia(Double.parseDouble(campoNormalMedia.getText()));
				ElegirAtenRevAceiteTaxis.getInstancia().setNormalBoolean(true);
				calcularValor();
				JOptionPane.showMessageDialog(null, "Se cambio tiempo de \n Arribo de los clientes", "Message", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(icono));
				cerrar();
			}
			
			if(radioExponencial.isSelected()){
				ElegirAtenRevAceiteTaxis.getInstancia().setExponencialBoolean(true);
				ElegirAtenRevAceiteTaxis.getInstancia().setNumeroExponencial(Integer.parseInt(campoExpoMedia.getText()));
				calcularValor();
				JOptionPane.showMessageDialog(null, "Se cambio tiempo de \n Arribo de los clientes", "Message", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(icono));
				cerrar();
			}
			
			if(radioConstante.isSelected()){
				ElegirAtenRevAceiteTaxis.getInstancia().setNumeroConstante(Double.parseDouble(campoUniforme.getText()));
				ElegirAtenRevAceiteTaxis.getInstancia().setConstanteBoolean(true);
				calcularValor();
				JOptionPane.showMessageDialog(null, "Se cambio tiempo de \n Arribo de los clientes", "Message", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(icono));
				cerrar();
			}
			
		}
		public void stateChanged(ChangeEvent e) {
			if(radioNormal.isSelected()){
				if(etiExpoMedia.isEnabled()){
					etiExpoMedia.setEnabled(false);
					campoExpoMedia.setEnabled(false);
				}
				if(etiConstante.isEnabled()){
					etiConstante.setEnabled(false);
					campoUniforme.setEnabled(false);
				}
				if(!etiNormalDesvio.isEnabled()){
					etiNormalDesvio.setEnabled(true);
					campoNormalDesvio.setEnabled(true);
					etiNormalMedia.setEnabled(true);
					campoNormalMedia.setEnabled(true);
				}
				botonAceptar.setEnabled(true);
			}
			
			if(radioExponencial.isSelected()){
				if(etiConstante.isEnabled()){
					etiConstante.setEnabled(false);
					campoUniforme.setEnabled(false);
				}
				if(etiNormalDesvio.isEnabled()){
					etiNormalDesvio.setEnabled(false);
					campoNormalDesvio.setEnabled(false);
					etiNormalMedia.setEnabled(false);
					campoNormalMedia.setEnabled(false);
				}
				if(!etiExpoMedia.isEnabled()){
					etiExpoMedia.setEnabled(true);
					campoExpoMedia.setEnabled(true);
				}
				botonAceptar.setEnabled(true);
			}
			if(radioConstante.isSelected()){
				if(!etiConstante.isEnabled()){
					etiConstante.setEnabled(true);
					campoUniforme.setEnabled(true);
				}
				if(etiNormalDesvio.isEnabled()){
					etiNormalDesvio.setEnabled(false);
					campoNormalDesvio.setEnabled(false);
					etiNormalMedia.setEnabled(false);
					campoNormalMedia.setEnabled(false);
				}
				if(etiExpoMedia.isEnabled()){
					etiExpoMedia.setEnabled(false);
					campoExpoMedia.setEnabled(false);
				}
				 botonAceptar.setEnabled(true);
			}
		}
	}
	public double calcularValor(){
		if( ElegirAtenRevAceiteTaxis.getInstancia().getConstanteBoolean()== true){
			ElegirAtenRevAceiteTaxis.getInstancia().setNumeroParaTodos(ElegirAtenRevAceiteTaxis.getInstancia().getNumeroConstante());
		}
		if(ElegirAtenRevAceiteTaxis.getInstancia().getExponencialBoolean() == true){
			DistribucionExponencial distriExponencial = new DistribucionExponencial();
			distriExponencial.generarValor(ElegirAtenRevAceiteTaxis.getInstancia().getNumeroExponencial());
			numeroParaTodos = distriExponencial.getValor();
			ElegirAtenRevAceiteTaxis.getInstancia().setNumeroParaTodos(numeroParaTodos);
		}
		if(ElegirAtenRevAceiteTaxis.getInstancia().getNormalBoolean() == true){
			DistribucionMedia distriMedia = new DistribucionMedia();
			distriMedia.generar(ElegirAtenRevAceiteTaxis.getInstancia().getNumeroNormalMedia(), ElegirAtenRevAceiteTaxis.getInstancia().getNumeroNormalDesvio());
			numeroParaTodos = distriMedia.getValor();
			ElegirAtenRevAceiteTaxis.getInstancia().setNumeroParaTodos(numeroParaTodos);
		}
		if(ElegirAtenRevAceiteTaxis.getInstancia().getConstanteBoolean()==false && ElegirAtenRevAceiteTaxis.getInstancia().getExponencialBoolean()==false && ElegirAtenRevAceiteTaxis.getInstancia().getNormalBoolean()==false){
			DistribucionMedia distriMedia = new DistribucionMedia();
			distriMedia.generar(10, 2);
			numeroParaTodos = distriMedia.getValor();
			ElegirAtenRevAceiteTaxis.getInstancia().setNumeroParaTodos(numeroParaTodos);
		}
		return numeroParaTodos;
	}
	/*
	public static void main(String[]args)
	{
		new ElegirArriboCamionetas();
		
	}*/
}
