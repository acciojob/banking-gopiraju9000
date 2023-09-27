package com.driver;

import java.util.ArrayList;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
               this.name = name;
         this.balance    = balance;
         this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{

        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        // example generate the account number with 4 digits and sum was 19

        ArrayList<String> possibleAccountNumbers = new ArrayList<>();
        boolean ans = combination(digits , sum , 0,"",possibleAccountNumbers);
        if(!possibleAccountNumbers.isEmpty()) return possibleAccountNumbers.get(0);//use any account number
        else {
            throw new Exception("Account Number can not be generated");
        }
    }

    public void deposit(double amount) {

        //add amount to balance

        balance = balance + amount;

    }

    public void withdraw(double amount) throws Exception {

        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if(balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        else balance = balance - amount;
    }

    boolean combination(int digits , int sum , int idx, String psf, ArrayList<String> ans) {


        if(digits == 0) {

            if(sum == 0) {
                ans.add(psf);
                return true;
            }
            return false;
        }

        if(idx > 9) return  false;

        if(sum < 0) return false;

        boolean pick    = combination(digits - 1 , sum - idx , idx , psf + idx , ans);// i can use that number any number ot times
        boolean notPick = combination(digits , sum , idx + 1 , psf , ans);// i dont want to choose that number again

        return pick || notPick;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}