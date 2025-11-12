package Java.Lab7.Classes;

import Java.Lab7.enums.AirDirection;

public class WindInstrument extends Instrument{

    private String bodyMaterial;
    private AirDirection airDirection; //(Прямое, поперечное)

    public WindInstrument(String brand, String name, AirDirection airDirection, String bodyMaterial) {
        super(brand, name);
        this.airDirection = airDirection;
        this.bodyMaterial = bodyMaterial;
    }

    @Override
    public void play() {
        System.out.println("Дуем в инструмент " + getName());
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public AirDirection getAirDirection() {
        return airDirection;
    }

    public void setAirDirection(AirDirection airDirection) {
        this.airDirection = airDirection;
    }
}
