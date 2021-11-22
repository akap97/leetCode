
// To get better performance create your own circular queue
class MovingAverage {
    Deque<Integer> q;
    int s = 0;
    double sum = 0;
    public MovingAverage(int size) {
        q = new ArrayDeque<>(size);
        s = size;
    }
    
    public double next(int val) {
        sum +=val;                                                                
        if (s == q.size())
            sum -=q.removeFirst();
        q.add(val);
        return sum/q.size();
    }
}
