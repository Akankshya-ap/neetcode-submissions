class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for(char c: s.toCharArray()){
            switch(c){
                case '}': {
                    if(!brackets.isEmpty() && brackets.peek()=='{'){
                        brackets.pop();
                        break;
                    }
                    else return false;
                }
                case ')': {
                    if(!brackets.isEmpty() && brackets.peek()=='('){
                        brackets.pop();
                        break;
                    }
                    else return false;
                }
                case ']': {
                    if(!brackets.isEmpty() && brackets.peek()=='['){
                        brackets.pop();
                        break;
                    }
                    else return false;
                }
                default: brackets.push(c);
            }
        }
        return !brackets.isEmpty()?false:true;
    }
}
