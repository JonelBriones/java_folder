import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls() {
    
        ArrayList<Integer> randomGenerate = new ArrayList<Integer>();
        Random randMachine = new Random();  

        for (int i = 1; i <= 10; i++) {
            randomGenerate.add(randMachine.nextInt(21) - 1);
        }

        return randomGenerate;
    }
    public String alphabets() {
        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvxyz";
        for(int i = 0; i <=25; i++) {
            alphabets.get(i);
        }

    }
}
