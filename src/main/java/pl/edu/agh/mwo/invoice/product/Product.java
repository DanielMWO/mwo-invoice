package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;
	
	private final BigDecimal priceWithTax;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		if ( name == null || name.isEmpty() ) {
			throw new IllegalArgumentException("Name is empty or null");
		}
		if ( price == null || price.signum() == -1) {
			throw new IllegalArgumentException("Price is negative or null");
			 
		}
		
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		this.priceWithTax = (price.multiply(taxPercent).add(price));
	
		}
	

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return priceWithTax;	}
}
