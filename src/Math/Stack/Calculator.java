package Java.Math.Stack;

public class Calculator {
	public static void main(String[] args) {

		String expression = "3-2*6-2";
		// ��������ջ,��ջ�ͷ���ջ
		Stack numStack = new Stack(10);
		Stack operStack = new Stack(10);
		// ������Ҫ����ر���
		int index = 0;// ����ɨ��  
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';// ��ÿ��ɨ��õ�char���浽ch
		String keepnum = "";
		// ��ʼwhileѭ��ɨ��expression
		while (true) {
			// ���εõ�expression��ÿ���ַ�
			ch = expression.substring(index, index + 1).charAt(0);
			// �ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
			if (operStack.isOper(ch) == true) {// ����������
				// �жϵ�ǰ����ջ�Ƿ�Ϊ��
				if (!operStack.isEmpty()) {
					// �������ջ�в�����,�ͽ��бȽ�,�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ�����,����Ҫ��ջ��pop��������
					// �ӷ�����pop��һ������,��������,���õ����������ջ,Ȼ�󽫵�ǰ�����������ջ
					if (operStack.priority(ch) <= operStack.priority(operStack.getTop())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.calculate(num1, num2, oper);
						// ������������ջ
						numStack.push(res);
						// Ȼ��ѵ�ǰ�Ĳ����������ջ
						operStack.push(ch);
					} else {
						// �����ǰ�Ĳ����������ȼ�����ջ�еĲ�����,��ֱ�������ջ
						operStack.push(ch);
					}
				} else {
					// ���Ϊ��ֱ����ջ
					operStack.push(ch);
				}
			} else {
				// ���������ֱ������ջ
				// numStack.push(ch - 48);
				// 1.�����λ��,��Ҫ��expression�ı��ʽindex���ٿ�һλ,��������ͼ�������ɨ��,����Ƿ��Ų���ջ
				// 2.���������Ҫ����һ���ַ�������,����ƴ��
				keepnum += ch;
				// ���ch�Ѿ���expression�����һλ,��ֱ����ջ
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepnum));
				} else {
					// �ж���һ���ַ��ǲ�������,��������֣������ɨ��,����������,����ջ
					// ע���ǿ���һλ,����index++
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						// �������Ϊ�������,����ջ
						numStack.push(Integer.parseInt(keepnum));
						// ��Ҫ�ģ�keepnum���
						keepnum = "";
					}
				}

			}
			// ��index+1,���ж��Ƿ�ɨ�赽expression���
			index++;
			if (index >= expression.length()) {
				break;
			}
		}

		// �����ʽɨ�����,��˳��Ĵ���ջh�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������
		while (true) {
			// �������ջΪ��,����㵽���Ľ������ջ��ֻ��һ�����֡������
			if (operStack.isEmpty() == true) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.calculate(num1, num2, oper);
			// ������������ջ
			numStack.push(res);
		}
		// ����ջ�������,pop�������ǽ��
		int res2 = numStack.pop();
		System.out.printf("���ʽ%s=%d", expression, res2);

	}
}

//����һ����Stack��ʾջ
class Stack {

	private int maxSize;// ջ�Ĵ�С
	private int stack[];// ����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1;// top��ʾջ��,��ʼ��Ϊ-1
	// ������

	public Stack(int maxSize) {
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

	// ��������������ȼ������ȼ��ǳ���Ա��ȷ��,���ȼ�ʹ�����ֱ�ʾ,����Խ�����ȼ�Խ��
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;// �ٶ�Ŀǰ�ı��ʽֻ��+��-��*��/
		}
	}

	// �ж��Ƿ���һ�������
	public boolean isOper(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/';
	}

	// ���㷽��
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