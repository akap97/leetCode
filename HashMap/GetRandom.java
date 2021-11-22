class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();
  
    /** Initialize your data structure here. */
    public RandomizedSet() {
      dict = new HashMap();
      list = new ArrayList();
    }
  
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (dict.containsKey(val)) return false;
  
      dict.put(val, list.size());
      list.add(list.size(), val);
      return true;
    }
  
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (! dict.containsKey(val)) return false;
  
      // move the last element to the place idx of the element to delete
      int lastElement = list.get(list.size() - 1);
      int idx = dict.get(val);
      list.set(idx, lastElement);
      dict.put(lastElement, idx);
      // delete the last element
      list.remove(list.size() - 1);
      dict.remove(val);
      return true;
    }
  
    /** Get a random element from the set. */
    public int getRandom() {
      return list.get(rand.nextInt(list.size()));
    }
  }


  // do not swap the last with last to improve time
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // only if not the last one then swap the last one with this val ** improves time
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}