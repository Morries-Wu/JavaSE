package Mycollection;

//自定义实现一个Arraylist,体会底层原理
public class SxtArrayList<E> {

	private Object elementData[];// 核心数组，存储内容
	private int size = 0;
	private final int DEFAULT_CAPACITY = 10;

	public SxtArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public SxtArrayList(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("容器的容量不能为负数");
		} else if (capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];
		}
		elementData = new Object[capacity];
	}

	public void remove(E element) {
		// element,将它和所有元素挨个比较,获得第一个比较为true,返回
		for (int i = 0; i < size; i++) {
			if (element.equals(get(i)) == true) {
				System.out.println(i);
				remove(i);
			}
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public void remove(int index) {
		if ((elementData.length - index) > 0 && index >= 0) {
			System.arraycopy(elementData, index, elementData, index - 1, elementData.length - index);
		}
		elementData[--size] = null;
	}

	public void CheckRange(int index) {
		// 索引合法判断[0，size) 10 0-9
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引不合法:" + index);
		}
	}

	public void add(E element) {
		if (size == elementData.length) {
			Object newArray[] = new Object[elementData.length + (elementData.length >> 1)];// 10-->10+10/2
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = element;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		// [a,b,c]
		sb.append("[");
		for (int i = 0; i < size - 1; i++) {
			sb.append(elementData[i] + ",");
		}
		sb.append(elementData[size - 1] + "]");
		return sb.toString();
	}

	public E get(int index) {
		CheckRange(index);
		return (E) elementData[index];
	}

	public void set(E element, int index) {
		CheckRange(index);
		elementData[index] = element;
	}

	public static void main(String[] args) {
		SxtArrayList s1 = new SxtArrayList(10);
		for (int i = 0; i <10; i++) {
			s1.add("奥利奥" + i);
		}
		System.out.println(s1.toString());
		s1.remove(1);
		System.out.println(s1.toString());
		System.out.println(s1.size);
	}

}
