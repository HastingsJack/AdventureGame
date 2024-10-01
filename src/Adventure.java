import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public String getItem() {
        String items = "";
        int i = 1;
        for(Item it : getRoom().getItem()) {
            items += "Item:" + it.getName() + "\n";
            i++;
        }
        return items;
    }

//    public ArrayList<Item> getItem() {
//        for(Item it : getRoom().getItem()) {
//
//        }
//        return player.getRoom().getItem();
//    }

    public Player getPlayer() {
        return player;
    }

    public String moveToRoom(String move) {
        if(player.moveToRoom(move) != null) {
            return "You are now in " + player.getRoom().getRoomDescription();
        }
        return "You cannot go that way";
    }

    public Rooms darkDirection() {
        return darkDirection();
    }


}
