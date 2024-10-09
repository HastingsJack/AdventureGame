public abstract class Weapon extends Item{
    private int damage;


    public Weapon(String name, String description, int weight, int damage) {
        super(name,description, weight);
        this.damage = damage;
    }

    abstract void useWeapon();
    abstract boolean setEquipped(boolean equipped);
    abstract boolean isEquipped();
    abstract boolean canUseWeapon();
}
