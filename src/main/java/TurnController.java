public class TurnController {
    private int playerTurn = 0;
    private int amountOfPlayers;

    private boolean extraTurn = false;

    public TurnController(int amountOfPlayers){
        this.amountOfPlayers = amountOfPlayers;
    }

    public void nextPlayer(){
        if(extraTurn == false) {
            playerTurn++;
            if (playerTurn >= amountOfPlayers) {
                playerTurn = 0;
            }
        } else{
            extraTurn = false;
        }
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
}
