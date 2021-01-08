package com.example.Notification.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import javax.validation.Valid;

import com.example.Notification.Service.NotificationService;
import com.example.Notification.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

@RequestMapping("api/notification")
@RestController
public class NotificationController {
	    private final NotificationService notificationService;

	    @Autowired
	    public NotificationController(NotificationService notificationService){
	        this.notificationService=notificationService;
	    }
	   // @PostMapping()
	    public boolean AddTemplate( @RequestBody NotificationTemplate notification){
	    	return notificationService.AddTemplate(notification);
	    }
	    @GetMapping
	    public ArrayList<NotificationTemplate> GetAllTemplates(){
	        return notificationService.GetAllTemplates();
	    }

	  // @GetMapping(path = "{id}")
	    public NotificationTemplate GetTemplate(@PathVariable("id") int id){
	        return notificationService.GetTemplate(id);
	    }

	    @DeleteMapping(path = "{id}")
	    public boolean DeleteTemplate(@PathVariable("id") int id){
	    	return notificationService.DeleteTemplate(id);
	    }
	    @PutMapping()
	    public boolean UpdateTemplate( @RequestBody NotificationTemplate template){
	    	return notificationService.UpdateTemplate(template);
	    }
	    
		@PostMapping(path = "{id}/{to}/{item}/{email}")
		public ArrayList<String> ReadyEmail (@PathVariable("id") int id,@PathVariable("to") String to,@PathVariable("item") String item,@PathVariable("email") String email) {

			return notificationService.ReadyEmail(id, to, item, email);      
	      }
	  // @PostMapping(path = "{id}/{to}/{item}/{phone}")
		public ArrayList<String> ReadySms (@PathVariable("id") int id,@PathVariable("to") String to,@PathVariable("item") String item,@PathVariable("phone") String phone) {

			return notificationService.ReadySms(id, to, item, phone);      
	      }
	   @GetMapping(path = "{id}")
	    public String sentEmail(@PathVariable("id") int id)
		{
			return notificationService.sendEmail(id);
		
		}
	  // @GetMapping(path = "{id}")
	    public String sentSms(@PathVariable("id") int id)
		{
			return notificationService.sendSms(id);
		
		}
	    
	    

}
