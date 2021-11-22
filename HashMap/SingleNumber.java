class Solution { // Maths+hashset
    public int singleNumber(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        int hash_sum = 0, total_sum = 0;
        for (int i: nums) {
            if (!h.contains(i)) {
                h.add(i);
                hash_sum += i;
            }
            total_sum += i;
        }
        return 2*hash_sum - total_sum; // 2*a - a
    }
}

// constant space
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i: nums) {
            res = res^i;
        }
        return res;
    }
}