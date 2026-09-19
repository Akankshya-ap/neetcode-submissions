class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        Map<Character, Integer> cMap = new HashMap<>();

        for(char c: s1.toCharArray()){
            cMap.put(c, cMap.getOrDefault(c,0)+1);
        }

        int l = 0;
        int count = 0;
        for(; l<s2.length(); l++){
            count = 0;
            int r=l;
            // char c = s2.charAt(r);
            while(r<s2.length() && cMap.containsKey(s2.charAt(r)) && cMap.get(s2.charAt(r))!=0){
                count++;
                cMap.put(s2.charAt(r),cMap.get(s2.charAt(r))-1);
                r++;
            }
            if(count == s1.length()) return true;
            int pl=l;
            while(l<r){
                if(cMap.containsKey(s2.charAt(l))) {
                    cMap.put(s2.charAt(l),cMap.get(s2.charAt(l))+1);
                }
                l++;
            }
            l=pl;
        }

        return false;

    }
}
