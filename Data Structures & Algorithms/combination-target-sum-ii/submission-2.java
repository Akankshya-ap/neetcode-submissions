class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int start,int[] candidates, int target){
        if(target<0) return;
        if(target==0) res.add(new ArrayList<>(temp));
        else {
            for(int i = start;i < candidates.length; i++){
                if(i>start && candidates[i]==candidates[i-1]) 
                    continue;
                if(candidates[i]>target) break;
                temp.add(candidates[i]);
                backtrack(res, temp, i+1, candidates, target-candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
