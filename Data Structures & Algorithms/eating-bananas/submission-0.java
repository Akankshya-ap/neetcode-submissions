class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        //h>number of piles ->. we can finish easily so we need to relax and eat.
        //h == number of piles --> we need to set up min k
        //h< number of piles -->not possible to cover this

        //1+4+3+2 - 4k  + 5k = 0 -> 

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = high;

        while(low<=high){
            int mid = (low+high)/2;
            long hours = 0;
            for(int p :piles){
                hours += Math.ceil((double)p/mid);
            }
            if(hours<=h){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;

    }
}
