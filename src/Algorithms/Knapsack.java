package Algorithms;
import java.util.*;

public class Knapsack {

    public static void main(String[] args) {

        int[] weights = {7, 2, 1, 9};
        int[] values =  {5, 4, 7, 2};
        int capacity = 15;

        System.out.println("N1");
        System.out.println("Solution");
        solveKnapsackDP(weights, values, capacity);

        System.out.println("\nGreedy Solution");
        solveKnapsackGreedy(weights, values, capacity);

        System.out.println("N3");
        //              A      B      C      D      F      G
        int[] invest = {600000,250000,750000,200000,250000,100000};
        int[] profit = {170000,125000,200000,150000,90000,70000};
        int budget = 1250000;

        solveInvestmentKnapsack(invest, profit, budget);
    }

    private static void solveKnapsackDP(int[] w, int[] v, int cap) {
        int n = w.length;
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                if (w[i - 1] <= c) {
                    dp[i][c] = Math.max(dp[i -  1][c], v[i - 1] + dp[i - 1][c - w[i - 1]]);
                } else {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }

        System.out.println("Max value = " + dp[n][cap]);
        int c = cap;
        List<Integer> chosen = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (dp[i][c] != dp[i - 1][c]) {
                chosen.add(i - 1);
                c -= w[i - 1];
            }
        }
        System.out.println("Chosen items (DP): " + chosen);
    }

    private static void solveKnapsackGreedy(int[] w, int[] v, int cap) {
        int n = w.length;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> Double.compare((double)v[b] / w[b], (double)v[a] / w[a]));

        int remaining = cap, totalValue = 0;
        List<Integer> chosen = new ArrayList<>();

        for (int i : idx) {
            if (w[i] <= remaining) {
                chosen.add(i);
                remaining -= w[i];
                totalValue += v[i];
            }
        }

        System.out.println("Max greedy value = " + totalValue);
        System.out.println("Chosen items (Greedy): " + chosen);
    }

    private static void solveInvestmentKnapsack(int[] cost, int[] profit, int budget) {
        int n = cost.length;
        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 1; i <= n; i++) {
            for (int b = 1; b <= budget; b++) {
                if (cost[i - 1] <= b) {
                    dp[i][b] = Math.max(dp[i - 1][b], profit[i - 1] + dp[i - 1][b - cost[i - 1]]);
                } else {
                    dp[i][b] = dp[i - 1][b];
                }
            }
        }

        System.out.println("Max Profit = " + dp[n][budget]);

        int b = budget;
        List<Integer> chosen = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (dp[i][b] != dp[i - 1][b]) {
                chosen.add(i - 1);
                b -= cost[i - 1];
            }
        }

        Collections.reverse(chosen);
        char[] names = {'A','B','C','D','E','F'};

        System.out.print("Selected projects: ");
        for (int i : chosen) System.out.print(names[i] + " ");
    }
}
