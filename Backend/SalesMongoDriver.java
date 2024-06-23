package iTrack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

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
}
