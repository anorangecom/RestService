package com.alex.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.alex.dto.Transfer;
import com.alex.dto.User;


@Path("/transfers")
public class TransferService {
	
	
	/* for demonstration purpose only static data in memory array */
	static private List<User> users = null;
	static private List<Transfer> transfers = null;	
    static {    
    	transfers = new Vector<Transfer>(1000);
    	users	= new Vector<User>(5000);
    	for (int i=0; i<1000; i++) {
    	   	users.add(i, new User(i, getRandomString(6), 1000.0)); /* to access User by id */	        	 
    	    }
    	}
		
   
    
    
    
	
 @GET
 @Path("/getTransfer/{id}")
 @Produces(MediaType.APPLICATION_XML) 
 public Transfer getTransfer(@PathParam("id") String id) {
	 int transferId = 0;
	 try {
		 transferId = Integer.parseInt(id);		 
	 	}
	 catch (NumberFormatException ex) {
		return null;
	 	}
	 
	 if (transferId >= 0  && transferId < TransferService.transfers.size()) {
		return TransferService.transfers.get(transferId);
	 	}	
		 else { 
			 return null;
		 	}
 	}
 
 
 
 @GET
 @Path("/getTransfers")
 @Produces(MediaType.APPLICATION_XML) 
 public List<Transfer> getTransfers() {
	 return TransferService.transfers;
 	}
 

 
 @GET
 @Path("/getUsers")
 @Produces(MediaType.APPLICATION_XML) 
 public List<User> getUsers() {
	 return TransferService.users;
 	}
 
 
 
 @GET
 @Path("/getUser/{id}")
 @Produces(MediaType.APPLICATION_XML) 
 public User getUser(@PathParam("id") String id) {
	 int userId = 0;
	 try {
		 userId = Integer.parseInt(id);		 
	 	}
	 catch (NumberFormatException ex) {
		return null;
	 	}
	 
	 if (userId >= 0  && userId < TransferService.users.size()) {
		return TransferService.users.get(userId);
	 	}	
		 else { 
			 return null;
		 	}
 	}
 
 
 
 
 /** returns transfer ammount if success */
 /*@POST*/
 @GET
 @Path("/transfer/{userFromId}/{userToId}/{ammount}")
 @Produces(MediaType.APPLICATION_XML) 
 public Transfer transfer(@PathParam("userFromId") String userFromId,
						 @PathParam("userToId") String userToId,
						 @PathParam("ammount") String ammount) {
	 
	 //List<String> result = new Vector<String>();
	 User userFrom = null;
	 User userTo = null;
	 Transfer transfer = null;
	 double transferAmmount = 0.0;	 
	 
	 try {
		 userFrom = TransferService.users.get(Integer.parseInt(userFromId));
		 userTo = TransferService.users.get(Integer.parseInt(userToId));
		 transferAmmount = Double.parseDouble(ammount);
		 
		 //update UserFrom balance		 
		 userFrom.setBalance(userFrom.getBalance() - transferAmmount);		 
		 
		//update UserTo balance
		userTo.setBalance(userTo.getBalance() + transferAmmount);
		 
		//add transaction to transfers list
		int nextId = TransferService.transfers.size() + 1;
		
		transfer = new Transfer(nextId, userFrom, userTo, transferAmmount);
		TransferService.transfers.add(transfer);		
		return transfer;
	 	}
	 catch (Exception ex) {
		transfer = new Transfer(0, null, null, 0.0); 
		return transfer; //"Error on transfer " + ex.getMessage();
	 	}	 
 }
 
 
 
 
 
 
 /** temp random string generator */
 static private String getRandomString(int len) {
 	//String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 	String chars = "abcdefghjjklmnopqrstuvwxyz";
 	Random rnd = new Random();    	
    StringBuilder sb = new StringBuilder( len );       
    for( int i = 0; i < len; i++ ) 
       sb.append(chars.charAt(rnd.nextInt(chars.length())));       
    return sb.toString();
 }
 
 
} 
