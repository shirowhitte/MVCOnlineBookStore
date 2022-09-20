package model;

public class Customer {
private int cid;
private String cfirstname, clastname,cemail,cphone, clogin;

public Customer(int cid)
{
	this.cid = cid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}

public Customer(int cid, String cemail) {
	this.cid = cid;
	this.cemail = cemail;
}
public Customer(String cfirstname, String clastname, String cemail, String cphone) {
	super();
	this.cfirstname = cfirstname;
	this.clastname = clastname;
	this.cemail = cemail;
	this.cphone = cphone;

}
public String getCfirstname() {
	return cfirstname;
}
public void setCfirstname(String cfirstname) {
	this.cfirstname = cfirstname;
}
public String getClastname() {
	return clastname;
}
public void setClastname(String clastname) {
	this.clastname = clastname;
}
public String getCemail() {
	return cemail;
}
public void setCemail(String cemail) {
	this.cemail = cemail;
}
public String getCphone() {
	return cphone;
}
public void setCphone(String cphone) {
	this.cphone = cphone;
}
public String getClogin() {
	return clogin;
}
public void setClogin(String clogin) {
	this.clogin = clogin;
}
}
