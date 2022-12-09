package com.gs.inmemory.manageusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.gs.inmemory.manageusers.entity.UserDetail;
import com.gs.inmemory.manageusers.service.UserDetailServiceImpl;

import java.sql.SQLException;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Validated
@RestController
public class ManageUsersController {
    private static final Logger logger = LoggerFactory.getLogger(ManageUsersController.class);
    @Autowired
    UserDetailServiceImpl userDetailService;
    
    @GetMapping(value="/api/userdetails/{empid}",  produces = "application/json")
    public ResponseEntity<UserDetail> getUserDetail(@Pattern(regexp = "[0-9]+", message = "Emp Id field only accepts numeric values.") @PathVariable String empid){
        if(logger.isInfoEnabled()) {
			logger.info("Request received for fetching the user Detail.");
		}
        return new ResponseEntity<UserDetail>( userDetailService.getUserDetails(empid), HttpStatus.OK);
    } 

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/api/updateuser", consumes = "application/json")
    public ResponseEntity<UserDetail> updateUserDetail(@Valid @RequestBody UserDetail userDetail){
        if(logger.isInfoEnabled()) {
			logger.info("Request received for updating the user Detail.");
		}
        return new ResponseEntity<UserDetail>(userDetailService.updateUserDetail(userDetail), HttpStatus.OK);
    }
/*    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/api/adduser")
    public ResponseEntity<UserDetail> addUserDetail(@Valid @RequestBody UserDetail userDetail) throws SQLException{
        if(logger.isInfoEnabled()) {
			logger.info("Request received for updating the user Detail.");
		}
        return new ResponseEntity<UserDetail>(userDetailService.addUserDetail(userDetail), HttpStatus.OK);
    }*/
}
