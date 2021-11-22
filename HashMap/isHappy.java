class Solution { // brute force
    public boolean isHappy(int n) {
        Set<Integer> h = new HashSet<>();
        while (curr_val != 1 || !h.contains()) {
            curr_val = get_squared_sum(curr_val);
            h.add(curr_val);
        }
        if (curr_val == 1)
            return true;
        return false;
    }
    
    private int get_squared_sum(int n) {
        int res = 0;
        while (n > 0) {
            int d = n%10;
            res+= d*d;
            n = n/10;
        }
        return res;
    }
    
}

// O(1) space. it's like finding cycle in linked list
public class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}