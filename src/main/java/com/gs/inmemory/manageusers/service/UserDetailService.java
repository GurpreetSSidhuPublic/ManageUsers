package com.gs.inmemory.manageusers.service;

import java.sql.SQLException;

import com.gs.inmemory.manageusers.entity.UserDetail;

public interface UserDetailService {
   UserDetail getUserDetails(String empid);

   //UserDetail addUserDetail(UserDetail userDetailDto) throws SQLException;

   UserDetail updateUserDetail(UserDetail userDetailDto);
}
