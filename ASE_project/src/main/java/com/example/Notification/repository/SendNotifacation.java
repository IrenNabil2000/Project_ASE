package com.example.Notification.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Repository;

import com.example.Notification.model.NotificationTemplate;

@Repository("sentRepo")
public class SendNotifacation {
	  private Queue<NotificationTemplate> smsQueue=new LinkedList<>();
	    private Queue<NotificationTemplate> mailQueue=new LinkedList<>();
	
	public boolean Ready(NotificationTemplate template)
	{
		Connection con =null; 
		boolean f=false;

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
	   String line = "INSERT INTO Ready(Content,Subject,Language,Channel,too,item,type,ID) VALUES("
               + "'" + template.getContent()+ "',"
               + "'" + template.getSubject() + "',"
                + "'" + template.getLanguage().toString()+ "',"
                + "'" + template.getChannel()+ "',"
               + "'" + template.getTo()+ "',"
               + "'" + template.getItem()+ "',"
               + "'" + template.getType()+ "',"
               + template.getId()+")";
       int Rows = Stmt.executeUpdate(line);
		if(template.getChannel().equalsIgnoreCase("email"))
		{
			f=true;
			
			mailQueue.add(template);
			
		}
		else
		{
			f=true;
			smsQueue.add(template);
			
		}
	    } catch(SQLException e){

		     System.out.println(e);
		     f=false;

		    }
	    return f;
	}
	
	public boolean sent() {
		Connection con =null; 
		boolean f= false;
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Sprint3;user=root;password=1234"; 

	    try{

	    con=DriverManager.getConnection(connectionURL);
	    Statement Stmt=null;
	  ResultSet RS=null;
	   Stmt = con.createStatement();
		Iterator<NotificationTemplate> iterator = smsQueue.iterator();
		Iterator<NotificationTemplate> iterator2 = mailQueue.iterator();
		boolean flagi1=iterator.hasNext();
		boolean flagi2=iterator2.hasNext();
        	while(flagi1||flagi2) {
        		
        		if(flagi1) {
        		NotificationTemplate t=iterator.next();
        		String line = "INSERT INTO Sent(Content,Subject,Language,Channel,too,item,type,ID) VALUES("
        	               + "'" +t.getContent()+ "',"
        	               + "'" +t.getSubject()+ "',"
        	                + "'" + t.getLanguage().toString()+ "',"
        	                + "'" +t.getChannel() + "',"
        	               + "'" +t.getTo()+ "',"
        	               + "'" + t.getItem()+ "',"
        	               + "'" + t.getType()+ "',"
        	               + t.getId()+")";
        	       Stmt.executeUpdate(line);
        	       Stmt.executeUpdate("DELETE FROM Ready WHERE ID="+t.getId()+";");
        	       f=true;
        		}
        	       
        	       //===================================================================================
        		else {
        	       NotificationTemplate t2=iterator2.next();
           		String line2 = "INSERT INTO Sent(Content,Subject,Language,Channel,too,item,type,ID) VALUES("
           	               + "'" +t2.getContent()+ "',"
           	               + "'" +t2.getSubject()+ "',"
           	                + "'" + t2.getLanguage().toString()+ "',"
           	                + "'" +t2.getChannel() + "',"
           	               + "'" +t2.getTo()+ "',"
           	               + "'" + t2.getItem()+ "',"
           	               + "'" + t2.getType()+ "',"
           	               + t2.getId()+")";
           	       Stmt.executeUpdate(line2);
           	       Stmt.executeUpdate("DELETE FROM Ready WHERE ID="+t2.getId()+";");
           	       f= true;
        		}
        		flagi1=iterator.hasNext();
        		flagi2=iterator2.hasNext();
           	   
        	}
	    }
	    catch(SQLException e){

		     System.out.println(e);
		    

		    }
	    return f;
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
