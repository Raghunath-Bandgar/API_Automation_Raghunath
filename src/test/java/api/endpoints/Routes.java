package api.endpoints;

//Will maintains only url's into routes.

//Swagger URI = https://petstore.swagger.io
//	
//	Create user(Post): https://petstore.swagger.io/v2/user
// Get user(Get): https://petstore.swagger.io/v2/user/{username}
// Update user(Put): https://petstore.swagger.io/v2/user/{username}
// Delete user(Delete): https://petstore.swagger.io/v2/user/{username}




/**
 * 
 * @author raghunathbandgar
 *
 */



public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	// u can create module wise URL's here 
	//Here we keep other modules URL's one by one
	
	// User Module 1...
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Module 2..
	
	
	
	//Module 3...
	
	
	
}
