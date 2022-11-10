public class Konto {

    //LanguageSelect languageSelect = new LanguageSelect();
    Languages languages = new Languages();
    public Konto(){
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
                System.out.println(languages.getMessages("balanceNull"));
            } else{
                System.out.printf(languages.getMessages("balanceNeg"),(money*(-1)));
                System.out.println();
            }
        } else{
            amountOfMoney += money;
            System.out.printf(languages.getMessages("balancePos"),money);
            System.out.println();
        }
    }
}