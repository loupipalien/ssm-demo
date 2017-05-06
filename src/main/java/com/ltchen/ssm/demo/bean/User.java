package com.ltchen.ssm.demo.bean;

public class User {
    private int id;//ID
    private String username;//用户名
    private String password;//密码
    private Gender gender;//性别
    private boolean isActive;//是否激活
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
          return username;
    }
    public void setUsername(String username) {
          this.username = username;
    }
    public String getPassword() {
          return password;
    }
    public void setPassword(String password) {
          this.password = password;
    }
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public User(){}
	
	public User(String username, String password, Gender gender, boolean isActive) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", isActive=" + isActive + "]";
	}
  
}

