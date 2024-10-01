
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startGame() {
        System.out.println("\t\uD83D\uDC7B Welcome to Jack's Haunted Halloween Adventure \uD83D\uDC7B");
        getHelp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //System.out.println(adventure.getRoom().getRoomName());
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
                case "look":
                    System.out.println(adventure.getPlayer().getRoom().getRoomDescription());
                    System.out.println(adventure.getPlayer().directionsChecked());
                    if(adventure.getItem().isEmpty()) {
                        System.out.println("The room is empty..");
                    } else {
                        System.out.println(adventure.getItem());
                    }break;
                case "xyzzy": adventure.teleport(); break;
                case "inventory":
                    System.out.println(adventure.getPlayer().showInventory()); break;
                case "take":
                    System.out.println("Type the name of the item you'd like to pick up");
                    input = scanner.nextLine().toLowerCase();
                    if(adventure.getPlayer().containsItem(input)){
                        System.out.println("You picked the " + input + " up!");
                    } else {
                        System.out.println("That item does not exist in this room.");
                    }
                    break;
                case "drop":
                    System.out.println("Which item would you like to drop?");
                    System.out.println(adventure.getPlayer().showInventory());
                    input = scanner.nextLine().toLowerCase();
                    if(adventure.getPlayer().dropItem(input)){
                        System.out.println("You dropped your " + input + " in " + adventure.getRoom().getRoomName()+"!");
                    } else {
                        System.out.println("You are not carrying that item.");
                    }
                    break;
//                case "room":
//                    System.out.println(adventure.getPlayer().getRoom().getRoomDescription());
//                    System.out.println(adventure.getItem()); break;
                default: System.out.println("Sorry, that is not an accepted command"); break;
            }
        }
    }

    public void getHelp() {
        System.out.println("\uD83C\uDF83 Navigate around the map by using compass directions -- North, South, East or West");
        System.out.println("\uD83C\uDF83 Exit - to Exit");
        System.out.println("\uD83C\uDF83 Xyzzy - to teleport");
        System.out.println("\uD83C\uDF83 Look - to look around the room");
        System.out.println("\uD83C\uDF83 Help - for help menu");
        System.out.println("\uD83C\uDF83 Take - to take an item");
        System.out.println("\uD83C\uDF83 Drop - to drop an item from your inventory");
        System.out.println("\uD83C\uDF83 Inventory - to check your inventory");
    }
}
