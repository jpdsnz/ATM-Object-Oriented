package com.simple.atm;

import java.io.*;

public abstract class Account implements Transactions {

    private final int accountNumber;
    private int pin;
    private double balance;

    //Auto increment acct number
    private static int nextAccountNumber = 1001;

    public Account(double bal, int pin){
        this.balance = bal;
        this.pin = pin;

        accountNumber = getNextAccountNumber(); //Will auto incrememnt acct number
    }

    public boolean validatePin(int p){
        if(this.pin == p)
            return true;

        System.out.println("Invalid pin!");
        return false;
    }

    public int getAccountNumber() { return accountNumber; }

    public static int getNextAccountNumber(){
        int acctNo = nextAccountNumber;
        nextAccountNumber++;
        return acctNo;
    }


    @Override
    public boolean withdraw(double debitAmt) {
        if(debitAmt > this.balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= debitAmt;
        Transactions.recordTransaction(debitAmt, "Debit");
        System.out.println("Please take your card and money.");
        return true;
    }

    @Override
    public boolean deposit(double creditAmt) {
        balance += creditAmt;
        Transactions.recordTransaction(creditAmt, "Credit");
        System.out.println("Deposit was successful!");
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public boolean printTransaction(){
        StringBuilder content = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))){
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                content.append(currentLine).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(content);
        return true;
    }
}
