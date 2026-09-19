class Solution {
    public int maxArea(int[] heights) {
        int maxTillNow = 0;

        int curr = 0;
        int l = 0, r= heights.length-1;

        while(l<r){
            maxTillNow = Math.max(Math.min(heights[l], heights[r]) * (r-l), maxTillNow);
            if(heights[l]<=heights[r]) l++;
            else r--;
        }
        return maxTillNow;

    }
}
