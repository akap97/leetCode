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
    // iterative
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }

    // non-elegant recursive
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        helper(prev, head, val);
        return prev.next;
    }

    private void helper(ListNode prev, ListNode curr, int val) {
        if (curr == null)
            return;

        if (curr.val == val) {
            prev.next = curr.next;
            curr = prev.next;
        }
        else {
            prev = curr;
            curr =  curr.next;
        }
        helper(prev, curr, val);     
    }

    //elegant recursive
    public ListNode removeElements(ListNode head, int val) {
        // head goes till last an then start coming back, go through this code multiple times
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
}
}