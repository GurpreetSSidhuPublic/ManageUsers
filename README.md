# ManageUsers
API for managing User Details using an In Memory DB
This API is based on Java 1.8 and Spring Boot 2.7.6.

How to Run
This application has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it through the IDE terminal.

Clone this repository
1. Make sure you are using JDK 1.8 and Maven 3.x
2. Open the project in any IDE (Intellij, VS-Code).
3. You can build the project and run the tests by running mvn clean package
4. Once successfully built, Open the terminal and run: For powershell  ".\mvnw clean spring-boot:run", For Mac "./mvnw clean spring-boot:run".

The API uses H2 In-Memory Database:
1. Database can be accessed at "http://localhost:8080/h2"
2. User for database - "admin", Password- Empty
3. Six records are inserted in the DB at application startup from "ManageUsersApplication.java".
4. There are two tables: 1. UserDetail - Containing the details of the user. Empid as primary key.
						 2. UserAddress - Containing the address of the user. It has one to one mapping with User detail joined on the basis of empid field.


For User acces control, there are two Profiles. Postman scripts have the users set as Basic  Auth.
1. ADMIN (UserId-"Admin", Password-"Password") --- Can perform both calls.
2. readonly (UserId-"nonadmin", Password-"nonadmin") -- Can only perform get call to fetch users.

There are 2 Rest calls:
1. getUserDetail( @PathVariable String empid) --- To fetch the user details. Called by "http://localhost:8080/api/userdetails/{empid}"
2. updateUserDetail(@Valid @RequestBody UserDetail userDetail) --- To update the user details. Called by "http://localhost:8080/api/updateuser"
	The user update can be done by sending the complete JSON package with updates to the required fields. Postman script has the JSON loaded as part of Body.
3. I have written call to add the user for my testing and didn't remove it. It is commented and can be used as reference. Its postman script is present in the repo. Circuit Breaker is not implemented on this.
	Called by "http://localhost:8080/api/adduser".