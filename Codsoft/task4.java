import java.util.Scanner;
public class task4{
    public static void main(String[] args) {
        ATM obj=new ATM();
        obj.checkpin();
    }
}
class ATM{

    float intbalance=0;
    int pin=0000;
    Scanner sc=new Scanner(System.in);

    public void checkpin(){
        System.out.print("Enter pin : ");
        int entpin=sc.nextInt();
        if(pin==entpin){
            menu();
        }
        else{
            System.out.println("Incorrect pin!");
            System.out.println("Please enter corect pin : ");
            checkpin();
        }
    }
    public void menu(){
        System.out.println("1)Check Balence");
        System.out.println("2)Deposit Money");
        System.out.println("3)Withdraw Money");
        System.out.println("4)Exit");
        System.out.println("Enter your choice : ");
        int choice=sc.nextInt();
        if(choice==1){
            checkbalance();
        }
        else if(choice==2)
            depomoney();
        else if(choice == 3)
            withdmoney();
        else if(choice==4)
            return;
        else{
            System.out.println("Please enter correct choice");
        }
    }

    public void checkbalance(){
        System.out.println("Current Balance : " + intbalance);
        menu();
    }
    public void depomoney(){
        System.out.println("Enter amount to deposit : ");
        int entamt=sc.nextInt();
        intbalance +=entamt;
        System.out.println("Money depositted successfully");
        menu();
    }
    public void withdmoney(){
        System.out.println("Enter amount to withdraw : ");
        int entamt=sc.nextInt();
        if(entamt>intbalance){
            System.out.println("Insufficient Balance");
        }
        else{
            intbalance -= entamt;
            System.out.println("Money Withdrawn Successfully");
        }
        menu();
    }





}