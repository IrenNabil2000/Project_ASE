package com.example.Notification.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

import com.example.Notification.model.NotificationTemplate;

public class SmsConnection {
	public Connection con;
	Statement Stmt;
	ResultSet RS;
	boolean f=true;
	
	

	public void setConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Sprint3;user=root;password=1234";
		con = DriverManager.getConnection(url);
	}

	public boolean Ready(NotificationTemplate template)
	{
		try{

			setConnection();
			Stmt = con.createStatement();
		    System.out.println("Connection is successfull");
		    
		   String line = "INSERT INTO ReadySms(Content,Subject,Language,too,item,type,ID,phone,Status) VALUES("
	               + "'" + template.getContent()+ "',"
	               + "'" + template.getSubject() + "',"
	                + "'" + template.getLanguage().toString()+ "',"
	               + "'" + template.getTo()+ "',"
	               + "'" + template.getItem()+ "',"
	               + "'" + template.getType()+ "',"
	               + template.getId()+","+
	               "'"+template.getPhone()+"',"+
	               "'"+template.getStatus()+"')";
	        Stmt.executeUpdate(line);
			
			
		    } catch(SQLException e){

			     System.out.println(e);
			    return false;

			    }
		    return true;
	}
	public boolean send(int id,String s) {
		int Rows = 0;
		try {

			setConnection();
			System.out.println("Connection is successfull");
			Stmt = con.createStatement();
			String line = "UPDATE ReadySms  SET Status=' " + s + " ' WHERE ID= " + id;
			Rows = Stmt.executeUpdate(line);

		} catch (SQLException e) {

			System.out.println(e);

		}
		if (Rows != 0)
			return true;

		return false;
	}
	public NotificationTemplate GetTemplate(Integer templateId) {

		NotificationTemplate t = new NotificationTemplate();
		try {

			setConnection();
			System.out.println("Connection is successfull");
			Stmt = con.createStatement();
			RS = Stmt.executeQuery("SELECT * FROM ReadySms WHERE ID= " + templateId);

			while (RS.next()) {
				t.setSubject(RS.getString("Subject"));
				t.setContent(RS.getString("Content"));
				t.setItem(RS.getString("item"));
				t.SetLanguage(RS.getString("Language"));
				t.setType(RS.getString("type"));
				t.setId((Integer) RS.getObject("id"));
				t.setPhone(RS.getString("phone"));
				t.setStatus(RS.getString("Status"));
			}

		} catch (SQLException e) {

			System.out.println(e);
		}
		return t;

	}
	public Queue<NotificationTemplate> GetAllTemplates() {

		Queue<NotificationTemplate> AllTemplates = new LinkedList<>();
		try {

			setConnection();
			System.out.println("Connection is successfull");
			Stmt = con.createStatement();
			RS = Stmt.executeQuery("SELECT * FROM ReadySms WHERE Status=' Sent ' OR Status=' faild '");

			while (RS.next()) {
				NotificationTemplate t = new NotificationTemplate();
				t.setSubject(RS.getString("Subject"));
				t.setContent(RS.getString("Content"));
				t.setItem(RS.getString("item"));
				t.SetLanguage(RS.getString("Language"));
				t.setType(RS.getString("type"));
				t.setId((Integer) RS.getObject("id"));
				t.setPhone(RS.getString("phone"));
				t.setStatus(RS.getString("Status"));
				AllTemplates.add(t);
			}
		} catch (SQLException e) {

			System.out.println(e);

		}
		return AllTemplates;
	}
}
