class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums.length<2) return false;
        //sort the array - O(nlogn)
        Arrays.sort(nums);


        //find adj duplicates (O(n))
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]) return true;
        }

        return false;
    }
}