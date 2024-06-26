package iTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DemographicSegmentation {
    public List<Document> fetchData() {
        List<Document> demographicData = new ArrayList<>();

        try (MongoClient mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("iTrack");
            MongoCollection<Document> customersCollection = database.getCollection("customers");

            AggregateIterable<Document> results = customersCollection.aggregate(Arrays.asList(
                new Document("$group", new Document()
                    .append("_id", "$Customer ID")
                    .append("fullName", new Document("$first", new Document("$concat", Arrays.asList(
                        "$First Name", " ", "$Last Name"
                    ))))
                    .append("cityCountry", new Document("$first", "$Country"))
                    .append("birthday", new Document("$first", "$Birthday"))
                    .append("gender", new Document("$first", "$Gender"))
                    .append("contactNumber", new Document("$first", "$Contact Number"))
                ),
                new Document("$project", new Document()
                    .append("_id", 0)
                    .append("customerID", "$_id")
                    .append("fullName", 1)
                    .append("country", "$cityCountry")
                    .append("birthday", 1)
                    .append("gender", 1)
                    .append("contactNumber", 1)
                )
            ));

            for (Document doc : results) {
                demographicData.add(doc);
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }

        // Print the data fetched from the database
        System.out.println("Fetched data: ");
        for (Document doc : demographicData) {
            System.out.println(doc.toJson());
        }

        return demographicData;
    }

    public static void main(String[] args) {
        DemographicSegmentation aggregation = new DemographicSegmentation();
        List<Document> data = aggregation.fetchData();
        data.forEach(doc -> System.out.println(doc.toJson()));
    }
}
