import java.util.Random;

public class Die {
    private int faceValue;
    private int amountOfFaces;

    public Die(int amountOfFaces) {
        this.amountOfFaces = amountOfFaces;
    }

    public Die(){
        this.amountOfFaces = 6;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public void rollDie(){
        Random random = new Random();
        faceValue = random.nextInt(amountOfFaces)+1;
    }
}