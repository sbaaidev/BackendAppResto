package net.sbaai.restoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Users implements  Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idUser;
private String username;
private String password;
private String type;
public Long getIdUser() {
	return idUser;
}
public void setIdUser(Long idUser) {
	this.idUser = idUser;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(String username, String password,String type) {
	super();
	this.username = username;
	this.password = password;
	this.type=type;
}
}
