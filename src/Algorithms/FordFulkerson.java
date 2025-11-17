package Algorithms;

import java.util.*;

public class FordFulkerson {
    static class MaxFlow {

        static final int V = 6;

        boolean bfs(int rGraph[][], int s, int t, int parent[]) {
            boolean visited[] = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            visited[s] = true;
            parent[s] = -1;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v = 0; v < V; v++) {
                    if (!visited[v] && rGraph[u][v] > 0) {
                        if (v == t) {
                            parent[v] = u;
                            return true;
                        }
                        q.add(v);
                        parent[v] = u;
                        visited[v] = true;
                    }
                }
            }
            return false;
        }

        int fordFulkerson(int graph[][], int s, int t) {
            int u, v;
            int count = 0;
            int rGraph[][] = new int[V][V];
            for (u = 0; u < V; u++)
                for (v = 0; v < V; v++)
                    rGraph[u][v] = graph[u][v];
            int parent[] = new int[V];
            int maxFlow = 0;
            while (bfs(rGraph, s, t, parent)) {
                int pathFlow = Integer.MAX_VALUE;
                int flowNumber = 0;

                for (v = t; v != s; v = parent[v]) {
                    u = parent[v];
                    pathFlow = Math.min(pathFlow, rGraph[u][v]);
                }
                for (v = t; v != s; v = parent[v]) {
                    u = parent[v];
                    rGraph[u][v] -= pathFlow;
                    rGraph[v][u] += pathFlow;
                }
                maxFlow += pathFlow;
                count++;
            }
            System.out.println("Кол-во потоков: " + count);
            return maxFlow;
        }
    }

    static class DoubleDegree {
        void findDoubleDegrees(int n, int[][] adj) {
            int[] degree = new int[n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (adj[i][j] == 1) degree[i]++;
            int[] doubleDegree = new int[n];
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++)
                    if (adj[i][j] == 1)
                        sum += degree[j];
                doubleDegree[i] = sum;
            }
            System.out.println("Double degrees of vertices:");
            for (int i = 0; i < n; i++)
                System.out.println("Vertex " + i + ": " + doubleDegree[i]);
        }
    }

    static class BipartiteCheck {
        boolean isBipartite(int[][] adj, int n) {
            int[] color = new int[n];
            Arrays.fill(color, -1);
            for (int start = 0; start < n; start++) {
                if (color[start] == -1) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(start);
                    color[start] = 0;
                    while (!q.isEmpty()) {
                        int u = q.poll();
                        for (int v = 0; v < n; v++) {
                            if (adj[u][v] == 1 && color[v] == -1) {
                                color[v] = 1 - color[u];
                                q.add(v);
                            } else if (adj[u][v] == 1 && color[v] == color[u]) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        System.out.println("N1");
        int[][] graph = {
                {0, 3, 0, 5, 0, 0},
                {0, 0, 5, 0, 0, 0},
                {0, 0, 0, 0, 6, 5},
                {0, 4, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 7},
                {0, 0, 0, 0, 0, 0}
        };
        MaxFlow m = new MaxFlow();
        System.out.println("The maximum possible flow is: " + m.fordFulkerson(graph, 0, 5));

        System.out.println("\nN2");
        int[][] adjUndirected = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };
        DoubleDegree d = new DoubleDegree();
        d.findDoubleDegrees(4, adjUndirected);

        System.out.println("\nN3");
        int[][] bipGraph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        BipartiteCheck b = new BipartiteCheck();
        System.out.println("Graph is bipartite: " + b.isBipartite(bipGraph, 4));
    }
}
