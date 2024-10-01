import java.util.ArrayList;

public class Item {
    private String name;
    private String shortname;

    public Item(String name, String shortName) {
        this.name = name;
        this.shortname = shortName;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " " + this.shortname;
    }
}
