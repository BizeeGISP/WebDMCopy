package com.bizee.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.mongodb.*;


public class BizeeConnectionDao 
{

	DBCollection collection = BizeeConnection.getConnection();

	public void insert(DBObject document)
	{

		collection.insert(document);
	}

	public void find(DBObject doc) 
	{

		DBObject cursor = collection.findOne(doc);
		System.out.println(cursor);

	}

	public void findAll(DBObject doc) 
	{
		DBCursor cursor = collection.find(doc);
		while (cursor.hasNext()) 
		{
			System.out.println(cursor.next());
		}

	}

	public void insert_many(List<DBObject> documents) 
	{
		collection.insert(documents);
	}

	public void delete_all(DBObject document)
	{

		collection.remove(document);
	}

	public void update_one(DBObject doc1, DBObject value) 
	{
		collection.update(doc1, value);
	}

	public void update_all(DBObject doc1, DBObject value)
	{
		collection.updateMulti(doc1, value);
	}

}