import java.util.Random;
import java.util.Scanner;
public class task1{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Number Game");
        int play=0;
        do{
            Random random= new Random();
            int num1=random.nextInt(100);
            System.out.print("Enter No. of attempts: ");
            int atmt=sc.nextInt();
            checkrandom(num1,atmt);
            System.out.println("Do you want to play more?(1/0)");
            play=sc.nextInt();
        }while(play==1);
        
    }
    
    static void checkrandom(int num1,int atmt){

        while(atmt>0){
            atmt--;
            System.out.print("Enter your guess : ");
            int num2=sc.nextInt();
            

            if(num1==num2){
                System.out.println("Congratulations! You guessed it right");
                System.out.println("Your Score : " + (atmt+1));
                return;
            }

            else{
                System.out.println("Sorry! You guess is wrong");
                if(num2>num1){
                    System.out.println("Desired no. is less than " + num2);
                }
                else{
                    System.out.println("Desired no. is greater than " + num2);              
                }
                
            }

        }
        if(atmt==0){
            System.out.println("You ran out of attempts.");
            System.out.println("The correct no. is : " + num1);
            return;
            
        }
    }

}