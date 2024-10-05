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

    public String moveToRoom(String move) {
        if(player.moveToRoom(move) != null) {
            return "You are now in " + player.getRoom().getRoomDescription();
        }
        return "You cannot go that way";
    }

    public String getDirectionsChecked() {
        return player.directionsChecked();
    }

    public void setWay(String way) {
        player.setWayTried(way);
    }

    public void teleport() {
        player.teleport();
    }

    public boolean unlockRoom() {
        return player.unlockRoom();
    }

    public String getPlayerInventory() {
        return player.showInventory();
    }

    //drop test
    public boolean dropPlayerItem(String item) {
        return player.dropItem(item);
    }

    public String getItem() {
        return getPlayer().getItems();
    }

    public Player getPlayer() {
        return player;
    }


    public int getPlayerHealth() {
        return player.getHealth();
    }

    public boolean eatItem(String item) {
        if(player.eatItem(item)) {
            return true;
        }
        return false;
    }

    public boolean drinkItem(String item) {
        if(player.drinkItem(item)) {
            return true;
        }
        return false;
    }

    //dark opgave
//    public Rooms darkDirection() {
//        return darkDirection();
//    }
}
