class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        long product = 1;

        Set<Integer> zeros = new HashSet<>();

        for(int i = 0;i <n; i++){
            if(nums[i]!=0) product*=(long)nums[i];
            else{
                zeros.add(i);
            }
        }

        for(int i = 0;i <n; i++){
            if(nums[i]!=0) {
                if(!zeros.isEmpty()) res[i] = 0;
                else{
                    res[i] = (int) (product/nums[i]);
                }
            } else {
                if(zeros.size()>1) res[i] = 0;
                else res[i] = (int)product;
            }
        }
        return res;
    }
}  
