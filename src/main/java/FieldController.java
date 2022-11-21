public class FieldController {

    Player[] players;
    UIController uiController;
    Languages languages;

    Chance chance;

    public FieldController(Player[] players, UIController uiController, Languages languages){
        this.players = players;
        this.uiController = uiController;
        this.languages = languages;
        chance = new Chance(players, uiController, languages);
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
