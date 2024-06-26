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

public class CustomerSegmentation extends JPanel {
	
	CustomerDashboard customerGraphs = new CustomerDashboard();
	
    
    public ChartPanel demographicChart() {
    	DefaultCategoryDataset demographicData = new DefaultCategoryDataset();
    	addValue(demographicData, customerGraphs.femaleCustomers(0, 17), "Female", "<18");
        addValue(demographicData, customerGraphs.femaleCustomers(18, 28), "Female", "18-28");
        addValue(demographicData, customerGraphs.femaleCustomers(29, 38), "Female", "29-38");
        addValue(demographicData, customerGraphs.femaleCustomers(39, 48), "Female", "39-48");
        addValue(demographicData, customerGraphs.femaleCustomers(49, 58), "Female", "49-58");
        addValue(demographicData, customerGraphs.femaleCustomers(59, 150), "Female", ">58");
        addValue(demographicData, customerGraphs.maleCustomers(0, 17), "Male", "<18");
        addValue(demographicData, customerGraphs.maleCustomers(18, 28), "Male", "18-28");
        addValue(demographicData, customerGraphs.maleCustomers(29, 38), "Male", "29-38");
        addValue(demographicData, customerGraphs.maleCustomers(39, 48), "Male", "39-48");
        addValue(demographicData, customerGraphs.maleCustomers(49, 58), "Male", "49-58");
        addValue(demographicData, customerGraphs.maleCustomers(59, 150), "Male", ">58");

        JFreeChart chart = createChart("DEMOGRAPHIC SEGMENTATION", "AGE & SEX", "FREQUENCY", demographicData);
        
        ChartPanel demographicPanel = new ChartPanel(chart);
        demographicPanel.setPreferredSize(new Dimension(520,265));
        demographicPanel.setBackground(new Color(255, 255, 255));
        demographicPanel.setBounds(10, 10, 520, 265);
        
        return demographicPanel;
    }
    
    public ChartPanel geographicChart() {
    	DefaultCategoryDataset geographicData = new DefaultCategoryDataset();
    	for (String country : customerGraphs.top10Countries()) {           
            int newCustomers = customerGraphs.newCustomersPerCountry(country);
            int allCustomers = customerGraphs.CustomersPerCountry(country);
            addValue(geographicData, newCustomers, "New", country);
            addValue(geographicData, allCustomers, "All", country);   
        }

        JFreeChart chart = createChart("GEOGRAPHIC SEGMENTATION", "COUNTRIES", "FREQUENCY", geographicData);
        
        ChartPanel geographicPanel = new ChartPanel(chart);
        geographicPanel.setPreferredSize(new Dimension(520,265));
        geographicPanel.setBackground(new Color(255, 255, 255));
        geographicPanel.setBounds(10, 10, 520, 265);
        
        return geographicPanel;
    }
    
    public ChartPanel transactionalChart() {
    	DefaultCategoryDataset transactionalData = new DefaultCategoryDataset();
    	addValue(transactionalData, customerGraphs.productsVsCustomers("iPhone"), "Customers", "iPhone");
        addValue(transactionalData, customerGraphs.productsVsCustomers("iPad"), "Customers", "iPad");
        addValue(transactionalData, customerGraphs.productsVsCustomers("Watch"), "Customers", "Watch");
        addValue(transactionalData, customerGraphs.productsVsCustomers("Mac"), "Customers", "Mac");
        addValue(transactionalData, customerGraphs.productsVsCustomers("TV & Home"), "Customers", "TV & Home");
        addValue(transactionalData, customerGraphs.productsVsCustomers("AirPods"), "Customers", "AirPods");
        addValue(transactionalData, customerGraphs.productsVsCustomers("Vision"), "Customers", "Vision");
  

        JFreeChart chart = createChart("TRANSACTIONAL SEGMENTATION", "PRODUCTS", "PURCHASES", transactionalData);
        
        ChartPanel transactionalPanel = new ChartPanel(chart);
        transactionalPanel.setPreferredSize(new Dimension(1068, 305));
        transactionalPanel.setBackground(new Color(255, 255, 255));
        transactionalPanel.setBounds(10, 10, 1068, 305);
        
        return transactionalPanel;
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
        domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(14f));
        
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(new Font("Poppins", Font.BOLD, 12));
        
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




