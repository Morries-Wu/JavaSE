package Collection;

import java.util.*;

public class TestList {
	public static void main(String[] args) {
		Collection<String> C = new ArrayList<>();
		System.out.println(C.size());
		System.out.println(C.isEmpty());
		C.add("���");
		C.add("����");
		System.out.println(C);
          
		System.out.println(C.contains("���"));
		Object objs[] = C.toArray();
		System.out.println(objs);
		System.out.println(objs[1]);
	}
}
