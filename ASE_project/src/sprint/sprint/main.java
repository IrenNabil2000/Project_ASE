package sprint;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Presist p= new Presist();
		sprint.Notification not=new sprint.Notification();

		/*System.out.println("Please enter the subject");
		Scanner s = new Scanner(System.in);
		String sub = s.nextLine();
		System.out.println("Please enter the language");
		String lang = s.nextLine();
		while(!p.languageValidations(lang)) {
			System.out.println("Please choose English or French only");
			lang=s.nextLine();
		}
		System.out.println("Please enter the channel");
		String chan = s.nextLine();
		while(!p.channelValidations(chan)) {
			System.out.println("Please choose Email or SMS only");
			chan=s.nextLine();
		}*/
	
		not=p.create("email confirmation", "english", "email");
		not.send(not);
		p.delete(not);
        p.read();
        p.update(not);
        p.read();
	}

}
