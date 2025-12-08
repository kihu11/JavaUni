package Java.Lab11;

public class Event implements Comparable<Event> {
    final double time;
    final EventType type;
    final CpuProcess process;

    public Event(double time, EventType type, CpuProcess process) {
        this.time = time;
        this.type = type;
        this.process = process;
    }

    public int compareTo(Event o) {
        if (time < o.time) return -1;
        if (time > o.time) return 1;
        return type.ordinal() - o.type.ordinal();
    }
}
