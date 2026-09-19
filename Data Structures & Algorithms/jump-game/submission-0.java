class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;

        for(int i =nums.length-2; i>=0; i--){
            if(i+nums[i]>=goal){
                goal = i;
            }
        }
        return goal == 0;
    }
    
}


// i i+1. ... i+3
//   here.    here
// n n-1 n-2 n-3.. n!
