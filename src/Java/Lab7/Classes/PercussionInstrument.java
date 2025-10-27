package Java.Lab7.Classes;

import java.util.Scanner;

public class PercussionInstrument extends Instrument {

    private boolean isTuned;
    private String material;

    public PercussionInstrument(String brand, String name, boolean isTuned, String material) {
        super(brand, name);
        this.isTuned = isTuned;
        this.material = material;
    }

    public void edit(Scanner scanner) {
        System.out.println("Отредактируем ударный инструмент");

        System.out.println("Введите новую настрой инструмента");
        this.isTuned = parseYesNo(scanner.next());

        System.out.println("Введите материал ударного инструмента");
        this.material = scanner.next();
    }

    public static PercussionInstrument set(Scanner scanner) {

        System.out.println("Опишите ударный инструмент: ");
        PercussionInstrument inst = new PercussionInstrument(" ", " ", false, " ") ;

        boolean isTune = parseYesNo(scanner.next());

        System.out.println("Введите материал инструмента");
        inst.material = scanner.next();

        return inst;
    }

    private static boolean parseYesNo(String input){

        System.out.println("Введите настроен ли инструмент Да[y], Нет[n]");

        if (input.equals("y")){
            return true;
        }
        else if (input.equals("n")){
            return false;
        }
        else{
            System.out.println("Введено неправильное значение. По умолчанию false");
            return false;
        }
    }

    @Override
    public void play() {
        System.out.println("Бьем в инструмент");
    }

    public boolean isTuned() {
        return isTuned;
    }

    public void setTuned(boolean tuned) {
        isTuned = tuned;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
