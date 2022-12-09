package com.gs.inmemory.manageusers.repository;


import org.springframework.data.repository.CrudRepository;

import com.gs.inmemory.manageusers.entity.UserDetail;

public interface UserDetailRepository extends CrudRepository<UserDetail, String> {
    

}
