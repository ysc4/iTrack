package iTrack;

import org.bson.Document;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CustomerDashboard extends JPanel {
	

	public int totalNew2023() throws Exception {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase itrackDB = mongo.getDatabase("iTrack");
        MongoCollection<Document> customerPurchases = itrackDB.getCollection("purchases");

        AggregateIterable<Document> results = customerPurchases.aggregate(Arrays.asList(
            new Document("$facet", new Document()
                .append("customers2022", Arrays.asList(
                    new Document("$match", new Document("Date and Time", new Document("$gte", new Date(122, 0, 1))
                            .append("$lt", new Date(123, 0, 1)))),
                    new Document("$group", new Document("_id", "$Customer ID"))
                ))
                .append("customers2023", Arrays.asList(
                    new Document("$match", new Document("Date and Time", new Document("$gte", new Date(123, 0, 1))
                            .append("$lt", new Date(124, 0, 1)))),
                    new Document("$group", new Document("_id", "$Customer ID"))
                ))
            ),
            new Document("$project", new Document()
                .append("customers2022", "$customers2022._id")
                .append("customers2023", "$customers2023._id")
            ),
            new Document("$project", new Document()
                .append("newCustomers2023", new Document("$setDifference", Arrays.asList("$customers2023", "$customers2022")))
            ),
            new Document("$project", new Document()
                .append("total_count", new Document("$size", "$newCustomers2023"))
            )
        ));

        Document result = results.first();
        if (result != null) {
            return result.getInteger("total_count", 0);
        } else {
            return 0;
        }
    }
	
	 public int totalNew2024() throws Exception {
	        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
	        MongoDatabase itrackDB = mongo.getDatabase("iTrack");
	        MongoCollection<Document> customerPurchases = itrackDB.getCollection("purchases");

	        AggregateIterable<Document> results = customerPurchases.aggregate(Arrays.asList(
	            new Document("$facet", new Document()
	                .append("customers2022_2023", Arrays.asList(
	                    new Document("$match", new Document("Date and Time", new Document("$gte", new Date(122, 0, 1))
	                            .append("$lt", new Date(124, 0, 1)))),
	                    new Document("$group", new Document("_id", "$Customer ID"))
	                ))
	                .append("customers2024", Arrays.asList(
	                    new Document("$match", new Document("Date and Time", new Document("$gte", new Date(124, 0, 1))
	                            .append("$lt", new Date(125, 0, 1)))),
	                    new Document("$group", new Document("_id", "$Customer ID"))
	                ))
	            ),
	            new Document("$project", new Document()
	                .append("customers2022_2023", "$customers2022_2023._id")
	                .append("customers2024", "$customers2024._id")
	            ),
	            new Document("$project", new Document()
	                .append("newCustomers2024", new Document("$setDifference", Arrays.asList("$customers2024", "$customers2022_2023")))
	            ),
	            new Document("$project", new Document()
	                .append("total_count", new Document("$size", "$newCustomers2024"))
	            )
	        ));

	        Document result = results.first();
	        if (result != null) {
	            return result.getInteger("total_count", 0);
	        } else {
	            return 0;
	        }
	    }
		    
	
	public int totalActive() throws Exception {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase itrackDB = mongo.getDatabase("iTrack");
		MongoCollection<Document> customerPurchases = itrackDB.getCollection("purchases");
		
		AggregateIterable<Document> results = customerPurchases.aggregate(Arrays.asList(
			    Aggregates.match(Filters.and(
			        Filters.gte("Date and Time", new Date(122, 0, 1)), 
			        Filters.lt("Date and Time", new Date(125, 0, 1)))), 
			    Aggregates.group("$Customer ID", Accumulators.sum("count", 1)),
			    Aggregates.group(null, Accumulators.sum("total_count", 1))));

		Document resultCount = results.first();
		if (resultCount != null) {
            int totalActive = resultCount.getInteger("total_count");
            return totalActive;
        } else {
            return 0; 
        }
	}

	
	public static double customerGrowth() throws Exception {
	    MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
	    MongoDatabase itrackDB = mongo.getDatabase("iTrack");
	    MongoCollection<Document> customerPurchases = itrackDB.getCollection("purchases");

	    AggregateIterable<Document> results = customerPurchases.aggregate(Arrays.asList(
	        new Document("$facet", new Document()
	            .append("customers2023", Arrays.asList(
	                new Document("$match", new Document("Date and Time", new Document("$gte", new Date(123, 0, 1))
	                        .append("$lt", new Date(124, 0, 1)))),
	                new Document("$group", new Document("_id", "$Customer ID")),
	                new Document("$group", new Document("_id", null).append("total_count", new Document("$sum", 1)))
	            ))
	            .append("customers2024", Arrays.asList(
	                new Document("$match", new Document("Date and Time", new Document("$gte", new Date(124, 0, 1))
	                        .append("$lt", new Date(125, 0, 1)))),
	                new Document("$group", new Document("_id", "$Customer ID")),
	                new Document("$group", new Document("_id", null).append("total_count", new Document("$sum", 1)))
	            ))
	        ),
	        new Document("$project", new Document()
	            .append("customers2023", new Document("$arrayElemAt", Arrays.asList("$customers2023.total_count", 0)))
	            .append("customers2024", new Document("$arrayElemAt", Arrays.asList("$customers2024.total_count", 0)))
	            .append("customergrowth", new Document("$cond", new Document("if", new Document("$eq", Arrays.asList(new Document("$arrayElemAt", Arrays.asList("$customers2023.total_count", 0)), 0)))
	                .append("then", new Document("$cond", new Document("if", new Document("$gt", Arrays.asList(new Document("$arrayElemAt", Arrays.asList("$customers2024.total_count", 0)), 0)))
	                    .append("then", 100)
	                    .append("else", 0)))
	                .append("else", new Document("$multiply", Arrays.asList(new Document("$divide", Arrays.asList(new Document("$subtract", Arrays.asList(new Document("$arrayElemAt", Arrays.asList("$customers2024.total_count", 0)), new Document("$arrayElemAt", Arrays.asList("$customers2023.total_count", 0)))), new Document("$arrayElemAt", Arrays.asList("$customers2023.total_count", 0)))), 100))))
	        )
	    )));

	    Document result = results.first();
	    if (result != null) {
	        double customerGrowth = result.getDouble("customergrowth");
	        return customerGrowth;
	    } else {
	        return 0;
	    }
	}
	
	public int CustomersPerCountry(String country) {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = db.getCollection("customers");

        Document match = new Document("$match", new Document("City/Country", country));

        Document group = new Document("$group", new Document()
                .append("_id", "$Customer ID")
                .append("customerCount", new Document("$sum", 1)));

        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(match, group));

        int customerCount = 0;
        for (Document doc : results) {
            customerCount++;
        }
        return customerCount;
	}
	
	public int activeCustomersPerCountry (String country) {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
	    MongoDatabase db = mongo.getDatabase("iTrack");
	    MongoCollection<Document> customers = db.getCollection("customers");
	    MongoCollection<Document> purchases = db.getCollection("purchases");

	    Document matchCustomers = new Document("$match", new Document("City/Country", country));

	    Document groupCustomers = new Document("$group", new Document("_id", "$Customer ID"));

	    AggregateIterable<Document> customerResults = customers.aggregate(Arrays.asList(matchCustomers, groupCustomers));

	    Set<String> customerIds = new HashSet<>();
	    for (Document doc : customerResults) {
	        customerIds.add(doc.getString("_id"));
	    }

	    Document matchPurchases = new Document("$match", new Document()
	            .append("Customer ID", new Document("$in", new ArrayList<>(customerIds)))
	            .append("Date and Time", new Document("$gte", new Date(122, 0, 1)))
	            .append("Date and Time", new Document("$lt", new Date(125, 0, 1)))
	    );

	    Document groupPurchases = new Document("$group", new Document("_id", "$Customer ID"));

	    AggregateIterable<Document> purchaseResults = purchases.aggregate(Arrays.asList(matchPurchases, groupPurchases));

	    int newCustomerCount = 0;
	    for (Document doc : purchaseResults) {
	        newCustomerCount++;
	    }
	    return newCustomerCount;
	}
	
	public int newCustomersPerCountry(String country) {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = database.getCollection("customers");
        MongoCollection<Document> purchases = database.getCollection("purchases");

        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(
        		new Document("$match", new Document("City/Country", country)), 
                new Document("$lookup", new Document()
                        .append("from", "purchases")
                        .append("localField", "Customer ID")
                        .append("foreignField", "Customer ID")
                        .append("as", "customerPurchases")
                ),
                new Document("$unwind", "$customerPurchases"), 
                new Document("$match", new Document("customerPurchases.Date and Time", new Document()
                        .append("$gte", new Date(124, 0, 1)) 
                        .append("$lt", new Date(125, 0, 1))  
                )),
                new Document("$group", new Document("_id", "$_id")), 
                new Document("$count", "newCustomerCount") 
        ));

   
        int newCustomerCount = 0;
        for (Document doc : results) {
            newCustomerCount = doc.getInteger("newCustomerCount");
        }
        return newCustomerCount;
	}

	public DefaultTableModel customerPerCountry() throws Exception {
		DefaultTableModel customerPerCountry = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Country", "Customer Count", "New Customers", "Active Customers"
				}
			);
		
		customerPerCountry.addRow(new Object[]{"Brussels", CustomersPerCountry("Brussels"), newCustomersPerCountry("Brussels"), activeCustomersPerCountry("Brussels")});
		customerPerCountry.addRow(new Object[]{"Vienna", CustomersPerCountry("Vienna"), newCustomersPerCountry("Vienna"), activeCustomersPerCountry("Vienna")});
		customerPerCountry.addRow(new Object[]{"New South Wales", CustomersPerCountry("New South Wales"), newCustomersPerCountry("New South Wales"), activeCustomersPerCountry("New South Wales")});
		customerPerCountry.addRow(new Object[]{"Amsterdam", CustomersPerCountry("Amsterdam"), newCustomersPerCountry("Amsterdam"), activeCustomersPerCountry("Amsterdam")});
		customerPerCountry.addRow(new Object[]{"Cambridge", CustomersPerCountry("Cambridge"), newCustomersPerCountry("Cambridge"), activeCustomersPerCountry("Cambridge")});
		customerPerCountry.addRow(new Object[]{"Los Angeles", CustomersPerCountry("Los Angeles"), newCustomersPerCountry("Los Angeles"), activeCustomersPerCountry("Los Angeles")});
		customerPerCountry.addRow(new Object[]{"China", CustomersPerCountry("China"), newCustomersPerCountry("China"), activeCustomersPerCountry("China")});
		customerPerCountry.addRow(new Object[]{"Australian Capital Territory", CustomersPerCountry("Australian Capital Territory"), newCustomersPerCountry("Australian Capital Territory"), activeCustomersPerCountry("Australian Capital Territory")});
		customerPerCountry.addRow(new Object[]{"Victoria", CustomersPerCountry("Victoria"), newCustomersPerCountry("Victoria"), activeCustomersPerCountry("Victoria")});
		customerPerCountry.addRow(new Object[]{"Japan", CustomersPerCountry("Japan"), newCustomersPerCountry("Japan"), activeCustomersPerCountry("Japan")});
		customerPerCountry.addRow(new Object[]{"Philippines", CustomersPerCountry("Philippines"), newCustomersPerCountry("Philippines"), activeCustomersPerCountry("Philippines")});
		customerPerCountry.addRow(new Object[]{"Taiwan", CustomersPerCountry("Taiwan"), newCustomersPerCountry("Taiwan"), activeCustomersPerCountry("Taiwan")});
		customerPerCountry.addRow(new Object[]{"Alberta", CustomersPerCountry("Alberta"), newCustomersPerCountry("Alberta"), activeCustomersPerCountry("Alberta")});
		customerPerCountry.addRow(new Object[]{"UAE", CustomersPerCountry("UAE"), newCustomersPerCountry("UAE"), activeCustomersPerCountry("UAE")});
		customerPerCountry.addRow(new Object[]{"Paris", CustomersPerCountry("Paris"), newCustomersPerCountry("Paris"), activeCustomersPerCountry("UParisS")});
		customerPerCountry.addRow(new Object[]{"Malaysia", CustomersPerCountry("Malaysia"), newCustomersPerCountry("Malaysia"), activeCustomersPerCountry("Malaysia")});
		customerPerCountry.addRow(new Object[]{"Michigan", CustomersPerCountry("Michigan"), newCustomersPerCountry("Michigan"), activeCustomersPerCountry("Michigan")});
		customerPerCountry.addRow(new Object[]{"Berlin", CustomersPerCountry("Berlin"), newCustomersPerCountry("Berlin"), activeCustomersPerCountry("Berlin")});
		customerPerCountry.addRow(new Object[]{"Queensland", CustomersPerCountry("Queensland"), newCustomersPerCountry("Queensland"), activeCustomersPerCountry("Queensland")});
		customerPerCountry.addRow(new Object[]{"Macau", CustomersPerCountry("Macau"), newCustomersPerCountry("Macau"), activeCustomersPerCountry("Macau")});
		
		return customerPerCountry;	
	}
	
	public int activeCustomersPerYear(int startYear, int endYear) {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> purchases = db.getCollection("purchases");

        Document match = new Document("$match", new Document()
                .append("Date and Time", new Document("$gte", new Date(startYear - 1900, 0, 1))) 
                .append("Date and Time", new Document("$lt", new Date(endYear - 1900, 0, 1))) 
        );

        Document group = new Document("$group", new Document()
                .append("_id", "$Customer ID")
                .append("customerCount", new Document("$sum", 1))
        );

        int customerCount = 0;
        AggregateIterable<Document> results = purchases.aggregate(Arrays.asList(match, group));
        for (Document doc : results) {
            customerCount = doc.getInteger("customerCount");
        }
        return customerCount;
	}
	
    public ChartPanel customerTrend() {
    	DefaultCategoryDataset customerTrend = new DefaultCategoryDataset();
    	addValue(customerTrend, activeCustomersPerYear(2022, 2023), "Active", "2022");
        addValue(customerTrend, activeCustomersPerYear(2023, 2024), "Active", "2023");
        addValue(customerTrend, activeCustomersPerYear(2024, 2025), "Active", "2024");

        JFreeChart chart = createChart("ACTIVE CUSTOMERS TREND", "CATEGORY", "FREQUENCY", customerTrend);
        ChartPanel customerTrendPanel = new ChartPanel(chart);
        customerTrendPanel.setPreferredSize(new Dimension(670, 200));
        customerTrendPanel.setBackground(new Color(255, 255, 255));
        customerTrendPanel.setBounds(5, 5, 670, 200);
        
        return customerTrendPanel;
    }
    
    public int femaleCustomers (int startAge, int endAge) {
    	MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
    	MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = db.getCollection("customers");

        LocalDate currentDate = LocalDate.now();
        LocalDate startBirthDate = currentDate.minusYears(endAge + 1).plusDays(1);
        LocalDate endBirthDate = currentDate.minusYears(startAge);

        Date startBirthDateAsDate = Date.from(startBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endBirthDateAsDate = Date.from(endBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Document match = new Document("$match", new Document()
                .append("Sex", "F")
                .append("Birthday", new Document("$gte", startBirthDateAsDate)
                        .append("$lt", endBirthDateAsDate))
        );

        Document group = new Document("$group", new Document()
                .append("_id", "$Customer ID")
        );

        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(match, group));
        
        int customerCount = 0;
        for (Document doc : results) {
        	customerCount++;
        }
        return customerCount;
    }
    
    public int maleCustomers (int startAge, int endAge) {
    	MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
    	MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = db.getCollection("customers");

        // Calculate birthdate range
        LocalDate currentDate = LocalDate.now();
        LocalDate startBirthDate = currentDate.minusYears(endAge + 1).plusDays(1);
        LocalDate endBirthDate = currentDate.minusYears(startAge);

        Date startBirthDateAsDate = Date.from(startBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endBirthDateAsDate = Date.from(endBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Match stage
        Document match = new Document("$match", new Document()
                .append("Sex", "M")
                .append("Birthday", new Document("$gte", startBirthDateAsDate)
                        .append("$lt", endBirthDateAsDate))
        );

        // Group stage
        Document group = new Document("$group", new Document()
                .append("_id", "$Customer ID")
        );

        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(match, group));
        
        int customerCount = 0;
        for (Document doc : results) {
        	customerCount++;
        }
        return customerCount;
    }
    
    public ChartPanel demographicChart() {
    	DefaultCategoryDataset demographicData = new DefaultCategoryDataset();
    	addValue(demographicData, femaleCustomers(0, 17), "Female", "<18");
        addValue(demographicData, femaleCustomers(18, 28), "Female", "18-28");
        addValue(demographicData, femaleCustomers(29, 38), "Female", "29-38");
        addValue(demographicData, femaleCustomers(39, 48), "Female", "39-48");
        addValue(demographicData, femaleCustomers(49, 58), "Female", "49-58");
        addValue(demographicData, femaleCustomers(59, 150), "Female", ">58");
        addValue(demographicData, maleCustomers(0, 17), "Male", "<18");
        addValue(demographicData, maleCustomers(18, 28), "Male", "18-28");
        addValue(demographicData, maleCustomers(29, 38), "Male", "29-38");
        addValue(demographicData, maleCustomers(39, 48), "Male", "39-48");
        addValue(demographicData, maleCustomers(49, 58), "Male", "49-58");
        addValue(demographicData, maleCustomers(59, 150), "Male", ">58");

        JFreeChart chart = createChart("DEMOGRAPHIC SEGMENTATION", "AGE & SEX", "FREQUENCY", demographicData);
        
        ChartPanel demographicPanel = new ChartPanel(chart);
        demographicPanel.setPreferredSize(new Dimension(350,210));
        demographicPanel.setBackground(new Color(255, 255, 255));
        demographicPanel.setBounds(10, 10, 350, 210);
        
        return demographicPanel;
    }

    public ArrayList<String> top10Countries() {	
    	MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
    	MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = db.getCollection("customers");
    	
        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(
                new Document("$lookup", new Document()
                        .append("from", "purchases")
                        .append("localField", "Customer ID")
                        .append("foreignField", "Customer ID")
                        .append("as", "customerPurchases")
                ),
                new Document("$match", new Document("customerPurchases.Date and Time", new Document()
                        .append("$gte", new Date(122, 0, 1))
                        .append("$lt", new Date(125, 0, 1))
                )),
                new Document("$group", new Document()
                        .append("_id", "$City/Country")
                        .append("customerCount", new Document("$sum", 1))
                ),
                new Document("$sort", new Document("customerCount", -1)),
                new Document("$limit", 10)
        ));

        ArrayList<String> top10 = new ArrayList<>();
        for (Document doc : results) {
            System.out.println("Document: " + doc.toJson());  // Debug print
            String country = doc.getString("_id"); // Extract country name from the document
            top10.add(country); // Add country name to the ArrayList
        }
        System.out.println(top10);

        return top10;
    }
    
    public ChartPanel geographicChart() {
    	DefaultCategoryDataset geographicData = new DefaultCategoryDataset(); 	
    	
        for (String country : top10Countries()) {           
            int newCustomers = newCustomersPerCountry(country);
            int allCustomers = CustomersPerCountry(country);
            addValue(geographicData, newCustomers, "New", country);
            addValue(geographicData, allCustomers, "All", country);
        }
             
        JFreeChart chart = createChart("GEOGRAPHIC SEGMENTATION", "COUNTRIES", "FREQUENCY", geographicData);
        
        ChartPanel geographicPanel = new ChartPanel(chart);
        geographicPanel.setPreferredSize(new Dimension(350,210));
        geographicPanel.setBackground(new Color(255, 255, 255));
        geographicPanel.setBounds(380, 10, 350, 210);
        
        return geographicPanel;
    }
    
    public int productsVsCustomers(String category) {
    	MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
    	MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> transacs = db.getCollection("transactions");
        
        AggregateIterable<Document> results = transacs.aggregate(Arrays.asList(
                new Document("$lookup", new Document()
                    .append("from", "purchases")
                    .append("localField", "Purchase ID")
                    .append("foreignField", "Purchase ID")
                    .append("as", "purchaseDetails")
                ),
                new Document("$unwind", "$purchaseDetails"),
                new Document("$lookup", new Document()
                    .append("from", "products")
                    .append("localField", "Product ID")
                    .append("foreignField", "Product ID")
                    .append("as", "productDetails")
                ),
                new Document("$unwind", "$productDetails"),
                new Document("$match", new Document("productDetails.Category", category)), // Change this to the desired category
                new Document("$group", new Document()
                    .append("_id", "$purchaseDetails.Customer ID")
                ),
                new Document("$count", "uniqueCustomers")
            ));

        	int customerCount = 0;
            for (Document doc : results) {
                customerCount = doc.getInteger("uniqueCustomers");
            }
            return customerCount;
    }
    
    public ChartPanel transactionalChart() {
    	DefaultCategoryDataset transactionalData = new DefaultCategoryDataset();
    	addValue(transactionalData, productsVsCustomers("iPhone"), "Customers", "iPhone");
        addValue(transactionalData, productsVsCustomers("iPad"), "Customers", "iPad");
        addValue(transactionalData, productsVsCustomers("Watch"), "Customers", "Watch");
        addValue(transactionalData, productsVsCustomers("Macbook"), "Customers", "Macbook");
        addValue(transactionalData, productsVsCustomers("TV & Home"), "Customers", "TV & Home");
        addValue(transactionalData, productsVsCustomers("AirPods"), "Customers", "AirPods");
        addValue(transactionalData, productsVsCustomers("Vision"), "Customers", "Vision");
  
        JFreeChart chart = createChart("TRANSACTIONAL SEGMENTATION", "PRODUCTS", "FREQUENCY", transactionalData);
        
        ChartPanel transactionalPanel = new ChartPanel(chart);
        transactionalPanel.setPreferredSize(new Dimension(350,210));
        transactionalPanel.setBackground(new Color(255, 255, 255));
        transactionalPanel.setBounds(740, 10, 350, 210);
        
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
        domainAxis.setCategoryMargin(0.1);
        domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(12f));
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
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




