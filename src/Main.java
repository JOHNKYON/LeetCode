import questions.leetcode123.BestTimetoBuyandSellStockIII;



public class Main {
    public static void main(String[] args) {

        BestTimetoBuyandSellStockIII method= new BestTimetoBuyandSellStockIII();

        int[] input = {7,6,4,3,1};
        int[][] hits = {{1,0}, {0,0}, {2,0}};

        System.out.print(method.maxProfit(input));
//        method.next(1);
//        method.next(10);
//        method.next(3);
//        method.next(5);
    }

}
