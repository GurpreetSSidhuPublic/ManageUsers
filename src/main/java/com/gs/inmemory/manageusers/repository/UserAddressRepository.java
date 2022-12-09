package com.gs.inmemory.manageusers.repository;

import org.springframework.data.repository.CrudRepository;

import com.gs.inmemory.manageusers.entity.UserAddress;


public interface UserAddressRepository extends  CrudRepository<UserAddress, String> {
 
}

