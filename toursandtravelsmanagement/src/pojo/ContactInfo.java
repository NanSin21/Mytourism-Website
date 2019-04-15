package pojo;

public class ContactInfo {
private int contact_id;
private String name, email_id;
private long phone_no;
private String message;
public int getContact_id() {
	return contact_id;
}
public void setContact_id(int contact_id) {
	this.contact_id = contact_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public long getPhone_no() {
	return phone_no;
}
public void setPhone_no(long phone_no) {
	this.phone_no = phone_no;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
