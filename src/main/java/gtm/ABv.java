package gtm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ABv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> a = new HashMap<String, Integer>();
		a.put("h", 2);
		a.put("e", 1);
		a.put("l", 3);
		
		for(Entry<String, Integer> b: a.entrySet()) {
			System.out.println(b.getKey());
			System.out.println(b.getValue());
		}
		
	}

}
