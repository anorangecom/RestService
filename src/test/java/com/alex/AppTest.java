package com.alex;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alex.dto.Transfer;
import com.alex.dto.User;
import com.alex.rest.TransferService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AppTest {
	
	private static final double DELTA = 1e-15;

	@Test
    public void AppTest()   {
        //Assert.assertTrue( true );
                
        TransferService s = new TransferService();        
        User u = s.getUser("1");        
        Assert.assertEquals(u.getId(), 1);
        
                
        Transfer t = s.transfer("1", "2", "100.0");
        Assert.assertEquals(t.getUserTo().getBalance(), 1100.0, DELTA);
        Assert.assertEquals(t.getUserFrom().getBalance(), 900.0, DELTA);
        
                
        
        }
	
	
    /*
    @Test
    public void testStatus() throws IOException {
	    Client client = Client.create();
		WebResource webResource = client.resource(Constants.url + "getUser/1");
		ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);		
		Assert.assertEquals(response.getStatus(), 200);
		
		//if (response.getStatus() != 200) {
		//   throw new RuntimeException("Failed : HTTP error code : "
		//	+ response.getStatus());
		//}	
	    //String output = response.getEntity(String.class);
		//User output = response.getEntity(User.class);	//Get the object from the response		
		//System.out.println("Output xml client .... \n");
		//System.out.println(output);
    } */
	
}