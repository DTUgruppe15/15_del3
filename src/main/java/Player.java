public class Player {

    Konto konto = new Konto();

    Die die1 = new Die();
    Die die2 = new Die();

    public void rollDice(){
        die1.rollDie();
        die2.rollDie();
    }

    public int sumOfDice(){
        return die1.getFaceValue()+die2.getFaceValue();
    }
}
