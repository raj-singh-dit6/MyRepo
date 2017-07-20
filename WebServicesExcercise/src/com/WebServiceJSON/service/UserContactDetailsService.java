package com.WebServiceJSON.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.WebServiceJSON.dao.UserContactDetailsDao;
import com.WebServiceJSON.model.UserDetails;
@Path("/UserContactDetailsService")
public class UserContactDetailsService {

	UserContactDetailsDao aUCDDaoObj=new UserContactDetailsDao();
	@GET
	@Path("/userContacts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> getTrackInJSON() throws SQLException {
		
		return aUCDDaoObj.mGetUserContactDetails();
	}
}
