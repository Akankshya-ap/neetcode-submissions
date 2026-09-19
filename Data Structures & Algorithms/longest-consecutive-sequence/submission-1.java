class Solution { 
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n<2 ) return n;

        int maxTillNow = 1;
        int count = 1;


        //O(n) solution
        Set<Integer> all = new HashSet<>();
        int i = 0;
        for(; i<n; i++){
            all.add(nums[i]);
        }

        i=0;
        while(i<n){
            if(!all.contains(nums[i]-1)) {
                count=1;
                while(all.contains(nums[i]+count)) {count++; }
                maxTillNow = Math.max(count, maxTillNow);
            }
            i++;
        }

        //O(n log n) solution
        // Arrays.sort(nums);
        // int i = 0;
        // while(i<n-1){
        //     if(nums[i+1] == nums[i]+1) count++;
        //     else if (nums[i+1] != nums[i]) count=1;
        //     maxTillNow = Math.max(count, maxTillNow);
        //     i++;
        // }

        return maxTillNow;
    }
}
