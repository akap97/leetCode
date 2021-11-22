class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int odd_ptr=-1;
        // i is even pointer
        for (int i=0; i<nums.length;i++) {
            if (nums[i] % 2 !=0 && odd_ptr == -1) {
                odd_ptr = i; // first element which is odd, after this odd will always be incremented by 1
            }
            else if (nums[i] %2 ==0) {
                if (odd_ptr != -1) { // make sure odd number exists to swap
                    swap(odd_ptr, i, nums);
                    odd_ptr++;
                }
            }
        }
        return nums;
    }
    private void swap(int odd_ptr, int even_ptr, int[] arr) {
        int temp = arr[odd_ptr];
        arr[odd_ptr] = arr[even_ptr];
        arr[even_ptr] = temp;
    }
}