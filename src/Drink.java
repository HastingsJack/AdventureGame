public class Drink extends Item {
    private int healthPoints;
    public Drink (String name, String description, int weight, int healthPoints) {
        super(name, description, weight);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }
}
