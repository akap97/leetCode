class Solution {
    public int firstUniqChar(String s) {
        int arr[] = new int[256];
        for (int i =0; i<s.length();i++) {
            if (arr[s.charAt(i)] == 0)
                arr[s.charAt(i)] = i+1;
            else arr[s.charAt(i)] = -1;
        }
        int min_index = Integer.MAX_VALUE;
        for (int i =0 ; i<256; i++) {
            if (arr[i] > 0 && min_index >= arr[i])
                min_index = arr[i];
        }
        return min_index != Integer.MAX_VALUE? min_index-1: -1;
    }
}