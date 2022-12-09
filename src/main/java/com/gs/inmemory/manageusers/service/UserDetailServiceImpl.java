package com.gs.inmemory.manageusers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gs.inmemory.manageusers.entity.UserAddress;
import com.gs.inmemory.manageusers.entity.UserDetail;
import com.gs.inmemory.manageusers.exception.ResourceNotFoundException;
import com.gs.inmemory.manageusers.repository.UserAddressRepository;
import com.gs.inmemory.manageusers.repository.UserDetailRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserDetailServiceImpl implements UserDetailService{
    
    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Autowired
    UserDetailRepository userDetailRepo;

    @Autowired
    UserAddressRepository userAddressRepo;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepository userDetailRepo) {
        this.userDetailRepo = userDetailRepo;
    }
    @Override
    @CircuitBreaker(name = "userService",
			fallbackMethod = "fallbackGetUserDetails")
    public UserDetail getUserDetails(String empid){
        if(logger.isInfoEnabled()) {
			logger.info("Fetching the User Details on basis of empid.");

		}
        
        if(!userDetailRepo.existsById(empid)){
            throw new ResourceNotFoundException("User", "empId", empid);
        }
        return userDetailRepo.findById(empid).get();
    }
/*
    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserDetail addUserDetail(UserDetail userDetailDto) throws SQLException{
        if(userDetailRepo.existsById(userDetailDto.getEmpid())){
            throw new SQLException("Record already exists");
        }
        UserAddress userAddress = userDetailDto.getAddress();
        userAddress.setEmpid(userDetailDto.getEmpid());
        userDetailDto.setAddress(userAddress);
        return userDetailRepo.save(userDetailDto);
    }*/

    @Override
    @Transactional(rollbackOn = Exception.class)
    @CircuitBreaker(name = "userService",
			fallbackMethod = "fallbackUpdateUserDetail")
    public UserDetail updateUserDetail(UserDetail userDetailDto){
        if(logger.isInfoEnabled()) {
			logger.info("Updating the User Details on basis of incoming JSON Load.");
		}
        if(!userDetailRepo.existsById(userDetailDto.getEmpid())){
            throw new ResourceNotFoundException("User Detail", "empId", userDetailDto.getEmpid());
        }
        UserAddress userAddress = userDetailDto.getAddress();
        userAddress.setEmpid(userDetailDto.getEmpid());
        userDetailDto.setAddress(userAddress);
        return userDetailRepo.save(userDetailDto);
    }

    public UserDetail fallbackUpdateUserDetail(UserDetail userDetail, Throwable exception){
        logger.error("Error encountered in updating User Detail:" + exception);
        return new UserDetail();
    }

    public UserDetail fallbackGetUserDetails(String empid, Throwable exception){
        logger.error("Error encountered in updating User Detail:" + exception);
        return new UserDetail();
    }

}
