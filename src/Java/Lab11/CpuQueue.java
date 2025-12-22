package Java.Lab11;

import java.util.LinkedList;

public class CpuQueue {
    private final LinkedList<CpuProcess> queue = new LinkedList<>();
    private int maxSize = 0;

    public synchronized void enqueue(CpuProcess p) {
        queue.addLast(p);
        if (queue.size() > maxSize) {
            maxSize = queue.size();
        }
        notifyAll();
    }

    public synchronized CpuProcess dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.pollFirst();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getMaxSize() {
        return maxSize;
    }
}
