package com.WebServiceJSON.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserContactDetails {

	private int user_id;
	private int contact_id;
	private int phone_number;
	private String comments;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public UserContactDetails(int user_id, int contact_id, int phone_number, String comments) {
		super();
		this.user_id = user_id;
		this.contact_id = contact_id;
		this.phone_number = phone_number;
		this.comments = comments;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public UserContactDetails()
	{
		super();
	}
}
