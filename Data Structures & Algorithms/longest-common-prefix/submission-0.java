class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l = strs.length;
        if(l<2) return strs[0];
        Arrays.sort(strs);

        String start = strs[0];
        String end = strs[l-1];

        int min = Math.min(start.length(), end.length());

        StringBuilder res = new StringBuilder();
        for(int i =0 ;i < min ;i++){
            if(start.charAt(i) != end.charAt(i)){
                return res.toString();
            }                 
            res.append(start.charAt(i));

        }
        return res.toString();


    }
}