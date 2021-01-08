package com.example.Notification.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.Notification.model.NotificationTemplate;

public class TemplateConnection {
	public Connection con;
	Statement Stmt;
	ResultSet RS;

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

	public boolean languageValidations(String languageInput) {

		if (languageInput.equalsIgnoreCase("English") || languageInput.equalsIgnoreCase("Arabic")) {
			return true;
		} else
			return false;
	}

	public boolean AddTemplate(NotificationTemplate template) {
		boolean flag = true;
		NotificationTemplate t=GetTemplate(template.getId());
		if(template.getId()!=t.getId()) {
		try {
			setConnection();
			Stmt = con.createStatement();

			if (languageValidations(template.getLanguage())) {

				flag = true;
			} else {
				System.out.println("Please choose English or Arabic only");
				flag = false;
			}
			if (flag == true) {
				String line = "INSERT INTO Template(Content,BasicContent,Subject,Language,Channel,too,item,type,ID) VALUES(" + "'"
						+ template.getContent() + "',"+"'"+template.getbasiccontent()+"'," + "'" + template.getSubject() + "'," + "'"
						+ template.getLanguage() + "'," + "'" + template.getChannel() + "'," + "'" + template.getTo()
						+ "'," + "'" + template.getItem() + "'," + "'" + template.getType() + "'," + template.getId()
						+ ")";
				Stmt.executeUpdate(line);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return (flag);
	}

	public boolean DeleteTemplate(Integer templateId) {
		int Rows = 0;
		try {
			setConnection();
			Stmt = con.createStatement();
			String line = "DELETE FROM Template WHERE ID= " + templateId;
			Rows = Stmt.executeUpdate(line);

		} catch (SQLException e) {

			System.out.println(e);

		}
		if (Rows != 0)
			return true;

		return false;

	}

	public boolean UpdateTemplate(NotificationTemplate template) {
		int Rows = 0;
		try {

			setConnection();
			System.out.println("Connection is successfull");
			Stmt = con.createStatement();
			String line = "UPDATE Template  SET Content=' " + template.getContent() + "' , Subject=' "
					+ template.getSubject() + "' ,Language=' " + template.getLanguage() + " ',Channel='"
					+ template.getChannel() + " ' ,too='" + template.getTo() + "',item='" + template.getItem()
					+ " ', type=' " + template.getType() + " ' WHERE ID= " + template.getId();
			Rows = Stmt.executeUpdate(line);

		} catch (SQLException e) {

			System.out.println(e);

		}
		if (Rows != 0)
			return true;

		return false;
	}

	public ArrayList<NotificationTemplate> GetAllTemplates() {

		ArrayList<NotificationTemplate> AllTemplates = new ArrayList<NotificationTemplate>();
		try {

			setConnection();
			System.out.println("Connection is successfull");
			Stmt = con.createStatement();
			RS = Stmt.executeQuery("SELECT * FROM Template ");

			while (RS.next()) {
				NotificationTemplate t = new NotificationTemplate();
				t.setSubject(RS.getString("Subject"));
				t.setbasiccontent(RS.getString("BasicContent"));
				t.setContent(RS.getString("too") , RS.getString("item"), RS.getString("type"));
				t.setChannel(RS.getString("Channel"));
				t.setItem(RS.getString("item"));
				t.SetLanguage(RS.getString("Language"));
				t.setType(RS.getString("type"));
				t.setId((Integer) RS.getObject("id"));
				AllTemplates.add(t);
			}
		} catch (SQLException e) {

			System.out.println(e);

		}
		return AllTemplates;
	}

	public NotificationTemplate GetTemplate(Integer templateId) {

		NotificationTemplate t = new NotificationTemplate();
		try {

			setConnection();
			System.out.println("Connection is successfull");
			Stmt = con.createStatement();
			RS = Stmt.executeQuery("SELECT * FROM Template WHERE ID= " + templateId);

			while (RS.next()) {
				t.setSubject(RS.getString("Subject"));
				t.setbasiccontent(RS.getString("BasicContent"));
				t.setContent(RS.getString("too") , RS.getString("item"), RS.getString("type"));
				t.setChannel(RS.getString("Channel"));
				t.setItem(RS.getString("item"));
				t.SetLanguage(RS.getString("Language"));
				t.setType(RS.getString("type"));
				t.setId((Integer) RS.getObject("id"));

			}

		} catch (SQLException e) {

			System.out.println(e);
		}
		return t;

	}

	public void display() {

		try {

			setConnection();
			System.out.println("Connection is successfull");
			Statement Stmt = null;
			ResultSet RS = null;
			Stmt = con.createStatement();
			RS = Stmt.executeQuery("SELECT * FROM Template;");

			while (RS.next()) {
				System.out.println("Subject: " + RS.getString("Subject"));
				System.out.println("Content: " + RS.getString("Content"));
				System.out.println("Language: " + RS.getString("Language"));
				System.out.println("Channel: " + RS.getString("Channel"));
			}
			con.close();
		} catch (SQLException e) {

			System.out.println(e);

		}
	}
}
