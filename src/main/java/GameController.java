public class GameController {

    UIController uiController;
    TurnController turnController;
    FieldController fieldController;

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
        int money;
        if(amountOfPlayers == 2){
            money = 20;
        } else if(amountOfPlayers == 3){
            money = 18;
        } else{
            money = 16;
        }
        for (int i = 0; i < amountOfPlayers; i++) {
            players[i] = new Player(money);
        }
        fieldController = new FieldController(players, uiController, uiController.getLanguages());

        boolean gameActive = true;

        while(gameActive == true){
            uiController.chooseAction(turnController.getPlayerTurn());

            players[turnController.getPlayerTurn()].rollDice();

            uiController.setDie(players[turnController.getPlayerTurn()].die1.getFaceValue());
            players[turnController.getPlayerTurn()].updatePosition();
            uiController.moveCar(turnController.getPlayerTurn(),players[turnController.getPlayerTurn()].getPosition());

            fieldController.landOnField(players[turnController.getPlayerTurn()].getPosition(),turnController.getPlayerTurn());
            
            uiController.setBalance(turnController.getPlayerTurn(),players[turnController.getPlayerTurn()].getMoney());
            turnController.nextPlayer();
        }
        //win condition
    }
}
