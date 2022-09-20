package model;

public class bookOrder {
private int oid,bid,cid,qty;
private String odate;
private double totalPrice;
public bookOrder() {
}
public bookOrder(int bid, int cid, int qty, String odate, double totalPrice) {
	super();
	this.bid = bid;
	this.cid = cid;
	this.qty = qty;
	this.odate = odate;
	this.totalPrice = totalPrice;
}

public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public String getOdate() {
	return odate;
}
public void setOdate(String odate) {
	this.odate = odate;
}
}
