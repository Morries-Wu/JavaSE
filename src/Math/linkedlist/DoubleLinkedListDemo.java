package Java.Math.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("˫���������");
		Node2 node1 = new Node2(1, "�ν�", "��ʱ��");
		Node2 node2 = new Node2(2, "¬����", "������");
		Node2 node3 = new Node2(3, "����", "�Ƕ���");
		Node2 node4 = new Node2(4, "�ֳ�", "����ͷ");
		DoubleLinkedList list = new DoubleLinkedList();
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.showall();

		System.out.println("\n�����޸Ĺ���");
		Node2 node5 = new Node2(4, "����ʤ", "������");
		list.update(node5);
		list.showall();
		System.out.println("\n���Ԅh������");
		for (int i = 1; i <= 4; i++) {
			list.delete(i);
			list.showall();
			System.out.println();
		}
	}

}

class DoubleLinkedList {
	// �ȳ�ʼ��һ��ͷ�ڵ�,ͷ�ڵ㲻��,����ž�������
	private Node2 head = new Node2(0, "", "");
	private Node2 end = new Node2(0, "", "");

	public Node2 getHead() {
		return head;
	}

	public void add(Node2 newnode) {
		if (head.next == null) {
			head.next = newnode;
			newnode.previous = head;
			end = newnode;
		}
		end.next = newnode;
		newnode.previous = end;
		end = newnode;
	}

	public void update(Node2 newnode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽ��,����no���
		// ����һ����������
		Node2 temp = head.next;
		boolean flag = false;
		while (temp != null) {
			temp = temp.next;
			if (temp.no == newnode.no) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			temp.name = newnode.name;
			temp.nickname = newnode.nickname;
		} else {
			System.out.printf("û���ҵ����%d�Ľ�㣬�����޸�\n", newnode);
		}
	}

	public void delete(int no) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		Node2 temp = head.next;
		boolean flag = false;
		while (temp != null) {
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		if (flag == true) {
			if (temp == head.next) {
				head.next = temp.next;
			} else {
				temp.previous.next = temp.next;
			}
			
			if (temp.next != null) {
				temp.next.previous = temp.previous;
			}
		} else {
			System.out.printf("Ҫɾ����%d��㲻����\n", no);
		}
	}

	public void showall() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㲻�ܶ������������Ҫһ����������������
		Node2 temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			// ��temp����	
			temp = temp.next;
		}
	}
}

class Node2 {
	public int no;
	public String name;
	public String nickname;
	public Node2 next;
	public Node2 previous;

	public Node2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
		next = previous = null;
	}

	public String toString() {
		return "Node[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
	}
}