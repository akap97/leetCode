class Solution { // brute force
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> h = new HashSet<>();
        List<Integer> l = new LinkedList<>();
        for (int i: nums1) {
            if (!h.contains(i))
                h.add(i);
        }
        
        for (int i=0; i<nums2.length; i++) {
            if (h.contains(nums2[i])) {
                h.remove(nums2[i]);
                l.add(nums2[i]);
            }
        }
        
        int res[] = new int[l.size()];
        for (int i =0; i< res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}

// if arrays are sorted. do it in O(1) space
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Assume two array are sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || nums1[i] != nums1[k - 1]) // most important part, to remove duplicates
                    nums1[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return Arrays.copyOf(nums1, k);
    }
}
