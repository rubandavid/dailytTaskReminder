package org.dtr.dao;

import java.util.List;
import org.dtr.modal.TaskDetails;

public  interface TaskDetailsDao
{
  public  List<TaskDetails> getTaskDetailsList();
  
  public  TaskDetails saveTaskDetails(TaskDetails taskDetails);
  
  public  List<TaskDetails> filtertaskDetails(String taskDate, String startTime, String endTime);
  
  public  TaskDetails getTaskDetailsById(int taskId);
  
  public  void deleteTaskDetailsById(int taskId);
  
  public  List<TaskDetails> filterDatatable(TaskDetails taskDetails);
}