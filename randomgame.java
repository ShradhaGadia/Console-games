import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class randomgame{

    static Scanner s=new Scanner(System.in);

    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void callagain(){
        int repeat=0;
        try{
            System.out.print("To play these games again enter any number between 1 to 9:");
            repeat=s.nextInt();}
        catch(Exception e){
         System.out.println("You entered something not a number.EXITING....");
         delay();
         System.exit(0);
        }
      if (repeat==1 || repeat==4 || repeat==7)
         rockps();
      else if (repeat==2 || repeat==5 || repeat==8)
         numguess();
      else if(repeat==3 || repeat==6 || repeat==9)
         wordguess();
      else
         System.out.println("GOODBYE.HOPE YOU ENJOYED.");
    }

    public static void wordguess(){
        Random random=new Random();
        System.out.println("You are about to play HANGMAN with the computer");
        delay();
        String[] list={"language","terminal","exams","shopping","coffee","chatgpt","amazon","java","assignment","computer","python","zebra","programming","algorithm","operators","database","software","interview","website"};
        String word=list[random.nextInt(list.length)];
        System.out.println("NUMBER OF ATTEMPTS AT GUESSING: 6");
        delay();
        int chance=0;
        System.out.println("Guess the word ");
        delay();
        int number=word.length();
        char[] current=new char[number]; 
        Arrays.fill(current,'_');
        System.out.print(current);
        System.out.println();
        delay();
        ArrayList<Character> guessedLetters=new ArrayList<>();
        while(chance<6){
            System.out.print("Enter the letter you are guessing: ");
            String letter=s.next().toLowerCase();
            if (letter.length()>1){
            System.out.println("Invalid entry");
            delay();
            continue;}
            char guess=letter.charAt(0);
            if (guessedLetters.contains(guess)){
            System.out.println("Already entered try entering another letter");
            delay();
            continue;}
            guessedLetters.add(guess);
            delay();
            if (word.contains(letter))
            System.out.println("CORRECT guess");
            else{
            System.out.println("WRONG guess");
            chance++;}   
            for(int i=0;i<word.length();i++){
                if (guessedLetters.contains(word.charAt(i))) {
                    current[i] = word.charAt(i);
                }
            }
            System.out.print(current);
            System.out.println();
            delay();
            if (Arrays.equals(current,word.toCharArray())){
            System.out.println("HURRAH!! you guessedLetters the whole word");
            break;}
            delay();
            System.out.println("Number of attempts remaining: "+(6-chance));
            delay();
        }
        System.out.println("The word to guess was: "+word);
        delay();
        callagain();
    }


    public static void numguess(){

        System.out.println("You are about to to play NUMBER GUESSING with computer");
        delay();
        int a=0;
        int b=0;
        int num=0;


        //taking lower & upper limits
        try{
        System.out.print("Enter the lower limit: ");
        delay();
        a=s.nextInt();}
        catch (Exception e){
            System.out.println("Please enter a number.RESTARTING....");
            delay();
            s.nextLine();
            numguess();
        }
        try{
        System.out.print("Enter the upper limit: ");
        delay();
        b=s.nextInt();}
        catch (Exception e){
            System.out.println("Please enter a number.RESTARTING....");
            delay();
            s.nextLine();
            numguess();
        }

        //selecting num from the provided range
        Random random=new Random();
        num=random.nextInt(a,b);
        boolean flag=false;
        int chance=0;

        //main game here..
        while(chance<6){
            System.out.print("Enter your guess: ");
            int guess=0;
            try{
            guess=s.nextInt();}
            catch (Exception e){
                System.out.println("You didn't enter a number.RESTARTING...");
                delay();
                s.nextLine();
                numguess();
            }
            if(guess==num){
                System.out.println("CORRECT!! You guessedLetters at attempt "+chance);
                flag=true;
                break;
            }
            else if(guess<num){
                System.out.println("Number is greater than this");
                chance++;
            }
            else{
                System.out.println("Number is smaller than this");
                chance++;
            }
            delay();
            System.out.println("Attempts remaining "+(6-chance));
            delay();
        }
        if (flag==false){
            System.out.println("Sorry!! You lost. The number was "+num);
        }
        delay();
        callagain();
    }

    public static void rockps(){
        System.out.println("You are about to play ROCK PAPER SCISSORS with the computer");
        delay();
        int user_score=0;
        int comp_score=0;
        int round=1;
        Scanner sc=new Scanner(System.in);

        //           ROUNDS                //
        while(round<4){
            System.out.println("Round number: "+round);
            delay();

            System.out.println("Enter a choice rock, paper or scissors -> ");

            String user_input=sc.nextLine();
            user_input=user_input.toLowerCase();

            String[] list={"rock","paper","scissors"};
            Random random=new Random();
            int index=random.nextInt(list.length);
            String comp_input=list[index];
            

            System.out.println("you selected "+user_input);
            //     COMPARISONS             //
            if (user_input.equals(comp_input) ){
                System.out.println("We both selected "+user_input+". So, it's a tie!");
                round+=1;
                delay();}
            else if (user_input.equals("rock")){
                if (comp_input.equals("scissors")){
                    System.out.println("Rock smashed scissors, You win this round!");
                    delay();
                    user_score+=1;}
                else{
                    System.out.println("Paper covers rock, You lose this round.");
                    delay();
                    comp_score+=1;}
                round+=1;
            }
            else if (user_input.equals("paper") ){
                if (comp_input.equals("rock") ){
                    System.out.println("Paper covers rock, You win this round.");
                    delay();
                    user_score+=1;}
                else{
                    System.out.println("Scissors cuts paper! You lose this round.");
                    delay();
                    comp_score+=1;}
                round+=1;
            }
            else if (user_input.equals("scissors") ){
                if (comp_input.equals("paper") ){
                    System.out.println("Scissors cuts paper! You win this round.");
                    delay();
                    user_score+=1;}
                else{
                    System.out.println("Rock smashes scissors! You lose this round.");
                    delay();
                    comp_score+=1;}
                round+=1;
            }
            else{
            System.out.println("Wrong input. TRY AGAIN.");
            delay();}
        }

        //     FINAL SCORESSSS         //
        if (user_score>comp_score){
            System.out.println("YOU WON!! YOUR SCORE: "+user_score+ " MY SCORE: "+comp_score);
            delay();}
        else if (user_score<comp_score){
            System.out.println("I WON!! MY SCORE: "+comp_score+ " YOUR SCORE: "+user_score);
            delay();}
        else{
            System.out.println("That was a whole DRAW!!!. NOONE WON.");
            delay();}
        callagain();
    }

    public static void gameselection(){
        System.out.println("As it is a random game generator please select a number from 1 to 9 to play a random game");
        int number=0;
        try {
            number=s.nextInt();
            switch(number){
                case 1:
                case 4:
                case 7: wordguess();
                break;
                case 2:
                case 5:
                case 8: numguess();
                break;
                case 3:
                case 6:
                case 9: rockps();
                break;
                default:System.out.println("OUT OF RANGE");
                delay();
                gameselection();
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.print("ERROR:");
            s.nextLine();
            gameselection();
        }
    }
    public static void main(String[] args) {
        System.out.print("Hello user please enter your name ->");
        String name=s.nextLine();
        delay();
        System.out.println("Hello "+name + " Welcome!!");
        delay();
        gameselection();
    }
}