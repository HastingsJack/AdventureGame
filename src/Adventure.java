public class Adventure {
    private BuildMap map;
    private Player player;

    public Adventure() {
        this.map = new BuildMap();
        this.player = new Player(map.getCurentRoom(), 100);
    }

    public String getRoomName() {
        return player.getRoomName();
    }

    public String getRoomDescription() {
        return player.getRoomDescription();
    }

    //Part 1
    //Movement
    public String moveToRoom(String move) {
        if(player.moveToRoom(move) != null) {
            return "You are now in " + player.getRoom().getRoomDescription() + "\n" + player.getEnemies();
        }
        return "You cannot go that way";
    }

    //Checking to see what directions we've tried in a room
    public String getDirectionsChecked() {
        return player.directionsChecked();
    }

    //Setting a direction to true
    public void setWay(String way) {
        player.setWayTried(way);
    }

    //Teleportation extra assignment
    public void teleport() {
        player.teleport();
    }

    //Dark room assignment
    public void darkDirection() {
        player.darkDirection();
    }

    //Locked doors assignment
    public boolean unlockRoom() {
        return player.unlockRoom();
    }

    //Printing player inventory
    public String getPlayerInventory() {
        return player.showInventory();
    }

    //Dropping an item
    public boolean dropPlayerItem(String item) {
        return player.dropItem(item);
    }

    //Retrieving an item
    public String getItem() {
        return player.getItems();
    }

    //Player's current location
    public Player getPlayer() {
        return player;
    }

    //Player's current health
    public int getPlayerHealth() {
        return player.getHealth();
    }

    //Checking to see if item can be eaten
    public boolean eatItem(String item) {
        if(player.eatItem(item)) {
            return true;
        }
        return false;
    }

    //Checking to see if item can be drunk
    public boolean drinkItem(String item) {
        if(player.drinkItem(item)) {
            return true;
        }
        return false;
    }

    //Check to see if I have weapon in inventory and equipping it
    public boolean hasWeaponToEquip(String item) {
        if(player.hasWeapontoEquip(item)) {
            return true;
        }
        return false;
    }

    //Checking to see if item is in inventory -- reached error without a separate check
    public boolean checkInventory(String item) {
        if(player.checkInventory(item)) {
            return true;
        }
        return false;
    }

    //Using equipped weapon
    public String useWeapon(String input) {
        return player.useWeapon(input);
    }

    public String getEnemies() {
        return player.getEnemies();
    }
}
