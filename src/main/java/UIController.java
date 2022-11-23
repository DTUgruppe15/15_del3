import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class UIController {

    GUI gui;
    Languages languages = new Languages();

    GUI_Player[] players;
    GUI_Field[] fields = { //All fields on the board
            new GUI_Start(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Jail(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Refuge(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Jail(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street()
    };

    public UIController(){
        gui = new GUI(fields);

        String selectLanguages = gui.getUserButtonPressed("Select Language", "English", "Dansk");
        if(selectLanguages.equals("Dansk")){
            languages.setLanguages("da","DK");
        } else{
            languages.setLanguages("en","US");
        }

        setInfoFields();
    }

    /**
     * This makes all the fields have the text it needs.
     */
    public void setInfoFields(){
        Color Brown = new Color(150,75,0);
        Color Cyan = new Color(0,255,255);
        Color Pink = new Color(255,20,147);

        fields[0].setTitle(languages.getMessages("Go"));
        fields[0].setSubText("<----");

        fields[1].setTitle(languages.getMessages("Brown1"));
        fields[1].setSubText("1");
        fields[1].setBackGroundColor(Brown);

        fields[2].setTitle(languages.getMessages("Brown2"));
        fields[2].setSubText("1");
        fields[2].setBackGroundColor(Brown);

        fields[3].setSubText(languages.getMessages("Chance"));

        fields[4].setTitle(languages.getMessages("Cyan1"));
        fields[4].setSubText("1");
        fields[4].setBackGroundColor(Cyan);

        fields[5].setTitle(languages.getMessages("Cyan2"));
        fields[5].setSubText("1");
        fields[5].setBackGroundColor(Cyan);

        fields[6].setSubText(languages.getMessages("Visit"));

        fields[7].setTitle(languages.getMessages("Pink1"));
        fields[7].setSubText("2");
        fields[7].setBackGroundColor(Pink);

        fields[8].setTitle(languages.getMessages("Pink2"));
        fields[8].setSubText("2");
        fields[8].setBackGroundColor(Pink);

        fields[9].setSubText(languages.getMessages("Chance"));

        fields[10].setTitle(languages.getMessages("Orange1"));
        fields[10].setSubText("2");
        fields[10].setBackGroundColor(Color.ORANGE);

        fields[11].setTitle(languages.getMessages("Orange2"));
        fields[11].setSubText("2");
        fields[11].setBackGroundColor(Color.ORANGE);

        fields[12].setSubText(languages.getMessages("Park"));

        fields[13].setTitle(languages.getMessages("Red1"));
        fields[13].setSubText("3");
        fields[13].setBackGroundColor(Color.RED);

        fields[14].setTitle(languages.getMessages("Red2"));
        fields[14].setSubText("3");
        fields[14].setBackGroundColor(Color.RED);

        fields[15].setSubText(languages.getMessages("Chance"));

        fields[16].setTitle(languages.getMessages("Yellow1"));
        fields[16].setSubText("3");
        fields[16].setBackGroundColor(Color.YELLOW);

        fields[17].setTitle(languages.getMessages("Yellow2"));
        fields[17].setSubText("3");
        fields[17].setBackGroundColor(Color.YELLOW);

        fields[18].setSubText(languages.getMessages("GoJail"));

        fields[19].setTitle(languages.getMessages("Green1"));
        fields[19].setSubText("4");
        fields[19].setBackGroundColor(Color.GREEN);

        fields[20].setTitle(languages.getMessages("Green2"));
        fields[20].setSubText("4");
        fields[20].setBackGroundColor(Color.GREEN);

        fields[21].setSubText(languages.getMessages("Chance"));

        fields[22].setTitle(languages.getMessages("Blue1"));
        fields[22].setSubText("5");
        fields[22].setBackGroundColor(Color.BLUE);

        fields[23].setTitle(languages.getMessages("Blue2"));
        fields[23].setSubText("5");
        fields[23].setBackGroundColor(Color.BLUE);
    }

    public void sendMessage(String text){
        gui.showMessage(text);
    }

    public void moveCar(int player, int field){
        players[player].getCar().setPosition(fields[field]);
    }

    public int addPlayerAmount(){
        int amountOfPlayers = gui.getUserInteger(languages.getMessages("ChoosePlayerAmount"),2,4);
        int money;
        if(amountOfPlayers == 2){
            money = 20;
        } else if(amountOfPlayers == 3){
            money = 18;
        } else{
            money = 16;
        }
        players = new GUI_Player[amountOfPlayers];

        for (int i = 0; i < players.length; i++) {
            players[i] = new GUI_Player(languages.getMessages("Player") + " " + (i+1),money);
            gui.addPlayer(players[i]);
            switch (i){ //Gives the car a unique color
                case 0:
                    players[i].getCar().setPrimaryColor(Color.RED);
                    break;
                case 1:
                    players[i].getCar().setPrimaryColor(Color.BLUE);
                    break;
                case 2:
                    players[i].getCar().setPrimaryColor(Color.YELLOW);
                    break;
                case 3:
                    players[i].getCar().setPrimaryColor(Color.GREEN);
                    break;
            }
            players[i].getCar().setPosition(fields[0]); //Set all cars initial position on GO
        }

        gui.showMessage(languages.getMessages("GameReady"));

        return amountOfPlayers;
    }

    public void setBalance(int player, int money){
        players[player].setBalance(money);
    }

    //Change the color of a plots border to the ownable player car's colour
    public void buyPlot(int position, int player) {
        GUI_Field field = gui.getFields()[position];
        GUI_Ownable ownable = (GUI_Ownable) field;
        ownable.setBorder(players[player].getCar().getPrimaryColor());
    }

    public void chooseAction(int player){
        String chosenButton = gui.getUserButtonPressed(
                languages.getMessages("Player") + " "  + (player+1) + " " + languages.getMessages("RollButton"),
                languages.getMessages("Roll")
        );
    }

    public void setDice(int die1, int die2){
        gui.setDice(die1, die2);
    }

    public void setDie(int die){
        gui.setDie(die);
    }

    public Languages getLanguages(){ //Past mistakes make spaghetti code
        return languages;
    }
}
