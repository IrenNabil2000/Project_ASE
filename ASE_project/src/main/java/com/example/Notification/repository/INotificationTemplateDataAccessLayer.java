package com.example.Notification.repository;

import java.util.ArrayList;

import com.example.Notification.model.*;


public interface INotificationTemplateDataAccessLayer {
	
   
    public boolean languageValidations(String languageInput);
    public boolean AddTemplate( NotificationTemplate template);
    public  boolean DeleteTemplate(Integer templateId);
    public boolean UpdateTemplate(NotificationTemplate template);
    public NotificationTemplate GetTemplate(Integer templateId);
    public  ArrayList<NotificationTemplate> GetAllTemplates();
    public void display();
	public void displayTemplate(NotificationTemplate t);

}
