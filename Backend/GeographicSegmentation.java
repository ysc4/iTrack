package iTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GeographicSegmentation {
    public List<Object[]> fetchData() {
        List<Object[]> geographicData = new ArrayList<>();

        try (MongoClient mongo = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = mongo.getDatabase("iTrack");
            MongoCollection<Document> customers = db.getCollection("customers");

            AggregateIterable<Document> results = customers.aggregate(Arrays.asList(
                new Document("$group", new Document()
                        .append("_id", "$Customer ID")
                        .append("fullName", new Document("$first", new Document("$concat", Arrays.asList(
                                "$First Name", " ", "$Last Name"
                        ))))
                        .append("address", new Document("$first", "$Address"))
                        .append("country", new Document("$first", "$Country"))
                        .append("region", new Document("$first", "$Region"))
                ),
                new Document("$project", new Document()
                        .append("_id", 0)
                        .append("customerID", "$_id")
                        .append("customerName", "$fullName")
                        .append("address", 1)
                        .append("country", "$country")
                        .append("region", "$region")
                )
            ));

            for (Document doc : results) {
                geographicData.add(new Object[]{
                    doc.getString("customerID"),
                    doc.getString("customerName"),
                    doc.getString("address"),
                    doc.getString("country"),
                    doc.getString("region")
                });
            }
        } catch (MongoException e) {
            System.err.println("MongoDB Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return geographicData;
    }

    public static void main(String[] args) {
        GeographicSegmentation segmentation = new GeographicSegmentation();
        List<Object[]> data = segmentation.fetchData();
        data.forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
