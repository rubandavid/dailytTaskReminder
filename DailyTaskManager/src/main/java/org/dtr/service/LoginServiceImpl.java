package org.dtr.service;

import javax.servlet.http.HttpSession;

import org.dtr.controller.LoginController;
import org.dtr.dao.LoginDao;
import org.dtr.modal.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
  @Autowired
  private LoginDao logindao;
  @Autowired
  private HttpSession session;
  
  
  
  public String validate(String userName, String password)
  {
    UserDetails ud = logindao.validate(userName, password);
    
    if (ud != null)
    {
      session.setAttribute("userId", Integer.valueOf(ud.getUserId()));
      session.setAttribute("userName", ud.getUserName());
      session.setAttribute("emailId", ud.getEmailId());
      return "index";
    }
    
    LoginController.msg = "* invalid credintials";
    
    return "fail";
  }
}