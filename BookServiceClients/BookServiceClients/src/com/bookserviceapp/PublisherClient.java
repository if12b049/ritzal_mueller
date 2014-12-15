package com.bookserviceapp;

import com.bookserviceapp.generated.Publisher;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phips on 15.12.2014.
 */
public class PublisherClient {
    public static void main(String[] args) throws Exception {

     /*   System.out.println("#####################################################################\n" +
                            "Usage: java PublisherClient -mode -[json-filepath] -[id] -[name]\n" +
                            "MODES:\tdelete : needs [id]; create: needs [filepath];\n" +
                            "\t\tupdate : needs  [filepath]; find : needs [id] or [name]\n" +
                            "#####################################################################");

    */
    System.out.println("Usage: java PublisherClient -json_filepath");
    if(args[0].isEmpty()) {
        System.out.println("Error: No Filename found!");
        return;
    }

    WebTarget target = ClientBuilder
            .newClient()
            //.register(new RequestFilter("myuser", "topsecret"))
            .target("http://localhost:8080/BookServiceWebAppWeb/resources/publisher");

    createPublisher(target,readFile(args[0]));
    }

    private static String readFile(String filename) throws IOException {
        //Parse to String in order to get a "good" json-format
        String json = new String();
        ArrayList<String> readString = (ArrayList<String>) Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        for(String tmp : readString) json += tmp;
        return json;
    }
    private static void createPublisher(WebTarget target, String jsonInput) throws IOException {
       //String jsonTestInput = "[{\"name\":\"ClientTest1\",\"postcode\":\"ASD-110\",\"countrycode\":\"USA\"}]";
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(jsonInput));
        System.out.println(response.getLocation());
    }
    /*** Not Used ***/
    private static List getPublisher(WebTarget target, Integer id, String name) {
        List publishers = new ArrayList();
        if (id == null && name == null) {
            //Get all Publisher
            publishers = target
                    .request(MediaType.APPLICATION_JSON)
                    .get(List.class);
        }
        else if(id != null){
            publishers = target
                    .path("/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .get(List.class);
        }
        else if(!name.isEmpty()){
            publishers = target
                    .path("name/{name}")
                    .resolveTemplate("name", name)
                    .request(MediaType.APPLICATION_JSON)
                    .get(List.class);
        }

        return publishers;
    }
}
