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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
            ListNode result = dummy
            ListNode p1 = head
            ListNode p2 = result

            int index = 0;
            while p1 is not null    
                if left <= index <= right
                    stack.push(p1.val)
                else if index > right
                    while stack isNotEmpty
                        p2 add stack.pop
                else if index < left
                    p2 add p1.val

                index ++;
            


            2 1 3 4 5
            3 2 1 4 5
            p       n c
            d 4 3 2 1 5
            5 4 3 2 1


            1~5
            d -> 1 -> 2 -> 3 -> 4 -> 5 
            
            prev = 1
            cur = 2

            next = 3
            2 -> 4
            3 -> 2
            1 -> 3
            => 1 3 2 4 5

            next = 4
            2 -> 5
            4 -> 3
            1 -> 4
            => 1 4 3 2 5

            e = 1 4 3 2 5

        */

        ListNode r = new ListNode();
        ListNode p1 = head;
        ListNode p2 = r;

        Stack<Integer> s = new Stack<>();
        int i = 1;
        while (p1 != null) {
            if (left <= i && i <= right) {
                s.push(p1.val);
            } else {
                p2.next = new ListNode(p1.val);
                p2 = p2.next;
            }

            while (i == right && !s.isEmpty()) {
                int v = s.pop();
                p2.next = new ListNode(v);
                p2 = p2.next;
            }

            p1 = p1.next;
            i ++;
        }

        return r.next;
    }
}