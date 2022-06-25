package Math.TestClass;

public class algorithmTest {

    public int[] reversePrint(ListNode head) {
        //计数就完事
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int[] arr = new int[count];

        cur = head;
        count--;
        while (cur != null && count >= 0) {
            arr[count--] = cur.val;
            cur = cur.next;
        }
        return arr;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next=node2;
        node2.next=node3;
        System.out.println(new algorithmTest().reversePrint(node1));

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
