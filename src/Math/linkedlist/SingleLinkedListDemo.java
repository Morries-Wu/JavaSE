package Java.Math.linkedlist;

import java.lang.Thread.State;
import java.util.Stack;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		Node node1 = new Node(1, "宋江", "及时雨");
		Node node2 = new Node(2, "卢俊义", "玉麒麟");
		Node node3 = new Node(3, "吴用", "智多星");
		Node node4 = new Node(4, "林冲", "豹子头");
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
		Node node5 = new Node(2, "小吕", "玉麒麟");
		list.update(node5);
		System.out.println();
		list.showall();
		System.out.println("\n测试求单链表中有效结点的个数");
		System.out.println("有效结点个数=" + list.getLength());
		System.out.println("\n测试查找链表倒数低K个节点数据");
		System.out.println(list.findLastindexNode(2));
		System.out.println("\n测试单链表的反转功能1");
		list.ReverseList1();
		list.showall();
		System.out.println("\n测试单链表的反转功能2");
		list.ReverseList2();
	}
}

//定义SingleLinkedlist管理我们的结点
class SingleLinkedList {
	// 先初始化一个头节点和一个尾结点，头节点不要动，不存放具体的数据
	private Node head = new Node(0, "", "");
	private Node end = null;

	public Node getHead() {
		return head;
	}

	/*
	添加结点到单链表
	思路，当不考虑编号顺序时
	1.找到当前链表的头节点
	2.将新生成的结点的下一个结点指向头节点的next
	*/
	public void add(Node newnode) {
		if (head.next == null) {
			head.next = newnode;
			end = newnode;
		}
		end.next = newnode;
		end = newnode;
	}

	// 第二种方式再添加英雄时，根据排名将英雄插入到指定位置
	// 如果有这个排名，则添加失败，并给出提示
	public void addByOrder(Node node) {
		// 因为头节点不能动,因此我们仍然通过一个辅助指针（变量）来帮助我们找到添加的位置
		// 因为我们找到的temp是位于添加位置的前一个结点,否则插入不了
		Node temp = head;
		boolean flag = false; // flag标志添加的编号是否存在,默认为false
		while (temp.next != null) { // 说明temp.next已经在链表的最后
			if (temp.next.no > node.no) {// 位置找到，就在temp的后面插入
				break;
			} else if (temp.next.no == node.no) {// 说明希望添加的node的编号已经存在
				System.out.printf("准备插入的英雄的编号%d已经存在了,不能加入了\n", node.no);
				break;
			}
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
	}

	// 修改结点的信息,根据no编号来修改,即no编号不能改
	// 根据nenode的no来修改即可
	public void update(Node newnode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 找到需要修改的结点,根据no编号
		// 定义一个辅助变量
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
			System.out.printf("没有找到编号%d的结点，不能修改\n", newnode);
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
			System.out.printf("要删除的%d结点不存在\n", no);
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

	// 查找单链表中的倒数第K个结点
	// 1.编写一个方法，接收head结点,同时接收一个index
	// 2.index表示倒数第index个结点
	// 3.先把链表从头到尾遍历,得到size之后，遍历（size-inde）个就是倒数index个
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

	// 將单链表反转
	public void ReverseList1() {
		// 如果当前链表为空,或者只有一个节点，无需反转直接返回
		if (head.next == null || head.next.next == null) {
			return;
		}
		// 定义一个辅助的指针，帮助我们遍历原来的链表
		Node temp = head.next;
		Node next = null;// 指向下一個結點
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
			System.out.println(stack.pop());// stack先进后出
		}

	}

	// 显示链表
	public void showall() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点不能动，因此我们需要一个辅助变量来遍历
		Node temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			// 将temp后移
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
