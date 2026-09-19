class KthLargest {

    private PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
    private int cap;

    public KthLargest(int k, int[] nums) {
        cap = k;
        for(int i = 0;i<nums.length; i++){
            if(pq.size()!=cap){
                pq.add(nums[i]);
            }
            else{
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()!=cap){
                pq.add(val);
        }
        else{
            if(val>pq.peek()){
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
        
    }
}
