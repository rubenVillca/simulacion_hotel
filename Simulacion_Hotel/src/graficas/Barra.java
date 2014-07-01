package graficas;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
public class Barra extends JFrame {

    private static final long serialVersionUID = 1L;
	private int demandaA1,demandaA2,demandaA3,demandaA4;
	private int demandaN1,demandaN2,demandaN3,demandaN4;
    
    public Barra(String title,int da1,int dn1,int da2,int dn2,int da3,int  dn3,int da4,int dn4 ) {
        super(title);
        demandaA1=da1;
        demandaN1=dn1;
        demandaA2=da2;
        demandaN2=dn2;
        demandaA3=da3;
        demandaN3=dn3;
        demandaA4=da4;
        demandaN4=dn4;
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(600, 470));
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setContentPane(chartPanel);
        pack();
        setVisible(true);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(demandaA1,"Clientes Atendidos 1","Habitacion1");
        dataset.addValue(demandaN1,"Clientes No Atendidos 1","Habitacion1");
        dataset.addValue(demandaA2,"Demanda Habitacion 2","Habitacion2");
        dataset.addValue(demandaN2,"Clientes No Atendidos 2","Habitacion2");
        dataset.addValue(demandaA3,"Demanda Habitacion 3","Habitacion3");
        dataset.addValue(demandaN3,"Clientes No Atendidos 3","Habitacion3");
        dataset.addValue(demandaA4,"Demanda Habitacion 4","Habitacion4");
        dataset.addValue(demandaN4,"Clientes No Atendidos 4","Habitacion4");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
            "Llegada de Clientes a las Habitaciones",       // chart title
            "Demanda Atencion Clientes",               // domain axis label
            "Clientes",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        chart.setBackgroundPaint(Color.white);
        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        plot.setNoDataMessage("No existe datos a ser pintados");
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        // set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gp1 = new GradientPaint(15.18f, 0.0f, Color.green,0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red,0.0f, 0.0f, new Color(64, 0, 0));
        GradientPaint gp3 = new GradientPaint(0.0f, 0.0f, Color.BLACK,0.0f, 0.0f, new Color(18,48,48));
        GradientPaint gp4 = new GradientPaint(0.0f, 0.0f, Color.CYAN,0.0f, 0.0f, new Color(78,78,78));
        GradientPaint gp5 = new GradientPaint(0.0f, 0.0f, Color.BLACK,0.0f, 0.0f, new Color(16,18,24));
        GradientPaint gp6 = new GradientPaint(0.0f, 0.0f, Color.LIGHT_GRAY,0.0f, 0.0f, new Color(0,0,250));
        GradientPaint gp7 = new GradientPaint(0.0f, 0.0f, Color.WHITE,0.0f, 0.0f, new Color(45,78,35));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        renderer.setSeriesPaint(3, gp3);
        renderer.setSeriesPaint(4, gp4);
        renderer.setSeriesPaint(5, gp5);
        renderer.setSeriesPaint(6, gp6);
        renderer.setSeriesPaint(7, gp7);
        
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(0));
        return chart;
    }
   public static void main(String[] args) {
        Barra demo = new Barra("REPORTE DE LLEGADA DE CLIENTES",100,90,80,70,60,50,40,30);
                RefineryUtilities.centerFrameOnScreen(demo);
    }
}
