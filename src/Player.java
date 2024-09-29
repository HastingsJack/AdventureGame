import java.util.Scanner;

public class Player {
    private Rooms room;
    private boolean teleportUsed;
    private Rooms lastRoom;

    public Player(Rooms room) {
        this.room = room;
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
}
