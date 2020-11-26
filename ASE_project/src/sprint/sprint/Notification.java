package sprint;

public class Notification implements iNotification {
	Template t=new Template();

<<<<<<< HEAD
	public void send(Notification n ){
		if(!t.getSub().contains("buy")) {
		
			Notification n3=new Notification();
			n3.t.setSub(n.t.getSub());
			n3.t.setTO("hassan");
			n3.t.setCont(n3);
			
			
			
			System.out.println(n3.t.getCont());
=======
	public void send(Notification n) {
	   
		if(!t.getSub().contains("email")) {
			Email e = new Email();		
			e.setSub(n.t.getSub());
			e.setTO("Hassan");
			e.setCont(n);
			System.out.println(e.geCont());
>>>>>>> cb86a0eda083886aff1cb302bc5fe70f97adbcb9
			}
		else {
			Notification n4=new Notification();
			n4.t.setSub(n.t.getSub());
			n4.t.setTO("hassan");
			n4.t.setItem("Mobile charger");
			n4.t.setCont(n4);
			System.out.println(n4.t.getCont());
		}
		

	}
}
