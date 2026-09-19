class Solution {

    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> res){
        res.add(new ArrayList<>(subset));
        for(int i = start; i< nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(nums, i+1, subset, res);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //initilizae  result list
        // subset
        //sorting

        // backtracking
        // [1,2,2]
        //sort -> [1,2,2]

        // sort nums to group the duplicates
        // start with backtracking from index start

        //recursion
        // -add current path to result 
        // for each i from start to lentgh of array 
        // skipping duplicate and include nums[i] and then backtrack

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;

        
    }
}
