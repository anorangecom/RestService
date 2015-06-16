package com.alex.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.alex.Constants;
import com.alex.dto.User;

public class JsonClient {

	public static void main(String[] args) {
		Client client = Client.create();
		
		//Get
		WebResource webResource = client.resource(Constants.url + "getUser/1/");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus() + " response->" + response.toString());
		}
		
		//String output = response.getEntity(String.class);
		User output = response.getEntity(User.class);//Get the object from the response		
		System.out.println("Output json client .... \n");
		System.out.println(output);
		
		//Post
		webResource = client.resource(Constants.url + "transfer/1/2/100.0");
		webResource.accept("application/json").post(ClientResponse.class, output);		
	}
}