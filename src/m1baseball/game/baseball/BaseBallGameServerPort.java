package m1baseball.game.baseball;

public enum BaseBallGameServerPort {
    RECEIVE(8081),
    SEND(8082),
    ;
    private int portNumber;

    BaseBallGameServerPort(int portNumber) {
        this.portNumber = portNumber;
    }

    public int getPortNumber() {
        return portNumber;
    }
}
