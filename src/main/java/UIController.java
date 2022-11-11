import gui_fields.*;
import gui_main.GUI;

public class UIController {

    GUI gui;
    Languages languages = new Languages();
    GUI_Field[] fields = {
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

    GUI_Player player1 = new GUI_Player("Player 1");
    GUI_Player player2 = new GUI_Player("Player 1");
    int last1 = 0;
    int last2 = 0;

    public UIController(){
        gui = new GUI(fields);
    }

    public GUI_Field[] SetInfoFields(){


        GUI_Street field0 = new GUI_Street();
        field0.setTitle(languages.getMessages("nameTower"));
        field0.setSubText("+250");
        fields[0] = field0;

        GUI_Street field1 = new GUI_Street();
        field1.setTitle(languages.getMessages("nameCrater"));
        field1.setSubText("-100");
        fields[1] = field1;

        GUI_Street field2 = new GUI_Street();
        field2.setTitle(languages.getMessages("namePalace"));
        field2.setSubText("+100");
        fields[2] = field2;

        GUI_Street field3 = new GUI_Street();
        field3.setTitle(languages.getMessages("nameDesert"));
        field3.setSubText("-20");
        fields[3] = field3;

        GUI_Street field4 = new GUI_Street();
        field4.setTitle(languages.getMessages("nameCity"));
        field4.setSubText("+180");
        fields[4] = field4;

        GUI_Street field5 = new GUI_Street();
        field5.setTitle(languages.getMessages("nameMonastery"));
        field5.setSubText("0");
        fields[5] = field5;

        GUI_Street field6 = new GUI_Street();
        field6.setTitle(languages.getMessages("nameCave"));
        field6.setSubText("-70");
        fields[6] = field6;

        GUI_Street field7 = new GUI_Street();
        field7.setTitle(languages.getMessages("nameHut"));
        field7.setSubText("+60");
        fields[7] = field7;

        GUI_Street field8 = new GUI_Street();
        field8.setTitle(languages.getMessages("nameWerewall"));
        field8.setSubText("-80 +turn");
        fields[8] = field8;

        GUI_Street field9 = new GUI_Street();
        field9.setTitle(languages.getMessages("namePits"));
        field9.setSubText("-50");
        fields[9] = field9;

        GUI_Street field10 = new GUI_Street();
        field10.setTitle(languages.getMessages("nameMine"));
        field10.setSubText("+650");
        fields[10] = field10;

        return fields;
    }

    public void sendMessage(String text){
        gui.showMessage(text);
    }

    public void moveCar(int player, int field){

        if(player == 0){
            fields[last1].setCar(player1,false);
            fields[field].setCar(player1,true);
            last1 = field;
        } else{
            fields[last2].setCar(player2,false);
            fields[field].setCar(player2,true);
            last2 = field;
        }

    }
}
