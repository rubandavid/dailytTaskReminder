package org.dtr.dao;

import javax.transaction.Transactional;

import org.dtr.modal.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao
{
  @Autowired
  private SessionFactory sessionfactory;
  
  
  
  public UserDetails validate(String userName, String password)
  {
    return (UserDetails)sessionfactory.getCurrentSession().createCriteria(UserDetails.class).add(Restrictions.eq("emailId", userName)).add(Restrictions.eq("password", password)).uniqueResult();
  }
}