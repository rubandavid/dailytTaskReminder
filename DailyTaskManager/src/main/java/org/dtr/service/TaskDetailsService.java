package org.dtr.service;

import java.util.List;
import org.dtr.modal.TaskDetails;

public  interface TaskDetailsService
{
  public  List<TaskDetails> getTaskDetailsList();
  
  public  TaskDetails saveTaskDetails(TaskDetails taskDetails);
  
  public  List<TaskDetails> filtertaskDetails(TaskDetails taskDetails);
  
  public  TaskDetails getTaskDetailsById(int taskId);
  
  public  void deleteTaskDetailsById(int taskId);
  
  public  List<TaskDetails> filterDatatable(TaskDetails taskDetails);
}