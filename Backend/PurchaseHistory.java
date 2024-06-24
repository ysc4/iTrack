package iTrack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PurchaseHistory {

	public DefaultTableModel purchaseHistory() {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> purchases = db.getCollection("purchases");
		
        AggregateIterable<Document> results = purchases.aggregate(Arrays.asList(
                new Document("$project", new Document()
                        .append("Purchase ID", 1)
                        .append("Store ID", 1)
                        .append("Customer ID", 1)
                        .append("Date and Time", 1)
                        .append("Total Spent", 1)
                )
        ));

        ArrayList<Document> purchaseList = new ArrayList<>();
        for (Document doc : results) {
            purchaseList.add(doc);
        }
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
		DefaultTableModel purchase = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Purchase ID", "Store ID", "Customer ID", "Date", "Time", "Total Spent"
				}
			);
		
		for (Document doc : purchaseList) {
            String purchaseId = doc.getString("Purchase ID");
            String storeId = doc.getString("Store ID");
            String customerId = doc.getString("Customer ID");
            Date dateTime = doc.getDate("Date and Time");
            int totalSpent = doc.getInteger("Total Spent");
            
            String date = dateFormat.format(dateTime);
            String time = timeFormat.format(dateTime);
            
            purchase.addRow(new Object[] {purchaseId, storeId, customerId, date, time, totalSpent});
        }
		
		return purchase;
	}
	
	
}
