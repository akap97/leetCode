// easiest to understand. 2 pass O(2N)
// Since we need to visit each node at most twice, 
// one for find the tail of the current branch, and the other for flatten the current node. Correct me if I am wrong.

// This is more like a top down flattening, when encounter a node with child node, 
//we directly flatten the current node, then move to the next node.
// The recursive method is more like bottom up flattening,
// means when we encounter a node with child node, we flatten the child node first, then flatten the current node.
class Solution {
    public Node flatten(Node head) {
        if( head == null) return head;
	// Pointer
        Node p = head; 
        while( p!= null) {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null ) 
                temp = temp.next;
            // Connect tail with p.next, if it is not null
            temp.next = p.next;  
            if( p.next != null )  p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child; 
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}

// single pass using stack. space O(N)

class Solution {
    public Node flatten(Node node) {
        Stack<Node> stk = new Stack<>();
        Node cur = node;
        while(cur != null) {
            if(cur.child != null) {
                Node next = cur.next;
                if(next != null)
                    stk.add(next);
                cur.next = cur.child;
                if(cur.next != null)
                    cur.next.prev = cur;
                cur.child = null;
            } else if(cur.next == null && !stk.isEmpty()) {
                cur.next = stk.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return node;
    }
}

public Node flatten(Node head) {
    // recursive
    flattentail(head);
    return head;
}

// flattentail: flatten the node "head" and return the tail in its child (if exists)
// the tail means the last node after flattening "head"

// Five situations:
// 1. null - no need to flatten, just return it
// 2. no child, no next - no need to flatten, it is the last element, just return it
// 3. no child, next - no need to flatten, go next
// 4. child, no next - flatten the child and done
// 5. child, next - flatten the child, connect it with the next, go next

private Node flattentail(Node head) {
    if (head == null) return head; // CASE 1
    if (head.child == null) {
        if (head.next == null) return head; // CASE 2
        return flattentail(head.next); // CASE 3
    }
    else {
        Node child = head.child;  
        head.child = null;
        Node next = head.next;
        Node childtail = flattentail(child);
        head.next = child;
        child.prev = head;  
        if (next != null) { // CASE 5
            childtail.next = next;
            next.prev = childtail;
            return flattentail(next);
        }
        return childtail; // CASE 4
    }	   	
}


// Optimization: One can avoid many of those recursive calls. 
// Restrict the recursive calls to only when the child node is present, 
// otherwise continue processing the next node in current method call stack.

class Solution {
    public Node flatten(Node head) {     
        Node curr = head;
        recur(curr);
        return head;
    }
    
   Node recur(Node node) {
        Node prev = node;
        while(node != null) {
            prev = node;
            
            // Continue iterating if there is no child node.
            if (node.child == null) {
                node = node.next;
                continue;
            }
            
            // At this point, the current node has a child.
            Node next = node.next; // Save the next node, will be used, when we backtrack.
            node.next = node.child; // Point the currenr node's next pointer to child node.
            node.child.prev = node; // Update the prev pointer of child node.

            // Recurse over the child node.
            Node ret = recur(node.child);
            node.child = null;

            if (next != null) {
                ret.next = next;
                next.prev = ret;
                node = next;
            } else {
                node = ret;
            }
        }
        return prev;
    }
}
