class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] row = new int[text2.length()+1];
        Arrays.fill(row, 0);

        for(int i = 1; i<= text1.length(); i++){
            int[] newRow = new int[text2.length()+1];
            Arrays.fill(newRow,0);
            for(int j = 1; j<=text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    newRow[j] = Math.max(1+ row[j-1], Math.max(row[j], newRow[j-1]));
                } else{
                    newRow[j] = Math.max(row[j], newRow[j-1]);
                }
            }
            row = newRow;
        }
        return row[text2.length()];

    }
}
//   c r a b t
// c 1 1 1 1 1
// a 1 1 2 2 2
// t 1 1 2 2 3