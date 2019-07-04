package com.empresa.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.empresa.hangar.model.Hangar;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	@NotNull(groups = EditProduct.class) // Hmm no tiene mucho sentido porque el id se pasa por path
	private long id;
	
	@Column
	@NotEmpty(groups = {CreateProduct.class, EditProduct.class})
	private String name;
	
	@ManyToOne
	@JoinColumn(name="hangar_id", foreignKey = @ForeignKey(name="hangar_id_fk"))
	private Hangar hangar;
	
	public void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}
	
	public Hangar getHangar() {
		return hangar;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	/*
	public void setId(long id) {
		this.id = id;
	}*/
	
	public void setName(String name) {
		this.name = name;
	}
	
	// CONSTRUCTORS
	
	public Product() { }
	
	public Product(String name) {
		this.name = name;
	}
	
	public Product(Long id, String name, Hangar hangar) {
		this.id = id;
		this.name = name;
		this.hangar = hangar;
	}
	
	public Product(Hangar hangar, String name) {
		this.hangar = hangar;
		this.name = name;
	}

}
