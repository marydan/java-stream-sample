package MyStreams;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProductAccess {

	public static void main(String[] args) throws Exception{

ProductInfo productinfo;
List<ProductInfo> myproducts=new ArrayList<ProductInfo>();
ProductService products;

FileInputStream fileread=new FileInputStream("productinfonew.dat");
ObjectInputStream objectout=new ObjectInputStream(fileread);

	try
	{
		myproducts=(List<ProductInfo>) objectout.readObject();
		
		ListIterator<ProductInfo> list=myproducts.listIterator();
		while(list.hasNext())
		{
			ProductInfo product=list.next();
			System.out.println("Product name"+ product.getProductname() + product.getPrice() );
		}
				
//		while ( (productinfo=(ProductInfo) objectout.readObject())!=null)
//		{
//		System.out.println("Product name"+ productinfo.getProductname() + productinfo.getPrice() );
//		}
	}
	catch(Exception eof)
		{
		System.out.println(eof.getMessage());
		objectout.close();
		}

	} //main
}
