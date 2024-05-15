package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created for perform create,read,update and delete requests of the user url.

public class UserEndPoints2_getdatafrom_propertiesfile {
	
	// get the URL's from properties file using the ResourceBuilder class 
	// create method for getting url from properties file.
	
	public static ResourceBundle getURL() {
		
		
		 ResourceBundle routes=ResourceBundle.getBundle("routes"); // pass the properties file name only ..no need give full path here
		return routes;
	}
	
	

	public static Response createUser(User payload) {

		// call the getURL() method here
		String post_URL = getURL().getString("post_url");
		
		
		Response res = given()
				           .contentType(ContentType.JSON) 
				           .accept(ContentType.JSON)
				           .body(payload)
				.when()
				      .post(post_URL);  //pass the variable here like .. post_url

		return res;

	}

   public static Response getUser(String userName) {
		
	    // call the getURL() method here
			String get_URL = getURL().getString("get_url");
	   
		Response res =given()
				            .pathParam("username", userName) 
		      
		              .when()
		                   .get(get_URL); //pass the variable here like .. get_URL
		
		       return res;
		
   }
   
 
   public static Response updateUser(User payload,String userName) {
		
	   // call the getURL() method here
		String put_URL = getURL().getString("put_url");
	   
	   
		Response res = given()
				             .contentType(ContentType.JSON)
				             .accept(ContentType.JSON) 
				             .pathParam("username", userName)
				             .body(payload)
				
	    	.when()
				.put(put_URL);  //pass the variable here like .. put_URL

		return res;

 		
 	
    }
    
   public static Response deleteUser(String userName) {
	   
	   // call the getURL() method here
		String delete_URL = getURL().getString("delete_url");
		
 		Response res =given()
 				            .pathParam("username", userName)
 		      
 		              .when()
 		                   .delete(delete_URL);//pass the variable here like .. delete_URL
 		
 		       return res;
 		
 	
    }
   
   
	
}
