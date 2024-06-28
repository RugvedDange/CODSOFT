import java.util.*;
import java.util.Random;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        int ch;
        System.out.println("\t\t\t\t\t\t\t\t\t   || Number Guesser ||\n\n");
        System.out.println("\t\t\t\tWelcome !!\nRules Of The Game :-\n1) Game will generate a number, your task is to guess the number\n2) You will get 5 attempts to guess the number\n3) After every guess hint will be provided regarding how far are you from the number\n\tRange\t| Hint\n\t0-10\t| Very Close\n\t11-25\t| Close\n\t26-50\t| Far\n\t51-100\t| Very Far");
        System.out.println("4) Your Score Will Be Generated After Attempting All 5 Guesses\n   Maximum Points Can Be Scored Are 20\n      Guess\t\t| Points\n    VERY CLOSE\t|  +3\n      CLOSE\t\t|  +2\n      FAR\t\t|  +1\n    VERY FAR\t|  +0");
        System.out.println("Sooooooo, Be Ready To Tickle Your Brain And Start Guessing The Number\n");
        do{
            int score=0;
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();
            int random = rand.nextInt(100);
            for(int i=0;i<5;i++) {
                System.out.println("Enter your " + (i + 1) + " Guess :- ");
                int guess = sc.nextInt();
                int diff = Math.abs(random - guess);
                if (diff == 0) {
                    System.out.println("Hurray :)) !!\nYou Have Guessed The Number \n\n");
                    score = 20;
                    break;
                } else if (diff > 0 && diff <= 10) {
                    System.out.println("Very Good Going :) !!\nYou Are VERY CLOSE\n\n");
                    score += 3;
                } else if (diff > 10 && diff <= 25) {
                    System.out.println("Good Going !!\nYou are CLOSE\n\n");
                    score += 2;
                } else if (diff > 25 && diff <= 50) {
                    System.out.println("Try Again :(\nYou are FAR\n\n");
                    score += 1;
                } else {
                    System.out.println("Ohhhhh Noooo !!\nYou are Very Far :((\n\n");
                    score += 0;
                }
            }
                System.out.println("The Generated Number Was - "+ random+"\n");
            System.out.println("Your Score Is - "+score+"\n\n");
                System.out.println("Do You Wish To Play Again ??\n\n1-Yes, For Sure\n0-No, Satisfied !!\n");
                ch = sc.nextInt();
        }while(ch==1);
    }
}
