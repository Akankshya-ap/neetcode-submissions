class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // have a window of size k
        // each window - find the maximum ele
        // keep the index of the maximum ele in a window instead of the ele
        // deque. -- descending order - > front of deque is the max
        if(nums==null || k==0) return new int[0];

        int n = nums.length;

        int[] res = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0;i <n; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if(dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }

        }
        return res;
    }
    
}
