package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
    private final int invoiceNo;
	private static int counter = 0;
	
     public Invoice() {
    	 this.invoiceNo = counter+1;
    	 counter = counter +1;
     }
    
	public void addProduct(Product product) {
		addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException();
		}
		products.put(product, quantity);
	}

	public BigDecimal getNetTotal() {
		BigDecimal totalNet = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalNet = totalNet.add(product.getPrice().multiply(quantity));
		}
		return totalNet;
	}

	public BigDecimal getTaxTotal() {
		return getGrossTotal().subtract(getNetTotal());
	}

	public BigDecimal getGrossTotal() {
		BigDecimal totalGross = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
		}
		return totalGross;
	}

	public int getInvoiceNumber() {
		// TODO Auto-generated method stub
		return invoiceNo;
	}

	public String printInvoice() {
		String invoiceNoString = Integer.toString(invoiceNo);
		for (Product  p : products.keySet()) {
			
			invoiceNoString += "\n";
			invoiceNoString += p.getName();
			invoiceNoString += products.get(p);
			invoiceNoString += p.getPrice();
		}
		
		return invoiceNoString;
	}	
	/*public String printInvoiceStream() {
		String invoiceNoString = Integer.toString(invoiceNo);
		invoiceNoString += products.keySet().stream()
				.map(product -> product.getName() + " " +products.get(product)
	}*/

	
}
