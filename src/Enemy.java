public class Enemy {
    private String name;
    private int health;
    private Weapon item;
    private String description;

    public Enemy(String name, String description, int health, Weapon item) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.item = item;
    }

    public String getEnemyName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public Weapon getWeapon() {
        return this.item;
    }

    public String getDescription() {
        return this.description;
    }

    public String takeDamage(int damage){
        if(this.health - damage <= 0) {
            this.health = 0;
            return this.description + " has been slain!";
        }
        this.health -= damage;
        return this.name + " took " + damage + " damage!";
    }
}
