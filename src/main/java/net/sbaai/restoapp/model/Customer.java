package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Customer implements Serializable{
	@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idCustomer;
private String name;
private String address;
private String tel;
@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
private Collection<Command> commands;
public Customer( String name, String address, String tel) {
	super();

	this.name = name;
	this.address = address;
	this.tel = tel;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getIdCustomer() {
	return idCustomer;
}
public void setIdCustomer(Long idCustomer) {
	this.idCustomer = idCustomer;
}
public Collection<Command> getCommands() {
	return commands;
}
public void setCommands(Collection<Command> commands) {
	this.commands = commands;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}

public String toString() {
	return name;
}


}
