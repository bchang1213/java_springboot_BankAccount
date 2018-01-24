package com.codingdojo.bank;

import java.util.Random;

public class BankAccount {
	//Attributes
	private String accountnumber;
	private double checkingbalance;
	private double savingsbalance;
	private static int numberofaccounts = 0;
	private static double totalassets = 0.0;
	
	//Get Checking balance method
	public double getCheckingbalance() {
		return checkingbalance;
	}
	//Get Savings balance method
	public double getSavingsbalance() {
		return savingsbalance;
	}
	//Constructor Method
	public BankAccount() {
		this.accountnumber = BankAccount.getAccountNumber();
		numberofaccounts ++;
		this.checkingbalance = 0.0;
		this.savingsbalance = 0.0;
	}
	//static Class method to generate account number, used in the constructor
	private static String getAccountNumber() {
		String acc = "";
		for(int i = 0; i < 10; i++) {
			Random rand = new Random();
			Integer n = rand.nextInt(10);
			acc += n.toString();
		}
		System.out.println(acc);
		return acc;
	}
	//depositing money into either savings or checkings
	public void deposit(String accounttype, double depositamount) {
		if(accounttype == "checkings") {
			checkingbalance = depositamount + checkingbalance;
			totalassets = totalassets + checkingbalance;
		}
		if(accounttype == "savings") {
			savingsbalance = depositamount + savingsbalance;
			totalassets = totalassets + checkingbalance;
		}
	}
	//withdrawing money
	public void withdraw(String accounttype, double withdrawalamount ) {
		if(accounttype == "checkings") {
			if(withdrawalamount > checkingbalance) {
				System.out.println("Your checkings account has insufficient funds.");
			}
			else{
				checkingbalance = checkingbalance - withdrawalamount;
				totalassets = totalassets - withdrawalamount;
			}
		}
		if(accounttype == "savings") {
			if(withdrawalamount > savingsbalance) {
				System.out.println("Your savings account has insufficient funds.");
			}
			else{
				savingsbalance = savingsbalance - withdrawalamount;
				totalassets = totalassets - withdrawalamount;
			}
		}
	}
	//Method to see total money from checking and savings
	public double getTotalAmount() {
		double totalaccountfunds = savingsbalance + checkingbalance;
		return totalaccountfunds;
	}
	
}
