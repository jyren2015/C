/**
 * Created by RJYWORK on 2020/1/8
 * Description:
 * Definition for singly-linked list:
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Rotateright {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int num = 0;
        while (tail.next!= null){
            tail = tail.next;
            num++;
        }
        num++;
        tail.next = head;
        tail = head;
        int index = k%num;
        num = num - index - 1;
        for (int i = 0;i<num;i++){
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}
