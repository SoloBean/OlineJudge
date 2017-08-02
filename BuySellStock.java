package buySellStock;

public class BuySellStock {
    public int maxProfit(int[] prices){
        if ( prices.length == 0 ){
            return 0;
        }
        int maxProfit = 0;

        int beginIndex = 0;
        int endIndex = 0;

        for(int i = 1; i < prices.length ; i++){
            if(prices[i] < prices[i-1]){
                maxProfit += prices[endIndex] - prices[beginIndex];
                beginIndex = i;
            }
            endIndex = i;
        }
        if(prices[endIndex] > prices[beginIndex]){
            maxProfit += prices[endIndex] - prices[beginIndex];
        }
        return maxProfit;
    }
    public static void main(String[] args){
        BuySellStock t = new BuySellStock();
        int[] prices = new int[]{2,1};
        System.out.println(t.maxProfit(prices));
    }
}
