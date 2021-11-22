class Solution {
    public int[] sortedSquares(int[] nums) {
        //brute force n + nlogn
        for (int i =0; i< nums.length; i++) {
            nums[i] = (int)Math.pow(Math.abs(nums[i]), 2);
        }
        Arrays.sort(nums); 
        return nums;
        
    }

    public int[] sortedSquares(int[] A) {
        // 2 ptrs: O(N) but O(N) space too.
        int n = A.length;
        int[] result = new int[n];
        int i = 0; // left most -ve integer
        int j = n - 1; //rightmost +ve integer
        for (int p = n - 1; p >= 0; p--) { // we will fill the resultant array from biggest to smallest
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}