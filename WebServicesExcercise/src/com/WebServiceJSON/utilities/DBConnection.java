package com.WebServiceJSON.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DBConnection {
	
		private String 	aDBName,aDBUser,aDBPassword,aDBHostName,aDBPortNumber;
		public Connection mGetConnection()
		{
			Connection lConnection = null;
			try
			{		
				PropertyResourceBundle lResourceFile = (PropertyResourceBundle) ResourceBundle.getBundle("DBConfig"); 
				aDBName = lResourceFile.getString("DatabaseName").trim();
				aDBUser = lResourceFile.getString("UserName").trim();
				aDBPassword = lResourceFile.getString("Password").trim();
				aDBPortNumber = lResourceFile.getString("PortNumber").trim();
				aDBHostName = lResourceFile.getString("HostName").trim();
				String lConnectionURL = "jdbc:mysql://"+this.aDBHostName+":"+this.aDBPortNumber+"/"+this.aDBName;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				lConnection = DriverManager.getConnection(lConnectionURL, this.aDBUser, this.aDBPassword);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("cDBConnection Exception: "+e.getMessage());
			}		
			return lConnection;		
		}
		
		public void mCloseConnection (Connection pConnectionObj) {
			if(pConnectionObj!=null)
				try {
					pConnectionObj.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("cDBConnection Connection close, Exception: "+e.getMessage());
				}
		}
}

