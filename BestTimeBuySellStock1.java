package bestTimeBuySellStock;

public class BestTimeBuySellStock1 {
	public int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] <= minPrice){
        		minPrice = prices[i];
        		continue;
        	}
        	else{
        		int tmpProfit = prices[i] - minPrice;
        		if(tmpProfit > maxProfit){
        			maxProfit = tmpProfit;
        		}
        	}
        }
        
        return maxProfit;
    }
}
