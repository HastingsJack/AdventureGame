public class RangedWeapon extends Weapon {
    private boolean equipped;
    private int ammo;

    public RangedWeapon(String name, String description, int weight, int damage, int ammo) {
        super(name, description, weight, damage);
        this.ammo = ammo;
    }

    @Override
    public void useWeapon() {
        if(this.ammo - 1 >= 0) {
            this.ammo -= 1;
            System.out.println("You shoot your ranged weapon.");
        } else {
            System.out.println("You are out of ammo!");
        }
    }

    @Override
    public boolean setEquipped(boolean equipped) {
        this.equipped = equipped;
        return equipped;
    }

    @Override
    public boolean isEquipped() {
        return equipped;
    }

    @Override
    public boolean canUseWeapon() {
        if(this.ammo - 1 > -1) {
            return true;
        }
        return false;
    }
}
