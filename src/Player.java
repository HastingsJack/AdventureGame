import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Rooms room;
    private boolean teleportUsed;
    private Rooms lastRoom;
    private ArrayList<Item> inventory;
    private int health;
    private final int maxWeight = 50;
    private String currentWeapon;

    public Player(Rooms room, int health) {
        this.room = room;
        this.inventory = new ArrayList<>();
        this.health = health;
        this.currentWeapon = "---";
    }

    public String getRoomDescription() {
        return room.getRoomDescription();
    }

    public String getRoomName() {
        return room.getRoomName();
    }

    public Rooms getRoom() {
        return room;
    }

    //Adding item from room to inventory
    public void takeItem(Item item) {
        inventory.add(item);
    }

    //Checking to see if I can add an item to my inventory based on weight allowance
    public boolean canAddItem(Item item) {
        int currentWeight = 0;
        for(Item it: inventory) {
            currentWeight += it.getWeight();
        }
        if(item.getWeight() + currentWeight <= maxWeight) {
            return true;
        }
        return false;
    }

    //Checking current weight of my inventory
    public int currentWeight() {
        int weight = 0;
        for(Item it: inventory) {
            weight += it.getWeight();
        }
        return weight;
    }

    //Printing out items in inventory
    public String showInventory() {
        if(inventory.size() == 0) {
            return "Inventory is empty";
        }
        String items = "Weapon Equipped:" + this.currentWeapon + "\t\tInventory Weight:" + currentWeight() + "/" + maxWeight
                        + "\n" + "Item:" + inventory.get(0).getItemDescription() + "  ";
        for(int i = 1; i < inventory.size(); i++) {
            items += "Item:" + inventory.get(i).getItemDescription() + "   ";
            if(i % 2 == 0) {
                items += "\n";
            }
        }
        return items;
    }

    //teleporting around the map
    public void teleport() {
        Rooms temp2;
        if (!teleportUsed) {
            BuildMap map = new BuildMap();
            System.out.println("teleport used");
            lastRoom = room;
            room = map.getCurentRoom();
        } else {
            temp2 = room;
            room = lastRoom;
            lastRoom = temp2;
        }
        this.teleportUsed = true;
    }


    //unlocking a room
    public boolean unlockRoom() {
        return room.unlock();
    }

    //Setting rooms to true if I have tried that direction before
    public void setWayTried(String way) {
        if(way.equals("North")) {
            room.setNorthWay(true);
        }
        if(way.equals("South")) {
            room.setSouthWay(true);
        }
        if(way.equals("East")) {
            room.setEastWay(true);
        }
        if(way.equals("West")) {
            room.setWestWay(true);
        }
    }

    //Room movement
    public Rooms moveToRoom(String move) {
        if (move.equals("east") && room.getEast() != null) {
            room = room.getEast();
            return room;
        } else if (move.equals("west") && room.getWest() != null) {
            room = room.getWest();
            return room;
        } else if (move.equals("south") && room.getSouth() != null) {
            room = room.getSouth();
            return room;
        } else if (move.equals("north") && room.getNorth() != null) {
            room = room.getNorth();
            return room;
        }
        checkVisited();
        return null;
    }

    //Setting rooms that I have been to true
    public void checkVisited() {
        if (!(room.getRoomVisited())) {
            room.setRoomVisited(true);
        }
    }

    //Checking to see what directions have been tried for a given room
    public String directionsChecked() {
        String direction = "";
        if (room.triedSouth() && room.triedWest() && room.triedEast() && room.triedNorth()) {
            if (room.getSouth() != null) {
                direction += "A door is open to the South..\n";
            }
            if (room.getEast() != null) {
                direction += "A door is open to the East..\n";
            }
            if (room.getWest() != null) {
                direction += "A door is open to the West..\n";
            }
            if (room.getNorth() != null) {
                direction += "A door is open to the North..";
            }
        }
        return direction;
    }

    //darkDirection assignment -- only allowed where you came from
    public void darkDirection() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("west")) {
            room = room.getWest();
            room.getRoomName();
        }
        if(input.equals("east")) {
            room = room.getEast();
            room.getRoomName();
        }
        if(input.equals("north")) {
            room = room.getNorth();
            room.getRoomName();
        }
    }

    //dropping an item from my inventory
    public boolean dropItem(String item) {
        for(Item it : inventory) {
            if(it.getName().toLowerCase().equals(item)) {
                inventory.remove(it);
                if(it.getName().equals(currentWeapon)) {
                    currentWeapon = "---";
                }
                getRoom().addItem(it);
                return true;
            }
        }
        return false;
    }

    //Checking to see if the item is in the room
    public boolean containsItem(String item) {
        for(Item it : getRoom().items) {
            if(it.getName().toLowerCase().equals(item)) {
                return true;
            }
        }
        return false;
    }

    //Adding an item to my inventory arraylist and removing it from the room
    public boolean addToInventory(String item) {
        for(Item it : getRoom().items) {
            if(it.getName().toLowerCase().equals(item) && canAddItem(it)) {
                takeItem(it);
                getRoom().removeItem(it);
                return true;
            }
        }
        return false;
    }

    //checking to see if the item is edible
    public boolean eatItem(String item) {
        for(Item it : getRoom().items) {
            if(it.getName().toLowerCase().equals(item)) {
                if(it instanceof Food) {
                    this.changeHealth((((Food)it).getHealthPoints()));
                    getRoom().removeItem(it);
                    return true;
                }
            }
        }
        return false;
    }

    //checking to see if item can be drunk
    public boolean drinkItem(String item) {
        for(Item it : getRoom().items) {
            if(it.getName().toLowerCase().equals(item)) {
                if(it instanceof Drink) {
                    this.changeHealth((((Drink)it).getHealthPoints()));
                    getRoom().removeItem(it);
                    return true;
                }
            }
        }
        return false;
    }

    //changing the player health
    public void changeHealth(int healthIncrease) {
        if(this.health + healthIncrease > 100) {
            this.health = 100;
        } else {
            this.health += healthIncrease;
        }
    }

    //returning player health
    public int getHealth() {
        return this.health;
    }

    //returning the items in a room
    public String getItems() {
        return room.getItem();
    }

    //Checking to see if an item is in my inventory
    public boolean checkInventory(String item) {
        for(Item it : inventory) {
            if(it.getName().toLowerCase().equals(item)) {
                return true;
            }
        }
        return false;
    }

    //returning String value of current weapon equipped
    public String getCurrentWeapon() {
        return this.currentWeapon;
    }

    //Checking to see if weapon is equipped and if there is ammo
    public void useWeapon() {
       for(Item it : inventory) {
           if(((Weapon)it).isEquipped() && ((Weapon)it).canUseWeapon()) {
               it.useAmmo();
               ((Weapon)it).useWeapon();
           }
       }
    }

    //Checking to see if item is a weapon that can be equipped
    public boolean hasWeapontoEquip(String item) {
        for(Item it : inventory) {
            if(it.getName().toLowerCase().equals(item)) {
                if(it instanceof Weapon) {
                    unequipWeapon();
                    ((Weapon)it).setEquipped(true);
                    equipWeapon(item);
                    currentWeapon = it.getName();
                    return true;
                }
            }
        }
        return false;
    }

    //unequipping equipped item
    public void unequipWeapon() {
        for(Item it : inventory) {
            ((Weapon)it).setEquipped(false);
        }
    }

    //equiping the chosen item
    public void equipWeapon(String item) {
        for(Item it : inventory) {
            if(it.getName().toLowerCase().equals(currentWeapon)) {
                ((Weapon)it).setEquipped(true);
            }
        }
        getRoom().items.remove(item);
    }
}
