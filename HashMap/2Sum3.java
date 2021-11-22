// brute force: find O(n)
class TwoSum {
    List<Integer> l;
    public TwoSum() {
        l = new ArrayList<>();
    }
    
    public void add(int number) {
        l.add(number);
    }
    
    public boolean find(int value) {
        HashSet<Integer> h = new HashSet<>();
        for (int i: l) {
            if (!h.contains(value - i))
                h.add(i);
            else return true;
        }
        return false;
    }
}

// find O(1) but add O(N) but space O(N*N)
public class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;
    
    TwoSum(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        if(num.contains(number)){
            sum.add(number * 2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        return sum.contains(value);
    }
}


// you can simplify your map and just map to Boolean because you are using an 
// integer but only caring about 2 states, occurring once or more than once.
// this seems like a bit of cheap trick but when I did this
// I shaved off 30% of my OJ time. For basically no cost you can keep track of min/max to rule out queries for numbers outside the bounds.
public class TwoSum 
{
    Dictionary<int,bool> map = new Dictionary<int,bool>();
    int max = int.MinValue;
    int min = int.MaxValue;
    
    public TwoSum() { }
    
    public void Add(int number) 
    {
        map[number] = map.ContainsKey(number);
        max = Math.Max(max, number);
        min = Math.Min(min, number);
    }
    
    public bool Find(int value) 
    {
        if (value < min + min || value > max + max) return false; //trick
        foreach (int x in map.Keys)
        {
            int y = value - x;
            if (map.ContainsKey(y) && (x != y || map[y] == true)) return true;
        }
        return false;
    }
}
