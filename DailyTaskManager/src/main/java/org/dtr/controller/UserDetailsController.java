package org.dtr.controller;

import org.dtr.modal.UserDetails;
import org.dtr.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserDetailsController
{
  @Autowired
  private UserDetailsService service;
  
  
  
  @RequestMapping("/register")
  @ResponseBody
  public UserDetails registerUser(@RequestBody UserDetails userDetails)
  {
    return service.registerUser(userDetails);
  }
}