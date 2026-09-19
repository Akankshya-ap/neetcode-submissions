class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i<numCourses; i++)
            adjList.add(new ArrayList<>());

        for(int[] pre: prerequisites){
            inDegree[pre[1]]++;
            adjList.get(pre[0]).add(pre[1]);
        }

        boolean flag = false;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            finish++;
            for(int node: adjList.get(curr)){
                inDegree[node]--;
                if(inDegree[node]==0) q.add(node);
            }
        }
        if(finish==numCourses) return true;
        else return false;

    }
}
