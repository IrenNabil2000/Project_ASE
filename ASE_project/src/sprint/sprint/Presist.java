package sprint;

import java.util.ArrayList;
import java.util.Scanner;

public class Presist implements Ipresist {
	ArrayList<Template> list = new ArrayList<Template>();

	Presist() {
		Notification n1 = new Notification();
		n1.t.setSub("email confirmation");
		n1.t.setAvll("english");
		n1.t.setAvlc("email");
		n1.t.setCont(n1);
		list.add(n1.t);
		Notification n2 = new Notification();
		n2.t.setSub("forget password");
		n2.t.setAvll("english");
		n2.t.setAvlc("email");
		n2.t.setCont(n2);
		list.add(n2.t);
	}
	public boolean subjectValidations(String subject)
	{ 
		 for(int i=0;i<list.size();i++)
	      {
	        if(subject.equalsIgnoreCase(list.get(i).getSub()))
	            return false;
	           
	      }
	      
		return true;
	}
	public boolean languageValidations(String languageInput) {
		if(languageInput.equalsIgnoreCase("English") || languageInput.equalsIgnoreCase("French")) {
			return true;
		}
		else
			return false;
	}
	public boolean channelValidations(String channelInput) {
		if(channelInput.equalsIgnoreCase("Email") || channelInput.equalsIgnoreCase("SMS")) {
			return true;
		}
		else
			return false;
	}
	public Notification create(String subj,String lanaguge,String channel) {
		Notification n=new Notification();
		boolean flag=true;
		boolean flag2=true;
		if(subjectValidations(subj)==false)
			{
			System.out.println("ERROR THIS TEMPLATE ALREADY EXISTS");
			
			}
		else {
		
		if(languageValidations(lanaguge))
			{  
			  
			   flag=true;
			}
		else
			{System.out.println("Please choose English or French only");
			  flag=false;
			}
		if(channelValidations(channel))
			{
			 flag2=true;
			}
		else
			{System.out.println("Please choose Email or SMS only");
			  flag2=false;
			}
		if(flag==true&& flag2==true)
		{
		
		n.t.setSub(subj);
		 n.t.setAvll(lanaguge);
		 n.t.setAvlc(channel);
		n.t.setCont(n);
		list.add(n.t);
		}
		else {
			System.out.println("The notification will not appear because of invalid inputs");
			System.out.println("--------------------------------");
			System.out.println("Here's the previous templates");
			System.out.println("--------------------------------");
		}
		}
		return n;
	}

	public void read() {

		for (int i = 0; i < list.size(); i++)
			System.out.println("Subject:" + list.get(i).getSub() + "\n" + "content:" + list.get(i).getCont() + "\n" + "Lang:" + list.get(i).getAvll() + "\n" + "channel:" + list.get(i).getAvlc() + "\n");

	}

	public void update(Notification n) {
		System.out.println("what de you want to update ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String in = scanner.nextLine();

		if(input.equals("subject"))
		{ 
			if(subjectValidations(in)==false)
			System.out.println("Error this subject already exist");
				
		else {
			n.t.setSub(in);
			n.t.setCont(n);
		}
		}
		else if (input.equals("language"))
		{
			if(languageValidations(in)==true)
				n.t.setAvll(in);
			else {
				System.out.println("Please choose English or French only");	
				update(n);
			}
		}
		else if (input.equals("channel"))
		{
			if(channelValidations(in)==true)
				n.t.setAvlc(in);
			else {
				System.out.println("Please choose Email or SMS only");
				update(n);
			}
		}
		else {
			System.out.println("invalid input");
		}

	}
    public void delete(Notification n)
{ 	
	list.remove(n.t);
	
}
}
