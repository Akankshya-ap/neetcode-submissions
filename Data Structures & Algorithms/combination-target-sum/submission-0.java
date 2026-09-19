class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> curr =new ArrayList<>();
        dfs(nums, 0, target, curr);
        return res;
    }

    private void dfs(int[] nums, int i, int rem, List<Integer> curr){
        if(rem==0) { res.add(new ArrayList(curr)); return;}
        if(i == nums.length || rem<0){
            return ;
        }

        curr.add(nums[i]);
        dfs(nums, i, rem-nums[i], curr);

        curr.remove(curr.size()-1);
        dfs(nums, i+1, rem, curr);
    }
}
