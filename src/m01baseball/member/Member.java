package m01baseball.member;

public class Member {
    protected final String name;

    public Member(String name) {
        this.name = name;
    }

    public boolean isSameName(String compareName) {
        return name.equals(compareName);
    }
}
