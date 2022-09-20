package model;

public class Admin {
private int aid;
private String apwd;

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getApwd() {
	return apwd;
}
public void setApwd(String apwd) {
	this.apwd = apwd;
}
public Admin(int aid, String apwd) {
	super();
	this.aid = aid;
	this.apwd = apwd;
}


}
