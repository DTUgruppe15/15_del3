import java.util.Random;

public class Chance {

    Player[] players;
    UIController uiController;
    Languages languages;
    Random random = new Random();
    Plot plot;

    public Chance(Player[] players, UIController uiController, Languages languages, Plot plot){
        this.players = players;
        this.uiController = uiController;
        this.languages = languages;
        this.plot = plot;
    }

    public Chance(){}

    public void drawCard(int playerTurn){
        switch (random.nextInt(16)){
            case 0:
                uiController.sendMessage(languages.getMessages("Chance1"));
                players[playerTurn].setPosition(0);
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                players[playerTurn].account.changeBalance(2);
                uiController.setBalance(playerTurn,players[playerTurn].getMoney());
                break;
            case 1:
                players[playerTurn].movePosition(uiController.gui.getUserInteger(languages.getMessages("Chance2"),1,5));
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                break;
            case 2:
                uiController.sendMessage(languages.getMessages("Chance3"));
                players[playerTurn].setPosition(10);
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 3:
                if(uiController.gui.getUserSelection(languages.getMessages("Chance4"), languages.getMessages("Chance4choice1"),languages.getMessages("Chance4choice2")) == languages.getMessages("Chance4choice1")){
                    players[playerTurn].movePosition(1);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                } else{
                    drawCard(playerTurn);
                }
                break;
            case 4:
                uiController.sendMessage(languages.getMessages("Chance5"));
                players[playerTurn].account.changeBalance(-2);
                uiController.setBalance(playerTurn,players[playerTurn].getMoney());
                break;
            case 5:
                if(uiController.gui.getUserSelection(languages.getMessages("Chance6"), languages.getMessages("Chance6choice1"), languages.getMessages("Chance6choice2"))== languages.getMessages("Chance6choice1")){
                    players[playerTurn].setPosition(10);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                } else{
                    players[playerTurn].setPosition(19);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                }
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 6:
                uiController.sendMessage(languages.getMessages("Chance7"));
                players[playerTurn].setPosition(4);
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 7:
                uiController.sendMessage(languages.getMessages("Chance8"));
                players[playerTurn].addGetOutOfJail();
                break;
            case 8:
                uiController.sendMessage(languages.getMessages("Chance9"));
                players[playerTurn].setPosition(23);
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                break;
            case 9:
                uiController.sendMessage(languages.getMessages("Chance10"));
                players[playerTurn].account.changeBalance(players.length-1);
                for (int i = 0; i < players.length; i++) {
                    if(i!=playerTurn){
                        players[i].account.changeBalance(-1);
                    }
                }
                break;
            case 10:
                if(uiController.gui.getUserSelection(languages.getMessages("Chance11"), languages.getMessages("Chance11choice1"), languages.getMessages("Chance11choice2"))== languages.getMessages("Chance11choice1")){
                    players[playerTurn].setPosition(7);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                } else{
                    players[playerTurn].setPosition(22);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                }
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 11:
                uiController.sendMessage(languages.getMessages("Chance12"));
                players[playerTurn].account.changeBalance(2);
                uiController.setBalance(playerTurn,players[playerTurn].getMoney());
                break;
            case 12:
                uiController.sendMessage(languages.getMessages("Chance13"));
                players[playerTurn].setPosition(13);
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 13:
                uiController.sendMessage(languages.getMessages("Chance14"));
                players[playerTurn].setPosition(10);
                uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 14:
                if(uiController.gui.getUserSelection(languages.getMessages("Chance15"), languages.getMessages("Chance15choice1"), languages.getMessages("Chance15choice2"))== languages.getMessages("Chance15choice1")){
                    players[playerTurn].setPosition(4);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                } else{
                    players[playerTurn].setPosition(13);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                }
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
            case 15:
                if(uiController.gui.getUserSelection(languages.getMessages("Chance16"), languages.getMessages("Chance16choice1"), languages.getMessages("Chance16choice2"))== languages.getMessages("Chance16choice1")){
                    players[playerTurn].setPosition(1);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                } else{
                    players[playerTurn].setPosition(16);
                    uiController.moveCar(playerTurn,players[playerTurn].getPosition());
                }
                if(plot.isPlotNotOwned(players[playerTurn].getPosition())){
                    plot.claimPlot(players[playerTurn].getPosition(),playerTurn);
                    uiController.buyPlot(players[playerTurn].getPosition(),playerTurn);
                }
                break;
        }
    }
}
