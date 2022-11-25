import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlotTest {
    Player[] players;
    Plot plot;

    public void setUp(int playerAmount) {
        players = new Player[playerAmount];
        int money;
        if(playerAmount == 2){
            money = 20;
        } else if(playerAmount == 3){
            money = 18;
        } else{
            money = 16;
        }
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(20);
        }
        plot = new Plot();
        plot.instantiation();
    }

    @org.junit.jupiter.api.Test
    void buyPlotTest() {
        setUp(2);

        players[0].setPosition(2);
        players[0].account.changeBalance(-plot.moneyToBePaid(players[0].getPosition(), 0));
        assertAll(
                () -> assertEquals(19, players[0].getMoney()),
                () -> assertEquals(1, plot.getPlotStatus(2, 1))
        );
    }

    @Test
    void cannotBuyPlotTest() {
        setUp(2);

        players[0].setPosition(3);
        plot.moneyToBePaid(players[0].getPosition(), 0);

        assertEquals(0, plot.getPlotStatus(3, 1));
    }
}