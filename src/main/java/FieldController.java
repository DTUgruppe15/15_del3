public class FieldController {

    Player[] players;
    UIController uiController;
    Languages languages;
    Chance chance;
    Plot plot;

    public FieldController(Player[] players, UIController uiController, Languages languages, Plot plot){
        this.players = players;
        this.uiController = uiController;
        this.languages = languages;
        this.plot = plot;
        chance = new Chance(players, uiController, languages, plot);
    }

    public void landOnField(int field, int playerTurn){
        switch(field){
            case 3:
            case 9:
            case 15:
            case 21:
                chance.drawCard(playerTurn);
                break;
        }
    }
}
