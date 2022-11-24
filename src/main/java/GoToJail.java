public class GoToJail {

    UIController uiController;

    public GoToJail(UIController uiController){
        this.uiController = uiController;
    }

    public void goToJail(Player player, int playerTurn){
        player.setPosition(6);
        player.setInJail(true);
        uiController.moveCar(playerTurn,6);
    }
}
