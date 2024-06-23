package iTrack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
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
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class SalesDashboard extends JPanel {
	LocalDate currentDate = LocalDate.now();
    public ChartPanel salesTrend() throws Exception {
    	SalesMainBackend data = new SalesMainBackend();
    	
    	DefaultCategoryDataset salesTrendData = new DefaultCategoryDataset();
    	addValue(salesTrendData, data.inputSalesProfitGraph(currentDate.getYear()-2, LocalDate.now().getMonthValue()), "Revenue", "2022");
        addValue(salesTrendData, data.inputSalesProfitGraph(currentDate.getYear()-1, LocalDate.now().getMonthValue()), "Revenue", "2023");
        addValue(salesTrendData, data.inputSalesProfitGraph(currentDate.getYear(), LocalDate.now().getMonthValue()), "Revenue", "2024");
        addValue(salesTrendData, data.inputSalesProfitGraph(currentDate.getYear()-2, LocalDate.now().getMonthValue()), "Profit", "2022");
        addValue(salesTrendData, data.inputSalesProfitGraph(currentDate.getYear()-1, LocalDate.now().getMonthValue()), "Profit", "2023");
        addValue(salesTrendData, data.inputSalesProfitGraph(currentDate.getYear(), LocalDate.now().getMonthValue()), "Profit", "2024");

        JFreeChart chart = createChart("SALES AND PROFIT TREND", "YEARS", "REVENUE/PROFIT ($M)", salesTrendData);
        ChartPanel salesTrendPanel = new ChartPanel(chart);
        salesTrendPanel.setPreferredSize(new Dimension(670,200));
        salesTrendPanel.setBackground(new Color(255, 255, 255));
        salesTrendPanel.setBounds(5, 5, 670, 200);
        
        return salesTrendPanel;
    }
    
    public ChartPanel productsTrend() throws Exception {
    	SalesMongoDriver data = new SalesMongoDriver();
    	DefaultCategoryDataset productsTrendData = new DefaultCategoryDataset();
    	addValue(productsTrendData, data.inputTopTenSalesPrice(1), "Revenue", data.inputTopTenSalesProductName(1));
        addValue(productsTrendData, data.inputTopTenSalesPrice(2), "Revenue", data.inputTopTenSalesProductName(2));
        addValue(productsTrendData, data.inputTopTenSalesPrice(3), "Revenue", data.inputTopTenSalesProductName(3));
        addValue(productsTrendData, data.inputTopTenSalesPrice(4), "Revenue", data.inputTopTenSalesProductName(4));
        addValue(productsTrendData, data.inputTopTenSalesPrice(5), "Revenue", data.inputTopTenSalesProductName(5));
        addValue(productsTrendData, data.inputTopTenSalesPrice(6), "Revenue", data.inputTopTenSalesProductName(6));
        addValue(productsTrendData, data.inputTopTenSalesPrice(7), "Revenue", data.inputTopTenSalesProductName(7));
        addValue(productsTrendData, data.inputTopTenSalesPrice(8), "Revenue", data.inputTopTenSalesProductName(8));
        addValue(productsTrendData, data.inputTopTenSalesPrice(9), "Revenue", data.inputTopTenSalesProductName(9));
        addValue(productsTrendData, data.inputTopTenSalesPrice(10), "Revenue", data.inputTopTenSalesProductName(10));

        JFreeChart chart = createChart("TOP 10 PRODUCTS (BY SALES)", "PRODUCTS", "REVENUE/PROFIT", productsTrendData);
        ChartPanel productsTrendPanel = new ChartPanel(chart);
        productsTrendPanel.setPreferredSize(new Dimension(670,200));
        productsTrendPanel.setBackground(new Color(255, 255, 255));
        productsTrendPanel.setBounds(5, 5, 670, 200);
        
        return productsTrendPanel;
    }
    
    public ChartPanel salesVolume() throws Exception {
    	ArrayList<String> countries = new ArrayList<String>();
    	ArrayList<Integer> sales = new ArrayList<Integer>();
		SalesMongoDriver.displaySalesPerCountry(countries, sales);
    	DefaultCategoryDataset salesTrendData = new DefaultCategoryDataset();
    	
   	 	// Add values from ArrayLists to the dataset
        for (int i = 0; i < 10; i++) {
            addValue(salesTrendData, sales.get(i), "Revenue", countries.get(i));
        }
        

        JFreeChart chart = createChart("REVENUE BY COUNTRY", "COUNTRY", "TOTAL SALES", salesTrendData);
        ChartPanel salesTrendPanel = new ChartPanel(chart);
        salesTrendPanel.setPreferredSize(new Dimension(670,200));
        salesTrendPanel.setBackground(new Color(255, 255, 255));
        salesTrendPanel.setBounds(5, 5, 380, 270);
        
        return salesTrendPanel;
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



