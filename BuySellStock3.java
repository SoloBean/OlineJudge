package buySellStock;

import java.util.ArrayList;
import java.util.List;

public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        if ( prices.length == 0 ){
            return 0;
        }
        if(prices.length == 1){
            return 0;
        }
        List<Integer> endIndex = new ArrayList<>();
        List<Integer> beginIndex = new ArrayList<>();
        //弄list
        int tmpBeginIndex = 1, tmpEndIndex = 0;
        while (prices[tmpBeginIndex] <= prices[tmpBeginIndex-1]){
            tmpBeginIndex++;
            if (tmpBeginIndex >= prices.length){
                break;
            }
        }
        if (tmpBeginIndex >= prices.length){
            return 0;
        }
        beginIndex.add(tmpBeginIndex-1);
        for ( int i = tmpBeginIndex; i < prices.length - 1; i++){
            if (prices[i-1] > prices[i] && prices[i] <= prices[i+1]){
                beginIndex.add(i);
            }
            if (prices[i-1] <= prices[i] && prices[i] > prices[i+1]){
                endIndex.add(i);
            }
        }
        if (beginIndex.size() > endIndex.size()){
            if (prices[beginIndex.get(beginIndex.size()-1)] < prices[prices.length-1]){
                endIndex.add(prices.length-1);
            }
            else {
                beginIndex.remove(beginIndex.size()-1);
            }
        }
        if (endIndex.size() == 0){
            return 0;
        }
        if (endIndex.size() == 1){
            return prices[endIndex.get(0)] - prices[beginIndex.get(0)];
        }
        else if (endIndex.size() == 2){
            return prices[endIndex.get(0)] + prices[endIndex.get(1)] -
                    prices[beginIndex.get(0)] - prices[beginIndex.get(1)];
        }
        else {
            int[] singleProfit = new int[endIndex.size()];
            int minPrice = prices[beginIndex.get(0)];
            singleProfit[0] = prices[endIndex.get(0)] - minPrice;
            for (int i = 1; i < endIndex.size(); i++){
                if (minPrice > prices[beginIndex.get(i)]){
                    minPrice = prices[beginIndex.get(i)];
                }
                singleProfit[i] = prices[endIndex.get(i)] - minPrice;
            }
            int maxProfit = prices[endIndex.get(0)] + prices[endIndex.get(1)] -
                    prices[beginIndex.get(0)] - prices[beginIndex.get(1)];
            for (int i = 2; i < endIndex.size(); i++){
                int max = 0;
                for (int k = i; k >= 1; k--){
                    for (int j = k - 1; j >= 0; j--){
                        int tmpMaxProfit = prices[endIndex.get(i)] - prices[beginIndex.get(k)] +
                                singleProfit[j];
                        if (max < tmpMaxProfit){
                            max = tmpMaxProfit;
                        }
                    }
                }
                if(maxProfit < max){
                    maxProfit = max;
                }
            }

            return maxProfit;
        }
    }

    public static void main(String[] args){
        BuySellStock3 t = new BuySellStock3();
        int[] prices = new int[]{1,9,6,9,1,7,1,1,5,9,9,9};
        System.out.println(t.maxProfit(prices));
    }
}
