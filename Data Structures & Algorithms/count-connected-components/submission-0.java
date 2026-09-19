class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i =0;i<n;i++) parent[i]=i;

        for(int[]e: edges){
            int root1= findParent(parent, e[0]);
            int root2 = findParent(parent, e[1]);
            if(root1!=root2){
                parent[root1] = root2;
            }
        }

        Set<Integer> roots = new HashSet<>();
        for(int i = 0;i<n; i++){
            roots.add(findParent(parent, i));
        }

        return roots.size();
    }
}
private int findParent(int[] parent, int i){
    if(parent[i]!=i) {
        parent[i] = findParent(parent, parent[i]);
    }
    return parent[i];
}
