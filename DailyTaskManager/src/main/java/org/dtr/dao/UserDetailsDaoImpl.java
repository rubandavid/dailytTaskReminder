package org.dtr.dao;

import javax.transaction.Transactional;
import org.dtr.modal.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao
{
  @Autowired
  private SessionFactory sessionfactory;
  

  public UserDetails registerUser(UserDetails userDetails)
  {
    sessionfactory.getCurrentSession().save(userDetails);
    
    return userDetails;
  }
}