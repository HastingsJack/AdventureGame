import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
    private String roomName;
    private String roomDescription;
    private boolean visited;
    private Rooms north, south, west, east;
    private boolean westWay = false;
    private boolean eastWay = false;
    private boolean northWay = false;
    private boolean southWay = false;
    private boolean lock = false;
    private boolean dark = false;
    ArrayList<Item> items;
    ArrayList<Enemy> enemies;


    public Rooms(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.visited = false;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public String getItem() {
        if(items.isEmpty()) {
            return "The room is empty..";
        }
        String item = "Item:" + items.get(0).getItemDescription() + "   ";
        for(int i = 1; i < items.size(); i++) {
            item += "Item:" + items.get(i).getItemDescription() + "   ";
            if(items.size() > 3) {
                if(i % 2 == 0) {
                    item+="\n";
                }
            }
        }
        return item;
    }

    public void removeItem (Item item){
        items.remove(item);
    }

    public void addItem(Item Item) {
        this.items.add(Item);
    }

    public Boolean getRoomVisited() {
        return visited;
    }

    public void setRoomVisited(boolean visited) {
        this.visited = true;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setNorth(Rooms north) {
        this.north = north;
    }

    public void setSouth(Rooms south) {
        this.south = south;
    }

    public void setWest(Rooms west) {
        this.west = west;
    }

    public void setEast(Rooms east) {
        this.east = east;
    }

    public String getName() {
        return roomName;
    }

    public Rooms getNorth() {
        return this.north;
    }

    public Rooms getSouth() {
        return this.south;
    }

    public Rooms getWest() {
        return this.west;
    }

    public Rooms getEast() {
        return this.east;
    }

    public void setEastWay(boolean eastWay) {
        this.eastWay = true;
    }

    public void setNorthWay(boolean northWay) {
        this.northWay = true;
    }

    public void setSouthWay(boolean southWay) {
        this.southWay = true;
    }

    public void setWestWay(boolean westWay) {
        this.westWay = true;
    }

    public boolean triedEast() {
        return eastWay;
    }

    public boolean triedWest() {
        return westWay;
    }

    public boolean triedNorth() {
        return northWay;
    }

    public boolean triedSouth() {
        return southWay;
    }

    public boolean unlock() {
        if (!lock) {
            System.out.println("The door is locked.");
            while (!lock) {
                Scanner input = new Scanner(System.in);
                String locked = input.nextLine();
                if (locked.equals("unlock")) {
                    lock = true;
                } else {
                    System.out.println("Try again");
                    continue;
                }
            }
        }
        return true;
    }

    public void setDark() {
        Scanner input = new Scanner(System.in);
        if (dark) {
            System.out.println("The lights are off");
            System.out.println("To turn on the lights type ON");
            System.out.println("Or press Enter to keep the lights off");
            String lights = input.nextLine();
            if (lights.equals("ON")) {
                this.dark = false;
            }
            if (lights.isEmpty()) {
                this.dark = true;
            }
        }
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public boolean isDark() {
        return this.dark;
    }

    public String getEnemies() {
        if(this.enemies.isEmpty()) {
            return "";
        }
        String enemies = "ENEMIES: " + this.enemies.get(0).getDescription() + "  HP: " + this.enemies.get(0).getHealth();
        for(int i = 1; i < this.enemies.size(); i++) {
            enemies += "\n\t\t " + this.enemies.get(i).getDescription() + "  HP: " + this.enemies.get(i).getHealth();
        }
        return enemies;
    }

}



