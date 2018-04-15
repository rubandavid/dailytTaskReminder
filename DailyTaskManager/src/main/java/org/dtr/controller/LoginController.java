package org.dtr.controller;

import javax.servlet.http.HttpSession;
import org.dtr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class LoginController
{
  @Autowired
  private LoginService service;
  @Autowired
  private HttpSession session;
  public static String msg = "";
  
  
  
  @RequestMapping("/")
  public String welcomePage() { session.setAttribute("msg", msg);
    
    return "login";
  }
  

  @RequestMapping("/validateUser")
  public String validate(@RequestParam String userName, @RequestParam String password)
  {
    return "redirect:/" + service.validate(userName, password);
  }
  

  @RequestMapping("/logout")
  public String logout()
  {
    session.invalidate();
    return "redirect:/";
  }
  

  @RequestMapping("/fail")
  public String fail()
  {
    session.setAttribute("msg", msg);
    
    msg = "";
    
    return "login";
  }
}