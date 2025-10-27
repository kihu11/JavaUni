package Algorithms;

import java.util.*;

class HuffmanNode {
    char symbol;
    double freq;
    HuffmanNode left, right;

    HuffmanNode(char s, double f) {
        symbol = s;
        freq = f;
    }

    HuffmanNode(double f, HuffmanNode l, HuffmanNode r) {
        freq = f;
        left = l;
        right = r;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }
}

public class Huffman {
    static HuffmanNode buildTree(Map<Character, Double> f) {

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(Comparator.comparingDouble(n -> n.freq));
        for (var e : f.entrySet()) q.add(new HuffmanNode(e.getKey(), e.getValue()));
        while (q.size() > 1) {
            HuffmanNode left = q.poll();
            HuffmanNode right = q.poll();
            HuffmanNode parent = new HuffmanNode(left.freq + right.freq, left, right);
            q.add(parent);
        }
        return q.poll();
    }

    static void buildCodes(HuffmanNode n, String c, Map<Character, String> m) {

        if (n == null) return;
        if (n.isLeaf()) m.put(n.symbol, c);
        else {
            buildCodes(n.left, c + "0", m);
            buildCodes(n.right, c + "1", m);
        }
    }

    static void printTree(HuffmanNode n, String prefix) {

        if (n == null) return;
        if (n.isLeaf()) System.out.println(prefix + n.symbol + " (" + n.freq + ")");
        else {
            System.out.println(prefix + "* (" + n.freq + ")");
            printTree(n.left, prefix + "  ");
            printTree(n.right, prefix + "  ");
        }
    }

    static String encode(String t, Map<Character, String> m) {

        StringBuilder s = new StringBuilder();
        for (char c : t.toCharArray()) s.append(m.get(c));
        return s.toString();
    }

    static void task1() {

        System.out.println("Задание 1:");
        Map<Character, Double> f = new LinkedHashMap<>();
        f.put('a', 0.31);
        f.put('b', 0.26);
        f.put('c', 0.24);
        f.put('d', 0.18);
        f.put('e', 0.01);
        HuffmanNode r = buildTree(f);
        Map<Character, String> m = new LinkedHashMap<>();
        buildCodes(r, "", m);
        for (var e : m.entrySet()) System.out.println(e.getKey() + ": " + e.getValue());
        printTree(r, "");
    }

    static void task2(Scanner sc) {

        System.out.println("Задание 2:");
        System.out.print("Введите текст: ");
        sc.nextLine();
        String t = sc.nextLine();
        Map<Character, Double> f = new HashMap<>();
        for (char c : t.toCharArray()) f.put(c, f.getOrDefault(c, 0.0) + 1);
        HuffmanNode r = buildTree(f);
        Map<Character, String> m = new HashMap<>();
        buildCodes(r, "", m);
        for (var e : m.entrySet()) System.out.println(e.getKey() + ": " + e.getValue());
        printTree(r, "");
        System.out.println("Код: " + encode(t, m));
    }

    static void task3() {

        System.out.println("Задание 3:");
        String t = "Algorithms and data structures";
        Map<Character, Double> f = new HashMap<>();
        for (char c : t.toCharArray()) f.put(c, f.getOrDefault(c, 0.0) + 1);
        HuffmanNode r = buildTree(f);
        Map<Character, String> m = new HashMap<>();
        buildCodes(r, "", m);
        for (var e : m.entrySet()) System.out.println(e.getKey() + ": " + e.getValue());
        printTree(r, "");
        System.out.println("Код: " + encode(t, m));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        task1();
        task2(sc);
        task3();
        sc.close();
    }
}
