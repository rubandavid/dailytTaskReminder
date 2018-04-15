package org.dtr.service;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.dtr.dao.TaskDetailsDao;
import org.dtr.modal.TaskDetails;
import org.dtr.modal.UserDetails;
import org.dtr.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TaskDetailsServiceImpl implements TaskDetailsService
{
  @Autowired
  private TaskDetailsDao taskDetails;
  @Autowired
  private HttpSession session;
  
 
  
  public List<TaskDetails> getTaskDetailsList()
  {
    return taskDetails.getTaskDetailsList();
  }
  
  public TaskDetails saveTaskDetails(TaskDetails taskDetails)
  {
    UserDetails user = taskDetails.getUserDetails();
    
    user.setUserId(((Integer)session.getAttribute("userId")).intValue());
    user.setUserName((String)session.getAttribute("userName"));
    
    taskDetails.setUserDetails(user);
    
    if (taskDetails.getStatus().equals("Completed"))
    {
      SendEmail.sendEmail(new String[] {(String)session.getAttribute("emailId"), (String)session.getAttribute("userName"), taskDetails.getTaskDescription() });
    }
    
    return this.taskDetails.saveTaskDetails(taskDetails);
  }
  
  public List<TaskDetails> filtertaskDetails(TaskDetails taskDetails)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String strDate = formatter.format(taskDetails.getTaskDate());
    
    String taskDate = strDate;
    String startTime = taskDetails.getStartTime();
    String endTime = taskDetails.getEndTime();
    


    return this.taskDetails.filtertaskDetails(taskDate, startTime, endTime);
  }
  
  public TaskDetails getTaskDetailsById(int taskId)
  {
    return taskDetails.getTaskDetailsById(taskId);
  }
  
  public void deleteTaskDetailsById(int taskId)
  {
    taskDetails.deleteTaskDetailsById(taskId);
  }
  

  public List<TaskDetails> filterDatatable(TaskDetails taskDetails)
  {
    return this.taskDetails.filterDatatable(taskDetails);
  }
}
