class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s, 0, res, curr);
        return res;
    }

    private void backtrack(String s, int start, List<List<String>> res, List<String> curr){
        if(start>=s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i))
             {
                curr.add(s.substring(start, i+1));
                backtrack(s, i+1, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String p, int l, int r){
        
        while(l<r){
            if(p.charAt(l) != p.charAt(r)) return false;
            l++;
            r--;
        }   
        return true;
    }
}
