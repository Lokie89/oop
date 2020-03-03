package m01baseball.game.baseball;

public enum BaseBallGameServerPort {
    RECEIVE(5002),
    SEND(5003),
    ;
    private int portNumber;

    BaseBallGameServerPort(int portNumber) {
        this.portNumber = portNumber;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public int getPortNumberByListSize(int listSize) {
        return portNumber + (listSize * 2);
    }
}
