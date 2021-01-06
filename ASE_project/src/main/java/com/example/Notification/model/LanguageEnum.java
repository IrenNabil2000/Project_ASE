package com.example.Notification.model;

public enum LanguageEnum {
	
	English, Arabic;
	

	   
    public String toString(){
    	String language="";
        switch (this) {
          case English:
            language="English";
            break;
          case Arabic:
        	  language="Arabic";
            break;
          
        }
    	return language;
    }

}
