package Java.Lab11;

public class Cpu {
    final String name;
    boolean busy = false;
    CpuProcess currentProcess = null;

    public Cpu(String name) {
        this.name = name;
    }
}
