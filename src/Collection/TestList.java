package Collection;

import java.util.*;

public class TestList {
	public static void main(String[] args) {
		Collection<String> C = new ArrayList<>();
		System.out.println(C.size());
		System.out.println(C.isEmpty());
		C.add("Ïé¸ç");
		C.add("Ïé¸ç¶þ");
		System.out.println(C);
          
		System.out.println(C.contains("Ïé¸ç"));
		Object objs[] = C.toArray();
		System.out.println(objs);
		System.out.println(objs[1]);
	}
}
