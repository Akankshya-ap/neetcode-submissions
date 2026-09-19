class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count; 

    public MedianFinder() {
        count = 0;
        minHeap = new PriorityQueue<>((a,b) -> (b-a));
        maxHeap = new PriorityQueue<>((a,b) -> (a-b));
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek() + maxHeap.peek())/2.0;
        }
        else if(minHeap.size()>maxHeap.size()){
            return (double)minHeap.peek();
        } else return (double)maxHeap.peek();
    }
}
