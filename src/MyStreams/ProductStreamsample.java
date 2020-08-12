package MyStreams;

import java.io.BufferedReader;
import java.io.FileReader;

public class ProductStreamsample {

	public static void main(String ar[]) throws Exception
	{
	FileReader file=new FileReader("product.csv");
	BufferedReader buff=new BufferedReader(file);
	String line;
	String data[]=new String[14]; 
	int count=0;
	while( (line=buff.readLine())!=null)
	{
		data[count]=line;
		System.out.println(line);
		count++;
	}
	
	for(int i=1;i<=count-1;i++)
	{
		String products[]=data[i].split(",");
		if (products[0].toLowerCase().contains("nuts"))
		{
			System.out.println("Price of Nuts is " + products[1]);
		}
				
	}
	
	}
	
}
