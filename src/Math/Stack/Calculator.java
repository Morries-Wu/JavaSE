package Java.Math.Stack;

public class Calculator {
	public static void main(String[] args) {

		String expression = "3-2*6-2";
		// 创建两个栈,数栈和符号栈
		Stack numStack = new Stack(10);
		Stack operStack = new Stack(10);
		// 定义需要的相关变量
		int index = 0;// 用于扫描  
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';// 将每次扫描得到char保存到ch
		String keepnum = "";
		// 开始while循环扫描expression
		while (true) {
			// 依次得到expression的每个字符
			ch = expression.substring(index, index + 1).charAt(0);
			// 判断ch是什么，然后做相应的处理
			if (operStack.isOper(ch) == true) {// 如果是运算符
				// 判断当前符号栈是否为空
				if (!operStack.isEmpty()) {
					// 如果符号栈有操作符,就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从栈中pop出两个数
					// 从符号中pop出一个符号,进行运算,将得到结果，入数栈,然后将但前操作符入符号栈
					if (operStack.priority(ch) <= operStack.priority(operStack.getTop())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.calculate(num1, num2, oper);
						// 把运算结果入数栈
						numStack.push(res);
						// 然后把当前的操作符入符号栈
						operStack.push(ch);
					} else {
						// 如果当前的操作符的优先级大于栈中的操作符,就直接入符号栈
						operStack.push(ch);
					}
				} else {
					// 如果为空直接入栈
					operStack.push(ch);
				}
			} else {
				// 如果是数字直接入数栈
				// numStack.push(ch - 48);
				// 1.处理多位数,需要向expression的表达式index后再看一位,如果是数就继续进行扫描,如果是符号才入栈
				// 2.因此我们需要定义一个字符串变量,用于拼接
				keepnum += ch;
				// 如果ch已经是expression的最后一位,就直接入栈
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepnum));
				} else {
					// 判断下一个字符是不是数字,如果是数字，则继续扫描,如果是运算符,则入栈
					// 注意是看后一位,不是index++
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						// 如果后以为是运算符,则入栈
						numStack.push(Integer.parseInt(keepnum));
						// 重要的！keepnum清空
						keepnum = "";
					}
				}

			}
			// 让index+1,并判断是否扫描到expression最后
			index++;
			if (index >= expression.length()) {
				break;
			}
		}

		// 当表达式扫描完毕,就顺序的从数栈h和符号栈中pop出相应的数和符号，并运行
		while (true) {
			// 如果符号栈为空,则计算到最后的结果，数栈中只有一个数字【结果】
			if (operStack.isEmpty() == true) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.calculate(num1, num2, oper);
			// 把运算结果入数栈
			numStack.push(res);
		}
		// 将数栈的最后数,pop出，就是结果
		int res2 = numStack.pop();
		System.out.printf("表达式%s=%d", expression, res2);

	}
}

//定义一个类Stack表示栈
class Stack {

	private int maxSize;// 栈的大小
	private int stack[];// 数组模拟栈，数据就放在该数组
	private int top = -1;// top表示栈顶,初始化为-1
	// 构造器

	public Stack(int maxSize) {
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

	// 返回运算符的优先级，优先级是程序员来确定,优先级使用数字表示,数字越大优先级越高
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;// 假定目前的表达式只有+、-、*、/
		}
	}

	// 判断是否是一个运算符
	public boolean isOper(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/';
	}

	// 计算方法
	public int calculate(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		}
		return res;
	}

	public int getTop() {
		return stack[top];
	}

}