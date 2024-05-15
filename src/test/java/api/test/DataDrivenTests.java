package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	
	// here we are creating multiple post request with multiple data with data provider
	@Test(priority=1, dataProvider= "Data", dataProviderClass= DataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String userEmail, String password, String phone) {
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
	//this will enter all data one by one multiple times.
		
		Response response= UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	// will delete user which we created 
	@Test(priority=2, dataProvider= "UserNames", dataProviderClass= DataProviders.class)
	
	public void testDeleteUserByName(String userName) {
		
		Response response= UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
	
	
}
