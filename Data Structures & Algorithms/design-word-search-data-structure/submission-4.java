class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean end = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchWord(root,word,0);
    }

    public boolean searchWord(TrieNode root, String word, int i){
        if(i == word.length()){
            return root.end;
        }
        if(word.charAt(i) != '.'){
            if(!root.children.containsKey(word.charAt(i))){
                return false;
            }
            return searchWord(root.children.get(word.charAt(i)), word,i+1);
        }
        else{
            boolean found = false;
            for(Character key: root.children.keySet()){
                found = searchWord(root.children.get(key), word, i+1);
                if(found){
                    break;
                }
            }
            return found;
        }
    }
}
