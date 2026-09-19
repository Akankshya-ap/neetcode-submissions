class Solution {
    public boolean validTree(int n, int[][] edges) {
        //0-1 , 0-2, 0-3, 1,4 
        // 0,1,2,3,4
        //action --> union -(0,1) --> (0,0,2,3,4)
        //action (0,0,2,3,4) --> (0, 0,0,3,4)
        //action(0,0,0,3,4)->(0,0,0,0,4)
        //action(0,0,0,0,4) -> (0,0,0,0,0)
        if(edges.length!=n-1) return false;

        int[] parent = new int[n];
        for(int i =0;i<n ;i++){ parent[i] = i;}

        for(int[] e: edges){
            int root1 = findParent(e[0], parent);
            int root2 = findParent(e[1], parent);
            if(root1==root2) return false;
            parent[root1] = root2;
        }
        return true;
    }

    private int findParent(int e, int[] parent){
        if(parent[e]!=e) parent[e] = findParent(parent[e], parent);
        return parent[e];
    }
}
