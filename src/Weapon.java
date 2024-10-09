public abstract class Weapon extends Item{

    public Weapon(String name, String description, int weight, int damage) {
        super(name,description, weight, damage);
    }

    abstract void useWeapon();
    abstract boolean setEquipped(boolean equipped);
    abstract boolean isEquipped();
    abstract boolean canUseWeapon();
    abstract int weaponDamage();
}
