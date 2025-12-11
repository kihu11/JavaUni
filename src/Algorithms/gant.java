package Algorithms;
import java.util.*;

class Activity {
    String id;
    int duration;
    List<String> preds;
    int ES, EF, LS, LF, slack;

    Activity(String id, int duration, String... preds) {
        this.id = id;
        this.duration = duration;
        this.preds = Arrays.asList(preds);
    }
}

public class gant {

    static void run(Map<String, Activity> a) {
        for (Activity x : a.values()) {
            int m = 0;
            for (String p : x.preds) m = Math.max(m, a.get(p).EF);
            x.ES = m;
            x.EF = x.ES + x.duration;
        }
        int T = a.values().stream().mapToInt(x -> x.EF).max().orElse(0);

        List<Activity> r = new ArrayList<>(a.values());
        Collections.reverse(r);
        for (Activity x : r) {
            List<Activity> s = new ArrayList<>();
            for (Activity y : a.values()) if (y.preds.contains(x.id)) s.add(y);
            x.LF = s.isEmpty() ? T : s.stream().mapToInt(y -> y.LS).min().orElse(T);
            x.LS = x.LF - x.duration;
            x.slack = x.LS - x.ES;
        }

        System.out.println("ID ES EF LS LF Slack Crit");
        for (Activity x : a.values())
            System.out.println(
                    x.id + "  " + x.ES + "  " + x.EF + "  " +
                            x.LS + "  " + x.LF + "  " + x.slack + "    " +
                            (x.slack == 0 ? "YES" : "NO")
            );

        System.out.println("Duration: " + T);
        System.out.print("Critical path: ");
        a.values().stream().filter(x -> x.slack == 0)
                .forEach(x -> System.out.print(x.id + " "));
        System.out.println("\n");
    }

    public static void main(String[] args) {

        System.out.println("N1");
        Map<String, Activity> e1 = new LinkedHashMap<>();
        e1.put("A1", new Activity("A1", 4));
        e1.put("A2", new Activity("A2", 6));
        e1.put("A3", new Activity("A3", 2, "A1"));
        e1.put("A4", new Activity("A4", 6, "A1"));
        e1.put("A5", new Activity("A5", 3, "A2", "A3"));
        e1.put("A6", new Activity("A6", 3, "A2", "A3"));
        e1.put("A7", new Activity("A7", 5, "A4", "A5"));
        run(e1);

        System.out.println("N2");
        Map<String, Activity> e2 = new LinkedHashMap<>();
        e2.put("A", new Activity("A", 1));
        e2.put("B", new Activity("B", 3, "A"));
        e2.put("C", new Activity("C", 2, "A"));
        e2.put("D", new Activity("D", 3, "B"));
        e2.put("E", new Activity("E", 3, "C"));
        e2.put("F", new Activity("F", 4, "D", "E"));
        run(e2);
    }
}
