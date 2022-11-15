public class TurnController {
    private int playerTurn = 0;
    private int amountOfPlayers;

    private boolean extraTurn = false;

    public TurnController(int amountOfPlayers){
        this.amountOfPlayers = amountOfPlayers;
    }

    public void nextPlayer(){
        if(extraTurn == false) { //Future proofing extra turn
            playerTurn++;
            if (playerTurn >= amountOfPlayers) { //Return to first player if it was the last players turn
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
