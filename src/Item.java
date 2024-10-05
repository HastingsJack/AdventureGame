public class Item {
    private String name;
    private String description;
    private int weight;

    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public String getItemDescription() {
        return this.description;
    }

    public String toString() {
        return this.name + " " + this.description;
    }

}
