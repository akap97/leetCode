class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1, i=1;
        while (i < nums.length) {
            while( i< nums.length && (nums[i] == nums[i-1])) // first condition avoids index out of bounds
                i++;
            if (i == nums.length)
                break;
            nums[k] = nums[i];
            i++;
            k++;
        }
        return k;
    }
}