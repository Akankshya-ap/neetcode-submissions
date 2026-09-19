class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        StringBuilder stack = new StringBuilder();
        backtrack(res, 0, 0, n, stack);
        return res;
    }

    private void backtrack(List<String> res, int open, int closed, int n, StringBuilder stack){

        if(open==closed && open==n){
            res.add(stack.toString());
            return;
        }

        if(open<n){
            stack.append('(');
            backtrack(res, open+1, closed, n, stack);
            stack.deleteCharAt(stack.length()-1);
        }

        if(closed<open){
            stack.append(')');
            backtrack(res, open, closed+1, n, stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
