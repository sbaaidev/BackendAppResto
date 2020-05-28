package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Command implements Serializable{
@Column(columnDefinition="serial",unique=true,insertable=false)
private Long idCommand;
@Id

private String numCommand;
@Temporal(TemporalType.TIMESTAMP)
private Date dtaeCommand;
@Temporal(TemporalType.TIMESTAMP)
private Date datenotime;
@ManyToOne
@JoinColumn(name="idCustomer")
private Customer customer;
@OneToMany(mappedBy="command",cascade = CascadeType.ALL)
private Collection<Command_line> command_line;
@ManyToOne
@JoinColumn(name="numTable")
private Tables table;
public String getNumCommand() {
	return numCommand;
}
public void setNumCommand(String numCommande) {
	this.numCommand = numCommande;
}
public Tables getTable() {
	return table;
}
public void setTable(Tables table) {
	this.table = table;
}

public Date getDtaeCommand() {
	return dtaeCommand;
	
}
public void setDtaeCommand(Date dtaeCommand) {
	this.dtaeCommand = dtaeCommand;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Collection<Command_line> getCommand_line() {
	return command_line;
}
public void setCommand_line(Collection<Command_line> command_line) {
	this.command_line = command_line;
}
public Command() {
	
	super();
	
	// TODO Auto-generated constructor stub
}
public Command(Date dtaeCommand) {
	super();
	this.dtaeCommand = dtaeCommand;
}
public Long getIdCommand() {
	return idCommand;
}
public void setIdCommand(Long idCommand) {
	this.idCommand = idCommand;
}
public Date getDatenotime() {
	return datenotime;
}
public void setDatenotime(Date datenotime) {
	this.datenotime = datenotime;
}






}
