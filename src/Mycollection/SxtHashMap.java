package Mycollection;

public class SxtHashMap<K, V> {

	public static void main(String[] args) {
		SxtHashMap<Integer, String> map = new SxtHashMap<Integer, String>();
		map.put(10, "aa");
		map.put(20, "bb");
		map.put(30, "cc");
		map.put(20, "qq");
		map.put(26, "�����");

		for (int i = 0; i < 50; i++) {
			System.out.println(i + "---" + map.myHash(i, 16));
		}

		System.out.println(map);
		System.out.println(map.get(26));
	}

	Node2 table[];// λͰ����
	int size; // ��ŵļ�ֵ�Եĸ���

	public SxtHashMap() {
		table = new Node2[16];// ����һ�㶨���2��������
	}

	public V get(K key) {
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		if (table[hash] != null) {
			Node2 temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) {// �����ȣ�˵���ҵ���ֵ��,������Ӧ��value
					value = (V) temp.value;
					break;
				}
				temp = temp.next;
			}
		}
		return value;
	}

	public void put(K key, V value) {
		// ���Ҫ����,����Ҫ�����������ݵ�����
		Node2 newnode = new Node2();
		newnode.hash = myHash(key.hashCode(), table.length);
		newnode.key = key;
		newnode.value = value;
		newnode.next = null;

		Node2 temp = table[newnode.hash];
		boolean KeyRepeat = false;
		if (temp == null) {
			// �˴�����Ϊ��,���½��Ž�ȥ
			table[newnode.hash] = newnode;
			size++;
		} else {
			// �˴�����Ԫ�ز�Ϊ��,�������Ӧ����
			while (temp.next != null) {
				// �ж�key�Ƿ��ظ�,����ظ��򸲸�
				if (temp.key.equals(key)) {
					KeyRepeat = true;
					temp.value = value; // ֻ�Ǹ���value����,������ֵ���ֲ���
					break;
				} else {
					// û���ҵ�key�ظ�Ҳû���ҵ����һ��Ԫ�ؾͽ�����һ������
					temp = temp.next;
				}
			}

			if (KeyRepeat == false) { // û�з���key�ظ������,����ӵ��������
				temp.next = newnode;
				size++;
			}
		}
	}

	public int myHash(int value, int lenght) {
		return value & (lenght - 1);// ��λ����
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