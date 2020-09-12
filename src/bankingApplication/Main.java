package bankingApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BankAccount obj = new BankAccount("Muskan", "abcd");
        obj.showMenu();
    }
}

class BankAccount {

    int balance;
    int previousTransaction;
    String customerName, customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    void moneyDeposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void moneyWithdrawn(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("The earlier transaction is of Rs " + previousTransaction);
        }else if(previousTransaction < 0){
            System.out.println("The earlier transaction is of Rs " + previousTransaction);
        }else{
            System.out.println("No transaction occured");
        }
    }

    void showMenu(){
        char key;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "." + "\n" + "Your ID is: " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit Money");
        System.out.println("C. Withdraw Money");
        System.out.println("D. View Previous Transaction");
        System.out.println("E. Exit");
        System.out.println();

        do {
            System.out.println("Please enter a key: ");
            key = scan.next().charAt(0);

            switch(key){
                case 'A':
                    System.out.println("Your current balance is: " + balance);
                    break;
                case 'B':
                    System.out.println("Enter an amount you want to deposit: ");
                    int amountDeposit = scan.nextInt();
                    moneyDeposit(amountDeposit);
                    System.out.println("Rs."+ amountDeposit + "is deposited in your bank account.");
                    break;
                case 'C':
                    System.out.println("Enter an amount you want to withdraw: ");
                    int amountWithdraw = scan.nextInt();
                     moneyWithdrawn(amountWithdraw);
                    System.out.println("Rs." + amountWithdraw + "is withdrawn form your bank account.");
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("******** you pressed exit ********");
                    break;
                default:
                    System.out.println("***Invalid Option***");
                    break;
            }
        }while(key != 'E');
        System.out.println("THANK YOU!");
    }
}