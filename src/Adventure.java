public class Adventure {
    private BuildMap map;
    private Player player;

    public Adventure() {
        this.map = new BuildMap();
        this.player = new Player(map.getCurentRoom());
    }

    public void teleport() {
        player.teleport();
    }

    public Rooms getRoom() {
        return player.getRoom();
    }

    public Player getPlayer() {
        return player;
    }

    public String moveToRoom(String move) {
        if(player.moveToRoom(move) != null) {
            return "You are now in " + player.getRoom().getName();
        }
        return "You cannot go that way";
    }

    public Rooms darkDirection() {
        return darkDirection();
    }
}
