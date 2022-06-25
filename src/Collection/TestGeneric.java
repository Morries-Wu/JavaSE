 package Collection;

import java.util.ArrayList;
import java.util.List;

//genericity
public class TestGeneric {
	public static void main(String[] args) {
		MyCollection<String> myCollection = new MyCollection<String>();
		myCollection.set("Ïé¸ç", 0);
		String b = myCollection.get(0);
		System.out.println(b);
	}
}

class MyCollection<E> {
	Object object[] = new Object[5];

	public void set(E obj, int index) {
		object[index] = obj;
	}

	public E get(int index) {
		return (E) object[index];
	}

}
