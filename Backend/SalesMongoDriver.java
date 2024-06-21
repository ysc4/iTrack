package iTrack;

import java.util.Arrays;
import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SalesMongoDriver {
	
	public int totalYearlySales(int retrieveYear) {
		// Connect to MongoDB
        String uri = "mongodb://localhost:27017"; // Replace with your MongoDB URI
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(uri);

        // Access the database and collections
        MongoDatabase database = mongoClient.getDatabase("iTrack"); // Replace with your database name
        MongoCollection<Document> purchaseHistoryCollection = database.getCollection("PurchaseHistory");

        // Define the aggregation pipeline
        AggregateIterable<Document> result = purchaseHistoryCollection.aggregate(Arrays.asList(
            new Document("$project", new Document("year", new Document("$year", "$Date and Time"))
                                          .append("Total Spent", 1)),
            new Document("$group", new Document("_id", "$year")
                                          .append("totalSales", new Document("$sum", "$Total Spent"))),
            new Document("$sort", new Document("_id", 1))
        ));

     // Create a hashmap to store the results
        HashMap<Integer, Integer> salesByYear = new HashMap<>();

        // Iterate over the results and store them in the hashmap
        for (Document doc : result) {
            int year = doc.getInteger("_id");
            int totalSales = doc.getInteger("totalSales");
            salesByYear.put(year, totalSales);
        }

       return salesByYear.get(retrieveYear);
        
    
	}

}
