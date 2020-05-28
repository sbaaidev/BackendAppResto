package net.sbaai.restoapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Food implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idFood;
private String name;
private double prix;
private boolean selected;
@OneToMany(mappedBy="food",cascade = CascadeType.ALL)
private List<Command_line> cmdline;
@Column(insertable=false)
private Integer qte;
public boolean isSelected() {
	return selected;
}
public void setSelected(boolean selected) {
	this.selected = selected;
}

@ManyToOne
@JoinColumn(name="idCategory")
private Category category;
public Food(String name, double prix, Category cat,Integer qte) {
	super();
	this.name = name;
	this.prix = prix;
	this.category=cat;
	this.qte=qte;
}
public Food() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getIdFood() {
	return idFood;
}
public void setIdFood(Long idFood) {
	this.idFood = idFood;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public String toString() {
	return name;
}
public Integer getQte() {
	return qte;
}
public void setQte(Integer qte) {
	this.qte = qte;
}
}
