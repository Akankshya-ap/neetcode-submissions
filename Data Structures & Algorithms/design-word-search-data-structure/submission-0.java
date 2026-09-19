class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26] ;
        boolean word = false;
    }

    TrieNode head;
    public WordDictionary() {
        head = new TrieNode();
    }

    public void addWord(String  word) {
        TrieNode node = head;
        for(char c: word.toCharArray()){
            int i = c-'a';
            if(node.children[i]==null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, head);
    }

    private boolean dfs(String word, int j, TrieNode root){
        TrieNode node = root;
        for(int i = j; i<word.length(); i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(TrieNode child: node.children){
                    if(child!=null && dfs(word, i+1, child)){
                        return true;
                    }
                }
                return false;
            } else{
                if(node.children[c-'a'] == null) return false;
                node = node.children[c-'a'];
            }

        }
        return node.word;
    }
}
