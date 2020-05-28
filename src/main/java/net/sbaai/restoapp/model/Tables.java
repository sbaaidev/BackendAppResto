package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Tables implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long numTable;
private int nbrchair;
private boolean reserved;
@ManyToOne
@JoinColumn(name="idWaiter")
private Waiter waiter;
@ManyToOne
@JoinColumn(name="idSector")
private Sector sector;
@OneToMany(mappedBy="table",cascade = CascadeType.ALL)
private Collection<Command> commands;
public Sector getSector() {
	return sector;
}


public Collection<Command> getCommands() {
	return commands;
}


public void setCommands(Collection<Command> commands) {
	this.commands = commands;
}


public void setSector(Sector sector) {
	this.sector = sector;
}

public Long getNumTable() {
	return numTable;
}
public void setNumTable(Long numTable) {
	this.numTable = numTable;
}
public int getNbrchair() {
	return nbrchair;
}
public void setNbrchair(int nbrchair) {
	this.nbrchair = nbrchair;
}
public Tables(int nbrchair) {
	super();
	
	this.nbrchair = nbrchair;
}

public boolean isReserved() {
	return reserved;
}
public void setReserved(boolean reserved) {
	this.reserved = reserved;
}
public Tables() {
	super();
	// TODO Auto-generated constructor stub
}
public String toString(){
	return String.valueOf(this.numTable);
}
public Waiter getWaiter() {
	return waiter;
}
public void setWaiter(Waiter waiter) {
	this.waiter = waiter;
}


}
