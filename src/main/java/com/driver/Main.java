package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        BankAccount bankAccount = new BankAccount("raju",10000,100);

        System.out.println(bankAccount.generateAccountNumber(4,19));
        bankAccount.withdraw(2000);
        bankAccount.deposit(2000);

        CurrentAccount currentAccount = new CurrentAccount("raju",1000,"AABBCD");

        currentAccount.validateLicenseId();

        SavingsAccount savingsAccount = new SavingsAccount("raju",10000,500000,2.0);

        savingsAccount.withdraw(2000);
        System.out.println(savingsAccount.getSimpleInterest(4));
        System.out.println(savingsAccount.getCompoundInterest(4,2));

        StudentAccount studentAccount = new StudentAccount("raju",2000,"ABC");

    }
}