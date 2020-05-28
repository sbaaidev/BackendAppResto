package net.sbaai.restoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Entity
public class SubCategory implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long idSubcategory;
private String name;
@OneToMany(mappedBy="subCategory")
@JsonIgnore
private List<Category> category;
	public Long getIdSubcategory() {
		return idSubcategory;
	}

	public void setIdSubcategory(Long idSubcategory) {
		this.idSubcategory = idSubcategory;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public SubCategory(String name, List<Category> category) {
		this.name = name;
		this.category = category;
	}

	public String toString() {
	return name;
}

	public SubCategory(String name) {
		this.name = name;
	}

	public SubCategory() {
	}
}
