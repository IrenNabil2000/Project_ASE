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
	
    public boolean languageValidations(String languageInput) {
        
        if(languageInput.equalsIgnoreCase("English" )|| languageInput.equalsIgnoreCase("Arabic")) {
            return true;
        }
        else
            return false;
    }
    
	@Override
     public boolean AddTemplate( NotificationTemplate template) {
		Connection con =null; 
		boolean flag = true;
	 
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
	 
	   Stmt = con.createStatement();
	   
       
           if (languageValidations(template.getLanguage())) {

               flag = true;
           } else {
               System.out.println("Please choose English or Arabic only");
               flag = false;
           }
           if (flag == true) {
        	   String line = "INSERT INTO Template(Content,Subject,Language,Channel,too,item,type,ID) VALUES("
                       + "'" + template.getContent()+ "',"
                       + "'" + template.getSubject() + "',"
                        + "'" + template.getLanguage()+ "',"
                        + "'" + template.getChannel()+ "',"
                       + "'" + template.getTo()+ "',"
                       + "'" + template.getItem()+ "',"
                       + "'" + template.getType()+ "',"
                       + template.getId()+")";
               Stmt.executeUpdate(line);   
           }
	    }
	    catch(SQLException e){

	     System.out.println(e);

	    }
		return (flag);     
     }
	
	@Override
    public  boolean DeleteTemplate(Integer templateId)
    {  
    int Rows=0;

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
	   Stmt = con.createStatement();
	   String line="DELETE FROM Template WHERE ID= "+templateId;
	  Rows = Stmt.executeUpdate(line);
	  
	   
        
	    }
	    catch(SQLException e){

		     System.out.println(e);

		    }
	    if(Rows!=0)
			   return true;
	    
		return false;
	    
	    }
	
	
    public boolean UpdateTemplate(NotificationTemplate template)
    {
    	
        int Rows=0;

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
    	   Stmt = con.createStatement();
           String line="UPDATE Template  SET Content=' "+template.getContent()+
                       "' , Subject=' "+template.getSubject()+
                       "' ,Language=' "+template.getLanguage()
                       +" ',Channel='"+template.getChannel()+
                       " ' ,too='"+template.getTo()+
                       "',item='"+template.getItem()+
                       " ', type=' "+template.getType()+
                       " ' WHERE ID= "+template.getId();
    	  Rows = Stmt.executeUpdate(line);
       
    	    }
    	    catch(SQLException e){

    		     System.out.println(e);

    		    }
    	    if(Rows!=0)
    			   return true;
    	    
    		return false;
    }
    
	@Override
    public NotificationTemplate GetTemplate(Integer templateId)
    {
		ResultSet RS=null;
	   
	    NotificationTemplate t=new NotificationTemplate();
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
		   Stmt = con.createStatement();
		   RS = Stmt.executeQuery("SELECT * FROM Template WHERE ID= "+templateId);
		  
		    while(RS.next()){
		    	t.setSubject(RS.getString("Subject"));
		        t.setContent("Dear,"+RS.getString("too")+" "+RS.getString("Content"));
		        t.setChannel(RS.getString("Channel"));
		        t.setItem(RS.getString("item"));
		       
		       t.SetLanguage(RS.getString("Language"));
		       t.setType(RS.getString("type"));
		        
		    }
		    
		    }
		    catch(SQLException e){

			     System.out.println(e);

			    }
		   
	    
			return t;
		    
        
    }

    public  ArrayList<NotificationTemplate> GetAllTemplates() {
    	ResultSet RS=null;
	   
	   ArrayList< NotificationTemplate> AllTemplates=new ArrayList<NotificationTemplate>();
	   
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
		   Stmt = con.createStatement();
		   RS = Stmt.executeQuery("SELECT * FROM Template ");
		  
		    while(RS.next()){
		    	NotificationTemplate t = new NotificationTemplate();
		    	t.setSubject(RS.getString("Subject"));
		        t.setContent("Dear,"+RS.getString("too")+" "+RS.getString("Content"));
		        t.setChannel(RS.getString("Channel"));
		        t.setItem(RS.getString("item"));
		        t.SetLanguage(RS.getString("Language"));
		        AllTemplates.add(t);
		    }
		    
		    }
		    catch(SQLException e){

			     System.out.println(e);

			    }
		return AllTemplates;      
    }
    public void display(){

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
