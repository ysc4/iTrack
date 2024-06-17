package iTrack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
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

public class SalesDashboard extends JPanel {
    public ChartPanel salesTrend() {
    	DefaultCategoryDataset salesTrendData = new DefaultCategoryDataset();
    	addValue(salesTrendData, 3.0, "Revenue", "2022");
        addValue(salesTrendData, 5.0, "Revenue", "2023");
        addValue(salesTrendData, 1.0, "Revenue", "2024");
        addValue(salesTrendData, 7.0, "Profit", "2022");
        addValue(salesTrendData, 5.0, "Profit", "2023");
        addValue(salesTrendData, 9.0, "Profit", "2024");

        JFreeChart chart = createChart("SALES AND PROFIT TREND", "YEARS", "REVENUE/PROFIT ($M)", salesTrendData);
        ChartPanel salesTrendPanel = new ChartPanel(chart);
        salesTrendPanel.setPreferredSize(new Dimension(670,200));
        salesTrendPanel.setBackground(new Color(255, 255, 255));
        salesTrendPanel.setBounds(5, 5, 670, 200);
        
        return salesTrendPanel;
    }
    
    public ChartPanel productsTrend() {
    	DefaultCategoryDataset productsTrendData = new DefaultCategoryDataset();
    	addValue(productsTrendData, 10.0, "Revenue", "Macbook Air");
        addValue(productsTrendData, 9.0, "Revenue", "AirPods Max");
        addValue(productsTrendData, 8.0, "Revenue", "iPad Pro");
        addValue(productsTrendData, 7.0, "Revenue", "Apple Vision Pro");
        addValue(productsTrendData, 6.0, "Revenue", "Macbook Pro");
        addValue(productsTrendData, 5.0, "Revenue", "iPhone 12 Pro");
        addValue(productsTrendData, 4.0, "Revenue", "iPad mini");
        addValue(productsTrendData, 3.0, "Revenue", "iPhone 11");
        addValue(productsTrendData, 2.0, "Revenue", "Apple Watch SE");
        addValue(productsTrendData, 1.0, "Revenue", "HomePod mini");
        addValue(productsTrendData, 5.0, "Profit", "Macbook Air");
        addValue(productsTrendData, 4.5, "Profit", "AirPods Max");
        addValue(productsTrendData, 4.0, "Profit", "iPad Pro");
        addValue(productsTrendData, 3.5, "Profit", "Apple Vision Pro");
        addValue(productsTrendData, 3.0, "Profit", "Macbook Pro");
        addValue(productsTrendData, 2.5, "Profit", "iPhone 12 Pro");
        addValue(productsTrendData, 2.0, "Profit", "iPad mini");
        addValue(productsTrendData, 1.5, "Profit", "iPhone 11");
        addValue(productsTrendData, 1.0, "Profit", "Apple Watch SE");
        addValue(productsTrendData, 0.5, "Profit", "HomePod mini");

        JFreeChart chart = createChart("TOP 10 PRODUCTS (BY SALES)", "PRODUCTS", "REVENUE/PROFIT", productsTrendData);
        ChartPanel productsTrendPanel = new ChartPanel(chart);
        productsTrendPanel.setPreferredSize(new Dimension(670,200));
        productsTrendPanel.setBackground(new Color(255, 255, 255));
        productsTrendPanel.setBounds(5, 5, 670, 200);
        
        return productsTrendPanel;
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
        domainAxis.setTickLabelFont(new Font("Poppins", Font.PLAIN, 8));
        domainAxis.setTickLabelInsets(new RectangleInsets(0.2, 0.2, 0.2, 0.2));
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);
        domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(10f));
        domainAxis.setCategoryMargin(0.1);
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(new Font("Poppins", Font.BOLD, 8));
        rangeAxis.setLabelFont(rangeAxis.getLabelFont().deriveFont(10f));
        
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




