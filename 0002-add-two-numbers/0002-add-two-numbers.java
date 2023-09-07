import java.lang.Math;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 노드를 숫자로 변환
        
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode answerP = new ListNode(0);
        ListNode answer = answerP;

        /*
             999
              99
            1098
        */
        int carry = 0;
        while (p1 != null || p2 != null) {
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;

            int sum = val1 + val2;
            int digit = (sum + carry) % 10;
            answerP.next = new ListNode(digit);
            answerP = answerP.next;

            if (sum + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        if (carry == 1) {
            answerP.next = new ListNode(1);
            answerP = answerP.next;
        }

        // dummy 제거
        ListNode temp = answer;
        answer = answer.next;
        temp.next = null;

        return answer;
    }
}