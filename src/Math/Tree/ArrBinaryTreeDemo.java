package Math.Tree;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

		// 创建一个ArrBianaryTree
		ArrBinaryTree arrtree = new ArrBinaryTree(arr);
		System.out.println("前序遍历");
		arrtree.pre_out(1);
		System.out.println("____________");

		System.out.println("中序遍历");
		arrtree.mid_out(2);
		System.out.println("____________");

		System.out.println("后序遍历");
		arrtree.pos_out(2);
	}
}

//编写一个ArrayBinaryTree,实现顺序存储二叉树遍历
class ArrBinaryTree {
	private int[] arr;// 存储数结点的数组

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}

	// 编写一个方法,完成顺序存储二叉树的前序遍历
	// index表示数组下标
	public void pre_out(int index) {
		// 如果数组为空,或者arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空,不能按照二叉树的前序遍历");
		}
		// 输出当前元素
		System.out.println(arr[index]);
		// 向左递归遍历
		if (index * 2 + 1 < arr.length) {
			pre_out(index * 2 + 1);
		}
		// 向右递归遍历
		if (index * 2 + 2 < arr.length) {
			pre_out(index * 2 + 2);
		}

	}

	// 编写一个方法,完成顺序存储二叉树的中序遍历
	// index表示数组下标
	public void mid_out(int index) {

		// 如果数组为空,或者arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空,不能按照二叉树的前序遍历");
		}

		// 向左递归遍历
		if (index * 2 + 1 < arr.length) {
			pre_out(index * 2 + 1);
		}
		// 输出当前元素
		System.out.println(arr[index]);
		// 向右递归遍历
		if (index * 2 + 2 < arr.length) {
			pre_out(index * 2 + 2);
		}

	}

	// 编写一个方法,完成顺序存储二叉树的后序遍历
	// index表示数组下标
	public void pos_out(int index) {

		// 如果数组为空,或者arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空,不能按照二叉树的前序遍历");
		}

		// 向左递归遍历
		if (index * 2 + 1 < arr.length) {
			pre_out(index * 2 + 1);
		}

		// 向右递归遍历
		if (index * 2 + 2 < arr.length) {
			pre_out(index * 2 + 2);
		}

		// 输出当前元素
		System.out.println(arr[index]);

	}

}