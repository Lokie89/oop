package m01baseball.game;

public enum GameServerPort {
    MAINRECEIVE(5000),
    MAINSEND(5001),
    ;
    private int portNumber;

    GameServerPort(int portNumber) {
        this.portNumber = portNumber;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public int getPortNumberByListSize(int listSize) {
        return portNumber + (listSize * 2);
    }
}
