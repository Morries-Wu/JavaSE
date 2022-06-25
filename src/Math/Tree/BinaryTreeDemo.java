package Math.Tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// ����Ҫ����һ�Ŷ�����
		BinaryTree binaryTree = new BinaryTree();
		// ������Ҫ�Ľ��
		Node root = new Node(1, "�ν�");
		Node Node2 = new Node(2, "����");
		Node Node3 = new Node(3, "¬����");
		Node Node4 = new Node(4, "�ֳ�");
		Node Node5 = new Node(5, "��ʤ");
		Node Node6 = new Node(6, "�ϰ�");
		Node Node7 = new Node(7, "����");
		// ˵�����������ֶ������ö���������������ѧϰ�ݹ�ķ�ʽ����������
		root.setLeft(Node2);
		root.setRight(Node3);
		Node2.setLeft(Node4);
		Node2.setRight(Node5);
		Node3.setLeft(Node6);
		Node3.setRight(Node7);
		binaryTree.setRoot(root);

		// ����
		System.out.println("ǰ�����"); // 1,2,3,5,4
		binaryTree.pre_out();

		// ����
		System.out.println("�������");
		binaryTree.mid_out(); // 2,1,5,3,4

		System.out.println("�������");
		binaryTree.post_out(); // 2,5,4,3,1

		// ǰ�����
		// ǰ������Ĵ��� ��4
		System.out.println("ǰ�������ʽ~~~");
		Node res = binaryTree.pre(5);
		if (res != null) {
			System.out.printf("�ҵ��ˣ���ϢΪ num=%d name=%s", res.getNum(), res.getName());
		} else {
			System.out.printf("û���ҵ� num = %d ��Ӣ��", 5);
		}

		// �����������
		// �������3��
//		System.out.println("���������ʽ~~~");
//		HeroNode res = binaryTree.infixOrderSearch(5);
//		if (res != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ num=%d name=%s", res.getnum(), res.getName());
//		} else {
//			System.out.printf("û���ҵ� num = %d ��Ӣ��", 5);
//		}

		// �����������
		// ����������ҵĴ��� 2��
//		System.out.println("���������ʽ~~~");
//		HeroNode res = binaryTree.postOrderSearch(5);
//		if (res != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ num=%d name=%s", res.getnum(), res.getName());
//		} else {
//			System.out.printf("û���ҵ� num = %d ��Ӣ��", 5);
//		}

		// ����һ��ɾ�����
		System.out.println("ɾ��ǰ,ǰ�����");
		binaryTree.pre_out(); // 1,2,3,5,4
		binaryTree.deleteNode(7);
		System.out.println("ɾ����ǰ�����");
		binaryTree.pre_out(); // 1,2,3,4

	}

}

//����BinaryTree ������
class BinaryTree {
	private Node root;

	public void setRoot(Node root) {
		this.root = root;
	}

	// ɾ�����
	public void deleteNode(int num) {
		if (root != null) {
			// ���ֻ��һ��root���, ���������ж�root�ǲ��Ǿ���Ҫɾ�����
			if (root.getNum() == num) {
				root = null;
			} else {
				// �ݹ�ɾ��
				root.deleteNode(num);
			}
		} else {
			System.out.println("����������ɾ��~");
		}
	}

	// ǰ�����
	public void pre_out() {
		if (this.root != null) {
			this.root.pre_out();
		} else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	// �������
	public void mid_out() {
		if (this.root != null) {
			this.root.mid_out();
		} else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	// �������
	public void post_out() {
		if (this.root != null) {
			this.root.post_out();
		} else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	// ǰ���������
	public Node pre(int num) {
		if (root != null) {
			return root.pre_Search(num);
		} else {
			return null;
		}
	}

	// �����������
	public Node mid(int num) {
		if (root != null) {
			return root.mid_Search(num);
		} else {
			return null;
		}
	}

	// �����������
	public Node pos(int num) {
		if (root != null) {
			return this.root.pos_Search(num);
		} else {
			return null;
		}
	}
}

//�ȴ���HeroNode ���
class Node {
	private int num;
	private String name;
	private Node left; // Ĭ��null
	private Node right; // Ĭ��null

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

	// �ݹ�ɾ�����
	// 1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
	// 2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
	public void deleteNode(int num) {

		// 1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
		// 2.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
		// 3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
		// 4.�����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
		// 5. �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.

		if (this.left != null && this.left.num == num) {
			this.left = null;
			return;
		}
		// 3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
		if (this.right != null && this.right.num == num) {
			this.right = null;
			return;
		}
		// 4.���Ǿ���Ҫ�����������еݹ�ɾ��
		if (this.left != null) {
			this.left.deleteNode(num);
		}
		// 5.��Ӧ�������������еݹ�ɾ��
		if (this.right != null) {
			this.right.deleteNode(num);
		}
	}

	// ��дǰ������ķ���
	public void pre_out() {
		System.out.println(this); // ����������
		// �ݹ���������ǰ�����
		if (this.left != null) {
			this.left.pre_out();
		}
		// �ݹ���������ǰ�����
		if (this.right != null) {
			this.right.pre_out();
		}
	}

	// �������
	public void mid_out() {

		// �ݹ����������������
		if (this.left != null) {
			this.left.mid_out();
		}
		// ��������
		System.out.println(this);
		// �ݹ����������������
		if (this.right != null) {
			this.right.mid_out();
		}
	}

	// �������
	public void post_out() {
		if (this.left != null) {
			this.left.post_out();
		}
		if (this.right != null) {
			this.right.post_out();
		}
		System.out.println(this);
	}

	// ǰ���������
	/**
	 * 
	 * @param num ����num
	 * @return ����ҵ��ͷ��ظ�Node ,���û���ҵ����� null
	 */
	public Node pre_Search(int num) {
		System.out.println("����ǰ�����");
		// �Ƚϵ�ǰ����ǲ���
		if (this.num == num) {
			return this;
		}
		// 1.���жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		// 2.�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
		Node res = null;
		if (this.left != null) {
			res = this.left.pre_Search(num);
		}
		if (res != null) {// ˵�������������ҵ�
			return res;
		}
		// 1.��ݹ�ǰ����ң��ҵ���㣬�򷵻أ�������жϣ�
		// 2.��ǰ�Ľ������ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
		if (this.right != null) {
			res = this.right.pre_Search(num);
		}
		return res;
	}

	// �����������
	public Node mid_Search(int num) {
		// �жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		Node res = null;
		if (this.left != null) {
			res = this.left.mid_Search(num);
		}
		if (res != null) {
			return res;
		}
		System.out.println("�����������");
		// ����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
		if (this.num == num) {
			return this;
		}
		// ������������ҵݹ���������
		if (this.right != null) {
			res = this.right.mid_Search(num);
		}
		return res;

	}

	// �����������
	public Node pos_Search(int num) {

		// �жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
		Node res = null;
		if (this.left != null) {
			res = this.left.pos_Search(num);
		}
		if (res != null) {// ˵�����������ҵ�
			return res;
		}

		// ���������û���ҵ��������������ݹ���к����������
		if (this.right != null) {
			res = this.right.pos_Search(num);
		}
		if (res != null) {
			return res;
		}
		System.out.println("����������");
		// �������������û���ҵ����ͱȽϵ�ǰ����ǲ���
		if (this.num == num) {
			return this;
		}
		return res;
	}

}
