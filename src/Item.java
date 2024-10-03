public class Item {
    private String name;
    private String shortName;

    //change name description
    public Item(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public int getHealthPoints() {
        return this.getHealthPoints();
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " " + this.shortName;
    }
}
