package org.dtr.modal;

import java.util.Date;

public class TaskDetails
{
  private int taskId;
  private String taskDescription;
  private Date taskDate;
  private String startTime;
  private String endTime;
  private String status;
  private UserDetails userDetails;
  
  
  
  public int getTaskId() {
    return taskId;
  }
  
  public void setTaskId(int taskId) { this.taskId = taskId; }
  
  public String getTaskDescription() {
    return taskDescription;
  }
  
  public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }
  
  public Date getTaskDate() {
    return taskDate;
  }
  
  public void setTaskDate(Date taskDate) { this.taskDate = taskDate; }
  
  public String getStartTime()
  {
    return startTime;
  }
  
  public void setStartTime(String startTime) { this.startTime = startTime; }
  
  public String getEndTime() {
    return endTime;
  }
  
  public void setEndTime(String endTime) { this.endTime = endTime; }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) { this.status = status; }
  
  public UserDetails getUserDetails() {
    return userDetails;
  }
  
  public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }
}