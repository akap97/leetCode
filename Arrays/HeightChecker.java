class Solution {
    public int heightChecker(int[] heights) {
        // brute O(nlogn) and O(N) space.
        // efficient O(n) and O(n) space. using count frequency method as range is only 1 to 100.
        int count=0, k=0;
        int freq_arr[] = new int[101];
        for (int i=0; i<heights.length; i++) {
            freq_arr[heights[i]]++;
        }
        
        for (int i=1; i<101; i++) {
            while (freq_arr[i] !=0) {
                if (heights[k] != i)
                  count++;
                freq_arr[i]--;
                k++;
            }
        }
        return count;
    }
}