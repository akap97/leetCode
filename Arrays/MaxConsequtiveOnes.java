class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr_freq = 0, max_freq=0;
        for (int i: nums) {
            if (i == 1) {
                curr_freq++;
                if (max_freq < curr_freq) // this code is not in else because if last item is 1, we will fail to update the max_freq
                    max_freq = curr_freq;
            }
            else curr_freq = 0;
        }
        return max_freq;
    }
}