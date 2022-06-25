package Java.Math.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToPolandNotation {
	public static void main(String[] args) {
		// ��ɽ�һ����׺���ʽת�ɺ�׺���ʽ�Ĺ���
		// 1. 1+((2+3)x4)-5 => 1 2 3 + 4 x + 5 -
		// 2.�Ƚ�1+((2+3)x4)-5ת����׺���ʽ��Ӧ��List
		// ��1+((2+3)x4)-5 =>ArrayList[1,(,(2,+,3,),x,4,),-,5]
		String expression = "1+((2+5)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("��׺���ʽ��Ӧ��List" + infixExpressionList);
		List<String> suffixExpreesionList = parseSuffixExpression(infixExpressionList);
		System.out.println("��׺���ʽ��Ӧ��List" + suffixExpreesionList);
		System.out.println(Calculate(suffixExpreesionList));
	}

	public static List<String> toInfixExpressionList(String expression) {
		List<String> list = new ArrayList<>();
		int i = 0;// ��ʱ��һ��ָ�룬���ڱ�����׺���ʽ�ַ���
		String str = "";// ��λ����ƴ��
		char c;// ÿ������һ���ַ�,�ͷ��뵽c
		do {
			if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {// �������ֵ�ASCII
				// ���c��һ�������֣���Ҫ���뵽list
				list.add("" + c);
				i++;
			} else {
				// �����һ��������Ҫ���Ƕ�λ��
				str = "";
				while (i < expression.length() && (c = expression.charAt(i)) > 48 && (c = expression.charAt(i)) <= 57) {
					str = str + c;
					i++;
				}
				list.add(str);
			}
		} while (i < expression.length());

		return list;
	}

	public static List<String> parseSuffixExpression(List<String> list) {
		// ��������ջ
		Stack<String> s1 = new Stack<String>();// ����ջ
		// ��Ϊs2���ջ,������ջת����,û��pop����,���Һ������ǻ���Ҫ�������
		// ��˱Ƚ��鷳,�������ǾͲ���Stack<String>ֱ����List<String>
		// Stack<String> s2 = new Stack<>();// �洢�м�����ջ
		List<String> s2 = new ArrayList<String>();// �洢�м�����List
		for (String item : list) {
			// �����һ�����ͼ��뵽s2
			if (item.matches("\\d+")) {// ������ʽ
				s2.add(item);
			} else if (item.equals("(")) {
				s1.push(item);
			} else if (item.equals(")")) {
				// �����������")",�����ε���s1ջ���������,��ѹ��s2��ֱ������������Ϊֹ,��ʱ����һ�����Ŷ���
				while (!s1.peek().equals("(") ) {
					s2.add(s1.pop());
				}
				s1.pop();// ���ص㡿��'�� '����s1ջ,����С����
			} else {
				// ��item�����ȼ�С�ڵ���s1ջ�������,��s1ջ������������������뵽s2��,�ٴ�ת��(4.1)��s1���µ�ջ���������Ƚ�
				// ���⣺ȱ��һ���Ƚ����ȼ��ߵ͵ķ���
				// �����ǰitem�������ջ�����������ֱ����ջ��������㼰��ջ������ִ�����в�������ջ
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		// ��s1ʣ�����������ε���������s2
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;// ע����Ϊ�Ǵ�ŵ�List����˰�˳��������Ƕ�Ӧ��׺���ʽ��Ӧ��List
	}

	// ��ɶ��沨�����ʽ������
	// 1.������ɨ��,��3��4ѹ���ջ
	// 2.����+���������˵���3��4��4Ϊջ��Ԫ��,3Ϊ�ζ�Ԫ�أ��������3+4��ֵ,��7,�ٽ�7��ջ
	// 3.��5��ջ
	// 4.��������x���������˵���5��7�������7x5=35����35��ջ
	// 5.��6��ջ
	public static int Calculate(List<String> list) {
		// ����ջ,ֻ��Ҫһ��ջ�Ϳ�����
		Stack<String> stack = new Stack<>();
		// ����list
		int result = 0;
		for (String item : list) {
			// ʹ��������ʽ��ȡ������Ŀ
			if (item.matches("\\d+")) {
				// ƥ����Ƕ�λ��,ֱ���뗣
				stack.push(item);
			} else {
				// pop��������������,������
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				result = CalculateResult(num1, num2, item);
				stack.push(result + "");
			}
		}
		// �������Stack�е�������������
		return Integer.parseInt(stack.pop());
	}

	public static int CalculateResult(int num1, int num2, String sign) {
		int res = 0;
		switch (sign) {
		case "+":
			res = num2 + num1;
			break;
		case "-":
			res = num2 - num1;
			break;
		case "*":
			res = num2 * num1;
			break;
		case "/":
			res = num2 / num1;
			break;
		default:
			throw new RuntimeException("�\������`��");
		}
		return res;
	}
}

//��дһ����Operation ���Է���һ���������Ӧ�����ȼ�	
class Operation {
	private static int ADD_SUB = 1;
	private static int MUL_DIV = 2;

	// дһ������,���ض�Ӧ�����ȼ�����
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD_SUB;
			break;
		case "-":
			result = ADD_SUB;
			break;
		case "*":
			result = MUL_DIV;
			break;
		case "/":
			result = MUL_DIV;
			break;
		case "(":
			break;
		default:
			System.out.println("�����ڸ��������");
			break;
		}
		return result;
	}
}
