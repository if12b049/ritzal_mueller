package com.bookserviceapp;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by phips on 15.12.2014.
 */
public class AuthorClient {
    public static void main(String[] args) throws Exception {
         System.out.println("Usage: java AuthorClient -json_filepath");
        if (args[0].isEmpty()) {
            System.out.println("Error: No Filename found!");
            return;
        }

        WebTarget target = ClientBuilder
                .newClient()
                        //.register(new RequestFilter("myuser", "topsecret"))
                .target("http://localhost:8080/BookServiceWebAppWeb/resources/author");

        createAuthor(target, readFile(args[0]));

    }

    private static String readFile(String filename) throws IOException {
        //Parse to String in order to get a "good" json-format
        String json = new String();
        ArrayList<String> readString = (ArrayList<String>) Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        for (String tmp : readString) json += tmp;
        return json;
    }

    private static void createAuthor(WebTarget target, String jsonInput) throws IOException {
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(jsonInput));
        System.out.println(response.getLocation());
    }
}
