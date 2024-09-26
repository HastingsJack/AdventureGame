import java.util.Scanner;

public class Adventure {
    private boolean teleport;
    private Rooms lastRoom;
    private BuildMap map;
    private Player player;

    public Adventure() {
        this.map = new BuildMap();
        this.player = new Player();
        map.buildRooms();
    }

    public Rooms setRoom(Rooms room) {
        map.room = room;
        return map.room;
    }

    public void teleport() {
        if (!teleportUsed()) {
            System.out.println("teleport used");
            map.room = map.room1;
        } else {
            System.out.println("why is this not working?!!?!?!");
            map.room = setRoom(lastRoom);

        }
        this.teleport = true;
    }

    public Boolean teleportUsed() {
        return teleport;
    }

    public void moveToRoom(String move) {
        if (move.equals("east") && map.room.getEast() != null) {
            map.room = map.room.getEast();
            System.out.println("You walk East..");
        } else if (move.equals("west") && map.room.getWest() != null) {
            map.room = map.room.getWest();
            System.out.println("You walk West..");
        } else if (move.equals("south") && map.room.getSouth() != null) {
            map.room = map.room.getSouth();
            System.out.println("You walk South..");
        } else if (move.equals("north") && map.room.getNorth() != null) {
            map.room = map.room.getNorth();
            System.out.println("You walk North..");
        } else {
            System.out.println("You cannot go that way.");
        }
        directionsChecked();
        checkVisited();
    }

    public void directionsChecked() {
        if (map.room.triedSouth() && map.room.triedEast() && map.room.triedNorth() && map.room.triedWest()) {
            if (map.room.getSouth() != null) {
                System.out.println("A door is open to the South..");
            }
            if (map.room.getEast() != null) {
                System.out.println("A door is open to the East..");
            }
            if (map.room.getWest() != null) {
                System.out.println("A door is open to the West..");
            }
            if (map.room.getNorth() != null) {
                System.out.println("A door is open to the North..");
            }
        }
    }

    public void checkVisited() {
        if (!(map.room.getRoomVisited())) {
            System.out.println(map.room.getRoomDescription());
        }
        map.room.setRoomVisited(true);
    }


    public void startGame() {
        System.out.println("Welcome to Jack's Haunted Halloween Adventure");
        getHelp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(map.room.getRoomName());
            if (this.map.room.dark) {
                map.room.setDark();
                if(map.room.dark) {
                    darkDirection();
                    continue;
                }
                continue;
            }
            System.out.print("Enter a command:");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            if (input.equals("help")) {
                getHelp();
                continue;
            }
            if (input.equalsIgnoreCase("south") ||
                    input.equalsIgnoreCase("s") ||
                    input.equalsIgnoreCase("go s") ||
                    input.equalsIgnoreCase("go south")) {
                if (map.room == map.room4) {
                    map.room.unlock();
                }
                map.room.setSouthWay(true);
                moveToRoom("south");
                continue;
            }
            if (input.equalsIgnoreCase("north") ||
                    input.equalsIgnoreCase("n") ||
                    input.equalsIgnoreCase("go n") ||
                    input.equalsIgnoreCase("go north")) {
                map.room.setNorthWay(true);
                moveToRoom("north");
                continue;
            }
            if (input.equalsIgnoreCase("east") ||
                    input.equalsIgnoreCase("e") ||
                    input.equalsIgnoreCase("go e") ||
                    input.equalsIgnoreCase("go east")) {
                if (map.room == map.room2) {
                    this.map.room.unlock();
                }
                map.room.setEastWay(true);
                moveToRoom("east");
                continue;
            }
            if (input.equalsIgnoreCase("west") ||
                    input.equalsIgnoreCase("w") ||
                    input.equalsIgnoreCase("go w") ||
                    input.equalsIgnoreCase("go west")) {
                map.room.setWestWay(true);
                moveToRoom("west");
                continue;
            }
            if (input.equalsIgnoreCase("look")) {
                System.out.println(map.room.getRoomDescription());
                continue;
            }
            if (input.equalsIgnoreCase("xyzzy")) {
                teleport();
            }
        }
    }

   public void darkDirection() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
            if(input.equals("west")) {
                map.room = map.room.getWest();
                map.room.getRoomName();
            }
            if(input.equals("east")) {
                map.room = map.room.getEast();
                map.room.getRoomName();
            }
            if(input.equals("north")) {
                map.room = map.room.getNorth();
                map.room.getRoomName();
            }
        }



    //more instructions will be added...
    public void getHelp() {
        System.out.println("Navigate around the map by using compass directions");
        System.out.println("North, South, East, or West");
        System.out.println("If you'd like to leave the game - type exit to exit");
        System.out.println("If you'd like to look around the room for clues - type look");
        System.out.println("Type help for command menu");
    }
}
