public class Account {

    public Account(){
        amountOfMoney = 1000;
    }

    private int amountOfMoney;

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void changeBalance(int money){
        if(money<0){
            amountOfMoney += money;
            if(amountOfMoney <= 0){
                amountOfMoney = 0;
            }
        } else{
            amountOfMoney += money;
        }
    }
}