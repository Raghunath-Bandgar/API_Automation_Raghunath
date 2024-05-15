package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setup() {

		// this is payload is pass in post and put request

		faker = new Faker(); // create object of faker class for creating dummy data.
		userPayload = new User(); // create object of pojo class.

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	// now we are writing the test cases one by one
	
	@Test(priority=1)
	public void testPostUser() {
		
		logger.info("************* creating the user ****************");
		
		Response res = UserEndPoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("************* User is Created ****************");
	}
			
	
	@Test(priority=2)
	public void testGetUser() {
		
		logger.info("************* getting the user info****************");
		Response res = UserEndPoints.getUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("************* user info getting displayed ****************");
	}
			
	@Test(priority=3)
	public void testUpdateUser() {
		
		
		// update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		
		logger.info("************* updating the user ****************");
		
		Response res = UserEndPoints.updateUser(userPayload,this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("************* user updated ****************");
		
		// checking the response after data update
		
		Response res1 = UserEndPoints.getUser(this.userPayload.getUsername());
		res1.then().log().all();
		Assert.assertEquals(res1.getStatusCode(), 200);
		
			}
	
	
	@Test(priority=4)
	public void testDeleteUser() {
		
		logger.info("************* deleting the user ****************");
		
		Response res = UserEndPoints.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("************* user deleted ****************");
	}
	
	
}
