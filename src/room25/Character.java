package room25;

public abstract class Character {

    private String name;

    protected String getName() {
        return this.name;
    }

    Character(String name) {
        this.name = name;
    }

}
