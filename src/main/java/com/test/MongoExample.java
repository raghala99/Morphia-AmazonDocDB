package com.test;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.test.models.Book;

public class MongoExample {
	public static void main(String[] args) {

		/*
		 * System.setProperty("DEBUG.MONGO", "true");
		 * 
		 * System.setProperty("DB.TRACE", "true");
		 */
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.ALL); // e.g. or Log.WARNING, et

		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://test:Test1234@127.0.0.1:27020"));
		/*
		 * // Enable MongoDB logging in general
		 * 
		 * MongoDatabase database = mongoClient.getDatabase("product");
		 * 
		 * // print existing databases List<String> list =
		 * mongoClient.getDatabaseNames(); for (String value : list) {
		 * System.out.println(value); }
		 */

		Morphia morphia = new Morphia();
		morphia.mapPackage("com.test.models");
		Datastore datastore = morphia.createDatastore(mongoClient, "books");
		datastore.ensureIndexes();
		Book book = new Book("b116" + new Random(), "Java1", "James Gosling1", 19.9);
		datastore.save(book);
		System.out.println(
				"Query : " + datastore.createQuery(Book.class).field("title").contains("java").getQueryObject().toString());
		List<Book> books = datastore.createQuery(Book.class).field("title").contains("ava").asList();
		books.forEach(book1 -> System.out.println(book1.getIsbn()));
	}
}