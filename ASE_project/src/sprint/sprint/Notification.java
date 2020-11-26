package sprint;

public class Notification implements iNotification {
	Template t=new Template();

	public void send(Notification n) {
	   
		if(!t.getSub().contains("email")) {
			Email e = new Email();		
			e.setSub(n.t.getSub());
			e.setTO("Hassan");
			e.setCont(n);
			System.out.println(e.geCont());
			}
		else {
			Notification n4=new Notification();
			n4.t.setSub(n.t.getSub());
			n4.t.setTO("hassan");
			n4.t.setItem("Mobile charger");
			n4.t.setCont(n4);
			System.out.println(n4.t.geCont());	
		}
		

	}
}
