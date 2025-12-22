package Java.Lab11;

import java.util.Iterator;
import java.util.LinkedList;

public class CpuQueue {
    private final LinkedList<CpuProcess> q = new LinkedList<>();

    public void enqueue(CpuProcess p) {
        q.addLast(p);
    }

    public CpuProcess dequeue() {
        return q.pollFirst();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public String toString() {
        if (q.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Iterator<CpuProcess> it = q.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
