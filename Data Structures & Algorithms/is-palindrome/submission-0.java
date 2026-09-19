class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;

        while(i<=j){
            if(!isAlphaNumeric(s.charAt(i))) {i++; continue;}
            if(!isAlphaNumeric(s.charAt(j))) {j--; continue;}

            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++; j--;
            }
            else return false;
        }
        return true;
    }
    private boolean isAlphaNumeric(char c){
        if(c>='A' && c<='Z')return true;
        else if(c>='a' && c<='z') return true;
        else if(c>='0' && c<='9') return true;
        return false;
    }
}
