class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean end = false;
    int index = -1;
    
}
class Solution {
    public TrieNode formTrie(String[] words){
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        for(int i=0; i<words.length; i++){
            for(char ch: words[i].toCharArray()){
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch,new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.end = true; 
            curr.index = i;
            curr = root;
        }
        return root;
    }

    public void backTrack(char[][] board, String[] words, TrieNode root, List<String> res, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char ch = board[i][j];
        if(!root.children.containsKey(ch)) return;

        TrieNode next = root.children.get(ch);

        if(next.end){
            res.add(words[next.index]);
            next.end = false;
        }

        board[i][j] = '#';

        backTrack(board,words,next,res,i-1,j);
        backTrack(board,words,next,res,i+1,j);
        backTrack(board,words,next,res,i,j-1);
        backTrack(board,words,next,res,i,j+1);
        
        board[i][j] = ch;

    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = formTrie(words);
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                backTrack(board,words,root,res,i,j);
            }
        }
        return res;
    }
}
