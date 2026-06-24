class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean end = false;
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr= curr.children.get(ch);
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch: prefix.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
                
            }
            curr= curr.children.get(ch);
        }
        return true;
    }
}
