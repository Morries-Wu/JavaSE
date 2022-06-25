package Mycollection;

//�Զ���һ������
public class SxtLinkedList<E> {
	private Node first;
	private Node last;
	private int size = 0;

	//˫������
	public void add(E element) {
		Node newnode = new Node(element);
		if (first == null) {
			first = newnode;
			last = newnode;
		} else {
			newnode.previous = last;
			newnode.next = null;
			last.next = newnode;
			last = newnode;
		}
		size++;
	}
	
	//˫������
	public void add(int index, E element) {
		CheckRange(index);
		Node newnode = new Node(element);
		Node temp = getNode(index);

		if (temp != null) {
			
			if (index == 0) {
				newnode.next = first;
				first.previous = newnode;
				first = newnode;
			}

			if (index == size - 1) {
				last.previous.next = newnode;
				newnode.previous = last.previous;
				newnode.next = last;
				last.previous = newnode;
			}
			
			Node up = temp.previous;
			up.next = newnode;
			newnode.previous = up;
			newnode.next = temp;
			temp.previous = newnode;
		}
		size++;
	}

	public void remove(int index) {
		CheckRange(index);
		Node temp = getNode(index);
		if (temp != null) {
			Node up = temp.previous;
			Node down = temp.next;
			if (up != null) {
				up.next = down;
			}
			if (down != null) {
				down.previous = up;
			}

			if (index == 0) {
				first = down;
			}

			if (index == size - 1) {
				last = up;
			}
			size--;
		}
	}

	private Node getNode(int index) {
		Node temp = null;
		if (index <= (size >> 1)) { // �൱size����2
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = last;
			for (int i = 0; i > index; i--) {
				temp = temp.previous;
			}
		}
		return temp;
	}

	public Object get(int index) {
		CheckRange(index);
		Node temp = getNode(index);
		return temp != null ? temp.element : null;
	}

	private void CheckRange(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("�������ֲ��Ϸ���" + index);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = first;
		while (temp != null) {
			sb.append(temp.element + ",");
			temp = temp.next;
		}
		sb.setCharAt(sb.length() - 1, ']');// Atʲôʲô�Ǳ�ʾ����length-1���������һ��Ԫ��
		return sb.toString();
	}

	public static void main(String[] args) {
		SxtLinkedList<String> list = new SxtLinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
//		System.out.println(list);
//		list.remove(3);
//		System.out.println(list);
//		list.remove(0);
//		System.out.println(list);
//
//		System.out.println();
//		list.remove(0);
//		System.out.println(list);
//		list.remove(1);
//		System.out.println(list);
//		list.remove(0);
//		System.out.println(list);
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		list.add("e");
//		list.add("f");
//		System.out.println(list);
		list.add(0, "forever  god");
//		System.out.println(list);
//		list.add(7, "forever  god");
		System.out.println(list);
	}

}
