package org.dtr.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.dtr.modal.TaskDetails;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TaskDetailsDaoImpl
  implements TaskDetailsDao
{
  @Autowired
  private SessionFactory sessionfactory;
  @Autowired
  private HttpSession session;
  

  
  public List<TaskDetails> getTaskDetailsList()
  {
    return sessionfactory.getCurrentSession().createCriteria(TaskDetails.class).add(Restrictions.sqlRestriction("this_.user_id = " + session.getAttribute("userId"))).list();
  }
  


  public TaskDetails saveTaskDetails(TaskDetails taskDetails)
  {
    sessionfactory.getCurrentSession().saveOrUpdate(taskDetails);
    
    return taskDetails;
  }
  
  public List<TaskDetails> filtertaskDetails(String taskDate, String startTime, String endTime)
  {
    Criteria criteria = sessionfactory.getCurrentSession().createCriteria(TaskDetails.class);
    


    Criterion crit = Restrictions.sqlRestriction("this_.task_date= '" + taskDate + "'");
    Criterion crit1 = Restrictions.sqlRestriction("('" + startTime + "'  between this_.start_time and this_.end_time or " + "'" + endTime + "'  between this_.start_time and this_.end_time)");
    


    criteria.add(crit);
    criteria.add(crit1).add(Restrictions.sqlRestriction("this_.user_id = " + session.getAttribute("userId")));
    


    return criteria.list();
  }
  
  public TaskDetails getTaskDetailsById(int taskId)
  {
    Criteria criteria = sessionfactory.getCurrentSession().createCriteria(TaskDetails.class);
    
    criteria.add(Restrictions.eq("taskId", Integer.valueOf(taskId)));
    
    return (TaskDetails)criteria.uniqueResult();
  }
  

  public void deleteTaskDetailsById(int taskId)
  {
    TaskDetails td = new TaskDetails();
    td.setTaskId(taskId);
    
    sessionfactory.getCurrentSession().delete(td);
  }
  




  public List<TaskDetails> filterDatatable(TaskDetails taskDetails)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String taskDate = formatter.format(new Date());
    


    Query q = sessionfactory.getCurrentSession().createQuery("FROM TaskDetails td where td.taskDate= '" + taskDate + "'  and td.startTime > :startTime and td.endTime < :endTime and userDetails.userId = " + session.getAttribute("userId"));
    

    q.setParameter("startTime", taskDetails.getStartTime());
    q.setParameter("endTime", taskDetails.getEndTime());
    
    return q.list();
  }
}