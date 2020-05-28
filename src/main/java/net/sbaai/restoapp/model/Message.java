package net.sbaai.restoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message implements  Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idmsg;
private String msg;
public Long getIdmsg() {
	return idmsg;
}
public void setIdmsg(Long idmsg) {
	this.idmsg = idmsg;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Message() {
	super();
	// TODO Auto-generated constructor stub
}
public Message(String msg) {
	super();
	this.msg = msg;
}


}
