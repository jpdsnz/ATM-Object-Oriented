package com.simple.atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int pinNum;
        int userOption = 0;

        //SavingsAccount account1 = new SavingsAccount(5000, 1423, .034f); //Use the 'f' to denote floating point number for interest rate param
        CheckingAccount account1 = new CheckingAccount(5000, 1423, 2); //Checking acct with 2 dollar fee

        Scanner scanner = new Scanner(System.in);

        account1.printTransaction(); //Used to print transactions to file!

        /*
        ATM atm = new ATM();

        pinNum = scanner.nextInt();

        if(account1.validatePin(pinNum)){
            do {
                atm.menu();
                userOption = scanner.nextInt();
                switch(userOption){
                    case 1:
                        atm.withdrawMenu();
                        double withdrawAmount = scanner.nextDouble();
                        account1.withdraw(withdrawAmount + account1.getFee());
                        //account1.withdraw(withdrawAmount);
                        break;
                    case 2:
                        atm.depositMenu();
                        double depositAmount = scanner.nextDouble();
                        account1.deposit(depositAmount);
                        break;
                    case 3:
                        atm.balanceMenu(account1.getBalance());
                        //System.out.printf("\nThe interest is: $%.2f", account1.calculateInterest()); // For Savings acct
                        break;
                    case 4:
                        atm.exitMenu();
                        break;
                    default:
                        atm.invalidMessageMenu();
                        break;
                }
            } while(userOption != 4);
        }
        */



    }
}