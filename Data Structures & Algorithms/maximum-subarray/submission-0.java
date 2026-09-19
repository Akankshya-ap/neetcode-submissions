class Solution {
    public int maxSubArray(int[] nums) {
        int prevSum = 0;
        int max = Integer.MIN_VALUE;

        for(int i =0; i<nums.length; i++){
            if(prevSum<0){
                prevSum = nums[i];
            }
            else{
                prevSum+=nums[i];
            }
            max = Math.max(max, prevSum);
        }
        return max;
    }
}

// 2 , -3, 4, -2, 2, 1, -1, 4

// 2  -1 4 2 4 5 4 8