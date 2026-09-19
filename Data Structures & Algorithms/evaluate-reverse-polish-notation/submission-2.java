class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String c: tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operator(a,b,c.toCharArray()[0]));
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    private int operator(int a , int b, char op){
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        if(op=='*') return a*b;
        if(op=='/') return a/b;
        return 0;
    }
}
