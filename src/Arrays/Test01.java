package Arrays;

public class Test01 {
	public static void main(String[] args) {
		int arr01[]; // 声明数组
		arr01 = new int[10]; // 分配空间
		String arr02[];
		User arr03[];

		arr03 = new User[3];
		arr03[0] = new User(1001, "祥哥");
		arr03[1] = new User(1002, "祥二哥");
		arr03[2] = new User(1003, "祥三哥");

		for (int i = 0; i < arr03.length; i++) {
			System.out.println(arr03[i].getName());
		}

		for (int i = 0; i < arr01.length; i++) {
			arr01[i] = i;
		}
		
		System.out.println("---------------------	");
		// foreach循环：用于读取数组元素的值，不能修改元素的值
		for (int m : arr01)// 循环遍历数组，把每个元素取出来放到m变量里面然后进行打印
		{
			System.out.println(m);
		}

	}
}
