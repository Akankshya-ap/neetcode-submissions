class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> close = new PriorityQueue<>((a,b)-> ((b[0]*b[0] + b[1]*b[1])-(a[0]*a[0] + a[1]*a[1])));

        for(int[] point:points){
            close.offer(point);
            if(close.size()>k){
                close.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(close.size()>0){
            res[i++] = close.poll();
        }
        return res;
    }
}
