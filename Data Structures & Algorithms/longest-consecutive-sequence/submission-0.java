class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n<2 ) return n;

        int maxTillNow = 1;
        int count = 1;

        Arrays.sort(nums);
        int i = 0;
        while(i<n-1){
            if(nums[i+1] == nums[i]+1) count++;
            else if (nums[i+1] != nums[i]) count=1;
            maxTillNow = Math.max(count, maxTillNow);
            i++;
        }

        return maxTillNow;
    }
}
