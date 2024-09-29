
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startGame() {
        System.out.println("Welcome to Jack's Haunted Halloween Adventure");
        getHelp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(adventure.getRoom().getRoomName());
//            if (this.map.getCurentRoom().dark) {
//                map.getCurentRoom().setDark();
//                if(map.getCurentRoom().dark) {
//                    adventure.darkDirection();
//                    continue;
//                }
//                continue;
//            }
            System.out.print("Enter a command:");
            String input = scanner.nextLine().toLowerCase();
            if(input.equals("exit")) {System.out.println("Thanks for playing!");break;}
            switch(input) {
                case "help": getHelp(); continue;
                case "south", "s", "go s", "go south":
                    adventure.getRoom().setSouthWay(true);
                    if (adventure.getRoom().getRoomName().equals("Room 4")) {
                        adventure.getRoom().unlock();
                    }
                    System.out.println(adventure.moveToRoom("south"));
                    break;
                case "north", "n", "go north", "go n":
                    adventure.getRoom().setNorthWay(true);
                    System.out.println(adventure.moveToRoom("north"));
                    break;
                case "west", "w", "go west", "go w":
                    adventure.getRoom().setWestWay(true);
                    System.out.println(adventure.moveToRoom("west"));
                    break;
                case "east", "e", "go east", "go e":
                    adventure.getRoom().setEastWay(true);
                    if (adventure.getRoom().getRoomName().equals("Room 2")) {
                        adventure.getRoom().unlock();
                    }
                    adventure.getRoom().setEastWay(true);
                    System.out.println(adventure.moveToRoom("east"));
                    break;
                case "look": System.out.println(adventure.getPlayer().directionsChecked());break;
                case "xyzzy": adventure.teleport(); break;
            }
        }
    }

    public void getHelp() {
        System.out.println("[] Navigate around the map by using compass directions");
        System.out.println("[] North, South, East, or West");
        System.out.println("[] If you'd like to leave the game - type exit to exit");
        System.out.println("[] If you'd like to look around the room for clues - type look");
        System.out.println("[] Type help for help");
        System.out.println("");
    }
}
