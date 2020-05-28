package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Waiter implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idWaiter;

private String name;
private String tel;
@OneToMany(mappedBy="waiter",cascade = CascadeType.ALL)
private Collection<Tables> tables;
public Waiter(String code, String name, String tel) {
	super();
	
	this.name = name;
	this.tel = tel;
}
public Collection<Tables> getTables() {
	return tables;
}
public void setTables(Collection<Tables> tables) {
	this.tables = tables;
}


public Waiter() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getIdWaiter() {
	return idWaiter;
}
public void setIdWaiter(Long idWaiter) {
	this.idWaiter = idWaiter;
}




public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}

public String toString(){
	return this.name;
}
}
