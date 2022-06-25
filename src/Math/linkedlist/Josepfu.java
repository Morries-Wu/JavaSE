package Java.Math.linkedlist;

public class Josepfu {
	public static void main(String[] args) {
		CircleSingleLinkedList List = new CircleSingleLinkedList();
		List.addBoy(25);
		List.countBoy(1, 2, 25);
	}

}

class CircleSingleLinkedList {
	private Boy first = new Boy(-1);
	private Boy last = null;

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				last = boy;
			} else {
				last.setNext(boy);
				last = boy;
			}
		}
		last.setNext(first);
	}

	public void ShowAll() {
		if (first == null) {
			System.out.println("沒有任何小孩");
		}
		Boy temp = first;
		while (true) {
			System.out.println(temp.getNo());
			temp = temp.getNext();
			if (temp == first)
				break;
		}
	}

	public void countBoy(int startNo, int countNum, int Nums) {

		// StartNo 表示从第几个小孩开始数数
		// countNum 表示数几下
		// Nums 表示最初有多少个小孩在圈中

		if (first == null || startNo < 1 || startNo > Nums) {
			System.out.println("参数输入有误,请重新输入");
			return;
		}
		// 创建要给辅助指针,帮助完成小孩出圈
		Boy temp = last;
		// 需要创建一个辅助指针temp,事先应该指向环形链表的最后这个节点
		// 小孩报数钱，先让first和temp移动startNo-1次
		for (int i = 0; i < startNo - 1; i++) {
			first = first.getNext();
			temp = temp.getNext();
		}
		// 当小孩报数时让first和temp指针同时移动m-1次然后出圈
		// 这里十个循环操作，直到圈中只有一个节点
		while (true) {
			// 让first和temp指针同时移动countNum-1次，然后出圈
			if (temp == first) {
				System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());
				first = last = null;
				break;
			}
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				temp = temp.getNext();
			}
			// 这时first指向的节点,就是要出圈的小孩的节点
			System.out.printf("小孩%d出圈\n", first.getNo());
			// 这时first指向的小孩节点出圈
			first = first.getNext();
			temp.setNext(first);
		}
	}

}

class Boy {
	private int no;// 编号
	private Boy next;

	public Boy(int no) {
		super();
		this.no = no;
		this.next = null;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}