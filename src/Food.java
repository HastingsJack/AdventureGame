public class Food extends Item {
    private int healthPoints;

    public Food(String name, String shortName, int HP) {
        super(name, shortName);
        this.healthPoints = HP;
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }
}
