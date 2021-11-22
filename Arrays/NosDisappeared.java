class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // O(N) space for frequency array
        // this is 2 pass algorithm
        List<Integer> l = new ArrayList<>();
        int[] arr = new int[nums.length+1];
        for (int i: nums) {
            arr[i]++;
        }
        for (int i=1; i<arr.length;i++) {
            if (arr[i] == 0)
                l.add(i);
        }
        return l;
    }
}


//Better Approach, use negation
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();
        // in first pass make numbers negative
        // second pass those which are not negative do not exist
        
        for (int i=0; i<nums.length;i++) {
            if (nums[Math.abs(nums[i])-1] > 0)
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        for (int i=0; i< nums.length; i++) {
            if (nums[i]> 0)
                l.add(i+1);
        }
        return l;
    }
}