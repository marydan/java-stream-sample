package MyStreams;

import java.io.Serializable;

public class ProductInfo implements Serializable {
  String productname;
  int price;
	public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
	ProductInfo(String prdname,int pri)
	{
		productname=prdname;
		price=pri;
	}
	
}


// marker interfaces
