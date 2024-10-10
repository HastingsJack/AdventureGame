import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startGame() {
        System.out.println("☠\uFE0F Welcome to Jack's Haunted Halloween Adventure ☠\uFE0F");
        getHelp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (adventure.getPlayer().getRoom().isDark()) {
                adventure.getPlayer().getRoom().setDark();
                if(adventure.getPlayer().getRoom().isDark()) {
                    adventure.darkDirection();
                    continue;
                }
                continue;
            }
            System.out.print("Enter a command:");
            String input = scanner.nextLine().toLowerCase();
            if(input.equals("exit")) {System.out.println("Thanks for playing!");break;}
            switch(input) {
                case "help": getHelp(); continue;
                case "south", "s", "go s", "go south":
                    adventure.setWay("South");
                    if (adventure.getRoomName().equals("Room 4")) {
                        adventure.unlockRoom();
                    }
                    System.out.println(adventure.moveToRoom("south"));
                    break;
                case "north", "n", "go north", "go n":
                    adventure.setWay("North");
                    System.out.println(adventure.moveToRoom("north"));
                    break;
                case "west", "w", "go west", "go w":
                    adventure.setWay("West");
                    System.out.println(adventure.moveToRoom("west"));
                    break;
                case "east", "e", "go east", "go e":
                    adventure.setWay("East");
                    if (adventure.getRoomName().equals("Room 2")) {
                        adventure.unlockRoom();
                    }
                    System.out.println(adventure.moveToRoom("east"));
                    break;
                case "look":
                    System.out.println(adventure.getRoomDescription());
                    if(adventure.getEnemies().isEmpty()) {
                        System.out.println("There are no enemies in this room..");
                    } else {
                        System.out.println(adventure.getEnemies());
                    }
                    if(!(adventure.getDirectionsChecked().isEmpty())) {
                        System.out.println(adventure.getDirectionsChecked());
                    }
                    System.out.println(adventure.getItem());
                    break;
                case "xyzzy": adventure.teleport(); break;
                case "inventory":
                    System.out.println(adventure.getPlayerInventory()); break;
                case "take":
                    System.out.println("Which item you'd like to pick up");
                    input = scanner.nextLine().toLowerCase();
                    if(adventure.getPlayer().addToInventory(input)){
                        System.out.println("You picked the " + input + " up!");
                    } else if(!adventure.getPlayer().containsItem(input)) {
                        System.out.println("That item is not in this room.");
                    } else {
                        System.out.println("Your inventory is full! Drop an item first");
                    }
                    break;
                case "drop":
                    if(adventure.getPlayerInventory().isEmpty()) {
                        System.out.println("Your inventory is empty.");
                        break;
                    }
                    System.out.println("Which item would you like to drop?");
                    System.out.println(adventure.getPlayerInventory());
                    input = scanner.nextLine().toLowerCase();
                    if(adventure.dropPlayerItem(input)){
                        System.out.println("You dropped your " + input + " in " + adventure.getRoomName()+"!");
                    } else {
                        System.out.println("You are not carrying that item.");
                    }
                    break;
                case "health":
                    System.out.println("HP: " + adventure.getPlayerHealth());
                    break;
                case "eat":
                    System.out.println("What item would you like to eat?");
                    System.out.println(adventure.getItem());
                    input = scanner.nextLine().toLowerCase();
                    int currentHealth = adventure.getPlayerHealth();
                    if(adventure.eatItem(input)) {
                        System.out.println("You ate the " + input + "!");
                        if(currentHealth > adventure.getPlayerHealth()) {
                            System.out.println("It was poisonous! You lost health!");
                        } else {
                            System.out.println("Delicious! You gained health!");
                        }
                    } else if(!adventure.getPlayer().containsItem(input)){
                        System.out.println("That item is not in this room.");
                    }else if(!adventure.eatItem(input)) {
                        System.out.println("That item is not edible.");
                    }
                    break;
                case "drink":
                    System.out.println("Which item would you like to drink?");
                    System.out.println(adventure.getItem());
                    input = scanner.nextLine().toLowerCase();
                    currentHealth = adventure.getPlayerHealth();
                    if(adventure.drinkItem(input)) {
                        System.out.println("You drank the " + input);
                        if(currentHealth > adventure.getPlayerHealth()) {
                            System.out.println("It was poisonous! You lost health!");
                        } else {
                            System.out.println("Delicious! You gained health!");
                        }
                    } else if(!adventure.getPlayer().containsItem(input)){
                        System.out.println("That item is not in this room.");
                    }else if(!adventure.drinkItem(input)) {
                        System.out.println("That item is not potable.");
                    }
                    break;
                case "equip":
                    System.out.println("What item would you like to equip?");
                    System.out.println(adventure.getPlayerInventory());
                    input = scanner.nextLine().toLowerCase();
                    if(adventure.hasWeaponToEquip(input)) {
                        System.out.println("Item equipped!");
                    } else if (!adventure.checkInventory(input)) {
                        System.out.println("That item is not in your inventory.");
                    }
                    else if(!adventure.hasWeaponToEquip(input)) {
                        System.out.println("That item is not equipable.");
                    }
                    break;
                case "attack":
                    if(!(adventure.getEnemies().isEmpty())) {
                        System.out.println("Who would you like to attack?");
                        System.out.println(adventure.getEnemies());
                        input = scanner.nextLine().toLowerCase();
                        if(adventure.getPlayer().getCurrentWeapon().equals("---")) {
                            System.out.println("You have nothing equipped!");
                            break;
                        } else {
                            System.out.println(adventure.useWeapon(input));
                        }
                        break;
                    } else {
                        System.out.println("The are no enemies in this room!");
                        break;
                    }
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
        System.out.println("\uD83C\uDF83 Health - to check your health");
        System.out.println("\uD83C\uDF83 Equip - to equip a weapon from your inventory");
        System.out.println("\uD83C\uDF83 Attack - to attack");
    }
}
