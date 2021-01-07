package com.example.Notification.repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.stereotype.Repository;

import com.example.Notification.model.NotificationTemplate;

@Repository("sentRepo")
public class SendNotifacation {
	 SendConnection sen = new SendConnection();

	
	public boolean Ready(NotificationTemplate template)
	{
		return sen.Ready(template);
	}
	
	public boolean sent() {
		return sen.sent();
	}
	
	/*
	public Queue<NotificationTemplate> read (Queue<NotificationTemplate>t) {

        Iterator<NotificationTemplate> iterator = t.iterator();
        if(iterator.next().getChannel().equalsIgnoreCase("sms"))
        	return smsQueue;
        else
        	return mailQueue;   
}*/
	public void display() {
		 Connection con =null; 

 	    try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

 	    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Sprint3;user=root;password=1234"; 

 	    try{

 	    con=DriverManager.getConnection(connectionURL);
 	    System.out.println("Connection is successfull");
 	    Statement Stmt=null;
 	  ResultSet RS=null;
 	   Stmt = con.createStatement();
 	    RS = Stmt.executeQuery("SELECT * FROM Ready;");
 	    
 	    while(RS.next()){
 	    	 System.out.println("Subject: "+RS.getString("Subject"));
 	        System.out.println("Content: "+"Dear,"+RS.getString("too")+" "+RS.getString("Content"));
 	        System.out.println("Language: "+RS.getString("Language"));
 	        System.out.println("Channel: "+RS.getString("Channel"));
 	    }
 	    con.close();
 	    }

 	    

 	    catch(SQLException e){

 	     System.out.println(e);

 	    }
}
    

}
