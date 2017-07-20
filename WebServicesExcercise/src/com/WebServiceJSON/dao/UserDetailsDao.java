package com.WebServiceJSON.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.WebServiceJSON.model.UserDetails;
import com.WebServiceJSON.utilities.DBConnection;

public class UserDetailsDao {

	DBConnection aDBobj=new DBConnection();
	Connection aConnObj=null;
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String,UserDetails>> mGetUserDetails() throws SQLException
	{ 	List<HashMap<String,UserDetails>> lUserDetailsList=new ArrayList<HashMap<String,UserDetails>>();
		try{
			aConnObj=aDBobj.mGetConnection();
			Statement lStatementObj=aConnObj.createStatement();
			String lQuery="select * from user_details";
			ResultSet lRs=lStatementObj.executeQuery(lQuery);
			while(lRs.next())
			{	UserDetails lUserDObj=new UserDetails();
			HashMap<String,UserDetails> lMap=new HashMap<String,UserDetails>();
				lUserDObj.setUser_id(lRs.getInt("user_id"));
				lUserDObj.setUser_firstname(lRs.getString("user_firstname"));
				lUserDObj.setUser_lastname(lRs.getString("user_lastname"));
				lUserDObj.setUser_age(lRs.getInt("user_age"));
				lUserDObj.setUser_email(lRs.getString("user_email"));
				lUserDObj.setUser_country(lRs.getString("user_country"));
				lUserDetailsList.addAll((Collection<? extends HashMap<String, UserDetails>>) lMap.put("success", lUserDObj));
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return lUserDetailsList;
	}
}
