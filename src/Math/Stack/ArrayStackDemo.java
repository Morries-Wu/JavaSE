package Java.Math.Stack;

import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);
		String key = "";
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		while (flag) {
			System.out.println("show:��ʾջ");
			System.out.println("exit:�˳�����");
			System.out.println("push:������ݵ�ջ��(��ջ)");
			System.out.println("pop:��ջ��ȡ������(��ջ)");
			System.out.println("����������ѡ��");
			key = input.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ����");
				int value = input.nextInt();
				stack.push(value);
				break;
			case "exit":
				input.close();
				flag = false;
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ��������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("����������������������!");
				break;
			}
		}
	}
}

//����һ����ArrayStack��ʾջ
class ArrayStack {

	private int maxSize;// ջ�Ĵ�С
	private int stack[];// ����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1;// top��ʾջ��,��ʼ��Ϊ-1
	// ������

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	// �ж�ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// �ж�ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��ջ
	public void push(int value) {
		// ���ж�ջ�Ƿ�����
		if (isFull() == true) {
			System.out.println("ջ���ˣ�");
			return;
		}
		top++;
		stack[top] = value;
	}

	// ��ջpop��ջ�������ݷ���
	public int pop() {
		if (isEmpty() == true) {
			throw new RuntimeException("ջ�գ��]������");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// ��ʾջ�����[����ջ],����ʱ��Ҫ��ջ����ʼ��ʾ����
	public void list() {
		if (isEmpty() == true) {
			System.out.println("ջ��û�����ݣ�");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}