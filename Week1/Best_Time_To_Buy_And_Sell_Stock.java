import java.util.*;
public class Best_Time_To_Buy_And_Sell_Stock{ 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {   
            prices[i] = sc.nextInt();
        }
        maxProfit(prices);
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int buy=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy){
                buy=prices[i];
            } 
            else{
                maxProfit=Math.max(maxProfit,prices[i]-buy);
            }
        }
        return maxProfit;
    }
}