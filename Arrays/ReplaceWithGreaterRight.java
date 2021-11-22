class Solution {
    public int[] replaceElements(int[] arr) {
        // brute force is O(n^2)
        // for O(n) start from reverse and keep storing max_value
        int max=arr[arr.length-1];
        for (int i=arr.length-1; i>=0;i--) {
            if (i == arr.length-1) {
               // max = arr[i];
                arr[i] = -1;
            }
            else {
                int curr_max = max;
                if (max < arr[i])
                    max = arr[i];
                arr[i] = curr_max;
            }
        }
        return arr;
    }
}