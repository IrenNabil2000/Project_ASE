package com.example.Notification.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.Notification.model.NotificationTemplate;
@Qualifier("sendRepo")
public interface ISendNotification {
	public ArrayList<String> Ready(int id,String to,String iteam,String channel);
	public boolean send( int id);
	public void display();
}
