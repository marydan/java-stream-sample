package MyStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

	public static void main(String[] args) throws Exception {

		 
	List<ProductInfo> products=new ArrayList<ProductInfo>();	

//	ProductInfo product3=new ProductInfo("Speaker" , 5000);
	ProductInfo product2=new ProductInfo("Inverter",26000);
	try
	{
	FileInputStream fileinput=new FileInputStream("productinfonew.dat");
	ObjectInputStream objects=new ObjectInputStream(fileinput);
	while( (products=  (List<ProductInfo>) objects.readObject() )!=null)
	{
	}
	}
	catch(Exception e)
	{
		
	}
	FileOutputStream file=new FileOutputStream("productinfonew.dat");
   ObjectOutputStream objectwrite=new ObjectOutputStream(file);	
 //  products.add(product3);
   products.add(product2);

//objectwrite.writeObject(product1);
objectwrite.writeObject(products);

objectwrite.close();

System.out.println("Object is stored in file");




	}

}
