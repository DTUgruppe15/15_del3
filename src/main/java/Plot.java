import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//**************************************************
//Class for the purchasable plots in Monopoly Junior
//**************************************************
public class Plot {
    //Defining the arraylist size.
    private int[][] plotStatus = new int[24][3];

    //Defining the 'fieldpositions' that are not purchasable plots.
    private final Integer[] notAvailablePlots = new Integer[]{0,3,6,9,12,15,18,21};

    //Creating an Arraylist, so we can use the array notAvailablePlots in plotNotOwned boolean.
    List<Integer> intList = new ArrayList<>(Arrays.asList(notAvailablePlots));

    //Creating arraylist for all plots in the first file, and player ownership in the second file. Each row has a value corresponding to the buy/rent of the plot.
    public void instantiation() {
        for(int i = 0; i < plotStatus.length; i++) {
            plotStatus[i][0] = i+1;
        }
        plotStatus[1][2] = 1;
        plotStatus[2][2] = 1;
        plotStatus[4][2] = 1;
        plotStatus[5][2] = 1;
        plotStatus[7][2] = 2;
        plotStatus[8][2] = 2;
        plotStatus[10][2] = 2;
        plotStatus[11][2] = 2;
        plotStatus[13][2] = 3;
        plotStatus[14][2] = 3;
        plotStatus[16][2] = 3;
        plotStatus[17][2] = 3;
        plotStatus[19][2] = 4;
        plotStatus[20][2] = 4;
        plotStatus[22][2] = 5;
        plotStatus[23][2] = 5;
    }

    //Checks if the plot is owned by the player.
    public boolean isPlotOwnedByPlayer(int position, int player) {
        return plotStatus[position][1] == player + 1;

    }
    //Checks if the plot is not already owned.
    public boolean isPlotNotOwned(int position) {
        return plotStatus[position][1] == 0 && canPlotBeBought(position);
    }
    //Checks if the plot can be bought.
    public boolean canPlotBeBought(int position) {
        return !intList.contains(position);
    }
    //Claims the plot.
    public void claimPlot(int position, int player) {
        plotStatus[position][1] = player+1;
    }

    //Decides the amount of money the player has to pay, whether it is owned by another player, and if it isn't owned then it gives ownership.
    public int moneyToBePaid(int position, int player) {
        //If the plot is not owned, then the player pays the rent and gets ownership.
        if(isPlotNotOwned(position)) {
            claimPlot(position, player);
            System.out.println("Plot have been claimed by " + (player+1));
            return plotStatus[position][2];
        }
        //Nothing happens if the player already owns that plot.
        else if(isPlotOwnedByPlayer(position, player)) {
            System.out.println("Plot already owned by player");
            return 0;
        }
        //Player pays rent to the player with the ownership.
        else {
            System.out.println("Player "+ (player+1) + " payed " + plotStatus[position][2]);
            return plotStatus[position][2];
        }
    }
    //Getter.
    public int getPlotStatus(int y, int x) {
        return plotStatus[y][x];
    }

    //Setter.
    public void setPlotStatus(int y, int x, int value) {
        plotStatus[y][x] = value;
    }

    //Returns the 2D array
    public int[][] plot() {
        return plotStatus;
    }
}
