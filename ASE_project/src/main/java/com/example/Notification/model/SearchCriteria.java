package com.example.Notification.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCriteria {

	public String Subject="";
	public String Content="";
	public LanguageEnum Language=LanguageEnum.Arabic;
	public String channel="mail";
	
	
	public SearchCriteria(){}
	
	public SearchCriteria(@JsonProperty("subject") String Subject, @JsonProperty("content")String Content,
			@JsonProperty("language") LanguageEnum Language, @JsonProperty("channel")String channel){
        this.Subject=Subject;
        this.Content=Content;
        this.Language=Language;
        this.channel=channel;
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
	public void SetLanguage(LanguageEnum l) {
		 this.Language= l;
		
	}

	public String getSubject() {
	    return Subject;
	  }
    public String getContent() {
		    return Content;
		  }
		  
   public String getLanguage() {
			 
	 return  Language.toString();
			  }

}
