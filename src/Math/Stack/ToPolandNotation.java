package Java.Math.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToPolandNotation {
	public static void main(String[] args) {
		// 完成将一个中缀表达式转成后缀表达式的功能
		// 1. 1+((2+3)x4)-5 => 1 2 3 + 4 x + 5 -
		// 2.先将1+((2+3)x4)-5转成中缀表达式对应的List
		// 即1+((2+3)x4)-5 =>ArrayList[1,(,(2,+,3,),x,4,),-,5]
		String expression = "1+((2+5)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("中缀表达式对应的List" + infixExpressionList);
		List<String> suffixExpreesionList = parseSuffixExpression(infixExpressionList);
		System.out.println("后缀表达式对应的List" + suffixExpreesionList);
		System.out.println(Calculate(suffixExpreesionList));
	}

	public static List<String> toInfixExpressionList(String expression) {
		List<String> list = new ArrayList<>();
		int i = 0;// 这时是一个指针，用于遍历中缀表达式字符串
		String str = "";// 多位数的拼接
		char c;// 每遍历到一个字符,就放入到c
		do {
			if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {// 不是数字的ASCII
				// 如果c是一个非数字，需要加入到list
				list.add("" + c);
				i++;
			} else {
				// 如果是一个数，需要考虑多位数
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
		// 定义两个栈
		Stack<String> s1 = new Stack<String>();// 符号栈
		// 因为s2这个栈,在整个栈转换中,没有pop操作,而且后面我们还需要逆序输出
		// 因此比较麻烦,这里我们就不用Stack<String>直接用List<String>
		// Stack<String> s2 = new Stack<>();// 存储中间结果的栈
		List<String> s2 = new ArrayList<String>();// 存储中间结果的List
		for (String item : list) {
			// 如果是一个数就加入到s2
			if (item.matches("\\d+")) {// 正则表达式
				s2.add(item);
			} else if (item.equals("(")) {
				s1.push(item);
			} else if (item.equals(")")) {
				// 如果是右括号")",则依次弹出s1栈顶的运算符,并压入s2，直到遇到左括号为止,此时将这一对括号丢弃
				while (!s1.peek().equals("(") ) {
					s2.add(s1.pop());
				}
				s1.pop();// 【重点】将'（ '弹出s1栈,消除小括号
			} else {
				// 当item的优先级小于等于s1栈顶运算符,将s1栈顶的运算符弹出并加入到s2中,再次转到(4.1)与s1中新的栈顶运算符相比较
				// 问题：缺少一个比较优先级高低的方法
				// 如果当前item运算符比栈顶运算符高则直接入栈，如果运算及比栈顶低则执行下列操作再入栈
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		// 将s1剩余的运算符依次弹出并加入s2
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;// 注意因为是存放到List，因此按顺序输出就是对应后缀表达式对应的List
	}

	// 完成对逆波兰表达式的运算
	// 1.从左到右扫描,将3和4压入堆栈
	// 2.遇到+运算符，因此弹出3个4（4为栈顶元素,3为次顶元素），计算出3+4的值,得7,再将7入栈
	// 3.将5入栈
	// 4.接下来是x运算符，因此弹出5和7，计算出7x5=35，将35入栈
	// 5.将6入栈
	public static int Calculate(List<String> list) {
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
			throw new RuntimeException("運算符有誤！");
		}
		return res;
	}
}

//编写一个类Operation 可以返回一个运算符对应的优先级	
class Operation {
	private static int ADD_SUB = 1;
	private static int MUL_DIV = 2;

	// 写一个方法,返回对应的优先级数字
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
			System.out.println("不存在该运算符！");
			break;
		}
		return result;
	}
}
