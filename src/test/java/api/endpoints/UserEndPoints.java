package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created for perform create,read,update and delete requests of the user url.

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response res = given()
				           .contentType(ContentType.JSON) 
				           .accept(ContentType.JSON)
				           .body(payload)
				.when()
				      .post(Routes.post_url);

		return res;

	}

   public static Response getUser(String userName) {
		
		Response res =given()
				            .pathParam("username", userName) 
		      
		              .when()
		                   .get(Routes.get_url);
		
		       return res;
		
   }
   
//   public static Response readUser(String username){
//		
//		Response response= given()
//         .pathParam("username", username)
//		.when()
//		.get(Routes.get_url);
//		
//		return response;
//	}
   
   
   public static Response updateUser(User payload,String userName) {
		
		Response res = given()
				             .contentType(ContentType.JSON)
				             .accept(ContentType.JSON) 
				             .pathParam("username", userName)
				             .body(payload)
				
	    	.when()
				.put(Routes.put_url);

		return res;

 		
 	
    }
    
   public static Response deleteUser(String userName) {
		
 		Response res =given()
 				            .pathParam("username", userName)
 		      
 		              .when()
 		                   .delete(Routes.delete_url);
 		
 		       return res;
 		
 	
    }
   
   
	
}
