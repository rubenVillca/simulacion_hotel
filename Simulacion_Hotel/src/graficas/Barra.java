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
import org.jfree.chart.ChartUtilities;
import java.io.File;
import java.io.*;
public class Barra extends JFrame {

    private static final long serialVersionUID = 1L;
	int caja;
    int esta;
    
    public Barra(String title,int ca,int est) {
        super(title);
        caja=ca;
        esta=est;
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(600, 470));
        setUndecorated(true);
         getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
          try {
            ChartUtilities.saveChartAsJPEG(new File("Barra.jpg"), chart, 500,300);
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        } 
         setContentPane(chartPanel);
        pack();
        setVisible(true);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(esta, "ESTADO DE CUENTA","");
        dataset.addValue(caja,"CAJA","");
        dataset.addValue(50,"neuvo","");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
            "LLEGADA DE CLIENTES",       // chart title
            "DIRECCION",               // domain axis label
            "CANTIDAD",                  // range axis label
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
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green,
                0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red,
                0.0f, 0.0f, new Color(64, 0, 0));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(0));
        return chart;
    }
   public static void main(String[] args) {
        Barra demo = new Barra("REPORTE DE LLEGADA DE CLIENTES",50,1);
                RefineryUtilities.centerFrameOnScreen(demo);
    }
}
