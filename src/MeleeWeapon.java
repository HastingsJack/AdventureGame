public class MeleeWeapon extends Weapon{
    private boolean equipped;

    public MeleeWeapon(String name, String description, int weight, int damage) {
        super(name, description, weight, damage);
    }

    @Override
    public void useWeapon() {
        System.out.println("You swing your melee weapon");
    }

    @Override
    public boolean isEquipped() {
        return equipped;
    }

    @Override
    public boolean setEquipped(boolean equipped) {
        this.equipped = equipped;
        return equipped;
    }

    @Override
    public boolean canUseWeapon() {
        return true;
    }

    @Override
    public int weaponDamage() {
        return super.damage;
    }

}
