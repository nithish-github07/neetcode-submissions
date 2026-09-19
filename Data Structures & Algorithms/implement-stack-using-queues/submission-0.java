class MyStack {

    Deque<Integer> q;
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int size = q.size();
        for(int i=0; i<size-1; i++){
            q.offer(q.poll());
        }
        return q.poll();
    }
    
    public int top() {
        int size = q.size();
        for(int i=0; i<size-1; i++){
            q.offer(q.poll());
        }
        int n = q.poll();
        q.offer(n);
        return n;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */