import java.util.Random;

public class Chance {

    public void drawCard(){
        Random random = new Random();
        System.out.println(random.nextInt(20));
    }

    public void showCard(UIController uiController){
        uiController.sendMessage("test");
    }

}
