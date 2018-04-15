package org.dtr.modal;

public class UserDetails
{
  private int userId;
  private String userName;
  private String emailId;
  private String password;
  private String status;
  
  
  
  public int getUserId() {
    return userId;
  }
  
  public void setUserId(int userId) { this.userId = userId; }
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) { this.userName = userName; }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) { this.password = password; }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) { this.status = status; }
  
  public String getEmailId() {
    return emailId;
  }
  
  public void setEmailId(String emailId) { this.emailId = emailId; }
}