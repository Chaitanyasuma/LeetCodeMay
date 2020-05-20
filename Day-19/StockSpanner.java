class StockSpanner {
    Stack<Integer> prices, stocks;

    public StockSpanner() {
        prices = new Stack(); //to store all incoming prices
        stocks = new Stack(); //to store all stock spans
    }

    public int next(int price) {
        int stockspan = 1;
        while (prices.isEmpty() == false && prices.peek() <= price) { //i.e. if there are more prices in the stack and of value less than the current one
            prices.pop();
            stockspan += stocks.pop(); //it's cumulative, thus, today's stockspan will be in addition to yesterday's, so yesterday's info will be recorded in today's
        }
        prices.push(price); //keeping track of previous prices
        stocks.push(stockspan);
        return stockspan;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */