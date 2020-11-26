package sprint;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Presist p= new Presist();
		Notification not=new Notification();
	
		not=p.create("email confirmation", "english", "email");
		not.send(not);
	}

}
