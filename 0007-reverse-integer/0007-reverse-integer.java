class Solution {
    public int reverse(int x) {
        /*
        int result = 0
        int next = x
        int n = 0;
        while (next >= 10)
            result = result * 10^(n+1) + next % 10 * 10 ^ n
            next = next / 10
            n ++;
            result =  


        123
        n=0 -> r = 3 (next=123 -> 12)
        n=1 -> r = 32 (next=12 -> 2)
        n=2 -> r = 

        120
        n=0 -> r = 0 (next=120 -> 12)
        n=1 -> r = 2 (next=12 -> 2)
        n=2 -> r =  (next=2 -> 2)

        1010
        n=0 -> r = 0 (next=120 -> 12)
        n=1 -> r = 2 (next=12 -> 2)
        n=2 -> r =  (next=2 -> 2)
         */

         long result = 0;
         int next = x;

        boolean exist = false;
         while (Math.abs(next) > 0) {
             int rest = (int) (next % 10);
             if (!exist && rest == 0) { 
                next = next / 10;
                continue;
             }
             result = result * 10 + rest;
             next = next / 10;
             exist = true;

            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                 return 0;
             }
         }

        return (int) result;
    }
}