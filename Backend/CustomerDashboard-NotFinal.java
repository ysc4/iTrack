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
    public ChartPanel customerTrend() {
    	DefaultCategoryDataset customerTrend = new DefaultCategoryDataset();
    	addValue(customerTrend, 30, "New", "2022");
        addValue(customerTrend, 50, "New", "2023");
        addValue(customerTrend, 10, "New", "2024");
        addValue(customerTrend, 70, "Current", "2022");
        addValue(customerTrend, 50, "Current", "2023");
        addValue(customerTrend, 90, "Current", "2024");

        JFreeChart chart = createChart("NEW VS. CURRENT CUSTOMERS TREND", "CATEGORY", "FREQUENCY", customerTrend);
        ChartPanel customerTrendPanel = new ChartPanel(chart);
        customerTrendPanel.setPreferredSize(new Dimension(670, 200));
        customerTrendPanel.setBackground(new Color(255, 255, 255));
        customerTrendPanel.setBounds(5, 5, 670, 200);
        
        return customerTrendPanel;
    }
    
    public ChartPanel demographicChart() {
    	DefaultCategoryDataset demographicData = new DefaultCategoryDataset();
    	addValue(demographicData, 20, "Female", "<18");
        addValue(demographicData, 50, "Female", "18-28");
        addValue(demographicData, 55, "Female", "29-38");
        addValue(demographicData, 40, "Female", "39-48");
        addValue(demographicData, 90, "Female", "49-58");
        addValue(demographicData, 15, "Female", ">59");
        addValue(demographicData, 35, "Male", "<18");
        addValue(demographicData, 60, "Male", "18-28");
        addValue(demographicData, 65, "Male", "29-38");
        addValue(demographicData, 70, "Male", "39-48");
        addValue(demographicData, 25, "Male", "49-58");
        addValue(demographicData, 10, "Male", ">59");

        JFreeChart chart = createChart("DEMOGRAPHIC SEGMENTATION", "AGE & SEX", "FREQUENCY", demographicData);
        
        ChartPanel demographicPanel = new ChartPanel(chart);
        demographicPanel.setPreferredSize(new Dimension(350,210));
        demographicPanel.setBackground(new Color(255, 255, 255));
        demographicPanel.setBounds(10, 10, 350, 210);
        
        return demographicPanel;
    }
    
    public ChartPanel geographicChart() {
    	DefaultCategoryDataset geographicData = new DefaultCategoryDataset();
    	addValue(geographicData, 20, "New", "Asia");
        addValue(geographicData, 50, "New", "Australia");
        addValue(geographicData, 55, "New", "Europe");
        addValue(geographicData, 40, "New", "Canada");
        addValue(geographicData, 90, "New", "USA");
        addValue(geographicData, 35, "Current", "Asia");
        addValue(geographicData, 60, "Current", "Australia");
        addValue(geographicData, 65, "Current", "Europe");
        addValue(geographicData, 70, "Current", "Canada");
        addValue(geographicData, 25, "Current", "USA");

        JFreeChart chart = createChart("GEOGRAPHIC SEGMENTATION", "COUNTRIES", "FREQUENCY", geographicData);
        
        ChartPanel geographicPanel = new ChartPanel(chart);
        geographicPanel.setPreferredSize(new Dimension(350,210));
        geographicPanel.setBackground(new Color(255, 255, 255));
        geographicPanel.setBounds(380, 10, 350, 210);
        
        return geographicPanel;
    }
    
    public ChartPanel transactionalChart() {
    	DefaultCategoryDataset transactionalData = new DefaultCategoryDataset();
    	addValue(transactionalData, 20, "Customers", "iPhone");
        addValue(transactionalData, 50, "Customers", "iPad");
        addValue(transactionalData, 55, "Customers", "Watch");
        addValue(transactionalData, 40, "Customers", "Macbook");
        addValue(transactionalData, 90, "Customers", "TV & Home");
        addValue(transactionalData, 15, "Customers", "AirPods");
        addValue(transactionalData, 65, "Customers", "Vision");
  

        JFreeChart chart = createChart("TRANSACTIONAL SEGMENTATION", "PRODUCTS", "PURCHASES", transactionalData);
        
        ChartPanel demographicPanel = new ChartPanel(chart);
        demographicPanel.setPreferredSize(new Dimension(350,210));
        demographicPanel.setBackground(new Color(255, 255, 255));
        demographicPanel.setBounds(740, 10, 350, 210);
        
        return demographicPanel;
    }
    
    private void addValue(DefaultCategoryDataset dataset, double value, String categ, String column) {
    	dataset.addValue(value, categ, column);
    }
    
    private JFreeChart createChart(String title, String Xaxis, String Yaxis, DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(title, Xaxis, Yaxis, dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        chart.setTitle(new TextTitle(title, new Font("Poppins", Font.BOLD, 16)));
        chart.getLegend().setPosition(RectangleEdge.RIGHT);

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
        domainAxis.setCategoryMargin(0.1);
        domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(12f));
        
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(new Font("Poppins", Font.BOLD, 10));
        rangeAxis.setLabelFont(rangeAxis.getLabelFont().deriveFont(12f));
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.black);
        renderer.setSeriesPaint(1, Color.DARK_GRAY);
        renderer.setItemMargin(0);
        
        LegendTitle legend = chart.getLegend();
        legend.setItemFont(new Font("Poppins", Font.ITALIC, 10));
        
        CategoryItemRenderer rendererCateg = plot.getRenderer();
        rendererCateg.setDefaultItemLabelFont(new Font("Poppins", Font.PLAIN, 10));
    	
		return chart;
    	
    }   
}




