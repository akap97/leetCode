// brute force: hashset


// alternative: array
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int j[] = new int[58];
        int res = 0;
        for (int i: jewels.toCharArray())
                j[i-65]++;
        for (int i: stones.toCharArray()) {
            if (j[i-65] != 0)
                res++;
        }
        return res;
    }
}


// least memory: bit manipulation
public int NumJewelsInStones(string J, string S) {
 
    int count = 0;
    long bitVector = 0;
    long n = 1;

    for(int i =0;i<J.Length;i++)
    {
        int pos = J[i]-'A';
        bitVector |= (n<<pos);
    }
    
    for(int i =0;i<S.Length;i++)
    {  
        int pos = S[i]-'A';
        if ((bitVector & (n << pos)) !=0) count++;
    }
    
    return count;
}