class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
       for(String s: strs){
        //convert into char count map

        int[] map = new int[26];
        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        String anaGroup = Arrays.toString(map);
        res.putIfAbsent(anaGroup, new ArrayList<>());
        res.get(anaGroup).add(s);
       }

       return new ArrayList<>(res.values());
    }
}
