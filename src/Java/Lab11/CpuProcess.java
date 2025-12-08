package Java.Lab11;

public class CpuProcess {
    final int id;
    final double arrivalTime;
    final double service1;
    final double service2;

    double start1 = -1, finish1 = -1;
    double start2 = -1, finish2 = -1;

    public CpuProcess(int id, double arrivalTime, double service1, double service2) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.service1 = service1;
        this.service2 = service2;
    }

    public String toString() {
        return "P" + id;
    }
}
