package Java.Math.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("双向链表测试");
		Node2 node1 = new Node2(1, "宋江", "及时雨");
		Node2 node2 = new Node2(2, "卢俊义", "玉麒麟");
		Node2 node3 = new Node2(3, "吴用", "智多星");
		Node2 node4 = new Node2(4, "林冲", "豹子头");
		DoubleLinkedList list = new DoubleLinkedList();
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.showall();

		System.out.println("\n测试修改功能");
		Node2 node5 = new Node2(4, "公孙胜", "入云龙");
		list.update(node5);
		list.showall();
		System.out.println("\n测试刪除功能");
		for (int i = 1; i <= 4; i++) {
			list.delete(i);
			list.showall();
			System.out.println();
		}
	}

}

class DoubleLinkedList {
	// 先初始化一个头节点,头节点不动,不存放具体数据
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
			System.out.println("链表为空");
			return;
		}
		// 找到需要修改的结点,根据no编号
		// 定义一个辅助变量
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
			System.out.printf("没有找到编号%d的结点，不能修改\n", newnode);
		}
	}

	public void delete(int no) {
		if (head.next == null) {
			System.out.println("链表为空");
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
			System.out.printf("要删除的%d结点不存在\n", no);
		}
	}

	public void showall() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点不能动，因此我们需要一个辅助变量来遍历
		Node2 temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			// 将temp后移	
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