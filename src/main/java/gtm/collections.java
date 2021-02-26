package gtm;

import java.util.ArrayList;
import java.util.HashSet;

public class collections {

	public static void main(String[] args) {
		
		ArrayList<String> status =new  ArrayList<String>();
		status.add("a");
		status.add("b");
		status.add("C");
		HashSet<String> dec=new HashSet<String>();  
		dec.add("z");
		dec.add("X");
		dec.add("y");
		System.out.println(dec.size());
		System.out.println(status.size());
	}

}
