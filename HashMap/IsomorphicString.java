// brute force: space O(2N)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int i=0;
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> h = new HashMap<>();
        HashSet<Character> hs = new HashSet<Character>();
        while (i < s.length()) {
            if (!h.containsKey(s.charAt(i)) && !hs.contains(t.charAt(i))) {
                h.put(s.charAt(i), t.charAt(i));
                hs.add(t.charAt(i));
            }
            else {
                if (!h.containsKey(s.charAt(i)) || h.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            i++;
        }
        return true;
    }
}

// less space complexity but 3 pass
// converting 1 string from binding leads to other string
class Solution {
    public boolean isIsomorphic(String s, String t) {
        s = transform(s);
        t = transform(t);
        if (s.equals(t)) // O(N)
            return true;
        return false;
      
    }
    
    private String transform(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int i = 0;
        while (i < str.length()) {
            if (!h.containsKey(str.charAt(i))) {
                h.put(str.charAt(i), i);
                sb.append(i+" ");
            }
            else sb.append(h.get(str.charAt(i)) + " ");
            i++;
        }
        return sb.toString();
    }
}

// Best: 1 pass and only 1 array
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int h[] = new int[512];
        int i=0;
        while (i <  s.length()) {
            if (h[s.charAt(i)] != h[t.charAt(i)+256])
                return false;
            else {
                h[s.charAt(i)] = i+1;
                h[t.charAt(i)+256] = i+1;
            }
            i++;
        }
        return true;
    }
}