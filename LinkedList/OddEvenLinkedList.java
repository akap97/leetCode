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
    public ListNode oddEvenList(ListNode head) {
        // 2 pointer technique
        if (head == null || head.next == null || head.next.next == null) // need min 3 nodes to do swapping
            return head;
        ListNode even_ptr = head.next, odd_ptr = head.next.next;
        int even_ptr_index = 2, odd_ptr_index = 3; // need to calc number of swaps
        while(odd_ptr != null) {
            swap_sublist(even_ptr, odd_ptr, (odd_ptr_index - even_ptr_index));
            if (odd_ptr.next == null)
                break;
            even_ptr_index +=1;
            odd_ptr_index +=2;
            even_ptr = even_ptr.next;
            odd_ptr = odd_ptr.next.next;
        }
        return head;
    }
    
    private void swap_sublist(ListNode l, ListNode r, int num_swaps) {
        while (num_swaps > 0) {
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
            num_swaps--;
            l = l.next;
        }
    }


    public ListNode oddEvenList(ListNode head) {
        // better: https://leetcode.com/problems/odd-even-linked-list/solution/
        // brilliant
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        // even head is the first position of even
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}