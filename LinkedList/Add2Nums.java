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
        // first find the longer one to store the result
        ListNode curr = l1;
        int len1 = 0, len2 = 0;
        while(curr != null) {
            len1++;
            curr = curr.next;
        }
        curr = l2;
        while(curr != null) {
            len2++;
            curr = curr.next;
        }
        ListNode big = len1 >= len2? l1:l2;
        ListNode small = len1 >= len2? l2:l1;
        ListNode current = big;
        ListNode prev = null; // use this to add any remaining carry if left
        int carry = 0;
        while ( current != null) {
            if (carry > 0) {
                current.val += carry;
                carry = 0;
            }
            if (small != null) {
                current.val +=  small.val;
                small = small.next;
            }
            if (current.val >= 10) {
                System.out.println("hiiiiii");
                current.val = current.val % 10;
                carry = 1;
            }
            prev = current; 
            current = current.next;
        }
        System.out.println("yoooo"+carry);
        if (carry > 0) { // any remaining carry if present
            prev.next = new ListNode(1, null);
        }
        
        return big;
    }
}