package com.bizee.core;

import java.io.FileReader;
import java.util.Properties;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class BizeeConnection {
	static FileReader reader = null;
	static Properties prop = null;
	static DBCollection collection = null;

	public static DBCollection getConnection() {
		String filepath ="C:/Users/Bizee/workspace/WebDM/src/resources/database.properties";
		try {
			reader = new FileReader(filepath);
			prop = new Properties();
			prop.load(reader);

			MongoClient mongoclient = new MongoClient(
					prop.getProperty("Mdb server"), Integer.parseInt(prop
							.getProperty("Mdb Port")));
			DB db = mongoclient.getDB(prop.getProperty("Mdb name"));
			collection = db.getCollection(prop.getProperty("Collection Name"));

			return collection;

		} catch (Exception e) {
			return null;
		}
	}
}
