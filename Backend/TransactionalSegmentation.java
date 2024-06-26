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

public class TransactionalSegmentation {
	public DefaultTableModel transactional(boolean sort) {
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> transacs = db.getCollection("transactions");
		
        ArrayList<Document> pipeline = new ArrayList<>(Arrays.asList(
                new Document("$lookup", new Document()
                        .append("from", "purchases")
                        .append("localField", "Purchase ID")
                        .append("foreignField", "Purchase ID")
                        .append("as", "purchaseInfo")
                ),
                new Document("$unwind", "$purchaseInfo"),
                new Document("$lookup", new Document()
                        .append("from", "customers")
                        .append("localField", "purchaseInfo.Customer ID")
                        .append("foreignField", "Customer ID")
                        .append("as", "customerInfo")
                ),
                new Document("$unwind", "$customerInfo"),
                new Document("$group", new Document()
                        .append("_id", "$purchaseInfo.Customer ID")
                        .append("customerName", new Document("$first", new Document("$concat", Arrays.asList(
                                "$customerInfo.First Name", " ", "$customerInfo.Last Name"
                        ))))
                        .append("totalTransactions", new Document("$sum", 1))
                        .append("totalUnitsPurchased", new Document("$sum", "$Quantity"))
                        .append("totalAmountSpent", new Document("$sum", "$Price"))
                ),
                new Document("$project", new Document()
                        .append("_id", 0)
                        .append("customerID", "$_id")
                        .append("customerName", 1)
                        .append("totalTransactions", 1)
                        .append("totalUnitsPurchased", 1)
                        .append("totalAmountSpent", 1)
                )
        ));

        // Sort stage based on ascending or descending order of Total Amount Spent
        pipeline.add(new Document("$sort", new Document("totalAmountSpent", sort ? 1 : -1)));

        AggregateIterable<Document> results = transacs.aggregate(pipeline);

        ArrayList<Document> transactions = new ArrayList<>();
        for (Document doc : results) {
            transactions.add(doc);
        }


        DefaultTableModel transactional = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Customer ID", "Customer Name", "Total Number of Transactions", "Total Number of Unit Purchased", "Total Amount of Purchases"
                }
        );

        for (Document doc : transactions) {
            String customerId = doc.getString("customerID");
            String customerName = doc.getString("customerName");
            int transac = doc.getInteger("totalTransactions");
            int units = doc.getInteger("totalUnitsPurchased");
            int totalSpent = doc.getInteger("totalAmountSpent");

            transactional.addRow(new Object[] {customerId, customerName, transac, units, totalSpent});
        }

        return transactional;
    }
}
