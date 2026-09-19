class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> inDegree = new HashMap<>();

      for(String s: words){
        for(char c: s.toCharArray()){
            inDegree.putIfAbsent(c,0);
        }
      }

      for(int i=0;i< words.length-1; i++){
        String w1 = words[i], w2 = words[i+1];
        
        if(w1.length()> w2.length() && w1.startsWith(w2)) return "";

        for(int j=0; j<Math.min(w1.length(), w2.length()); j++){
            char c1 = w1.charAt(j), c2 = w2.charAt(j);
            if(c1!=c2){
                if(graph.computeIfAbsent(c1, k-> new HashSet<>()).add(c2)){
                    inDegree.put(c2, inDegree.get(c2)+1);
                }
                break;
            }
        }
      }

      Queue<Character> q = new LinkedList<>();
      for(char c: inDegree.keySet()){
        if(inDegree.get(c)==0){
            q.add(c);
        }
      }

    StringBuilder sb = new StringBuilder();
      while(!q.isEmpty()){
        char c = q.poll();
        sb.append(c);

        for(char neigh: graph.getOrDefault(c, new HashSet<>())){
            inDegree.put(neigh, inDegree.get(neigh)-1);
            if(inDegree.get(neigh)==0) q.add(neigh);
        }

      }

      return sb.length() == inDegree.size() ? sb.toString(): "";
    }
}
