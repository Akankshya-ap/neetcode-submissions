class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0]<nums[n-1]){
            return nums[0];
        }

        int left = 0;
        int right = n-1;
        int res = nums[0];
        while(left<=right){
            if(nums[left]<nums[right])
            {
                res = Math.min(res, nums[left]);
                break;
            }
            int mid = left + (right-left)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid]<nums[right] ){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }
}
