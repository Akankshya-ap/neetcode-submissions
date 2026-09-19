class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create a Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        //traverse array in one D
        for(int i=0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                return new int[]{j,i};
            }
            map.put(target-nums[i], i);
        }
        return new int[0];
    }
}
