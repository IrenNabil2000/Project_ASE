package sprint;

public class Template implements iTemplate{
	String sub="";
	String cont="";
	String avll="";
	String avlc="";
	String to="x";
	String item="y";
	public void setItem(String item)
	{
	this.item=item;
	}
	public String getItem()
	{
	return item;
	}
	public void setSub(String s) {
		sub=s;
	}
	public void setTO(String t) {
		to=t;
	}
	public void setCont(Notification n) {
	if(n.t.getSub().contains("email")) {
			
		cont="dear, "+to+" your email is confirmed";
			
		}
	if(n.t.getSub().contains("forget pass")) {
			
		cont="dear, "+to+" you can rest your password";
			
		}
	if(n.t.getSub().contains("buy")) {
		 
		cont="Dear "+to+" , your booking of the"+ item+"  is confirmed. thanks for using our store :) ";
			
		}
	}
	public void setAvll(String l) {
	  avll=l;
	}
	public void setAvlc(String ch) {
		avlc=ch;
	}
	public String getSub() {
		return sub;
	}
	public String getTo() {
		return to;
	}
	public String getCont() {
		return cont;
	}
	public String getAvll() {
		return avll;
	}
	public String getAvlc() {
		return avlc;
	}
	Template(){};
	Template(String s,String l,String ch){
		sub=s;
		avll=l;
		avlc=ch;
	}
}
