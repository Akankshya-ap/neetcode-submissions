class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     Arrays.sort(candidates);

     List<List<Integer>> res = new ArrayList<List<Integer>>();
    backtrack(candidates, target, new ArrayList<>(), res, 0);
    return res;

    }

    private void backtrack(int[] candidates, int target, List<Integer> templist, List<List<Integer>> res, int curr){
        if(target == 0) res.add(new ArrayList<>(templist));
        else if(target<0) return;
        else{
            for(int i = curr; i< candidates.length; i++){
                if(i>curr && candidates[i]==candidates[i-1]) continue;
                if(target-candidates[i]<0) break;
                templist.add(candidates[i]);
                backtrack(candidates, target - candidates[i], templist, res, i+1);
                templist.remove(templist.size()-1);
            }
        }
        return;
    }
}
