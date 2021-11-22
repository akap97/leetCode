class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i: nums) {
            if (numDigits(i) % 2 == 0)
                count++;
        }
        return count;
    }
    
    private int numDigits (int n) {
        // using divide and conquer. in constraint biggest given num is 10^5
        if (n < 1000) {
            if (n < 100) {
                if (n < 10)
                    return 1;
                else return 2;
            }
            else return 3;
        }
        else {
            if (n < 100000) {
                if (n < 10000)
                    return 4;
                else return 5;
            }
            else return 6;
        }
    }
}