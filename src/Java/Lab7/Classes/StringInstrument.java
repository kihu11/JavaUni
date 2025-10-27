package Java.Lab7.Classes;

import Java.Lab7.Enums.PlayStyle;

public class StringInstrument extends Instrument {

    private int numberOfStrings;
    private PlayStyle playStyle;

    public StringInstrument(String brand, String name, int numberOfStrings, PlayStyle playStyle) {
        super(brand, name);
        this.numberOfStrings = numberOfStrings;
        this.playStyle = playStyle;
    }

    @Override
    public void play() {
        System.out.println("Играем " + getName() + " с помощью " + playStyle);
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public PlayStyle getPlayStyle() {
        return playStyle;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }
}
