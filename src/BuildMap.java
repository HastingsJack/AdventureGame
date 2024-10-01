public class BuildMap {
    private Rooms room, room1, room2, room3, room4, room5, room6, room7, room8, room9;

    public BuildMap() {
        buildRooms();
        buildItems();
    }

    public void buildRooms() {
       room1 = new Rooms("Room 1","Start room");
       room2 = new Rooms("Room 2","Room Description");
       room3 = new Rooms("Room 3","Room 3");
       Rooms room4 = new Rooms("Room 4","Room 4");
       Rooms room5 = new Rooms("Room 5","Room 5");
       Rooms room6 = new Rooms("Room 6","Room 6");
       Rooms room7 = new Rooms("Room 7","Room 7");
       room8 = new Rooms("Room 8","Room 8");
       Rooms room9 = new Rooms("Room 9","Room 9");

        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room9.setNorth(room6);
        room9.setWest(room8);
        room = room1;
        room2.isDark(true);
        room6.isDark(true);
        room9.isDark(true);
    }

    public void buildItems() {
        Item item1 = new Item("Lamp", "Lamp");
        Item item2 = new Item("Stick", "Stick");
        Item item3 = new Item("Ball", "Ball");
        room1.items.add(item1);
        room1.items.add(item2);
        room3.items.add(item3);
    }

    public Rooms getCurentRoom() {
        return this.room;
    }





}