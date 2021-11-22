// basic
class ValidWordAbbr {
    
    HashMap<String, Set<String>> h = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s: dictionary) {
            String abbr = getAbbr(s);
            if (!h.containsKey(abbr)) {
                Set<String> st = new HashSet<>();
                st.add(s);
                h.put(abbr, st);
            }
            else h.get(abbr).add(s);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!h.containsKey(abbr) || (h.get(abbr).size() == 1 && h.get(abbr).contains(word)))
            return true;
        return false;
    }
    
    private String getAbbr(String s) {
        if (s.length() == 2)
            return s;
        int mid_char = s.length()-2;
        return String.valueOf(s.charAt(0))+mid_char+String.valueOf(s.charAt(s.length()-1));
    }
}



// without set
class ValidWordAbbr {
    HashMap<String, String> h = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s: dictionary) {
            String abbr = getAbbr(s);
            if (!h.containsKey(abbr)) {
                h.put(abbr, s);
            }
            else {
                if (!h.get(abbr).equals(s))
                    h.put(abbr, "NU");
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!h.containsKey(abbr) || h.get(abbr).equals(word))
            return true;
        return false;
    }
    
    private String getAbbr(String s) {
        if (s.length() == 2)
            return s;
        int mid_char = s.length()-2;
        return String.valueOf(s.charAt(0))+mid_char+String.valueOf(s.charAt(s.length()-1));
    }
}

// improved
class ValidWordAbbr {
    HashMap<String, String> h = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s: dictionary) {
            String abbr = getAbbr(s);
            if (h.containsKey(abbr) && !h.get(abbr).equals(s)) // improve time by simplifying if else
                h.put(abbr, "");
            else h.put(abbr, s);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !h.containsKey(abbr) || h.get(abbr).equals(word); // improve by using direct return 
    }
    
    private String getAbbr(String str) { // improve memory by using string builder
        int len=str.length();
        if(len<=2) return str;
        StringBuilder sb=new StringBuilder();
        sb.append(str.charAt(0));
        sb.append(len);
        sb.append(str.charAt(len-1));
        return sb.toString();
    }
}

// another way by modifying string creation, not much impact on the memory
class ValidWordAbbr {
    
    Map<String, String> abbrMap = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = word.length() + "_" + word.charAt(0) + "_" + word.charAt(word.length() - 1);
            
            if (abbrMap.containsKey(abbr)) {
                if (!abbrMap.get(abbr).equals(word)) {
                    abbrMap.put(abbr, "");
                }
            } else {
                 abbrMap.put(abbr, word);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = word.length() + "_" + word.charAt(0) + "_" + word.charAt(word.length() - 1);
        
        return !abbrMap.containsKey(abbr) || (abbrMap.containsKey(abbr) && abbrMap.get(abbr).equals(word));
    }
}