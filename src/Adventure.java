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

    public String getDirectionsChecked() {
        return player.directionsChecked();
    }

    public String getPlayerInventory() {
        return player.showInventory();
    }

    public void teleport() {
        player.teleport();
    }

    public Rooms getRoom() {
        return player.getRoom();
    }

    public boolean unlockRoom() {
        return player.unlockRoom();
    }

    public void setWay(String way) {
        player.setWayTried(way);
    }

    //drop test
    public boolean dropPlayerItem(String item) {
        return player.dropItem(item);
    }

    public String getItem() {
        String items = "";
        int i = 1;
        for(Item it : getRoom().getItem()) {
            items += "Item:" + it.getName() + "\n";
            i++;
        }
        return items;
    }

    public Player getPlayer() {
        return player;
    }

    public String moveToRoom(String move) {
        if(player.moveToRoom(move) != null) {
            return "You are now in " + player.getRoom().getRoomDescription();
        }
        return "You cannot go that way";
    }

    public int getPlayerHealth() {
        return player.getHealth();
    }

    public void eatItem(String item) {
        player.eatItem(item);
    }

    //dark opgave
//    public Rooms darkDirection() {
//        return darkDirection();
//    }
}
