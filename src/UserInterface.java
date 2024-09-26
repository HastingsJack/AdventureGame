public class UserInterface {
    private Adventure adventure;
    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startGame() {
        adventure.startGame();
    }
}
