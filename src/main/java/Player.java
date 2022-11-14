public class Player {

    Account konto = new Account();

    Die die1 = new Die();
    Die die2 = new Die();

    private int position = 0;

    private boolean inJail = false;

    private int getOutOfJail = 0;

    public void rollDice(){
        die1.rollDie();
        die2.rollDie();
    }

    public int sumOfDice(){
        return die1.getFaceValue()+die2.getFaceValue();
    }

    public boolean useGetOutOfJailCard(){
        if(getOutOfJail>0){
            getOutOfJail--;
            return true;
        }else {
            return false;
        }
    }

    public boolean hasGetOutOfJailCard(){
        if(getOutOfJail>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean isInJail(){
        return inJail;
    }
}
