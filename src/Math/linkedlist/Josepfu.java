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
			System.out.println("nums��ֵ����ȷ");
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
			System.out.println("�]���κ�С��");
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

		// StartNo ��ʾ�ӵڼ���С����ʼ����
		// countNum ��ʾ������
		// Nums ��ʾ����ж��ٸ�С����Ȧ��

		if (first == null || startNo < 1 || startNo > Nums) {
			System.out.println("������������,����������");
			return;
		}
		// ����Ҫ������ָ��,�������С����Ȧ
		Boy temp = last;
		// ��Ҫ����һ������ָ��temp,����Ӧ��ָ����������������ڵ�
		// С������Ǯ������first��temp�ƶ�startNo-1��
		for (int i = 0; i < startNo - 1; i++) {
			first = first.getNext();
			temp = temp.getNext();
		}
		// ��С������ʱ��first��tempָ��ͬʱ�ƶ�m-1��Ȼ���Ȧ
		// ����ʮ��ѭ��������ֱ��Ȧ��ֻ��һ���ڵ�
		while (true) {
			// ��first��tempָ��ͬʱ�ƶ�countNum-1�Σ�Ȼ���Ȧ
			if (temp == first) {
				System.out.printf("�������Ȧ�е�С�����%d\n", first.getNo());
				first = last = null;
				break;
			}
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				temp = temp.getNext();
			}
			// ��ʱfirstָ��Ľڵ�,����Ҫ��Ȧ��С���Ľڵ�
			System.out.printf("С��%d��Ȧ\n", first.getNo());
			// ��ʱfirstָ���С���ڵ��Ȧ
			first = first.getNext();
			temp.setNext(first);
		}
	}

}

class Boy {
	private int no;// ���
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