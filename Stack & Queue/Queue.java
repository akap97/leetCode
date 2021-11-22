class MyCircularQueue {
    final int[] a;
    int front, rear = -1; // start front at 0 rather than -1 to reduce ops
    int len;

    public MyCircularQueue(int k) { 
        a = new int[k];
        len = 0;
    }

    public boolean enQueue(int val) {
        if (!isFull()) {
            rear = (rear + 1) % a.length;
            a[rear] = val;
            len++;
            return true;
        } else return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % a.length;
            len--;
            return true;
        } else return false;
    }

    public int Front() { return isEmpty() ? -1 : a[front];}

    public int Rear() {return isEmpty() ? -1 : a[rear];}

    public boolean isEmpty() { return len == 0;}

    public boolean isFull() { return len == a.length;}
}

// less space complexity as we are not predefining array of fixed size. Fixed size array might have some space wasted.
// in linked list no space is wasted
class MyCircularQueue {
    
    private class ListNode {
        int data;
        ListNode next;
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
    
    int size = 0;
    int capacity = 0;
    ListNode head;
    ListNode tail;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (size < capacity) {
            if (tail != null) {
                tail.next = new ListNode(value, null);
                tail = tail.next;
            } else {
                head = new ListNode(value, null);
                tail = head;
            }
            size += 1;
            return true;
        } 
        
        return false;
        
    }
    
    public boolean deQueue() {
        
        if (this.size == 0) {
            return false;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            this.size -= 1;
            return true; 
        }
        
    }
    
    public int Front() {
        return this.size == 0 ? -1 : head.data;
    }
    
    public int Rear() {
        return this.size == 0 ? -1 : tail.data;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}