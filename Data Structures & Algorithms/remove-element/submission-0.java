class Solution {
    public int removeElement(int[] nums, int val) {
        int i =0, j = 0;
        int n = nums.length;

        while(i<n && nums[i]!=val){
            i++;
        }
        j=i;
        while(j<n){
        while(j<n && nums[j]==val){
            j++;
        }
        while(i<j && j<n && nums[j]!=val){
            nums[i++] = nums[j++];
        }
        }
        return i;
    }
}