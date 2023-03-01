package com.example.ems;
//import org.apache.commons.codec.digest.DigestUtils;
import java.util.Objects;

public abstract class Person {
	/*
	 *   Data fields:
	 *       username:String
	 *       password:String
	 *       name:String
	 *       mobileNumber:String
	 *       emailAddress:String
	 *   Methods:
	 *       register():void
	 *       register(username:String,password:String):void
	 *       login(username:String, password:String):void
	 *       verifyLogin():bool ???????????????????????????????
	 *       logout():void
	 * */
	private String username;
	private String password;
	private String name;
	private String mobileNumber;
	private String emailAddress;
	private boolean isLoggedInFlag = false;
	private boolean isAdminFlag = false;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isLoggedIn() {
		return this.isLoggedInFlag;
	}
	public boolean isAdmin() {
		return this.isAdminFlag;
	}
	
	
	public void login(String username, String password) {
		this.isLoggedInFlag =
				Objects.equals(
						username,
						this.username
				)
						&
						Objects.equals(
								password,
								this.password
						);
	}
	public void logout() {
		isLoggedInFlag = false;
	}
	
	public Person(String username, String password, String name, String mobileNumber, String emailAddress, String type) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		if(type.equals("admin")) this.isAdminFlag = true;
	}
	public void printData() {
		System.out.println("Username : " + username);
		System.out.println("Name     : " + name);
		System.out.println("Number   : " + mobileNumber);
		System.out.println("Email    : " + emailAddress);
		
	}
	/*public static void main(String[] args) {
		Student Ziad = new Student("ZiadAmerr", "a", "Ziad Amerr", "01007130602", "ziad.amerr@yahoo.com");
	}*/
	
	/*public static void main(String[] args) {
		Person Ziad = new Person("ZiadAmerr", "PasswordX", "Ziad Amerr", "01007130602", "ziad.amerr@yahoo.com", "Student");
		//Ziad.printData();
		//Ziad.login("ZiadAmerr", "PasswordX");
		//Ziad.logout();
		//System.out.println(Ziad.isLoggedIn());
	}*/
}