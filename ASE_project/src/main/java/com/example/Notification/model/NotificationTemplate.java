package com.example.Notification.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

	public class NotificationTemplate {
	
		protected String Subject="";
		protected String Content="";
		protected String Language="Arabic";
		protected String channel="mail";
		 protected  int id=0;
			protected  String to="Hassan";
			protected  String item="";
			protected String type="";

			    public NotificationTemplate(@JsonProperty("id") int id,@JsonProperty("to") String to,
			    		@JsonProperty("subject") String Subject, @JsonProperty("content")String Content,
						@JsonProperty("language") String Language, @JsonProperty("channel")String channel,@JsonProperty("item") String item,
						@JsonProperty("type") String type){
			        this.id=id;
			        this.to=to;
			        this.Subject=Subject;
			        this.Content=Content;
			        this.Language=Language;
			        this.channel=channel;
			        this.type=type;
			        this.item=item;
			    }
			public void setTo(String to)
			{
				this.to=to;
			}
			public String getTo()
			{
				return to;
			}
			public void setItem(String item)
			{
				this.item=item;
			}
			public String getItem()
			{
				return item;
			}
			public void setType(String type)
			{
				this.type=type;
			}
			public String getType()
			{
				return type;
			}
		 public int getId() {
			 return id;
		 }

			public void setId(int id) {
				this.id = id;
			}
			public void setChannel(String channel)
			{
				this.channel=channel;
			}
			public String getChannel()
			{
				return channel;
			}
			public void setSubject(String newSub) {
			    this.Subject= newSub;
			  }
			public void setContent(String newcont) {
			    this.Content= newcont;
			  }
			public void SetLanguage(String l) {
				 this.Language= l;
				
			}

			public String getSubject() {
			    return Subject;
			  }
		    public String getContent() {
				    return Content;
				  }
				  
		   public String getLanguage() {
					 
			 return  Language;
					  }

		
		public NotificationTemplate(){
		}


		public void display() {
			System.out.println("subject: "+getSubject()+"\n content:"+getContent()+"\n language:"+
		getLanguage()+"\n Channel: "+getChannel());
			
		}
	
			
		}




