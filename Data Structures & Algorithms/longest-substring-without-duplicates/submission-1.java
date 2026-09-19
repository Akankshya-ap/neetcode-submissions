class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;

        Set<Character> seen = new HashSet<>();
        int left = 0 ;
        int right = 0;

        int maxLength = 0;

        while(right<n){
            char c = s.charAt(right);
            if(seen.contains(c) ){
                while(seen.contains(c)) 
                { 
                    seen.remove(s.charAt(left));
                    left++;
                }
            }
            seen.add(c);
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;        
    }
}
