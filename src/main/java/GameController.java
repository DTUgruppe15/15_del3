public class GameController {

    UIController uiController;
    TurnController turnController;

    private int amountOfPlayers;

    Player[] players;

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.game();
    }

    public void game(){
        uiController = new UIController();

        amountOfPlayers = uiController.addPlayerAmount();
        turnController = new TurnController(amountOfPlayers);
        players = new Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            players[i] = new Player();
        }


        boolean gameActive = true;

        while(gameActive == true){
            uiController.chooseAction(turnController.getPlayerTurn());

            players[turnController.getPlayerTurn()].rollDice();

            uiController.setDice(players[turnController.getPlayerTurn()].die1.getFaceValue(),players[turnController.getPlayerTurn()].die2.getFaceValue());



            

            turnController.nextPlayer();
        }
    }
}
