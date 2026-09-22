class FreqStack {

    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0) + 1);
        int f = freq.get(val);
        maxFreq = Math.max(maxFreq,f);
        group.computeIfAbsent(f,k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int res = group.get(maxFreq).pop();
        freq.put(res,freq.get(res) - 1);
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */