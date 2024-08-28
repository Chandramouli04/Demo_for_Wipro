//Name:chandramouli
//date:28-8-24
package testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RestAPItestingTest {
  @Test(priority = 2)
  public void createUser() {
	  String reqBody = "{\n"
	  		+ "    \"name\": \"morpheus\",\n"
	  		+ "    \"job\": \"leader\"\n"
	  		+ "}"; 
	  given()
	    .body(reqBody)
	  .when()
	    .post("/api/users/")
	  .then()
	    .assertThat()
	    .statusCode(201);
  }
  @Test(priority = 1)
  public void getAllUsers() { 
	  given()
	  .when()
	    .get("/api/users?page=2")
	  .then()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 3)
  public void putUser() { 
	  String reqBody = "{\n"
	  		+ "    \"name\": \"morpheus\",\n"
	  		+ "    \"job\": \"zion resident\"\n"
	  		+ "}";
	  given()
	  .body(reqBody)
	  .when()
	    .put("/api/users/2")
	  .then()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 4)
  public void patchUser() { 
	  String reqBody = "{\n"
	  		+ "    \"name\": \"morpheus-updated\",\n"
	  		+ "}";
	  given()
	  .body(reqBody)
	  .when()
	    .patch("/api/users/2")
	  .then()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 5)
  public void deleteUser() { 
	 
	  given()
	  .when()
	    .delete("/api/users/2")
	  .then()
	    .assertThat()
	    .statusCode(204);
  }
  
	@BeforeClass
	public void setUp() {
		baseURI = "https://reqres.in/";
	}
}
