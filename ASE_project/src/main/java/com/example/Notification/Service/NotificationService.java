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
	private ISendNotification Emailnotification=new SendEmail();
	private ISendNotification Smsnotification=new SendSms();


    @Autowired
    public NotificationService(@Qualifier("notifyRepo") INotificationTemplateDataAccessLayer inotification,
    @Qualifier("EmailRepo") SendEmail Emailnotification, @Qualifier("SMSRepo") SendSms Smsnotification){
        this.inotification=inotification;
        this.Emailnotification=Emailnotification;
        this.Smsnotification=Smsnotification;
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

	public ArrayList<String> ReadyEmail (int id,String to,String iteam,String email) {
		
        return Emailnotification.Ready(id,to,iteam,email); 
   }
   public ArrayList<String> ReadySms (int id,String to,String iteam,String phone) {
       
        return Smsnotification.Ready(id,to,iteam,phone); 
   }
   public String sendEmail(int id) {
       boolean f=Emailnotification.send(id);
       if(f)
        return "success";
       else
           return "failure";
   }
   public String sendSms(int id) {
       boolean f= Smsnotification.send(id);
       if(f)
            return "success";
           else
               return "failure";
   }
}