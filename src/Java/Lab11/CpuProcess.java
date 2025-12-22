package Java.Lab11;

public class CpuProcess {
    final int id;
    final double arrivalTime;
    final double service;

    double start = -1, finish = -1;

    public CpuProcess(int id, double arrivalTime, double service) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.service = service;
    }

    public String toString() {
        return "P" + id;
    }
}
