class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a,b)->(a[0]==b[0]? a[1]-b[1]:a[0]-b[0]));
        int[] curr = intervals[0];

        List<int[]> res = new ArrayList<>();

        for(int i = 1; i<intervals.length; i++ ){
            int[] in = intervals[i];
            if(curr==null){
                res.add(in);
            }else if(in[0]>curr[1]){
                res.add(curr);
                curr = in;
            } else {
                curr[0] = Math.min(curr[0], in[0]);
                curr[1] = Math.max(curr[1], in[1]);
            }
        }
        if(curr!=null){
            res.add(curr);
        }

        return res.toArray(new int[res.size()][]);
        
    }
}
