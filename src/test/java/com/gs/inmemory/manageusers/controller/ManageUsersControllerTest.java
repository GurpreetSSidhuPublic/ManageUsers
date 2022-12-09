package com.gs.inmemory.manageusers.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.gs.inmemory.manageusers.controller.ManageUsersController;
import com.gs.inmemory.manageusers.entity.UserDetail;
import com.gs.inmemory.manageusers.service.UserDetailServiceImpl;
import com.gs.inmemory.manageusers.entity.UserAddress;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ManageUsersControllerTest {
    @Autowired 
	private ManageUsersController userController;

	@Mock
	private UserDetailServiceImpl userDetailServiceMock;

    @BeforeEach
    public static void setup() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("empid","1290");


    }

    @Test
	public void getUserDetailTest() throws Exception {
		String empid = "1290";
		UserDetail userDetail = new UserDetail(empid,"Mr", "Gurpreet","Sidhu","Male",new UserAddress(empid,"120 Trean","Sydney","NSW",128333));
        when(userDetailServiceMock.getUserDetails(empid)).thenReturn(userDetail);
		UserDetail resultDetail = userDetailServiceMock.getUserDetails(empid);
		assertEquals(userDetail.getTitle(), resultDetail.getTitle());
        assertEquals(userDetail.getFirstn(), resultDetail.getFirstn());
        assertEquals(userDetail.getLastname(), resultDetail.getLastname());
        assertEquals(userDetail.getGender(), resultDetail.getGender());
        assertEquals(userDetail.getAddress().getStreet(), resultDetail.getAddress().getStreet());
        assertEquals(userDetail.getAddress().getCity(), resultDetail.getAddress().getCity());
        assertEquals(userDetail.getAddress().getState(), resultDetail.getAddress().getState());
        assertEquals(userDetail.getAddress().getPostcode(), resultDetail.getAddress().getPostcode());
	}

    @Test
    public void updateUserDetailTest(){
          String empid = "1980";
          UserDetail userDetail = new UserDetail(empid,"Mr", "Gurpreet","Sidhu","Male",new UserAddress(empid,"120 Trean","Sydney","NSW",128333));
          when(userDetailServiceMock.updateUserDetail(userDetail)).thenReturn(userDetail);
          userDetail.setFirstn("Vikram");
          UserDetail resultDetail = userDetailServiceMock.updateUserDetail(userDetail);
          assertEquals(userDetail.getTitle(), resultDetail.getTitle());
          assertEquals("Vikram", resultDetail.getFirstn());
          assertEquals(userDetail.getLastname(), resultDetail.getLastname());
          assertEquals(userDetail.getGender(), resultDetail.getGender());
          assertEquals(userDetail.getAddress().getStreet(), resultDetail.getAddress().getStreet());
          assertEquals(userDetail.getAddress().getCity(), resultDetail.getAddress().getCity());
          assertEquals(userDetail.getAddress().getState(), resultDetail.getAddress().getState());
          assertEquals(userDetail.getAddress().getPostcode(), resultDetail.getAddress().getPostcode());
      }
}
