public class Solution { // without hashmap, works only for positive numbers
    public boolean containsDuplicate(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1<<k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j]|=check;
        }
        return false;
    }
}

// works for both positive and negative
// use if for learning bin manipulation only (MEMEORY_LIMIT_EXCEEDED)
int BIT_SIZE = 32;
		int[] posMark = new int[Integer.MAX_VALUE / BIT_SIZE + 1];
		int[] negMark = new int[Integer.MAX_VALUE / BIT_SIZE + 1];
		for (int n : nums) {
			boolean sign = n >= 0;
			int hash  = Math.abs(n) / BIT_SIZE;
			int index = Math.abs(n) % BIT_SIZE;
			int check = 1 << index;
			if ((sign && (posMark[hash] & check) != 0) || (!sign && (negMark[hash] & check) != 0))
				return true;
			if (sign) {
				posMark[hash] |= check;
			} else {
				negMark[hash] |= check;
			}

		}
return false;