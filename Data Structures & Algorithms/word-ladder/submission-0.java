class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        HashMap<String,ArrayList<String>> nei = new HashMap<>();
        wordList.add(beginWord);
        for(String word: wordList){
            for(int i=0; i<word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i,'*');
                nei.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(word);
            }
        }

        int res = 1;
        Deque<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return res;
                }
                for(int j=0; j<word.length(); j++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(j,'*');
                    for(String neiword: nei.get(sb.toString())){
                        if(!visited.contains(neiword)){
                            visited.add(neiword);
                            q.offer(neiword);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
