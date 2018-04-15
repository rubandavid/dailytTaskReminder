package org.dtr.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.dtr.modal.TaskDetails;
import org.dtr.service.TaskDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;






@Controller
public class TaskDetailsController
{
  @Autowired
  private TaskDetailsService service;
  @Autowired
  private HttpSession session;
  
  
  
  @RequestMapping("/index")
  public String index()
  {
    if (session.getAttribute("userId") == null) {
      return "redirect:/";
    }
    
    return "index";
  }
  
  @RequestMapping("/getTaskDetailsList")
  @ResponseBody
  public List<TaskDetails> getTaskDetailsList() {
    return service.getTaskDetailsList();
  }
  
  @RequestMapping("/saveTaskDetails")
  @ResponseBody
  public TaskDetails saveTaskDetails(@RequestBody TaskDetails taskDetails) { 
	  
	  return service.saveTaskDetails(taskDetails); 
	  
  }
  

  @RequestMapping("/filtertaskDetails")
  @ResponseBody
  public List<TaskDetails> filtertaskDetails(@RequestBody TaskDetails taskDetails)
  {
    return service.filtertaskDetails(taskDetails);
  }
  
  @RequestMapping("/getTaskDetailsById/{taskId}")
  @ResponseBody
  public TaskDetails getTaskDetailsById(@PathVariable int taskId)
  {
    return service.getTaskDetailsById(taskId);
  }
  
  @RequestMapping("/deleteTaskDetailsById/{taskId}")
  @ResponseBody
  public void deleteTaskDetailsById(@PathVariable int taskId)
  {
    service.deleteTaskDetailsById(taskId);
  }
  


  @RequestMapping("/filterDatatable")
  @ResponseBody
  public List<TaskDetails> filterDatatable(@RequestBody TaskDetails taskDetails)
  {
    return service.filterDatatable(taskDetails);
  }
}