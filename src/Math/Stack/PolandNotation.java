package Java.Math.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {


		// 先定义个逆波兰表达式
		// （30+4)x5-6=> 3 4 - 5 x 6 - =>164
		// 说明为了方便,逆波兰表达式的数字和符号使用空格隔开
		String suffixExpression = "30 4 + 5 * 6 -";
		PolandNotation polandNotation = new PolandNotation();
		List<String> list = polandNotation.getListString(suffixExpression);
		System.out.println(list);
		int result = polandNotation.Calculate(list);
		System.out.printf("计算结果为%d\n", result);
		// 1.先将"3 4 + 5 * 6 -"=>放到ArrayList中
		// 2.将ArrayList传递给一个方法,配合栈完成计算
		// 将一个逆波兰表达式,依次将数据和运算符放入到ArrayList中

	}

	

	public List<String> getListString(String expression) {
		String temp[] = expression.split(" ");
		List<String> list = new ArrayList<>();
		for (String i : temp) {
			list.add(i);
		}
		return list;
	}

	// 完成对逆波兰表达式的运算
	// 1.从左到右扫描,将3和4压入堆栈
	// 2.遇到+运算符，因此弹出3个4（4为栈顶元素,3为次顶元素），计算出3+4的值,得7,再将7入栈
	// 3.将5入栈
	// 4.接下来是x运算符，因此弹出5和7，计算出7x5=35，将35入栈
	// 5.将6入栈
	public int Calculate(List<String> list) {
		// 创建栈,只需要一个栈就可以了
		Stack<String> stack = new Stack<>();
		// 便利list
		int result = 0;
		for (String item : list) {
			// 使用正则表达式来取出来数目
			if (item.matches("\\d+")) {
				// 匹配的是多位數,直接入棧
				stack.push(item);
			} else {
				// pop出两个数并运算,再运算
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				result = CalculateResult(num1, num2, item);
				stack.push(result + "");
			}
		}
		// 最后留在Stack中的数据是运算结果
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
			throw new RuntimeException("運算符有誤！");
		}
		return res;
	}

}
