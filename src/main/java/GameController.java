import java.util.Arrays;

public class GameController {

    UIController uiController;
    TurnController turnController;
    FieldController fieldController;
    Plot plot;

    private int amountOfPlayers;

    Player[] players;

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.game();
    }

    public void game(){
        uiController = new UIController();
        plot = new Plot();
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


        //Constructs the plot-array
        plot.instantiation();
        boolean gameActive = true;
        fieldController = new FieldController(players, uiController, uiController.getLanguages(), plot);

        while(gameActive == true) {
            System.out.println((turnController.getPlayerTurn()+1) + " " + players[turnController.getPlayerTurn()].hasGetOutOfJailCard());
            if(players[turnController.getPlayerTurn()].isInJail()){
                String choice = uiController.chooseActionJail(turnController.getPlayerTurn(), players[turnController.getPlayerTurn()].hasGetOutOfJailCard());
                players[turnController.getPlayerTurn()].setInJail(false);
                if(choice=="CardUsed"){
                    players[turnController.getPlayerTurn()].useGetOutOfJail();
                } else{
                    players[turnController.getPlayerTurn()].account.changeBalance(-1);
                    uiController.setBalance(turnController.getPlayerTurn(), players[turnController.getPlayerTurn()].getMoney());
                }
            }

            if(!players[turnController.getPlayerTurn()].isInJail()) {
                uiController.chooseAction(turnController.getPlayerTurn());

                players[turnController.getPlayerTurn()].rollDice();

                uiController.setDie(players[turnController.getPlayerTurn()].die1.getFaceValue());
                players[turnController.getPlayerTurn()].updatePosition();
                uiController.moveCar(turnController.getPlayerTurn(), players[turnController.getPlayerTurn()].getPosition());

                fieldController.landOnField(players[turnController.getPlayerTurn()].getPosition(), turnController.getPlayerTurn());

                //*******************
                //Controls the plots
                //*******************

                //If plot is not owned by a player - when player lands on that plot - , then this changes the bordercolour of that plot to the colour of the player.
                if (plot.isPlotNotOwned(players[turnController.getPlayerTurn()].getPosition())) {
                    uiController.buyPlot(players[turnController.getPlayerTurn()].getPosition(), turnController.getPlayerTurn());
                }

                //Removes money from the player.
                int a = plot.moneyToBePaid(players[turnController.getPlayerTurn()].getPosition(), turnController.getPlayerTurn());
                players[turnController.getPlayerTurn()].account.changeBalance(-a);

                //Adds money to the balance of the player that owns the plot when someone else lands on it.
                int b = plot.getPlotStatus(players[turnController.getPlayerTurn()].getPosition(), 1);
                if (b != (turnController.getPlayerTurn() + 1) && plot.canPlotBeBought(players[turnController.getPlayerTurn()].getPosition())) {
                    players[(b - 1)].account.changeBalance(a);
                    //Updates the UI-balance
                    uiController.setBalance((b - 1), players[(b - 1)].getMoney());
                }

                //Updates the UI-balance
                uiController.setBalance(turnController.getPlayerTurn(), players[turnController.getPlayerTurn()].getMoney());

                //Breaks out of the while-loop, if a players money reaches 0.
                if (players[turnController.getPlayerTurn()].getMoney() == 0) {
                    break;
                }
            }

            turnController.nextPlayer();
        }
        //win condition - finds player with most money.
        int player = 0;
        int prevMoney = players[0].getMoney();
        for(int i = 0; i < players.length; i++) {
            if(players[i].getMoney() >= prevMoney) {
                player = i+1;
                prevMoney = players[i].getMoney();
            }
        }
        uiController.sendMessage("The winner of the game is player: " + player + " with " + prevMoney + " money");
        //System.out.println("The winner of the game is player: " + player + " with " + prevMoney + " money");
    }
}
