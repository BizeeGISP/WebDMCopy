package com.bizee.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.bson.BasicBSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class BizeeConnectionMain {

	public static void main(String[] args) {

		BizeeConnectionDao mdb = new BizeeConnectionDao();

		/*// INSERT MANY DATA
		DBObject document1 = new BasicDBObject();
		document1.put("name", "Kiran");
		document1.put("age", 20);

		DBObject document2 = new BasicDBObject();
		document2.put("name", "John");
		document2.put("age", "23");

		List<DBObject> documents = new ArrayList<>();
		documents.add(document1);
		documents.add(document2);

		mdb.insert_many(documents);
*/
		
		//  MDB mdb = new MDB(); 
		  
		  
		BasicDBObject doc = new BasicDBObject();
		  
		  doc.put("url", "webzonsolutions.in");
		  
		  mdb.findAll(doc);
		 

		/*
		 * BasicDBObject doc = new BasicDBObject();
		 * 
		 * doc.put("name", "rahul");
		 * 
		 * mdb.insert(doc);
		 */

		/*
		 * BulkWriteOperation builder =
		 * Collectionstion.initializeOrderedBulkOperation(); builder.insert(new
		 * BasicDBObject("_id", 1)); builder.insert(new BasicDBObject("_id",
		 * 2)); builder.insert(new BasicDBObject("_id", 3));
		 */

		/*
		 * DBObject doc1 = new BasicDBObject("name","opq"); DBObject value = new
		 * BasicDBObject();
		 * 
		 * value.put("name","zyx"); mdb.update_all(doc1,value);
		 * System.out.println("data updated");
		 */

		// Delete all record with same name
		/*
		 * BasicDBObject doc1 = new BasicDBObject("name","rahul");
		 * 
		 * mdb.delete_all(doc1);
		 */

		// Multiple Update record with same name
		/*
		 * BasicDBObject updateQuery = new BasicDBObject();
		 * updateQuery.append("$set", new BasicDBObject().append("name","zyx"));
		 * 
		 * BasicDBObject searchQuery = new BasicDBObject();
		 * searchQuery.append("name","opq"); mdb.update_all(searchQuery,
		 * updateQuery);
		 */

	}

}
