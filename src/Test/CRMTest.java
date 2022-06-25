package Test;


public class CRMTest {


    ListNode Header = null;

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            pre = cur.next;
            cur.next = null;
            insertEnd(cur);
            cur = pre;
        }
        return Header;
    }

    public void insertEnd(ListNode node) {
        if (Header == null) {
            Header = node;
        } else {
            node.next = Header;
            Header = node;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode newnode = new CRMTest().reverseList(node1);
        while (newnode != null) {
            System.out.println(newnode.val);
            newnode = newnode.next;
        }

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
