package org.dtr.dao;

import org.dtr.modal.UserDetails;

public  interface LoginDao
{
  public  UserDetails validate(String userName, String password);
}