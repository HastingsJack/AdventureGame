import java.util.ArrayList;

public class Player {
    private Rooms room;
    private boolean teleportUsed;
    private Rooms lastRoom;
    private ArrayList<Item> inventory;
    private int health;
    private final int maxWeight = 50;

    public Player(Rooms room, int health) {
        this.room = room;
        this.inventory = new ArrayList<>();
        this.health = health;
    }

    public String getRoomDescription() {
        return room.getRoomDescription();
    }

    public String getRoomName() {
        return room.getRoomName();
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

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

    public String showInventory() {
        if(inventory.size() == 0) {
            return "";
        }
        String items = "\t\t\tWeight: " + currentWeight() + "/" + maxWeight + "\n" + "Item:" + inventory.get(0).getItemDescription() + "  ";
        for(int i = 1; i < inventory.size(); i++) {
            items += "Item:" + inventory.get(i).getItemDescription() + "  ";
            if(i % 2 == 0) {
                items += "\n";
            }
        }
        return items;
    }

    public int currentWeight() {
        int weight = 0;
        for(Item it: inventory) {
            weight += it.getWeight();
        }
        return weight;
    }

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

    public Rooms getRoom() {
        return room;
    }

    public boolean unlockRoom() {
        return room.unlock();
    }

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

    public void checkVisited() {
        if (!(room.getRoomVisited())) {
            room.setRoomVisited(true);
        }
    }

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

//    public void darkDirection() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        if(input.equals("west")) {
//            room = room.getWest();
//            room.getRoomName();
//        }
//        if(input.equals("east")) {
//            room = room.getEast();
//            room.getRoomName();
//        }
//        if(input.equals("north")) {
//            room = room.getNorth();
//            room.getRoomName();
//        }
//    }

    public boolean dropItem(String item) {
        for(Item it : inventory) {
            if(it.getName().toLowerCase().equals(item)) {
                inventory.remove(it);
                getRoom().addItem(it);
                return true;
            }
        }
        return false;
    }

    public boolean containsItem(String item) {
        for(Item it : getRoom().items) {
            if(it.getName().toLowerCase().equals(item)) {
                //getRoom().removeItem(it);
                return true;
            }
        }
        return false;
    }

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

    public void changeHealth(int healthIncrease) {
        if(this.health + healthIncrease > 100) {
            this.health = 100;
        } else {
            this.health += healthIncrease;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public String getItems() {
        return room.getItem();
    }
}
