package com.gs.inmemory.manageusers;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.gs.inmemory.manageusers.controller.ManageUsersController;
import com.gs.inmemory.manageusers.entity.UserDetail;
import com.gs.inmemory.manageusers.service.UserDetailServiceImpl;
import static org.mockito.Mockito.when;

@SpringBootTest
class ManageUsersApplicationTests {

	@Autowired 
	private ManageUsersController userController;

	@Test
	void contextLoads() {
		assertNotNull(userController);
	}

}
