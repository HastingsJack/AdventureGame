import java.util.Random;

public class BuildMap {
    private Rooms room, room1, room2, room3, room4, room5, room6, room7, room8, room9;

    public BuildMap() {
        buildRooms();
        buildItems();
        buildFoodAndDrink();
        buildWeapons();
        buildEnemies();
    }

    public void buildRooms() {
       room1 = new Rooms("Room 1","The Foyer/Starting Room");
       room2 = new Rooms("Room 2","The Living Room");
       room3 = new Rooms("Room 3","The TV Room");
       room4 = new Rooms("Room 4","The Bathroom");
       room5 = new Rooms("Room 5","The Basement");
       room6 = new Rooms("Room 6","The Bedroom");
       room7 = new Rooms("Room 7","The Laundry Room");
       room8 = new Rooms("Room 8","The Kitchen");
       room9 = new Rooms("Room 9","The Sunroom");

        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room9.setNorth(room6);
        room9.setWest(room8);
        room = room1;
        room2.setDark(true);
//        room6.isDark(true);
//        room9.isDark(true);
    }

    public void buildItems() {
        room1.items.add(new Item("Lamp", "Lamp", 5));
        room1.items.add(new Item("Bat", "Bat", 5));
        room3.items.add(new Item("Sword", "Sword", 5));
        room7.items.add(new Item("Axe", "Axe", 5));
        room5.items.add(new Item("Pistol", "Pistol", 5));

    }

    public void buildFoodAndDrink() {
        room1.items.add(new Food("Apple", "Green Apple", 2,new Random().nextInt(-30,-10)));
        room1.items.add(new Food("Banana", "Purple Banana", 2, new Random().nextInt(20,40)));
        room1.items.add(new Drink("Juice", "Mango Juice", 2, new Random().nextInt(20,40)));
        room1.items.add(new Drink("Beer", "Budweiser Beer",2, new Random().nextInt(-20,-10)));
    }

    public void buildWeapons() {
        room1.items.add(new RangedWeapon("Bow", "Bow", 7,15, 5));
        room1.items.add(new MeleeWeapon("Axe", "Axe", 7,5));
    }

    public void buildEnemies() {
        room1.enemies.add(new Enemy("Jason","Jason Voorhees", 15, new MeleeWeapon("Knife", "Jason's Knife", 7, 5)));

    }

    public Rooms getCurentRoom() {
        return this.room;
    }





}