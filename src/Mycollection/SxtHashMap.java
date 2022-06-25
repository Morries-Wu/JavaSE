package Mycollection;

public class SxtHashMap<K, V> {

	public static void main(String[] args) {
		SxtHashMap<Integer, String> map = new SxtHashMap<Integer, String>();
		map.put(10, "aa");
		map.put(20, "bb");
		map.put(30, "cc");
		map.put(20, "qq");
		map.put(26, "奥里给");

		for (int i = 0; i < 50; i++) {
			System.out.println(i + "---" + map.myHash(i, 16));
		}

		System.out.println(map);
		System.out.println(map.get(26));
	}

	Node2 table[];// 位桶数组
	int size; // 存放的键值对的个数

	public SxtHashMap() {
		table = new Node2[16];// 长度一般定义成2的整数幂
	}

	public V get(K key) {
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		if (table[hash] != null) {
			Node2 temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) {// 如果相等，说明找到键值对,返回相应的value
					value = (V) temp.value;
					break;
				}
				temp = temp.next;
			}
		}
		return value;
	}

	public void put(K key, V value) {
		// 如果要完善,还需要考虑数组扩容的问题
		Node2 newnode = new Node2();
		newnode.hash = myHash(key.hashCode(), table.length);
		newnode.key = key;
		newnode.value = value;
		newnode.next = null;

		Node2 temp = table[newnode.hash];
		boolean KeyRepeat = false;
		if (temp == null) {
			// 此处数组为空,则将新结点放进去
			table[newnode.hash] = newnode;
			size++;
		} else {
			// 此处数组元素不为空,则遍历对应链表
			while (temp.next != null) {
				// 判断key是否重复,如果重复则覆盖
				if (temp.key.equals(key)) {
					KeyRepeat = true;
					temp.value = value; // 只是覆盖value即可,其他的值保持不变
					break;
				} else {
					// 没有找到key重复也没有找到最后一个元素就进行下一个遍历
					temp = temp.next;
				}
			}

			if (KeyRepeat == false) { // 没有发生key重复的情况,则添加到链表最后
				temp.next = newnode;
				size++;
			}
		}
	}

	public int myHash(int value, int lenght) {
		return value & (lenght - 1);// 与位运算
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("{");
		for (int i = 0; i < table.length; i++) {
			Node2 temp = table[i];
			while (temp != null) {
				builder.append(temp.key + ":" + temp.value + ",");
				temp = temp.next;
			}
		}
		builder.setCharAt(builder.length() - 1, '}');
		return builder.toString();
	}

}

class Node2<K, V> {
	int hash;
	K key;
	V value;
	Node2 next;
}