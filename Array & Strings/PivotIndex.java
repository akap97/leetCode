class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

// Another approach (Cumulative apporach), worse space complexity
class Solution {
    public int pivotIndex(int[] nums) {
        int arr1[] = new int[nums.length];
        int arr2[] = new int[nums.length];
        for(int i=1; i<nums.length; i++) {
            arr1[i] = nums[i-1] + arr1[i-1];
            arr2[nums.length-i-1] = nums[nums.length-i] + arr2[nums.length-i];
        }
        for(int i=0; i<nums.length; i++) {
            if(arr1[i]==arr2[i])
                return i;
        }
        return -1;
    }
}