package sprint;

public class Notification implements iNotification {
	Template t=new Template();

	public void send(Notification n) {
	   
		if(!t.getSub().contains("buy")) {
		
			Notification n3=new Notification();
			n3.t.setSub(n.t.getSub());
			n3.t.setTO("hassan");
			n3.t.setCont(n3);
			
			
			
			System.out.println(n3.t.geCont());
			}
		else {
			
		}
		

	}
}
