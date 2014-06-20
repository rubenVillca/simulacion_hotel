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
import org.jfree.chart.ChartUtilities;
import java.io.*;
public class Torta extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int caja,esta;
    
    public Torta(String title, int ca, int est) {

        super(title);      
        caja=ca;
        esta=est;
        setUndecorated(true);
        PieDataset dataset = createSampleDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        try {
            ChartUtilities.saveChartAsJPEG(new File("Torta.jpg"), chart, 500,300);
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        } 
        
        setContentPane(chartPanel);         
        pack();
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
            setVisible(true);
    }
  
    private PieDataset createSampleDataset() {
        
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("CAJA", caja);
        result.setValue("ESTADO DE CUENTA", esta);
        result.setValue("Nuevo",50);
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
        Torta re=new Torta("Reporte de Torta Llegada de clientes",46,46); 
        RefineryUtilities.centerFrameOnScreen(re);
    }
}
