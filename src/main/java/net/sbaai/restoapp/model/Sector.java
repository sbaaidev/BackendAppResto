package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Sector implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idSector;
private String name;
@OneToMany(mappedBy="sector",cascade = CascadeType.ALL)
private Collection<Tables> tables;
public Sector() {
	super();
	// TODO Auto-generated constructor stub
}
public Sector(String name) {
	super();
	this.name = name;
	this.tables = tables;
}

public Long getIdSector() {
	return idSector;
}
public void setIdSector(Long idSector) {
	this.idSector = idSector;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Collection<Tables> getTables() {
	return tables;
}
public void setTables(Collection<Tables> tables) {
	this.tables = tables;
}

public String toString(){
	return this.name;
}
}
