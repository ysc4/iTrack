package iTrack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class CustomerDashboard extends JPanel {

    public CustomerDashboard() {
        // Create dataset
        CategoryDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = createChart(dataset);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(660,190));
        add(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        addValue(dataset, 30, "New", "2022");
        addValue(dataset, 50, "New", "2023");
        addValue(dataset, 10, "New", "2024");
        addValue(dataset, 70, "Current", "2022");
        addValue(dataset, 50, "Current", "2023");
        addValue(dataset, 90, "Current", "2024");

        return dataset;
    }
    
    private void addValue(DefaultCategoryDataset dataset, double value, String categ, String column) {
    	dataset.addValue(value, categ, column);
    }
    
    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "NEW VS. CURRENT CUSTOMERS TREND", // Chart title
                "Customers",         // X-axis label
                "Value",            // Y-axis label
                dataset,            // Dataset
                PlotOrientation.VERTICAL,
                true,               // Show legend
                true,
                false
        );

        // Customization
        chart.setBackgroundPaint(Color.white);
        chart.setTitle(new TextTitle("NEW VS. CURRENT CUSTOMERS TREND", new Font("Poppins", Font.BOLD, 20)));
        chart.getLegend().setPosition(RectangleEdge.RIGHT);
        chart.getLegend().setMargin(2, 2, 2, 2);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setInsets(new RectangleInsets(2, 2, 2, 2));
        plot.getDomainAxis().setLowerMargin(1);
        plot.getDomainAxis().setUpperMargin(1);
        
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(new Font("Poppins", Font.PLAIN, 10));
        domainAxis.setTickLabelInsets(new RectangleInsets(0.5, 0.5, 0.5, 0.5));
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);
        domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(16f));
       
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(new Font("Poppins", Font.BOLD, 14));

        // Customization of the bar chart
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.black);
        renderer.setSeriesPaint(1, Color.DARK_GRAY);
        
        LegendTitle legend = chart.getLegend();
        legend.setItemFont(new Font("Poppins", Font.ITALIC, 10));
        
        CategoryItemRenderer rendererCateg = plot.getRenderer();
        rendererCateg.setDefaultItemLabelFont(new Font("Poppins", Font.PLAIN, 10));

        return chart;
    }   
}
