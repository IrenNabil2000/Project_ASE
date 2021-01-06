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
	   /* @PostMapping()
	    public boolean AddTemplate( @RequestBody NotificationTemplate notification){
	    	return notificationService.AddTemplate(notification);
	    }
	    @GetMapping
	    public ArrayList<NotificationTemplate> GetAllTemplates(){
	        return notificationService.GetAllTemplates();
	    }

	   @GetMapping(path = "{id}")
	    public NotificationTemplate GetTemplate(@PathVariable("id") int id){
	        return notificationService.GetTemplate(id);
	    }*/

	    @DeleteMapping(path = "{id}")
	    public boolean DeleteTemplate(@PathVariable("id") int id){
	    	return notificationService.DeleteTemplate(id);
	    }
	    @PutMapping()
	    public boolean UpdateTemplate( @RequestBody NotificationTemplate template){
	    	return notificationService.UpdateTemplate(template);
	    }
	    
	   @GetMapping
	    public boolean sent()
		{
			return notificationService.sent();
		
		}
	    @PostMapping()
		public boolean Ready (@RequestBody NotificationTemplate t) {

			return notificationService.Ready(t);      
	      }
	    
	    

}
