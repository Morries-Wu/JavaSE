package Java.Math.linkedlist;

import java.lang.Thread.State;
import java.util.Stack;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		Node node1 = new Node(1, "�ν�", "��ʱ��");
		Node node2 = new Node(2, "¬����", "������");
		Node node3 = new Node(3, "����", "�Ƕ���");
		Node node4 = new Node(4, "�ֳ�", "����ͷ");
		SingleLinkedList list = new SingleLinkedList();
//		list.add(node1);
//		list.add(node2);
//		list.add(node3);
//		list.add(node4);

		list.addByOrder(node1);
		list.addByOrder(node4);
		list.addByOrder(node2);
		list.addByOrder(node3);

		list.showall();
		Node node5 = new Node(2, "С��", "������");
		list.update(node5);
		System.out.println();
		list.showall();
		System.out.println("\n��������������Ч���ĸ���");
		System.out.println("��Ч������=" + list.getLength());
		System.out.println("\n���Բ�����������K���ڵ�����");
		System.out.println(list.findLastindexNode(2));
		System.out.println("\n���Ե�����ķ�ת����1");
		list.ReverseList1();
		list.showall();
		System.out.println("\n���Ե�����ķ�ת����2");
		list.ReverseList2();
	}
}

//����SingleLinkedlist�������ǵĽ��
class SingleLinkedList {
	// �ȳ�ʼ��һ��ͷ�ڵ��һ��β��㣬ͷ�ڵ㲻Ҫ��������ž��������
	private Node head = new Node(0, "", "");
	private Node end = null;

	public Node getHead() {
		return head;
	}

	/*
	��ӽ�㵽������
	˼·���������Ǳ��˳��ʱ
	1.�ҵ���ǰ�����ͷ�ڵ�
	2.�������ɵĽ�����һ�����ָ��ͷ�ڵ��next
	*/
	public void add(Node newnode) {
		if (head.next == null) {
			head.next = newnode;
			end = newnode;
		}
		end.next = newnode;
		end = newnode;
	}

	// �ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��
	// �������������������ʧ�ܣ���������ʾ
	public void addByOrder(Node node) {
		// ��Ϊͷ�ڵ㲻�ܶ�,���������Ȼͨ��һ������ָ�루�����������������ҵ���ӵ�λ��
		// ��Ϊ�����ҵ���temp��λ�����λ�õ�ǰһ�����,������벻��
		Node temp = head;
		boolean flag = false; // flag��־��ӵı���Ƿ����,Ĭ��Ϊfalse
		while (temp.next != null) { // ˵��temp.next�Ѿ�����������
			if (temp.next.no > node.no) {// λ���ҵ�������temp�ĺ������
				break;
			} else if (temp.next.no == node.no) {// ˵��ϣ����ӵ�node�ı���Ѿ�����
				System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ�������,���ܼ�����\n", node.no);
				break;
			}
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
	}

	// �޸Ľ�����Ϣ,����no������޸�,��no��Ų��ܸ�
	// ����nenode��no���޸ļ���
	public void update(Node newnode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽ��,����no���
		// ����һ����������
		Node temp = head.next;
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
		Node temp = head;
		boolean flag = false;
		while (temp.next != null) {
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag == true) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("Ҫɾ����%d��㲻����\n", no);
		}
	}

	public int getLength() {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		Node temp = head.next;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	// ���ҵ������еĵ�����K�����
	// 1.��дһ������������head���,ͬʱ����һ��index
	// 2.index��ʾ������index�����
	// 3.�Ȱ������ͷ��β����,�õ�size֮�󣬱�����size-inde�������ǵ���index��
	public Node findLastindexNode(int index) {
		int size = getLength();
		if (head.next == null) {
			return null;
		}
		if (index <= 0 || index > size) {
			return null;
		}
		Node temp = head.next;
		for (int i = 0; i < size - index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// ��������ת
	public void ReverseList1() {
		// �����ǰ����Ϊ��,����ֻ��һ���ڵ㣬���跴תֱ�ӷ���
		if (head.next == null || head.next.next == null) {
			return;
		}
		// ����һ��������ָ�룬�������Ǳ���ԭ��������
		Node temp = head.next;
		Node next = null;// ָ����һ���Y�c
		Node reverseHead = new Node(0, "", "");
		while (temp != null) {
			next = temp.next;
			temp.next = reverseHead.next;
			reverseHead.next = temp;
			temp = next;
		}
		head.next = reverseHead.next;
	}

	public void ReverseList2() {
		if (head.next == null || head.next.next == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node temp = head.next;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}

		while (stack.size() > 0) {
			System.out.println(stack.pop());// stack�Ƚ����
		}

	}

	// ��ʾ����
	public void showall() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㲻�ܶ������������Ҫһ����������������
		Node temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			// ��temp����
			temp = temp.next;
		}
	}
}

class Node {
	public int no;
	public String name;
	public String nickname;
	public Node next;

	public Node(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
		next = null;
	}

	public String toString() {
		return "Node[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
	}
}
