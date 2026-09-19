class Solution {
    public boolean isValidSudoku(char[][] board) {
        //keep a map of each 3*3 sub-box
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();


        for(int i=0;i<9; i++){
            for(int j = 0; j<9; j++){
                char val = board[i][j];

                if(val=='.') continue;

                String boxKey = (i/3)+","+(j/3);

                if(row.getOrDefault(i, new HashSet<Character>()).contains(val)
                || col.getOrDefault(j, new HashSet<Character>()).contains(val)
                || box.getOrDefault(boxKey, new HashSet<Character>()).contains(val)) return false;

                row.computeIfAbsent(i, k -> new HashSet<>()).add(val);
                col.computeIfAbsent(j,k -> new HashSet<>()).add(val);
                box.computeIfAbsent(boxKey,k -> new HashSet<>()).add(val);

            }
        }
        return true;

    }
}
