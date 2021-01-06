package com.example.Notification.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.Notification.model.NotificationTemplate;
import com.example.Notification.model.SearchCriteria;
import com.example.Notification.repository.INotificationTemplateDataAccessLayer;
import com.example.Notification.repository.SendNotifacation;

@Service
public class NotificationService {
	private final INotificationTemplateDataAccessLayer inotification;
	private final SendNotifacation sendnotification;

    @Autowired
    public NotificationService(@Qualifier("notifyRepo") INotificationTemplateDataAccessLayer inotification,
    @Qualifier("sentRepo") SendNotifacation sendnotification){
        this.inotification=inotification;
        this.sendnotification=sendnotification;
    }

    public boolean AddTemplate(NotificationTemplate notification){

        return inotification.AddTemplate(notification);
    }

    public ArrayList<NotificationTemplate> GetAllTemplates(){
        return inotification.GetAllTemplates();
    }

    public NotificationTemplate GetTemplate(int id){
        return inotification.GetTemplate(id);
    }
    public boolean DeleteTemplate(int id){
        return inotification.DeleteTemplate(id);
    }
    public boolean UpdateTemplate(NotificationTemplate newtemplate){
        return inotification.UpdateTemplate(newtemplate);
    }

	public boolean Ready (NotificationTemplate t) {
		
		 return sendnotification.Ready(t); 
	}
    public boolean sent()
	{
    	return sendnotification.sent();
	

}
}