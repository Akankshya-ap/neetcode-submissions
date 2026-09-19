class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l = strs.length;
        if(l<2) return strs[0];

        int mini = 0;
        for(int i =1; i<l; i++){
            if(strs[mini].length() > strs[i].length()){
                mini = i;
            }
        }

        Trie trie = new Trie();
        trie.insert(strs[mini]);
        int prefixLen = strs[mini].length();

        for(int i =0; i<l ;i++){
            prefixLen = trie.lcp(strs[i], prefixLen);
        }

        return strs[0].substring(0, prefixLen);
        // Arrays.sort(strs);

        // String start = strs[0];
        // String end = strs[l-1];

        // int min = Math.min(start.length(), end.length());

        // StringBuilder res = new StringBuilder();
        // for(int i =0 ;i < min ;i++){
        //     if(start.charAt(i) != end.charAt(i)){
        //         return res.toString();
        //     }                 
        //     res.append(start.charAt(i));

        // }
        // return res.toString();


    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
}

class Trie{
    TrieNode root = new TrieNode();

    void insert(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
    }

    int lcp(String word, int preFixLen){
        TrieNode node = root;

        int i = 0;
        while(i<Math.min(word.length(), preFixLen)){
            if(!node.children.containsKey(word.charAt(i))) return i;
            node = node.children.get(word.charAt(i));
            i++;
        }
        return Math.min(word.length(), preFixLen);
    }
}