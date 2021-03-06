package com.WebServiceJSON.model;

import java.util.ArrayList;

public class UserDetails {

	private int user_id;
	private String user_firstname;
	private String user_lastname;
	private int user_age;
	private String user_email;
	private String user_country;
	private ArrayList<UserContactDetails> user_contact_details;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_country() {
		return user_country;
	}
	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	
	public ArrayList<UserContactDetails> getUser_contact_details() {
		return user_contact_details;
	}
	public void setUser_contact_details(ArrayList<UserContactDetails> user_contact_details) {
		this.user_contact_details = user_contact_details;
	}
	
	
	public UserDetails(int user_id, String user_firstname, String user_lastname, int user_age, String user_email,
			String user_country) {
		this.user_id = user_id;
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.user_age = user_age;
		this.user_email = user_email;
		this.user_country = user_country;
	}

	
	public UserDetails(String user_firstname,
			String user_lastname, int user_age, String user_email,
			String user_country,
			ArrayList<UserContactDetails> user_contact_details) {
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.user_age = user_age;
		this.user_email = user_email;
		this.user_country = user_country;
		this.user_contact_details = user_contact_details;
	}
	public UserDetails()
	{
		super();
	}
}
