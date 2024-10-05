public class Food extends Item {
    private int healthPoints;

    public Food(String name, String description, int weight, int HP) {
        super(name, description, weight);
        this.healthPoints = HP;
    }

    public String getName() {
        return super.getName();
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }
}
