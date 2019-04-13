package com.company;
import com.mongodb.DB;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOneModel;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class MongoDB {

    public MongoDB(){
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        MongoCredential credential;
        credential = MongoCredential.createCredential("eladnaeh@gmail.com", "AppointmentsDatabase", "eladnaeh@321".toCharArray());

        System.out.println("Connected to the database successfully");
        MongoDatabase database = mongo.getDatabase("AppointmentsDatabase");

        MongoCollection<Document> users = database.getCollection("usersCollection");
        MongoCollection<Document> doctors = database.getCollection("doctorsCollection");

        System.out.println("Collection sampleCollection selected successfully");
    }

    public void example(){

    }

    public static void main(String[] args) {

    }
}
