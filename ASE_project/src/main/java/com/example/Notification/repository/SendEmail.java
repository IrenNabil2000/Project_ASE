package com.example.Notification.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Notification.model.NotificationTemplate;
import com.fasterxml.jackson.annotation.JsonProperty;
@Repository("EmailRepo")
public class SendEmail implements ISendNotification {
	EmailConnection sen = new EmailConnection();
     private Queue<NotificationTemplate> mailQueue = new LinkedList<>();
     public  SendEmail(){
     	
     	 mailQueue=sen.GetAllTemplates();
      }
	 
	public ArrayList<String> Ready(@JsonProperty("id") int id,
    		@JsonProperty("subject") String to, @JsonProperty("content")String iteam,@JsonProperty("Email")String email)
	{
		TemplateConnection c=new TemplateConnection();
		NotificationTemplate t=c.GetTemplate(id);
		ArrayList<String>all=new ArrayList<>();
		t.setTo(to);
		t.setItem(iteam);
		t.setContent(to, iteam,t.getType());
		t.setEmail(email);
		t.setStatus("Ready");
	
		if(t.getChannel().equalsIgnoreCase("email"))
		{ sen.Ready(t);
		
		all.add("Subject: "+t.getSubject());
		all.add("Content: "+t.getContent());
		all.add("Email: "+t.getEmail());
		all.add("Status: "+t.getStatus());
		return all;
		}
		else
			return null;
	}
	public boolean send(@JsonProperty("id") int id) {
		EmailConnection c=new EmailConnection();
		NotificationTemplate t=c.GetTemplate(id);
		    boolean f=true;
		    Iterator<NotificationTemplate> iterator = mailQueue.iterator(); 
			  
	       /* while (iterator.hasNext()) { 
	        	NotificationTemplate temp=iterator.next();
	            if(temp.getId()==id)
	            	f=false;
	        } */
	        if(f) {
			if(t.getEmail().contains("@"))
			{ t.setStatus("success");
			  mailQueue.add(t);
			f=sen.send(id,"success");
			
			}
			else {
				t.setStatus("failure");
				  mailQueue.add(t);
				f=sen.send(id,"failure");
				f=false;
			}
	        }
	        return f;
	}
	public void display() {
		Iterator<NotificationTemplate> iterator = mailQueue.iterator(); 
		  
        while (iterator.hasNext()) { 
        	NotificationTemplate t=iterator.next();
            System.out.println(t.getContent() + "\n "+t.getPhone()+" "+t.getStatus()); 
        } 
	}
	
}
