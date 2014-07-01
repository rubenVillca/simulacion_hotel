package graficas;
import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;
/*import org.jfree.chart.ChartUtilities;
import java.io.*;*/
public class Torta extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int demandaA1,demandaA2,demandaA3,demandaA4;
	private int demandaN1,demandaN2,demandaN3,demandaN4;
    
    public Torta(String title,int da1,int dn1,int da2,int dn2,int da3,int  dn3,int da4,int dn4 ) {
        super(title);
        demandaA1=da1;
        demandaN1=dn1;
        demandaA2=da2;
        demandaN2=dn2;
        demandaA3=da3;
        demandaN3=dn3;
        demandaA4=da4;
        demandaN4=dn4;
        setUndecorated(true);
        PieDataset dataset = createSampleDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        /*try {
            ChartUtilities.saveChartAsJPEG(new File("Torta.jpg"), chart, 500,300);
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        } */
        
        setContentPane(chartPanel);         
        pack();
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
            setVisible(true);
    }
  
    private PieDataset createSampleDataset() {
        
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("ClienteA1", demandaA1);
        result.setValue("ClienteN1",demandaN1);
        result.setValue("ClienteA2", demandaA2);
        result.setValue("ClienteN2",demandaN2);
        result.setValue("ClienteA3", demandaA3);
        result.setValue("ClienteN3",demandaN3);
        result.setValue("ClienteA4", demandaA4);
        result.setValue("ClienteN4",demandaN4);
        return result;       
    }
  
    @SuppressWarnings("deprecation")
	private JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart3D("Reporte de Llegada de Clientes  ", dataset, true, true, false );
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setBackgroundPaint(new Color(192, 192,192));
        plot.setOutlinePaint(Color.red);
        plot.setSectionPaint(0,new Color(0, 255,0));
        plot.setSectionPaint(1,new Color(0, 0,128));
        plot.setDepthFactor(0.2);
        // plot.setDarkerSides(false);
        plot.setNoDataMessage("No existe datos a ser pintados");
        
        return chart;
        
    }
     public static void main(String[]jj)
    {   
        Torta re=new Torta("Reporte de Torta Llegada de clientes",46,46,45,45,47,48,96,21); 
        RefineryUtilities.centerFrameOnScreen(re);
    }
}
