package pojo;

import java.sql.Date;

public class FlightBook {
private int fbook_id, cust_id, no_passengers;
private String from_loc, to_loc,f_class;
private Date departure_date;
public int getFbook_id() {
	return fbook_id;
}
public void setFbook_id(int fbook_id) {
	this.fbook_id = fbook_id;
}
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public int getNo_passengers() {
	return no_passengers;
}
public void setNo_passengers(int no_passengers) {
	this.no_passengers = no_passengers;
}
public String getFrom_loc() {
	return from_loc;
}
public void setFrom_loc(String from_loc) {
	this.from_loc = from_loc;
}
public String getTo_loc() {
	return to_loc;
}
public void setTo_loc(String to_loc) {
	this.to_loc = to_loc;
}
public String getF_class() {
	return f_class;
}
public void setF_class(String f_class) {
	this.f_class = f_class;
}
public Date getDeparture_date() {
	return departure_date;
}
public void setDeparture_date(Date departure_date) {
	this.departure_date = departure_date;
}

}
