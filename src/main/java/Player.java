public class Player {

    Account account;

    public Player(int money){
        account = new Account(money);
    }

    Die die1 = new Die();
    //Die die2 = new Die();

    private int position = 0;

    private boolean inJail = false;

    private int getOutOfJail = 0;

    public void rollDice(){
        die1.rollDie();
        //die2.rollDie();
    }

    public int sumOfDice(){
        return die1.getFaceValue();//+die2.getFaceValue();
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

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void updatePosition(){
        position += sumOfDice();
        if(position>23){
            account.changeBalance(2);
            position -= 24;
        }
    }

    public int getMoney(){
        return account.getAmountOfMoney();
    }

    public void movePosition(int amount){
        position += amount;
        if(position>23){
            account.changeBalance(2);
            position -= 24;
        }
    }

    public void addGetOutOfJail(){
        getOutOfJail++;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void useGetOutOfJail(){
        getOutOfJail--;
    }
}
