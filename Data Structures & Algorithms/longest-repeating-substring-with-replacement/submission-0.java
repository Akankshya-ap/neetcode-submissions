class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int res = 0;
        Map<Character, Integer> cMap = new HashMap<>();

        while(right<s.length()){
            char c = s.charAt(right);
            cMap.put(c, cMap.getOrDefault(c, 0)+1);
            maxCount = Math.max(maxCount, cMap.get(c));

            while((right-left+1) -maxCount >k){
                cMap.put(s.charAt(left), cMap.get(s.charAt(left))-1);
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}
