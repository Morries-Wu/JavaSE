package Mycollection;

//�Զ���ʵ��һ��Arraylist,���ײ�ԭ��
public class SxtArrayList<E> {

	private Object elementData[];// �������飬�洢����
	private int size = 0;
	private final int DEFAULT_CAPACITY = 10;

	public SxtArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public SxtArrayList(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("��������������Ϊ����");
		} else if (capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];
		}
		elementData = new Object[capacity];
	}

	public void remove(E element) {
		// element,����������Ԫ�ذ����Ƚ�,��õ�һ���Ƚ�Ϊtrue,����
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
		// �����Ϸ��ж�[0��size) 10 0-9
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("�������Ϸ�:" + index);
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
			s1.add("������" + i);
		}
		System.out.println(s1.toString());
		s1.remove(1);
		System.out.println(s1.toString());
		System.out.println(s1.size);
	}

}
