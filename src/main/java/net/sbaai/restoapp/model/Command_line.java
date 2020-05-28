package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Command_line implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;	
@ManyToOne
@JoinColumn(name="idFood")
private Food food;
private int qte;
private double prix;
@Temporal(TemporalType.TIMESTAMP)
private Date date;
@ManyToOne()
@JoinColumn(name="numCommand")
private Command command;
public Command_line() {
	super();
	// TODO Auto-generated constructor stub
}

public Command getCommand() {
	return command;
}
public void setCommand(Command command) {
	this.command = command;
}

public Command_line(Food food, int qte, double prix) {
	super();
	this.food = food;
	this.qte = qte;
	this.prix = prix;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Food getFood() {
	return food;
}
public void setFood(Food food) {
	this.food = food;
}
public int getQte() {
	return qte;
}
public void setQte(int qte) {
	this.qte = qte;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public String toString(){
	return String.valueOf(this.id);
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}



}
