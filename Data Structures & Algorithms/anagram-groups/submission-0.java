class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //2D arraylist of maps. where each row maps to one anagram. 
        HashMap<String, List<String>> map= new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }
            String p = Arrays.toString(count);
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
