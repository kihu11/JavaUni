package Java.Lab11;

public class CpuProcess {
    final int id;
    final double service;

    public CpuProcess(int id, double service) {
        this.id = id;
        this.service = service;
    }

    @Override
    public String toString() {
        return "P" + id;
    }
}
