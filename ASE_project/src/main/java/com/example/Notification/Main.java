package com.example.Notification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.example.Notification.model.LanguageEnum;
import com.example.Notification.model.NotificationTemplate;
import com.example.Notification.repository.MemoryNotificationTemplateDataAccessLayer;
import com.example.Notification.repository.SendNotifacation;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemoryNotificationTemplateDataAccessLayer repo=new MemoryNotificationTemplateDataAccessLayer();
        ArrayList<MemoryNotificationTemplateDataAccessLayer> m=new 	ArrayList<MemoryNotificationTemplateDataAccessLayer>();
       //repo.GetTemplate(1).display();
        //repo.display();
        NotificationTemplate t=new NotificationTemplate();
        t.setItem("mobile charger");
        t.setTo("Hassn");
        t.setContent("dear"+t.getTo()+" The"+t.getItem()+" item has been confirmed");
        t.setSubject("Buy Confirmation");
        t.setChannel("SMS");
        t.SetLanguage("English");
       
        t.setType("Buy");
        t.setId(3);
        //=============================================================
      /*  NotificationTemplate t2=new NotificationTemplate();
        t2.setItem(null);
        t2.setTo("Ahmed");
        t2.setContent("dear"+t2.getTo()+" your email  has been confirmed");
        t2.setSubject(" EConfirmation");
        t2.setChannel("Email");
        t2.SetLanguage("English");
       
        t2.setType("Email");
        t2.setId(4);
        if(repo.AddTemplate(t))
        {
        	
           repo.display();
        }
        else
            System.out.println("not added");
        t.setSubject("Conformation ");
        if(repo.UpdateTemplate(t))
        {
            repo.display();
        }
        else
            System.out.println("not updated");
        System.out.println("====================================");
      repo.displayTemplate(repo.GetTemplate(3));*/
        SendNotifacation s= new SendNotifacation();
       // s.Ready(t);
       // s.Ready(t2);
        s.display();
       //s.sent();
       
        
        
        //repo.display(repo.GetAllTemplates());
       /* if(repo.DeleteTemplate(t.getId()))
        {
        	 repo.display();
            System.out.println("deleted");
        }
        else
            System.out.println("not deleted ");
        */
        
        
       /* t.SetLanguage(LanguageEnum.valueOf("English"));
        //repo.read(repo.SearchTemplates(t));
        System.out.println("============================ ");
        //invoked to be sent
        SendNotifacation send=new SendNotifacation();
        
        send.display( send.send(t));*/
       

    }


	}


