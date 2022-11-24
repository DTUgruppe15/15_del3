public class FieldController {

    Player[] players;
    Chance chance;
    GoToJail goToJail;

    public FieldController(Player[] players, UIController uiController, Languages languages, Plot plot){
        this.players = players;
        chance = new Chance(players, uiController, languages, plot);
        goToJail = new GoToJail(uiController);
    }

    public void landOnField(int field, int playerTurn){
        switch(field){
            case 3:
            case 9:
            case 15:
            case 21:
                chance.drawCard(playerTurn);
                break;
            case 18:
                goToJail.goToJail(players[playerTurn],playerTurn);
                break;

        }
    }
}
