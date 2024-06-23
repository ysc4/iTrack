package iTrack;

import java.awt.Color;
import java.time.LocalDate;

import javax.swing.JLabel;

public class SalesMainBackend {
	
	public static void TotalSalesDisplay(JLabel salesIncreaseAmount, JLabel salesIncreasePercentage) throws Exception {
		// Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Extract the current year
        int currentYear = currentDate.getYear();
        
        // Calculate the previous year
        int previousYear = currentDate.getYear()-1;
        
        int currentMonth = LocalDate.now().getMonthValue();
        
        SalesMongoDriver retrieve = new SalesMongoDriver();
        int totalCurrentSale = retrieve.totalMonthlySales(currentYear, currentMonth);
        int totalPreviousSale = retrieve.totalMonthlySales(previousYear, currentMonth);
        
        double percentage = computeIncrease(totalCurrentSale, totalPreviousSale);
        
        if (percentage < 0) {
        	salesIncreasePercentage.setText("(" + String.format("%.2f", percentage) + "%)");
        	salesIncreasePercentage.setForeground(Color.red);
        } else if (percentage == 0) {
        	salesIncreasePercentage.setText("(" + String.format("%.2f", percentage) + "%)");
        	salesIncreasePercentage.setForeground(Color.black);
        } else {
        	salesIncreasePercentage.setText("(+" + String.format("%.2f", percentage) + "%)");
        	salesIncreasePercentage.setForeground(Color.green);
        }
        
        salesIncreaseAmount.setText("$" + displayNumber(totalCurrentSale));
        
	}
	
	public static void TotalOrdersDisplay(JLabel OrderNum, JLabel IncreasePercentage) throws Exception {
		// Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Extract the current year
        int currentYear = currentDate.getYear();
        
        // Calculate the previous year
        int previousYear = currentDate.getYear()-1;
        
        int currentMonth = LocalDate.now().getMonthValue();
        
        SalesMongoDriver retrieve = new SalesMongoDriver();
        
        int totalCurrentOrders = retrieve.totalMonthlyTransactions(currentYear, currentMonth);
        int totalPreviousOrders = retrieve.totalMonthlyTransactions(previousYear, currentMonth);
        
        double percentage = computeIncrease(totalCurrentOrders, totalPreviousOrders);
        
        if (percentage < 0) {
        	IncreasePercentage.setText("(" + String.format("%.2f", percentage) + "%)");
        	IncreasePercentage.setForeground(Color.red);
        } else if (percentage == 0) {
        	IncreasePercentage.setText("(" + String.format("%.2f", percentage) + "%)");
        	IncreasePercentage.setForeground(Color.black);
        } else {
        	IncreasePercentage.setText("(+" + String.format("%.2f", percentage) + "%)");
        	IncreasePercentage.setForeground(Color.green);
        }
        
        OrderNum.setText(displayNumber(totalCurrentOrders));
        
	}
	
	public double inputSalesProfitGraph(int retrieveYear, int retrieveMonth) throws Exception{
		double graphValue = 0;
        
        SalesMongoDriver retrieve = new SalesMongoDriver();
        
        int totalSales = retrieve.totalMonthlySales(retrieveYear, retrieveMonth);
        
        graphValue = displayGraphNumber(totalSales);
		
		return graphValue;
	}
	
	private static double computeIncrease(double current, double previous) {
		// Ensure previousYearSales is not zero to avoid division by zero error
		if (previous != 0) {
			// Calculate the increase percentage
			double increasePercentage = ((current - previous) / previous);
	        return increasePercentage * 100;
        } else if (current == 0 || previous == 0) {
        	return 0;
        } else {
        	return 100;
        }
		
	}
	
	private static String displayNumber(double amount) {
		String converted = "";
		double convert = Math.abs(amount);
		
		if (convert >= 0 && convert < 1000) {
			converted = String.format("%.0f", amount);	
		} else if (convert >= 1000 && convert < 100000) {
			converted = String.format("%.0f", amount/1000) + "K";
		} else if (convert >= 100000 && convert < 1000000) {
			converted = String.format("%.0f", amount/1000) + "K";
		} else if (convert >= 1000000 && convert < 1000000000) {
			converted = String.format("%.0f", amount/1000000) + "M";	
		} else {
			converted = "0.00";
		}
		
		return converted;
	}
	
	private double displayGraphNumber(double num) {
		String converted = "";
		double convert = Math.abs(num);
		
		if (convert >= 0 && convert < 1000000000) {
			converted = String.format("%.3f", num/1000000);
		} else if (convert >= 1000000000){
			converted = String.format("%.3f", num/1000000000);	
		} else {
			converted = "0.000";
		}
		
		return Double.parseDouble(converted);
	}
}
