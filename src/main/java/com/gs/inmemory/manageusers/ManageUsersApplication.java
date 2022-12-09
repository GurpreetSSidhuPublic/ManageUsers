package com.gs.inmemory.manageusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gs.inmemory.manageusers.entity.UserAddress;
import com.gs.inmemory.manageusers.entity.UserDetail;
import com.gs.inmemory.manageusers.repository.UserAddressRepository;
import com.gs.inmemory.manageusers.repository.UserDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@SpringBootApplication
public class ManageUsersApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(ManageUsersApplication.class);

	@Autowired
	UserDetailRepository userDetailRepo;
	@Autowired
	UserAddressRepository userAddressRepo;
	public static void main(String[] args) {
		if(logger.isInfoEnabled()) {
			logger.info("Starting the Manage Users Spring Boot Application.");
		}
		SpringApplication.run(ManageUsersApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		UserDetail[] users = new UserDetail[] {
			new UserDetail("120","Mr", "Gurpreet","Sidhu","Male",new UserAddress("120","120 Trean","Sydney","NSW",128333)),
			new UserDetail("121","Mr", "Vinod","Sampath","Male",new UserAddress("121","14 Sunny View","Sydney","NSW",120099)),
			new UserDetail("122","Mrs", "Sri","Sri","Female",new UserAddress("122","7 AppleTree","Sydney","NSW",120033)),
			new UserDetail("123","Mr", "Harry","Dev","Male",new UserAddress("123","1 Tredue St","Melbourne","Victoria",128531)),
			new UserDetail("124","Mr", "Garry","Kumar","Male",new UserAddress("124","High Road","Adelaide","Victoria",120091)),
			new UserDetail("125","Miss", "Suvinya","Gaur","Female",new UserAddress("125","55 Macker St","Central Coast","NSW",120490)),
			};
		for(int i=0; i<users.length; i++){
			userDetailRepo.save(users[i]);
		}
	}
}
