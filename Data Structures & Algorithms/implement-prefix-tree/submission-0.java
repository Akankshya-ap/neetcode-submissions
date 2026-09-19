class PrefixTree {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd = false;
    }

    private final TrieNode head;


    public PrefixTree() {
         head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = head;
        for(char c: word.toCharArray()){
            int i = c-'a';
            if(node.children[i] == null){
                node.children[i] = new TrieNode();

            }
            node = node.children[i];
        }
        node.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = head;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null) return false;
            node = node.children[i];
        }
        return node.isWordEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for(char c: prefix.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null) return false;
            node = node.children[i];
        }
        return true;
    }
}
