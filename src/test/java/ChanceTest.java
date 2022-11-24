import org.apache.commons.codec.language.bm.Lang;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    Player[] players;
    ChanceStub chance;
    Languages languages = new Languages();

    public void setUp(int playerAmount,int num){
        players = new Player[playerAmount];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(20);
        }
        chance = new ChanceStub(players, languages);
        chance.setNum(num-1);
    }

    @org.junit.jupiter.api.Test
    void drawCard1() {
        setUp(1,1);

        //test card 1
        chance.drawCard(0);
        assertAll(languages.getMessages("Chance1"),
                () -> assertEquals(22,players[0].getMoney()),
                () -> assertEquals(0,players[0].getPosition())
        );
    }

    @Test
    void drawCard2(){
        setUp(1,2);

        //test card 2
        int[] result = new int[5];
        for (int i = 1; i <= 5; i++) {
            chance.setInputInt(i);
            chance.drawCard(0);
            result[i-1] = players[0].getPosition();
            players[0].setPosition(0);
        }
        int[] expected = {1,2,3,4,5};

        assertArrayEquals(expected,result);
    }

    @Test
    void drawCard3(){
        setUp(1,3);

        //test card 3
        chance.drawCard(0);

        assertEquals(10,players[0].getPosition());
    }

    @Test
    void drawCard4(){
        setUp(1,4);

        chance.setInputString(true);
        chance.drawCard(0);
        assertEquals(1,players[0].getPosition());
    }

    @Test
    void drawCard5(){
        setUp(1,5);

        chance.drawCard(0);
        assertEquals(18,players[0].getMoney());
    }

    @Test
    void drawCard6(){
        setUp(1,6);

        chance.setInputString(true);
        chance.drawCard(0);
        assertEquals(10,players[0].getPosition());
        chance.setInputString(false);
        chance.drawCard(0);
        assertEquals(19,players[0].getPosition());
    }

    @Test
    void drawCard7(){
        setUp(1,7);

        chance.drawCard(0);

        assertEquals(4,players[0].getPosition());
    }

    @Test
    void drawCard8(){
        setUp(1,8);

        assertEquals(false,players[0].hasGetOutOfJailCard());
    }

    @Test
    void drawCard9(){
        setUp(1,9);

        chance.drawCard(0);
        assertEquals(23,players[0].getPosition());
    }

    @Test
    void drawCard10(){
        setUp(4,10);

        chance.drawCard(0);

        assertAll(languages.getMessages("Chance10"),
                () -> assertEquals(23,players[0].getMoney()),
                () -> assertEquals(19,players[1].getMoney()),
                () -> assertEquals(19,players[2].getMoney()),
                () -> assertEquals(19,players[3].getMoney())
        );
    }

    @Test
    void drawCard11(){
        setUp(1,11);

        chance.setInputString(true);
        chance.drawCard(0);
        assertEquals(7,players[0].getPosition());
        chance.setInputString(false);
        chance.drawCard(0);
        assertEquals(22,players[0].getPosition());
    }

    @Test
    void drawCard12(){
        setUp(1,12);

        chance.drawCard(0);
        assertEquals(22,players[0].getMoney());
    }

    @Test
    void drawCard13(){
        setUp(1,13);

        chance.drawCard(0);
        assertEquals(13,players[0].getPosition());
    }

    @Test
    void drawCard14(){
        setUp(1,14);

        chance.drawCard(0);

        assertEquals(10,players[0].getPosition());
    }

    @Test
    void drawCard15(){
        setUp(1,15);

        chance.setInputString(true);
        chance.drawCard(0);
        assertEquals(4,players[0].getPosition());
        chance.setInputString(false);
        chance.drawCard(0);
        assertEquals(13,players[0].getPosition());
    }

    @Test
    void drawCard16(){
        setUp(1,16);

        chance.setInputString(true);
        chance.drawCard(0);
        assertEquals(1,players[0].getPosition());
        chance.setInputString(false);
        chance.drawCard(0);
        assertEquals(16,players[0].getPosition());
    }
}