package Arrays;

public class Test02 {
	public static void main(String[] args) {
		// 静态初始化
		int a[] = { 2, 3, 4, 5 };
		User B[] = { new User(1001, "祥哥"), new User(1002, "张三"), new User(1003, "李四") };
		// 默认初始化
		int b[] = new int[3]; // 默认给数组的元素进行赋值，赋值的规则和成员变量默认赋值规则一致。
		int a2[] = new int[2]; // 默认值：0，0
		boolean b2[] = new boolean[2]; // 默认值:false,false
		String s[] = new String[2]; // 默认值:null,null
		// 动态初始化
		int a1[] = new int[2]; // 动态初始化数组，先分配空间
		a1[0] = 1;// 给数组元素赋值;
		a1[1] = 2;// 给数组元素赋值;

	}
}
