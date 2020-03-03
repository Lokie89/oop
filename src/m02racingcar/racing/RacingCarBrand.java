package m02racingcar.racing;

public enum RacingCarBrand {
    FERRARI(10),
    PORSCHE(9),
    LAMBORGHINI(8),
    MASERATI(7),
    ASTON_MARTIN(6),
    BUGATTI(5),
    MCLAREN(4),
    KOENIGSEGG(3),
    PAGANI(2),
    NOBLE(1),
    ;

    RacingCarBrand(int speed) {
        this.speed = speed;
    }

    private int speed;

    public int getSpeed() {
        return speed;
    }
}
