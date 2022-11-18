public class FieldController {

    Player[] players;
    UIController uiController;

    Chance chance = new Chance();

    public FieldController(Player[] players, UIController uiController){
        this.players = players;
        this.uiController = uiController;
    }

    public void landOnField(int field){
        switch (field){
            case 3:
            case 9:
            case 15:
            case 21:
                chance.drawCard();
                chance.showCard(uiController);
                break;
        }
    }



}
