package com.WebServiceJSON.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.WebServiceJSON.dao.UserDetailsDao;
import com.WebServiceJSON.model.UserDetails;

@Path("/UserDetailsService")
public class UserDetailsService {
	
	UserDetailsDao aUDDaoObj=new UserDetailsDao();
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HashMap<String,UserDetails>> getTrackInJSON() throws SQLException {
		
		return aUDDaoObj.mGetUserDetails();
	}
}