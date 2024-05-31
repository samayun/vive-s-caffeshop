import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner guessSc = new Scanner(System.in);
        Integer guessNum = guessSc.nextInt();
        Integer randomNumber = 11;
        if(guessNum < 1 && guessNum > 16){
            System.out.println("Please Input 1-15");
        } else if(guessNum == randomNumber) {
            System.out.println("Hurray, You won The Game!");
        } else{
            System.out.println("Sorry, Game Over!");
        }
    }
}
