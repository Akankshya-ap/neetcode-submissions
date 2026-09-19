class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> seen = new HashMap<>();

       for(int i=0; i< nums.length; i++){
        int look = target-nums[i];
        if(seen.containsKey(look)){
            return new int[]{seen.get(look), i};
        }
        if(!seen.containsKey(nums[i]))
        {seen.put(nums[i], i);}
       }
       return new int[]{};
    }
}
