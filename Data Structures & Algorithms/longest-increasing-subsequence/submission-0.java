class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for(int i = nums.length-1; i>=0; i--){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }

    /*
    nums
    nums[i]<nums[i+p]< nums[i+r]
    s - e
    for each starting point -> find the numof elements in rest
    thats increasing .. 
    s-0 s-3 s-7
    s[i] = 1+ s[]

    set -> 

  1,3. 5  1, 2, 3, 4
           [] [0][0]
    */
}
