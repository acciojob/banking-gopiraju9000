package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {

        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {

        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if(getBalance() < amount) {//default minimum balance is zero
            throw  new Exception("Insufficient Balance");
        }
        else{
            if(amount > maxWithdrawalLimit) throw new Exception("Maximum Withdraw Limit Exceed");
        }
        double v = super.getBalance()-amount;//none of the exceptions will hit it was valid amount
        super.setBalance(v);//update the valid amount


    }

    public double getSimpleInterest(int years){

        // Return the final amount considering that bank gives simple interest on current amount

        //SI = P * T * R / 100;

        double simpleInterest = (super.getBalance() *  years * rate)/100;

        return simpleInterest + getBalance();

    }

    public double getCompoundInterest(int times, int years){

        // Return the final amount considering that bank gives compound interest on current amount given times per year

        double principal = getBalance();

        double CI = principal *
                (Math.pow((1 + rate / 100), years));

        return CI;
    }

}
