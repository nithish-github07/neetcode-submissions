class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean end = false;

    public void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.end = true;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for(String word: wordDict){
            root.insert(root,word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        int n = s.length();
        for(int i=n-1; i>=0; i--){
            TrieNode curr = root;
            for(int j=i; j<n; j++){
                if(!curr.children.containsKey(s.charAt(j))){
                    break;
                }
                curr = curr.children.get(s.charAt(j));
                if(curr.end && dp[j+1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
