public class Item {
    private String name;
    private String description;
    private int weight;
    private int amount;

    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public Item(String name, String description, int weight, int amount) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.amount = amount;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getItemDescription() {
        return this.description;
    }

    public String toString() {
        return this.name + " " + this.description;
    }

    //weapon test
    public void useAmmo() {
        this.amount -= 1;
    }

}
