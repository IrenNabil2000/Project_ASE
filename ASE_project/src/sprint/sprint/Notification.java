package sprint;

public class Notification implements iNotification {
	Template t=new Template();

	public void send(Notification n) {
		if (t.getSub().contains("email")) {
					Email e = new Email();
					e.setSub(n.t.getSub());
					e.setTO("Hassan");
					e.setCont(n);
					System.out.println(e.getCont());
				}
		else if (t.getSub().contains("buy")) {

					Buy p = new Buy();
					p.setSub(n.t.getSub());
					p.setTO("hassan");
					p.setItem("Mobile charger");
					p.setCont(n);
					System.out.println(p.getCont());
				}
		else if (t.getSub().contains("Forget")) {

			Forget f = new Forget();
			f.setSub(n.t.getSub());
			f.setTO("hassan");
			f.setCont(n);
			System.out.println(f.getCont());
		}


	}
}
