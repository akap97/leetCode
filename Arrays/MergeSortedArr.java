class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // start copying from largest to smallest
       int i=m-1, j=n-1, k=n+m-1;
        while (k >=0) {
            if (i <0) { // i is exhausted, copy remaining j
                while(j >=0) {
                    nums1[k] = nums2[j];
                    k--;
                    j--;
                }
                break;
            }
            else if (j < 0) {
                while(i >=0) { //j is exhausted, copy remaining i
                    nums1[k] = nums1[i];
                    k--;
                    i--;
                }
                break;
            }
            else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;  
            }
            else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}

class Solution {
    // recursive implementation of above
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) {
            if (m == 0 && n == 0) 
                return;
            else if (m == 0) {
                nums1[m+n-1] = nums2[n-1];
                // n-=1;
                merge(nums1, 0, nums2, --n);
            }
            else {
                nums1[m+n-1] = nums1[m-1];
                // m-=1;
                merge(nums1, --m, nums2, 0);
            }
        }
        else if (nums1[m-1] >= nums2[n-1]) {
            nums1[m+n-1] = nums1[m-1];
            // m-=1;
            merge(nums1, --m, nums2, n);
            
        }
        else {
             nums1[m+n-1] = nums2[n-1];
             // n-=1;
             merge(nums1, m, nums2, --n);
        }
        
    }
}