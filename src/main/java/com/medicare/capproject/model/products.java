package com.medicare.capproject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.type.BlobType;

@Entity
@Table(name="products")
public class products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="productname")
	private String productname;
	
	@Column(name="categoryname")
	private String categoryname;
	
	
	@Lob
    @Column(name = "main_image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

	
	
	@Column(name="Instock")
	private int Instock;
	
	@Column(name="price")
	private float price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getInstock() {
		return Instock;
	}

	public void setInstock(int instock) {
		Instock = instock;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
