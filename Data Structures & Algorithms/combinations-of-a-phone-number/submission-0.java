class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        backtrack(digits, 0, res, curr, map);
        return res;
    }

    private void backtrack(String digits, int start, List<String> res, StringBuilder curr, Map<Integer, String> map){
        if(start==digits.length()) {
            res.add(curr.toString());
            return;
        }

        
        char c = digits.charAt(start);
        for(char j : map.get(c-'0').toCharArray()){
            curr.append(j);
            backtrack(digits, start+1, res, curr, map);
            curr.deleteCharAt(curr.length()-1);
        }
        

    }


}
