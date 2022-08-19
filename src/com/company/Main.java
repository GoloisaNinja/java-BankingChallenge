package com.company;

public class Main {

    public static void main(String[] args) {
	    Bank myBank = new Bank();
	    myBank.createNewBranch("West Branch");
	    myBank.createNewBranch("East Branch");
		myBank.newCustomer("Jack Collins", 20.00, "West Branch");
		myBank.printBranchCustomers("West Branch");
		myBank.addCustomerTransaction("Jack Collins", 40.00, "West Branch");
		myBank.addCustomerTransaction("Jack Collins", -10.00, "West Branch");
		myBank.printBranchCustomerTransactions("West Branch", "Jack Collins");
		myBank.printBranchCustomerBalance("West Branch", "Jack Collins");
		myBank.printBranches();
    }
}
