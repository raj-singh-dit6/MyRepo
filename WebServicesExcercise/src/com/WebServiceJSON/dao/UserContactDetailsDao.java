package com.WebServiceJSON.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.WebServiceJSON.model.UserContactDetails;
import com.WebServiceJSON.model.UserDetails;
import com.WebServiceJSON.utilities.DBConnection;

public class UserContactDetailsDao {

	DBConnection aDBobj=new DBConnection();
	Connection aConnObj=null;
	
	public List<UserDetails> mGetUserContactDetails() throws SQLException
	{ 	List<UserDetails> lUserContactDetailsFinalList=new ArrayList<UserDetails>();
		try{
			aConnObj=aDBobj.mGetConnection();
			Statement lStatementObj=aConnObj.createStatement();
			String lQuery="select * from user_details";
			ResultSet lRs=lStatementObj.executeQuery(lQuery);
			while(lRs.next())
			{	UserDetails lUserDObj=new UserDetails();
				lUserDObj.setUser_id(lRs.getInt("user_id"));
				lUserDObj.setUser_firstname(lRs.getString("user_firstname"));
				lUserDObj.setUser_lastname(lRs.getString("user_lastname"));
				lUserDObj.setUser_age(lRs.getInt("user_age"));
				lUserDObj.setUser_email(lRs.getString("user_email"));
				lUserDObj.setUser_country(lRs.getString("user_country"));
				
				int lUserID=lRs.getInt("user_id");
				String lQuery1="Select * from user_contact_details where user_id="+lUserID;
				ResultSet lRs1=lStatementObj.executeQuery(lQuery1);
				
				ArrayList<UserContactDetails> lUserContactDetailsList= new ArrayList<UserContactDetails>();
				while(lRs1.next())
				{ 
					UserContactDetails lUserCDobj=new UserContactDetails();
					lUserCDobj.setContact_id(lRs1.getInt("contact_id"));
					lUserCDobj.setPhone_number(lRs1.getInt("phone_number"));
					lUserCDobj.setComments(lRs1.getString("comments"));
					lUserContactDetailsList.add(lUserCDobj);
				}
				lUserDObj.setUser_contact_details(lUserContactDetailsList);
				lUserContactDetailsFinalList.add(lUserDObj);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return lUserContactDetailsFinalList;
	}
	
}
