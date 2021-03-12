package com.ifpb.view;


import com.ifpb.model.Produto;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.function.Consumer;

import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App {

    public static void main(String[] args) {

        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient mongoClient = new MongoClient("172.19.0.2",
                MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

        MongoDatabase database = mongoClient.getDatabase("exemplo")
                .withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Produto> collection = database.getCollection("Produto", Produto.class);

        //Inserindo um objeto
//        collection.insertOne(new Produto(1, "Arroz", 5));

        //Consultando um objeto
//        collection.find().forEach((Consumer<? super Produto>)  p -> System.out.println(p));

        //Atualizando um objeto
//        collection.updateOne(new Document("_id", 1), set("descricao", "Arroz Parbolizado"));

        //Deletando um objeto
//        collection.deleteOne(new Document("descricao", "  Parbolizado"));

    }

}
