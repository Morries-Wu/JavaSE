package Java.Math.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {


		// �ȶ�����沨�����ʽ
		// ��30+4)x5-6=> 3 4 - 5 x 6 - =>164
		// ˵��Ϊ�˷���,�沨�����ʽ�����ֺͷ���ʹ�ÿո����
		String suffixExpression = "30 4 + 5 * 6 -";
		PolandNotation polandNotation = new PolandNotation();
		List<String> list = polandNotation.getListString(suffixExpression);
		System.out.println(list);
		int result = polandNotation.Calculate(list);
		System.out.printf("������Ϊ%d\n", result);
		// 1.�Ƚ�"3 4 + 5 * 6 -"=>�ŵ�ArrayList��
		// 2.��ArrayList���ݸ�һ������,���ջ��ɼ���
		// ��һ���沨�����ʽ,���ν����ݺ���������뵽ArrayList��

	}

	

	public List<String> getListString(String expression) {
		String temp[] = expression.split(" ");
		List<String> list = new ArrayList<>();
		for (String i : temp) {
			list.add(i);
		}
		return list;
	}

	// ��ɶ��沨�����ʽ������
	// 1.������ɨ��,��3��4ѹ���ջ
	// 2.����+���������˵���3��4��4Ϊջ��Ԫ��,3Ϊ�ζ�Ԫ�أ��������3+4��ֵ,��7,�ٽ�7��ջ
	// 3.��5��ջ
	// 4.��������x���������˵���5��7�������7x5=35����35��ջ
	// 5.��6��ջ
	public int Calculate(List<String> list) {
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

	public int CalculateResult(int num1, int num2, String sign) {
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
