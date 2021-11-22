class Solution {

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false; //this is used so if once false come it is always false for rest of the pops from recursion stack
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next; // only when no false is there
        }
        return true; //returned when we reach the end through recursion
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}


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
    // in place reverse second half
    public boolean isPalindrome(ListNode head) {
       ListNode fast = head, slow = head, mid = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null)
            mid = slow;
        else mid = slow.next;
         mid = reverse(mid);
        return compareLL(head, mid);
    }
    
    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }  
        return prev;
    }
    
    private boolean compareLL(ListNode head1, ListNode head2) {
        while (head2 != null) {
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    
}