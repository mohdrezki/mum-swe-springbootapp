package edu.swe425.mum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@NotEmpty(message = "*Product Name is required")
	private String productName;
	
	@NotEmpty(message = "*Product description is required")
	private String productDescription;
	
	@NotEmpty(message = "*Product price is required")
	private String productPrice;
	
	@NotEmpty(message = "*Product image is required")
	private String productImage;
	
	public Product() {
		super();
	}
	
	public Product(long productId, String productName, String productDescription, String productPrice, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productImage == null) ? 0 : productImage.hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product product = (Product) obj;
		if (productImage == null) {
			if (product.productImage != null) {
				return false;
			}
		} else if (!productImage.equals(product.productImage)) {
			return false;
		}
		if (productPrice == null) {
			if (product.productPrice != null) {
				return false;
			}
		} else if (!productPrice.equals(product.productPrice)) {
			return false;
		}
		if (productDescription == null) {
			if (product.productDescription != null) {
				return false;
			}
		} else if (!productDescription.equals(product.productDescription)) {
			return false;
		}
		if (productName == null) {
			if (product.productName != null) {
				return false;
			}
		} else if (!productName.equals(product.productName)) {
			return false;
		}
		if (productId != product.productId) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Product [productId=%s, productName=%s, productDescription=%s, productPrice=%s, productImage=%s]",
				productId, productName, productDescription, productPrice, productImage);
	}
}
