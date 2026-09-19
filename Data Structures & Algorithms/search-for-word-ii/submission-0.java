class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int idx = -1;
        int refs = 0;

        public void addWord(String word, int i){
            TrieNode curr = this;
            curr.refs++;
            for(char c: word.toCharArray()){
                int j = c-'a';
                if(curr.children[j]==null){
                    curr.children[j] = new TrieNode();
                }
                curr = curr.children[j];
                curr.refs++;
            }   
            curr.idx = i;   
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode head = new TrieNode();

        for(int i = 0;i <words.length ;i++)
            head.addWord(words[i], i);
        
        List<String> res = new ArrayList<>();

        for(int r = 0; r<board.length ; r++){
            for(int c = 0; c<board[0].length; c++){
                backtrack(board, r, c, head, res, words);
            }
        }
        return res;
    }

    void backtrack(char[][] board, int i, int j, TrieNode node, List<String> res, String[] words){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '*' || 
        node.children[board[i][j] - 'a'] == null ) return;

        char temp = board[i][j];
        board[i][j] = '*';
        TrieNode prev = node;

        node = node.children[temp-'a'];
        if(node.idx!=-1){
            res.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            if(node.refs == 0){
                node = null;
                prev.children[temp-'a'] = null;
                board[i][j] = temp;
                return;
            }
        }

        backtrack(board, i+1, j, node, res, words);
        backtrack(board, i, j+1, node, res, words);
        backtrack(board, i-1, j, node, res, words);
        backtrack(board, i, j-1, node, res, words);

        board[i][j] = temp;
    }


    


}
