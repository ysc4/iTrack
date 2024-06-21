package iTrack;

import java.awt.Color;
import java.time.LocalDate;

import javax.swing.JLabel;

public class SalesMainBackend {
	
	public static void TotalSalesDisplay(JLabel salesIncreaseAmount, JLabel salesIncreasePercentage) {
		// Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Extract the current year
        int currentYear = currentDate.getYear();
        
        // Calculate the previous year
        int previousYear = currentYear - 1;
        
        SalesMongoDriver retrieve = new SalesMongoDriver();
        int totalCurrentSale = retrieve.totalYearlySales(currentYear);
        int totalPreviousSale = retrieve.totalYearlySales(previousYear);
        
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
	
	private static double computeIncrease(double current, double previous) {
		// Ensure previousYearSales is not zero to avoid division by zero error
        if (previous != 0) {
            // Calculate the increase percentage
            double increasePercentage = ((current - previous) / previous);
            return increasePercentage * 100;
        } else {
            // Handle case where previousYearSales is zero
            throw new IllegalArgumentException("Previous year sales cannot be zero");
        }
		
	}
	
	private static String displayNumber(double amount) {
		String converted = "";
		double convert = Math.abs(amount);
		
		if (convert >= 0 && convert < 1000) {
			converted = String.format("%.1f", amount);	
		} else if (convert >= 1000 && convert < 100000) {
			converted = String.format("%.1f", amount/1000) + "K";
		} else if (convert >= 100000 && convert < 1000000) {
			converted = String.format("%.1f", amount/100000) + "K";
		} else if (convert >= 1000000 && convert < 1000000000) {
			converted = String.format("%.1f", amount/1000000) + "M";	
		} else {
			converted = "0.00";
		}
		
		return converted;
	}
}
