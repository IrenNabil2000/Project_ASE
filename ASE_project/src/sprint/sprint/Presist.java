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

	public Notification create(String subj, String lanaguge, String channel) {
		Notification n = new Notification();
		n.t.setSub(subj);
		n.t.setAvll(lanaguge);
		n.t.setAvlc(channel);
		n.t.setCont(n);
		list.add(n.t);
		return n;

	}

	public void read() {

		for (int i = 0; i < list.size(); i++)
			System.out.println("Subject:" + list.get(i).getSub() + "\n" + "content:" + list.get(i).geCont() + "\n" + "Lang:" + list.get(i).getAvll() + "\n" + "channel:" + list.get(i).getAvlc() + "\n");

	}

	public void update(Notification n) {
		System.out.println("what de you want to update ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String in = scanner.nextLine();

		if (input.equals("subject")) {
			n.t.setSub(in);
			n.t.setCont(n);
		} else if (input.equals("language")) {
			n.t.setAvll(in);
		} else if (input.equals("channel")) {
			n.t.setAvlc(in);
		} else {
			System.out.println("invalid input");
		}

	}
    public void delete(Notification n)
{ 	
	list.remove(n.t);
	
}
}
