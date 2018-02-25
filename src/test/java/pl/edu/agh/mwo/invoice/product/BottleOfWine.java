package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends OtherProduct implements IExciseTax {

	public BottleOfWine(String name, BigDecimal price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal getExciseTax() {
		// TODO Auto-generated method stub
		return new BigDecimal("5.56");
	}

	@Override
	public BigDecimal getPriceWithTax() {
		
		return super.getPriceWithTax().add(getExciseTax());
	}
}