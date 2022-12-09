package com.gs.inmemory.manageusers.service;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;


import com.gs.inmemory.manageusers.entity.UserAddress;
import com.gs.inmemory.manageusers.entity.UserDetail;
import com.gs.inmemory.manageusers.repository.UserDetailRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailServiceImplStubTest {
    
    @Mock
    UserDetailRepository userDetailRepo;

    @InjectMocks
    UserDetailServiceImpl userDetailService;


    @Test
    public void getUserDetailsTest(){

        String empid = "1999";
        UserDetail userDetail = new UserDetail(empid,"Mr", "Gurpreet","Sidhu","Male",new UserAddress(empid,"120 Trean","Sydney","NSW",128333));
        when(userDetailRepo.findById(empid)).thenReturn(Optional.of(userDetail));
        when(userDetailRepo.existsById(empid)).thenReturn(true);
        UserDetail resultDetail = userDetailService.getUserDetails(empid);
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
          when(userDetailRepo.save(userDetail)).thenReturn(userDetail);
          when(userDetailRepo.existsById(empid)).thenReturn(true);
          userDetail.setFirstn("Vikram");
          UserDetail resultDetail = userDetailService.updateUserDetail(userDetail);
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
