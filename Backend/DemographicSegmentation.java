package iTrack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DemographicSegmentation {
	public  List<Document> fetchData() throws Exception {
        List<Document> demographicData = new ArrayList<>();

        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongo.getDatabase("iTrack");
        MongoCollection<Document> customers = db.getCollection("customers");

        AggregateIterable<Document> results = customers.aggregate(Arrays.asList(
            new Document("$group", new Document()
                .append("_id", "$Customer ID")
                .append("fullName", new Document("$first", new Document("$concat", Arrays.asList(
                    "$First Name", " ", "$Last Name"
                ))))
                .append("birthday", new Document("$first", "$Birthday"))
                .append("sex", new Document("$first", "$Sex"))
                .append("contactNumber", new Document("$first", "$Contact Number"))
            ),
            new Document("$project", new Document()
                .append("_id", 0)
                .append("customerID", "$_id")
                .append("fullName", 1)
                .append("birthday", 1)
                .append("sex", 1)
                .append("contactNumber", 1)
            )
        ));

        for (Document doc : results) {
            demographicData.add(doc);
        }

        return demographicData;
    }
	
	public  DefaultTableModel addToTable() throws Exception {
		 DefaultTableModel demographic = new DefaultTableModel(
	                new Object[][] {},
	                new String[] {
	                		"Customer ID", "Customer Name", "Birthday", "Sex", "Contact Number"
	                }
	        );
		 
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	        for (Document doc : fetchData()) {
	            String customerId = doc.getString("customerID");
	            String customerName = doc.getString("fullName");
	            Date birthday = doc.getDate("birthday");
	            String sex = doc.getString("sex");
	            String contactNum = doc.getString("contactNumber");
	            
	            String birthdate = dateFormat.format(birthday);
	            

	            demographic.addRow(new Object[] {customerId, customerName, birthdate, sex, contactNum});
	        }

	        return demographic;
	    }
	
}
