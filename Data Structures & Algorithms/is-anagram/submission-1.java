class Solution {
    public boolean isAnagram(String s, String t) {

        //convert to Arrays
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);

        //compare arrays
        int i =0, j=0;
        for(; i< s1.length && j< t1.length; i++, j++){
            if(s1[i] != t1[j]) return false;
        }

        
        if(i==s1.length && j==t1.length) return true;
        return false;
    }
}
