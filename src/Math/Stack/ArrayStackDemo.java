package Java.Math.Stack;

import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);
		String key = "";
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		while (flag) {
			System.out.println("show:显示栈");
			System.out.println("exit:退出程序");
			System.out.println("push:添加数据到栈中(入栈)");
			System.out.println("pop:从栈顶取出数据(出栈)");
			System.out.println("请输入您的选择");
			key = input.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数");
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
					System.out.printf("出栈的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("您的输入有误请重新输入!");
				break;
			}
		}
	}
}

//定义一个类ArrayStack表示栈
class ArrayStack {

	private int maxSize;// 栈的大小
	private int stack[];// 数组模拟栈，数据就放在该数组
	private int top = -1;// top表示栈顶,初始化为-1
	// 构造器

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	// 判断栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 判断栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈
	public void push(int value) {
		// 先判断栈是否已满
		if (isFull() == true) {
			System.out.println("栈满了！");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈pop将栈顶的数据返回
	public int pop() {
		if (isEmpty() == true) {
			throw new RuntimeException("栈空！沒有数据");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 显示栈的情况[遍历栈],遍历时需要从栈顶开始显示数据
	public void list() {
		if (isEmpty() == true) {
			System.out.println("栈空没有数据！");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}