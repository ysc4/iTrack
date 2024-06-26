package iTrack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GeographicSegmentation {
	public  List<Document> fetchData() throws Exception {
        List<Document> geographicData = new ArrayList<>();

        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = db.getCollection("customers");

        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(
                new Document("$group", new Document()
                        .append("_id", "$Customer ID")
                        .append("fullName", new Document("$first", new Document("$concat", Arrays.asList(
                                "$First Name", " ", "$Last Name"
                        ))))
                        .append("address", new Document("$first", "$Street #"))
                        .append("country", new Document("$first", "$City/Country"))
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
                geographicData.add(doc);;
            }

        return geographicData;
    }
	
	public DefaultTableModel addToTable() throws Exception {
		 DefaultTableModel geographic = new DefaultTableModel(
	                new Object[][] {},
	                new String[] {
	                		"Customer ID", "Customer Name","Address", "Country", "Region"
	                }
	        );

	        for (Document doc : fetchData()) {
	            String customerId = doc.getString("customerID");
	            String customerName = doc.getString("customerName");
	            String address = doc.getString("address");
	            String country = doc.getString("country");
	            String region = doc.getString("region");
	          	         

	            geographic.addRow(new Object[] {customerId, customerName, address, country, region});
	        }

	        return geographic;
	    }
	
}


