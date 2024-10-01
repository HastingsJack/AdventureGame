import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
    private String roomName;
    private String roomDescription;
    private boolean visited;
    private Rooms north;
    private Rooms south;
    private Rooms west;
    private Rooms east;
    boolean westWay = false;
    boolean eastWay = false;
    boolean northWay = false;
    boolean southWay = false;
    boolean lock = false;
    boolean dark = false;
    ArrayList<Item> items;


    public Rooms(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.visited = false;
        this.items = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public ArrayList<Item> getItem() {
        return items;
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

    public void isDark(boolean dark) {
        this.dark = dark;
    }

//    public boolean containsItem(String item) {
//        for(Item it : items) {
//            if(it.getName().toLowerCase().equals(item)) {
//                .takeItem(it);
//                removeItem(it);
//                return true;
//            }
//        }
//        return false;
//    }
//

        public void removeItem (Item item){
            items.remove(item);
        }
    }



