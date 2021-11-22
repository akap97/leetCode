class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 2 pass algo
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        int len = 0;
        while (curr != null) { // calc len
            len++;
            curr = curr.next;
        }
        if (k == len)
            return head;
        int num_rotations = k % len; // so if num rotations exceed len
        int last_node = len - num_rotations;
        curr = head;
        int ptr = 1;
        while (ptr != last_node) {
            ptr++;
            curr = curr.next; //this guy next needs to be detached
        }
        ListNode last = curr;
        while (curr.next != null) {
            curr = curr.next; //last element
        }
        curr.next = head; // attach last to head
        head = last.next;
        last.next = null;
        return head;
    }
}


public ListNode rotateRight(ListNode head, int n) {
    // using 2 ptrs
    if (head == null || head.next == null || n == 0) {
         return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    ListNode newHead;
    for (int i = 0; i < n; i++) { // move fats ptr n nodes ahead
        if (fast.next == null) { // when n > len, fast will become null and come back to head
            fast = head;
        } else {
            fast = fast.next;
        }
    }
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    fast.next = head;
    newHead = slow.next;
    slow.next = null;
    return newHead;
}