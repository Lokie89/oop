package m02racingcar.racing;

public enum CarBrand {
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

    CarBrand(int speed) {
        this.speed = speed;
    }

    private int speed;

    public int getSpeed() {
        return speed;
    }
}
