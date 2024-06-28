import java.util.Scanner;

class Account {

    static int acc_no=1111;
    String acc_holder_name;
    int pin;
    double balance;

    void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name Of The Account Holder");
        acc_holder_name = sc.nextLine();
        int length_pin = 0;
        do {
            System.out.println("Enter 4 Digit Pin");
            pin = sc.nextInt();
            length_pin = String.valueOf(pin).length();
        } while (length_pin != 4);
        System.out.println("Enter initial deposit amount");
        balance = sc.nextDouble();
        System.out.println("Account Created Successfully !!");
        System.out.println("Account Details :-\nAccount Number :- " + acc_no + "\nAccount Holder Name :-" + acc_holder_name + "\nBalance :- " + balance + "\nThank You !!");
    }
}
class ATM extends Account{
    void Withdraw(Account acc){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Account Number :- ");
        int temp_acc_no=sc.nextInt();
        System.out.println("Enter Your 4 Digit Pin");
        int temp_pin=sc.nextInt();
        if(temp_acc_no==super.acc_no && temp_pin==super.pin){
            System.out.println("Enter Amount To Be Withdrawn From The Account");
            double amount = sc.nextDouble();
            if(amount>super.balance){
                System.out.println("Insufficient Balance\nTransaction Failed");
            }
            else {
                super.balance-=amount;
                System.out.println("Rs "+amount+" Withdrawn From Your Account\nTransaction Completed\nThank You For Banking With Us !!");
            }
        }
        else{
            System.out.println("Incorrect Account Number Or Password\nTransaction Failed");
        }
    }

    void deposit(Account acc){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Account Number :- ");
        int temp_acc_no=sc.nextInt();
        System.out.println("Enter Your 4 Digit Pin");
        int temp_pin=sc.nextInt();
        if(temp_acc_no==super.acc_no && temp_pin==super.pin){
            System.out.println("Enter The Amount To Be Deposited in your account");
            double amount = sc.nextDouble();
            super.balance+=amount;
            System.out.println("Rs "+amount+" Deposited In Your Account\nTransaction Completed\nThank You For Banking With Us !!");
        }
        else{
            System.out.println("Incorrect Account Number Or Password\nTransaction Failed");
        }
    }
    void CheckBalance(Account acc){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Account Number :- ");
        int temp_acc_no=sc.nextInt();
        System.out.println("Enter Your 4 Digit Pin");
        int temp_pin=sc.nextInt();
        if(temp_acc_no==super.acc_no && temp_pin==super.pin){
            System.out.println("Your Account Balance Is :- "+super.balance+"\nThank You");
        }
        else{
            System.out.println("Incorrect Account Number Or Password\nTransaction Failed");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM a = new ATM();
        Account acc = new Account();
        System.out.println("Welcome !!\nSelect Your Preferred Transaction");
        int ch;
        do{
            System.out.println("\n1.Create Account\n2.Withdraw Amount From Account\n3.Deposit Money Into Account\n4.Check Your Account Balance\n5.Exit\n");
            ch = sc.nextInt();
            switch (ch){
                case 1 : a.createAccount();
                        break;
                case 2 : a.Withdraw(acc);
                        break;
                case 3 : a.deposit(acc);
                        break;
                case 4 : a.CheckBalance(acc);
                        break;
                case 5 : break;
            }
        }while(ch!=5);
    }
}