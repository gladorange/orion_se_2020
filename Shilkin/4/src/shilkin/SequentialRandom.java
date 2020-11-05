package shilkin;
import java.util.Random;

public class SequentialRandom {

    private static int myInt;

    SequentialRandom(){
        if (myInt == 0){
            Random random = new Random();
            myInt = random.nextInt();
        }else{
            myInt++;
        }
    }

    public static int getMyInt() {
        return myInt;
    }

    public static void resetRandom(){
        myInt = 0;
    }
}
