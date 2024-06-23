package iTrack;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.lookup;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Sorts.descending;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class SalesMongoDriver {
	
	public int totalMonthlySales(int retrieveYear, int retrieveMonth) {
		// MongoDB connection string
        String connectionString = "mongodb://localhost:27017";

        // Create MongoClientSettings
        ConnectionString connString = new ConnectionString(connectionString);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();

        	MongoClient mongoClient = MongoClients.create(settings);
            // Connect to database
            MongoDatabase database = mongoClient.getDatabase("iTrack");

            // Connect to collection
            MongoCollection<Document> collection = database.getCollection("TransactionHistory");

     // Define the year and month range
        int year = retrieveYear; // Specify the year of interest
        int startMonth = 1; // Start month (March, 1-based index)
        int endMonth = retrieveMonth;   // End month (May, 1-based index)

        // Aggregation pipeline to calculate total sales for the specified month range in a specific year
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                // Match documents for the specified year
                Aggregates.match(Filters.and(
                        Filters.expr(new Document("$eq", Arrays.asList(new Document("$year", "$Date and Time"), year))),
                        Filters.expr(new Document("$gte", Arrays.asList(new Document("$month", "$Date and Time"), startMonth))),
                        Filters.expr(new Document("$lte", Arrays.asList(new Document("$month", "$Date and Time"), endMonth)))
                )),
                // Project to extract year and sales amount
                Aggregates.project(
                        Projections.fields(
                                Projections.computed("year", new Document("$year", "$Date and Time")),
                                Projections.computed("salesAmount", new Document("$toDouble", new Document("$multiply", Arrays.asList("$Quantity", "$Price"))))
                        )
                ),
                // Group by year and calculate total sales amount
                Aggregates.group("$year", Accumulators.sum("totalSales", "$salesAmount")),
                // Sort by year if needed
                Aggregates.sort(new Document("_id", 1))
        ));

        // HashMap to store results
        Map<Integer, Double> yearSalesMap = new HashMap<>();

        // Populate the HashMap with aggregation results
        for (Document doc : result) {
            Integer aggregatedYear = doc.getInteger("_id");
            Double totalSales = doc.getDouble("totalSales");
            yearSalesMap.put(aggregatedYear, totalSales);
        }

        if (yearSalesMap.get(retrieveYear) == null) {
        	return 0;
        } else {
        	return (int) Math.round(yearSalesMap.get(retrieveYear));
        }

	}
	
	public int totalYearlySales(int retrieveYear) throws Exception{
		// MongoDB connection string
        String connectionString = "mongodb://localhost:27017";

        // Create MongoClientSettings
        ConnectionString connString = new ConnectionString(connectionString);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();

        	MongoClient mongoClient = MongoClients.create(settings);
            // Connect to database
            MongoDatabase database = mongoClient.getDatabase("iTrack");

            // Connect to collection
            MongoCollection<Document> collection = database.getCollection("TransactionHistory");

            // Aggregation pipeline to calculate total sales per year
            AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                    // Project to extract year and sales amount
                    Aggregates.project(
                            Projections.fields(
                                    Projections.computed("year", new Document("$year", "$Date and Time")),
                                    Projections.computed("salesAmount", new Document("$toDouble", new Document("$multiply", Arrays.asList("$Quantity", "$Price"))))
                            )
                    ),
                    // Group by year and calculate total sales amount
                    Aggregates.group("$year", Accumulators.sum("totalSales", "$salesAmount")),
                    // Sort by year if needed
                    Aggregates.sort(new Document("_id", 1))
            ));

            // HashMap to store results
            Map<Integer, Double> yearSalesMap = new HashMap<>();

            // Populate the HashMap with aggregation results
            for (Document doc : result) {
                Integer year = doc.getInteger("_id");
                Double totalSales = doc.getDouble("totalSales");
                yearSalesMap.put(year, totalSales);
            }
            
            if (yearSalesMap.get(retrieveYear) == null) {
            	return 0;
            } else {
            	return (int) Math.round(yearSalesMap.get(retrieveYear));
            }
	}
	
	public int totalMonthlyTransactions(int retrieveYear, int retrieveMonth) throws Exception{
		String uri = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
			
		MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("iTrack"); // Replace with your database name
            MongoCollection<Document> collection = database.getCollection("TransactionHistory");

            int year = retrieveYear; // Specify the year
            int startMonth = 1; // Specify the start month
            int endMonth = retrieveMonth; // Specify the end month

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            // Construct the start and end dates
            String startDateStr = String.format("%d-%02d-01T00:00:00", year, startMonth);
            String endDateStr = String.format("%d-%02d-01T00:00:00", year, endMonth + 1);
            LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);

            // Build the query
            Document query = new Document("$and", List.of(
                new Document("Date and Time", new Document("$gte", startDate)),
                new Document("Date and Time", new Document("$lt", endDate))
            ));

            // Execute the query
            int orderCount = (int) collection.countDocuments(query);
            return orderCount;
	}
	
	public double inputTopTenSalesPrice(int displayRank) throws Exception {
		String uri = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("iTrack"); // Replace with your database name
            MongoCollection<Document> transactionHistoryCollection = database.getCollection("TransactionHistory");

            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            int year = currentDate.getYear(); // Specify the year
            int startMonth = 1; // Specify the start month
            int endMonth = LocalDate.now().getMonthValue(); // Specify the end month

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            // Construct the start and end dates
            String startDateStr = String.format("%d-%02d-01T00:00:00", year, startMonth);
            String endDateStr = String.format("%d-%02d-01T00:00:00", year, endMonth + 1);
            LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);

            // Build the aggregation pipeline
            List<Bson> pipeline = Arrays.asList(
                match(and(gte("Date and Time", startDate), lte("Date and Time", endDate))),
                group("$Product ID", sum("totalSales", new Document("$multiply", Arrays.asList("$Quantity", "$Price")))),
                sort(descending("totalSales")),
                limit(10),
                lookup("ProductsData", "_id", "Product ID", "productDetails"),
                unwind("$productDetails"),
                project(new Document("Product Name", "$productDetails.Product Name")
                        .append("Total Sales", "$totalSales"))
            );

            // Execute the aggregation query
            AggregateIterable<Document> result = transactionHistoryCollection.aggregate(pipeline);

            // Store results in a HashMap with keys 1-10
            Map<Integer, Map<String, Object>> topProductsMap = new HashMap<>();
            int rank = 1;
            for (Document doc : result) {
                Map<String, Object> productInfo = new HashMap<>();
                productInfo.put("Product Name", doc.getString("Product Name"));

                Object totalSalesObj = doc.get("Total Sales");
                double totalSales;
                if (totalSalesObj instanceof Integer) {
                    totalSales = ((Integer) totalSalesObj).doubleValue();
                } else if (totalSalesObj instanceof Double) {
                    totalSales = (Double) totalSalesObj;
                } else {
                    throw new IllegalStateException("Unexpected value type for total sales: " + totalSalesObj.getClass());
                }
                productInfo.put("Total Sales", totalSales);

                topProductsMap.put(rank, productInfo);
                rank++;
            }

            // Display a specific product from the top 10
            double totalSold = 0;
            int productRankToDisplay = displayRank; // Specify the rank of the product to display (1-10)
            if (topProductsMap.containsKey(productRankToDisplay)) {
                Map<String, Object> productInfo = topProductsMap.get(productRankToDisplay);
                totalSold = (double) productInfo.get("Total Sales");
            } else {
                System.out.println("No product found at rank " + productRankToDisplay);
            }
            
            return totalSold;
       }
	}
	
	public String inputTopTenSalesProductName(int displayRank) {
		String uri = "mongodb://localhost:27017"; // Replace with your MongoDB connection string
        MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("iTrack"); // Replace with your database name
            MongoCollection<Document> transactionHistoryCollection = database.getCollection("TransactionHistory");
            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            int year = currentDate.getYear(); // Specify the year
            int startMonth = 1; // Specify the start month
            int endMonth = LocalDate.now().getMonthValue(); // Specify the end month

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            // Construct the start and end dates
            String startDateStr = String.format("%d-%02d-01T00:00:00", year, startMonth);
            String endDateStr = String.format("%d-%02d-01T00:00:00", year, endMonth + 1);
            LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);

            // Build the aggregation pipeline
            List<Bson> pipeline = Arrays.asList(
                match(and(gte("Date and Time", startDate), lte("Date and Time", endDate))),
                group("$Product ID", sum("totalSales", new Document("$multiply", Arrays.asList("$Quantity", "$Price")))),
                sort(descending("totalSales")),
                limit(10),
                lookup("ProductsData", "_id", "Product ID", "productDetails"),
                unwind("$productDetails"),
                project(new Document("Product Name", "$productDetails.Product Name")
                        .append("Total Sales", "$totalSales"))
            );

            // Execute the aggregation query
            AggregateIterable<Document> result = transactionHistoryCollection.aggregate(pipeline);

            // Store results in a HashMap with keys 1-10
            Map<Integer, Map<String, Object>> topProductsMap = new HashMap<>();
            int rank = 1;
            for (Document doc : result) {
                Map<String, Object> productInfo = new HashMap<>();
                productInfo.put("Product Name", doc.getString("Product Name"));

                Object totalSalesObj = doc.get("Total Sales");
                double totalSales;
                if (totalSalesObj instanceof Integer) {
                    totalSales = ((Integer) totalSalesObj).doubleValue();
                } else if (totalSalesObj instanceof Double) {
                    totalSales = (Double) totalSalesObj;
                } else {
                    throw new IllegalStateException("Unexpected value type for total sales: " + totalSalesObj.getClass());
                }
                productInfo.put("Total Sales", totalSales);

                topProductsMap.put(rank, productInfo);
                rank++;
            }

            // Display a specific product from the top 10
            String prodName = "";
            int productRankToDisplay = displayRank; // Specify the rank of the product to display (1-10)
            if (topProductsMap.containsKey(productRankToDisplay)) {
                Map<String, Object> productInfo = topProductsMap.get(productRankToDisplay);
                prodName = (String) productInfo.get("Product Name");
            } else {
                System.out.println("No product found at rank " + productRankToDisplay);
            }
 
            return prodName;
	}
	
	public static void displayTopTenStores(DefaultTableModel tableModel) {
		// Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("iTrack");

        // Collections
        MongoCollection<Document> purchaseHistoryCollection = database.getCollection("PurchaseHistory");
        MongoCollection<Document> storeDataCollection = database.getCollection("StoreData");

        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        int year = currentDate.getYear(); // Specify the year
        String startDateStr = year + "-01-01T00:00:00Z";
        String endDateStr = (year + 1) + "-01-01T00:00:00Z";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Aggregation pipeline
        List<Document> pipeline = Arrays.asList(
                new Document("$match", Filters.and(
                        Filters.gte("Date and Time", startDate),
                        Filters.lt("Date and Time", endDate)
                )),
                new Document("$group", new Document("_id", "$Store ID")
                        .append("totalSales", new Document("$sum", "$Total Spent"))),
                new Document("$sort", new Document("totalSales", -1)),
                new Document("$limit", 15)
        );

        // Execute the aggregation
        AggregateIterable<Document> topStores = purchaseHistoryCollection.aggregate(pipeline);

        for (Document store : topStores) {
            String storeId = store.getString("_id");
            Number totalSales = store.get("totalSales", Number.class); // Get as Number

            // Find store details from StoreData collection
            Document storeDetails = storeDataCollection.find(new Document("Store ID", storeId)).first();

            if (storeDetails != null) {
                String storeName = storeDetails.getString("Store Name");
                String country = storeDetails.getString("Country");

                tableModel.addRow(new Object[] {storeName, country, totalSales.toString()});
            }
        }

        // Close the MongoDB client
        mongoClient.close();
	}
	
	public static void displaySalesPerCountry(ArrayList<String> countries,  ArrayList<Integer> sumSales) {
        countries.clear();
        sumSales.clear();
        
		String uri = "mongodb://localhost:27017"; // Update with your MongoDB URI
        MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("iTrack"); // Update with your database name
            MongoCollection<Document> purchaseHistory = database.getCollection("PurchaseHistory");
            MongoCollection<Document> storeData = database.getCollection("StoreData");

            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            int year = currentDate.getYear(); // Specify the year

            // Define the start and end date for the year
            LocalDateTime startOfYear = LocalDateTime.of(year, 1, 1, 0, 0);
            LocalDateTime endOfYear = LocalDateTime.of(year, 12, 31, 23, 59);

         // Aggregation pipeline to get sales per country and sort by totalSales in descending order
            AggregateIterable<Document> result = purchaseHistory.aggregate(Arrays.asList(
                    Aggregates.match(Filters.and(
                            Filters.gte("Date and Time", startOfYear.toInstant(ZoneOffset.UTC)),
                            Filters.lte("Date and Time", endOfYear.toInstant(ZoneOffset.UTC))
                    )),
                    Aggregates.lookup("StoreData", "Store ID", "Store ID", "store_info"),
                    Aggregates.unwind("$store_info"),
                    Aggregates.group("$store_info.Country",
                            Accumulators.sum("totalSales", "$Total Spent")
                    ),
                    Aggregates.sort(Sorts.descending("totalSales"))
            ));
            
            for (Document doc : result) {
                String country = doc.getString("_id");
                Integer totalSales = doc.getInteger("totalSales");

                countries.add(country);
                sumSales.add(totalSales);
            }
            
	}
}
