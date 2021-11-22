class Solution {
    public void moveZeroes(int[] nums) {
        // use read pointer which will go ahead. Use write pointer to write which will always be behind read pointer
        int k = 0, num_zeros = 0;
        // i is the read pointer and k is write pointer
        for (int i=0; i<nums.length;i++) {
            if (nums[i] == 0) {
                num_zeros++;
                
            }
            else {
                nums[k] = nums[i];
                k++;
            }
        }
        // no fill num_zeros at the end
        int i=nums.length-1;
        while(num_zeros >0) {
            nums[i] = 0;
            i--;
            num_zeros--;
        }
    }
}