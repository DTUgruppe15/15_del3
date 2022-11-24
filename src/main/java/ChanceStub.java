import javax.swing.text.StyledEditorKit;

public class ChanceStub extends Chance{

    private int num;
    private int inputInt;
    private Boolean inputString;

    public void setNum(int num) {
        this.num = num;
    }

    public void setInputInt(int inputInt) {
        this.inputInt = inputInt;
    }

    public void setInputString(Boolean inputString) {
        this.inputString = inputString;
    }

    Player[] players;

    Languages languages;

    public ChanceStub(Player[] players, Languages languages){
        this.players = players;
        this.languages = languages;
    }

    @Override
    public void drawCard(int playerTurn){
        switch (num){
            case 0:
                players[playerTurn].setPosition(0);
                players[playerTurn].account.changeBalance(2);
                break;
            case 1:
                players[playerTurn].movePosition(inputInt);
                break;
            case 2: //Need buy plot to function
                players[playerTurn].setPosition(10);
                break;
            case 3:
                if(inputString){
                    players[playerTurn].movePosition(1);
                } else{
                    drawCard(playerTurn);
                }
                break;
            case 4:
                players[playerTurn].account.changeBalance(-2);
                break;
            case 5: //Need buy plot to function
                if(inputString){
                    players[playerTurn].setPosition(10);
                } else{
                    players[playerTurn].setPosition(19);
                }
                break;
            case 6: //Need buy plot to function
                players[playerTurn].setPosition(4);
                break;
            case 7:
                players[playerTurn].addGetOutOfJail();
                break;
            case 8:
                players[playerTurn].setPosition(23);
                break;
            case 9:
                players[playerTurn].account.changeBalance(players.length-1);
                for (int i = 0; i < players.length; i++) {
                    if(i!=playerTurn){
                        players[i].account.changeBalance(-1);
                    }
                }
                break;
            case 10: //Need buy plot to function
                if(inputString){
                    players[playerTurn].setPosition(7);
                } else{
                    players[playerTurn].setPosition(22);
                }
                break;
            case 11:
                players[playerTurn].account.changeBalance(2);
                break;
            case 12: //Need buy plot to function
                players[playerTurn].setPosition(13);
                break;
            case 13: //Need buy plot to function
                players[playerTurn].setPosition(10);
                break;
            case 14: //Need buy plot to function
                if(inputString){
                    players[playerTurn].setPosition(4);
                } else{
                    players[playerTurn].setPosition(13);
                }
                break;
            case 15: //Need buy plot to function
                if(inputString){
                    players[playerTurn].setPosition(1);
                } else{
                    players[playerTurn].setPosition(16);
                }
                break;
        }
    }
}
