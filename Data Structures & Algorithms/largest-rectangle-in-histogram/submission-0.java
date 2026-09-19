class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i =0; i<=n; i++){
            int h = (i==n)? 0: heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >h){
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                maxArea = Math.max(maxArea, height * (right-left));
             }
             stack.push(i);
        }
        return maxArea;
    }
}
