package model;

public class book {
private int bid;
private String bname,bauthor;
private int bstock;
private double bprice;
private String cname, img;

public book()
{
	
}
public book(String bname, String bauthor, int bstock, double bprice, String cname, String img) {
	super();
	this.bname = bname;
	this.bauthor = bauthor;
	this.bstock = bstock;
	this.bprice = bprice;
	this.cname = cname;
	this.img = img;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBauthor() {
	return bauthor;
}
public void setBauthor(String bauthor) {
	this.bauthor = bauthor;
}
public int getBstock() {
	return bstock;
}
public void setBstock(int bstock) {
	this.bstock = bstock;
}
public double getBprice() {
	return bprice;
}
public void setBprice(double bprice) {
	this.bprice = bprice;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
}
