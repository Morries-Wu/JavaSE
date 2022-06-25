package Math.Tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// 先需要创建一颗二叉树
		BinaryTree binaryTree = new BinaryTree();
		// 创建需要的结点
		Node root = new Node(1, "宋江");
		Node Node2 = new Node(2, "吴用");
		Node Node3 = new Node(3, "卢俊义");
		Node Node4 = new Node(4, "林冲");
		Node Node5 = new Node(5, "关胜");
		Node Node6 = new Node(6, "老八");
		Node Node7 = new Node(7, "潘子");
		// 说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
		root.setLeft(Node2);
		root.setRight(Node3);
		Node2.setLeft(Node4);
		Node2.setRight(Node5);
		Node3.setLeft(Node6);
		Node3.setRight(Node7);
		binaryTree.setRoot(root);

		// 测试
		System.out.println("前序遍历"); // 1,2,3,5,4
		binaryTree.pre_out();

		// 测试
		System.out.println("中序遍历");
		binaryTree.mid_out(); // 2,1,5,3,4

		System.out.println("后序遍历");
		binaryTree.post_out(); // 2,5,4,3,1

		// 前序遍历
		// 前序遍历的次数 ：4
		System.out.println("前序遍历方式~~~");
		Node res = binaryTree.pre(5);
		if (res != null) {
			System.out.printf("找到了，信息为 num=%d name=%s", res.getNum(), res.getName());
		} else {
			System.out.printf("没有找到 num = %d 的英雄", 5);
		}

		// 中序遍历查找
		// 中序遍历3次
//		System.out.println("中序遍历方式~~~");
//		HeroNode res = binaryTree.infixOrderSearch(5);
//		if (res != null) {
//			System.out.printf("找到了，信息为 num=%d name=%s", res.getnum(), res.getName());
//		} else {
//			System.out.printf("没有找到 num = %d 的英雄", 5);
//		}

		// 后序遍历查找
		// 后序遍历查找的次数 2次
//		System.out.println("后序遍历方式~~~");
//		HeroNode res = binaryTree.postOrderSearch(5);
//		if (res != null) {
//			System.out.printf("找到了，信息为 num=%d name=%s", res.getnum(), res.getName());
//		} else {
//			System.out.printf("没有找到 num = %d 的英雄", 5);
//		}

		// 测试一把删除结点
		System.out.println("删除前,前序遍历");
		binaryTree.pre_out(); // 1,2,3,5,4
		binaryTree.deleteNode(7);
		System.out.println("删除后，前序遍历");
		binaryTree.pre_out(); // 1,2,3,4

	}

}

//定义BinaryTree 二叉树
class BinaryTree {
	private Node root;

	public void setRoot(Node root) {
		this.root = root;
	}

	// 删除结点
	public void deleteNode(int num) {
		if (root != null) {
			// 如果只有一个root结点, 这里立即判断root是不是就是要删除结点
			if (root.getNum() == num) {
				root = null;
			} else {
				// 递归删除
				root.deleteNode(num);
			}
		} else {
			System.out.println("空树，不能删除~");
		}
	}

	// 前序遍历
	public void pre_out() {
		if (this.root != null) {
			this.root.pre_out();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 中序遍历
	public void mid_out() {
		if (this.root != null) {
			this.root.mid_out();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 后序遍历
	public void post_out() {
		if (this.root != null) {
			this.root.post_out();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 前序遍历查找
	public Node pre(int num) {
		if (root != null) {
			return root.pre_Search(num);
		} else {
			return null;
		}
	}

	// 中序遍历查找
	public Node mid(int num) {
		if (root != null) {
			return root.mid_Search(num);
		} else {
			return null;
		}
	}

	// 后序遍历查找
	public Node pos(int num) {
		if (root != null) {
			return this.root.pos_Search(num);
		} else {
			return null;
		}
	}
}

//先创建HeroNode 结点
class Node {
	private int num;
	private String name;
	private Node left; // 默认null
	private Node right; // 默认null

	public Node(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [num=" + num + ", name=" + name + "]";
	}

	// 递归删除结点
	// 1.如果删除的节点是叶子节点，则删除该节点
	// 2.如果删除的节点是非叶子节点，则删除该子树
	public void deleteNode(int num) {

		// 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
		// 2.如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
		// 3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
		// 4.如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
		// 5. 如果第4步也没有删除结点，则应当向右子树进行递归删除.

		if (this.left != null && this.left.num == num) {
			this.left = null;
			return;
		}
		// 3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
		if (this.right != null && this.right.num == num) {
			this.right = null;
			return;
		}
		// 4.我们就需要向左子树进行递归删除
		if (this.left != null) {
			this.left.deleteNode(num);
		}
		// 5.则应当向右子树进行递归删除
		if (this.right != null) {
			this.right.deleteNode(num);
		}
	}

	// 编写前序遍历的方法
	public void pre_out() {
		System.out.println(this); // 先输出父结点
		// 递归向左子树前序遍历
		if (this.left != null) {
			this.left.pre_out();
		}
		// 递归向右子树前序遍历
		if (this.right != null) {
			this.right.pre_out();
		}
	}

	// 中序遍历
	public void mid_out() {

		// 递归向左子树中序遍历
		if (this.left != null) {
			this.left.mid_out();
		}
		// 输出父结点
		System.out.println(this);
		// 递归向右子树中序遍历
		if (this.right != null) {
			this.right.mid_out();
		}
	}

	// 后序遍历
	public void post_out() {
		if (this.left != null) {
			this.left.post_out();
		}
		if (this.right != null) {
			this.right.post_out();
		}
		System.out.println(this);
	}

	// 前序遍历查找
	/**
	 * 
	 * @param num 查找num
	 * @return 如果找到就返回该Node ,如果没有找到返回 null
	 */
	public Node pre_Search(int num) {
		System.out.println("进入前序遍历");
		// 比较当前结点是不是
		if (this.num == num) {
			return this;
		}
		// 1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
		// 2.如果左递归前序查找，找到结点，则返回
		Node res = null;
		if (this.left != null) {
			res = this.left.pre_Search(num);
		}
		if (res != null) {// 说明我们左子树找到
			return res;
		}
		// 1.左递归前序查找，找到结点，则返回，否继续判断，
		// 2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
		if (this.right != null) {
			res = this.right.pre_Search(num);
		}
		return res;
	}

	// 中序遍历查找
	public Node mid_Search(int num) {
		// 判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
		Node res = null;
		if (this.left != null) {
			res = this.left.mid_Search(num);
		}
		if (res != null) {
			return res;
		}
		System.out.println("进入中序查找");
		// 如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
		if (this.num == num) {
			return this;
		}
		// 否则继续进行右递归的中序查找
		if (this.right != null) {
			res = this.right.mid_Search(num);
		}
		return res;

	}

	// 后序遍历查找
	public Node pos_Search(int num) {

		// 判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
		Node res = null;
		if (this.left != null) {
			res = this.left.pos_Search(num);
		}
		if (res != null) {// 说明在左子树找到
			return res;
		}

		// 如果左子树没有找到，则向右子树递归进行后序遍历查找
		if (this.right != null) {
			res = this.right.pos_Search(num);
		}
		if (res != null) {
			return res;
		}
		System.out.println("进入后序查找");
		// 如果左右子树都没有找到，就比较当前结点是不是
		if (this.num == num) {
			return this;
		}
		return res;
	}

}
