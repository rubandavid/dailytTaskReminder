package org.dtr.service;

import org.dtr.dao.UserDetailsDao;
import org.dtr.modal.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSErviceImpl implements UserDetailsService
{
  @Autowired
  private UserDetailsDao dao;
  

  
  public UserDetails registerUser(UserDetails userDetails)
  {
    return dao.registerUser(userDetails);
  }
}