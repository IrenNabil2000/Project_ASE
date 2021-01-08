package com.example.Notification.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Notification.model.NotificationTemplate;
import com.fasterxml.jackson.annotation.JsonProperty;
@Repository("SMSRepo")
public class SendSms implements ISendNotification {
	SmsConnection sen = new SmsConnection();
	int id;
     private Queue<NotificationTemplate> smsQueue = new LinkedList<>();
    public SendSms(){
    	
    	 smsQueue=sen.GetAllTemplates();
     }
	public ArrayList<String> Ready(@JsonProperty("id") int id,
    		@JsonProperty("subject") String to, @JsonProperty("content")String iteam,@JsonProperty("Phone")String phone)
	{
		TemplateConnection T=new TemplateConnection();
		NotificationTemplate t=T.GetTemplate(id);
		ArrayList<String>all=new ArrayList<>();
		this.id=id;
		t.setTo(to);
		t.setItem(iteam);
		t.setContent(to, iteam,t.getType());
		t.setStatus("Ready");
		t.setPhone(phone);
		if(t.getChannel().equalsIgnoreCase("SMS"))
		{  sen.Ready(t);
		
		all.add("Subject: "+t.getSubject());
		all.add("Content: "+t.getContent());
		all.add("PhoneNumber: "+t.getPhone());
		all.add("Status: "+t.getStatus());
		return all;
		
		}
			else
				return null;
	}
	public boolean send(@JsonProperty("id") int id) {
		SmsConnection c=new SmsConnection();
		NotificationTemplate t=c.GetTemplate(id);
		boolean f=true;
	    Iterator<NotificationTemplate> iterator = smsQueue.iterator(); 
		  
       /* while (iterator.hasNext()) { 
        	NotificationTemplate temp=iterator.next();
            if(temp.getId()==id)
            	f=false;
        } */
        if(f) {
		if( t.getPhone().length()==11)
		{ t.setStatus("success");
		  smsQueue.add(t);
			f= sen.send(id,"success");
		
		}
		else {
			t.setStatus("failure");
			  smsQueue.add(t);
			f= sen.send(id,"failure");
			f=false;
		}
        }
        return f;
	}
	public void display() {
		Iterator<NotificationTemplate> iterator = smsQueue.iterator(); 
		  
        while (iterator.hasNext()) { 
        	NotificationTemplate t=iterator.next();
            System.out.println(t.getContent() + "\n "+t.getPhone()+" "+t.getStatus()); 
        } 
	}
	
}