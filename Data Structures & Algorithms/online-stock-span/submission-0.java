class Stock{
    int val;
    int span;
    Stock(int val, int span){
        this.val = val;
        this.span = span;
    }
}
class StockSpanner {

    Stack<Stock> s;
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!s.isEmpty() && s.peek().val <= price){
            count += s.pop().span;
        }
        s.push(new Stock(price,count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */