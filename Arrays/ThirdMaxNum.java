class Solution {
    public int thirdMax(int[] nums) {
        SortedSet<Integer> s = new TreeSet<>(); // using treeset to store 3 max sorted
        for (int i: nums) {
            if (s.size() < 3 || i > s.first()) {
                if (s.size() < 3) //simply add
                    s.add(i);
                else if (!s.contains(i)){ // add only if does not exist, otherwise item will be removed at line 9 but will not add at line 10 making size less than 3
                    s.remove(s.first());
                    s.add(i);
                }
            }
        }
        if (s.size() < 3) return s.last();
        else return s.first();
    }
}