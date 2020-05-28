package net.sbaai.restoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category implements Serializable {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idCategory;
private String name;
@ManyToOne
@JoinColumn(name="idSubCategory")
private SubCategory subCategory;
@OneToMany(mappedBy="category")
@JsonIgnore
private Collection<Food> foods;
public Category(String name) {
	super();
	this.name = name;
}

	public Category(String name,SubCategory subCategory) {
		super();
		this.name = name;
		this.subCategory=subCategory;
	}
public Category() {
	super();
}
public Long getIdCategory() {
	return idCategory;
}
public void setIdCategory(Long idCategory) {
	this.idCategory = idCategory;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Collection<Food> getFoods() {
	return foods;
}
public void setFoods(Collection<Food> foods) {
	this.foods = foods;
}
public String toString() {
	return name;
}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
}