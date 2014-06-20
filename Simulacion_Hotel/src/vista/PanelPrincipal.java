package vista;

import javax.swing.JPanel;

import controlador.Controlador;

import modelo.Hotel;

public class PanelPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;
	private PAnimacion pA;
	private PConfiguracion pConf;
	private PBotones pBotones;
	private Controlador ctrl;
	private VFrame vFrame;
	private Hotel hotel;
	public PanelPrincipal(Controlador c,VFrame frame){
	   //System.out.println("     constructor pp iniciado");
	   ctrl=c;
	   vFrame=frame;
	   hotel=ctrl.getHotel();
	   confi_ini();
	   inicializar();
	   confi_fin();
	   //System.out.println("     constructor pp termimado");
	}
    private void confi_ini() {
    	setLayout(null);
		//setBounds(10,10, 1240,640);
		cambiarTam();
	}
    private void cambiarTam(){    	setSize(vFrame.getSize());    }
    /*public void paintComponent(Graphics g){
    	cambiarTam();
    	//ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_02.jpg"));
    	//g.drawImage(imagen.getImage(),0,0,(int)getSize().getWidth(),getSize().height,null);
    	//setOpaque(false);
    	super.paintComponent(g);
    }*/
	private void inicializar() {
		//System.out.println("      inicializar pp");
		//hotel=ctrl.getHotel();
		
		pA=new PAnimacion(this);		
		add(pA);
		
		//System.out.println("      creando hotel en pp");
		//hotel=pA.getHotel();
		//System.out.println("      creado hotel en pp");
		
		
		pConf=new PConfiguracion(this);		
		add(pConf);
		
		pBotones=new PBotones(ctrl,this);
		add(pBotones);
	}
	private void confi_fin() {					setVisible(true);	}
    public PBotones getP_botones() {			return pBotones;	}
	public PAnimacion getPA() {		return pA;	}
	public PConfiguracion getP_confi() {		return pConf;	}
	public VFrame getvPrinc() {					return vFrame;	}
	public int get_ancho_conBot() {				return pBotones.getWidth();	}
	public Hotel getHotel() {					
		if(hotel==null)
			System.out.println("        Hotel es NO existe en pp");
		return hotel;	}
	public Controlador getCtrl(){				return ctrl;	}
	public void prueba(String string) {
		//ctrl.prueba(string);
		//System.out.println("Ha pasado por VPanel Principal "+string);
		hotel.prueba(string+" la prueba en pp ");
	}
}