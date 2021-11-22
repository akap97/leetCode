//time complexity O(m+n), space: O(N)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l = new LinkedList<>();
        HashMap<String, Integer> h = new HashMap<>();
        for (int i=0;i<list1.length;i++) {
            if (!h.containsKey(list1[i]))
                h.put(list1[i], i);
        }
        int min_sum = Integer.MAX_VALUE;;
        for (int i=0;i<list2.length;i++) {
            if (h.containsKey(list2[i])) {
                int curr_sum = h.get(list2[i])+i;
                if (min_sum >= curr_sum) {
                    if (min_sum == curr_sum)
                        l.add(list2[i]);
                    else {
                        min_sum = curr_sum;
                        l.clear();
                        l.add(list2[i]);

                    }
                }
            }
        }
        String[] res = new String[l.size()];
        for (int s=0; s<l.size(); s++) 
            res[s] = l.get(s);
        return res;
    }
}