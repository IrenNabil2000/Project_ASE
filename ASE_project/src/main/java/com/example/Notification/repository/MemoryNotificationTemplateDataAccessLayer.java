package com.example.Notification.repository;

import java.util.ArrayList;


import com.example.Notification.model.*;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Repository("notifyRepo")
public class MemoryNotificationTemplateDataAccessLayer implements INotificationTemplateDataAccessLayer  {

	TemplateConnection temp=new TemplateConnection();
	@Override
     public boolean AddTemplate( NotificationTemplate template) {
		     temp.AddTemplate(template);
     }
	
	@Override
    public  boolean DeleteTemplate(Integer templateId)
    {  
		temp.DeleteTemplate(templateId);
	}
	
	
    public boolean UpdateTemplate(NotificationTemplate template)
    {
    	
        temp.UpdateTemplate(template);
    }
    
	@Override
    public NotificationTemplate GetTemplate(Integer templateId)
    {
		temp.GetTemplate(templateId);
    }

    public  ArrayList<NotificationTemplate> GetAllTemplates() {
    }
    public void display(){

    	 Connection con =null; 

    	    try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Sprint3;user=roott;password=1234"; 

    	    try{

    	    con=DriverManager.getConnection(connectionURL);
    	    System.out.println("Connection is successfull");
    	    Statement Stmt=null;
    	  ResultSet RS=null;
    	   Stmt = con.createStatement();
    	    RS = Stmt.executeQuery("SELECT * FROM Template;");
    	    
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
  
    public void displayTemplate(NotificationTemplate t) {
    	System.out.println("Subject:" + t.getSubject() +
                    "\n" + "content:" + t.getContent() + "\n" +
                    "Lang:" + t.getLanguage()+"\n "+"Channel: "+t.getChannel());

    }
	public void display(ArrayList<NotificationTemplate>t) {
		for(int i=0;i<t.size();i++)
		{
	
		System.out.println("subject: "+t.get(i).getSubject()+"\n content:"+t.get(i).getContent()+"\n language:"+
				t.get(i).getLanguage()+"\n Channel: "+t.get(i).getChannel());
		}
		}


}
