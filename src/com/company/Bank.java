package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches;

    // Constructor
    public Bank() {
        this.branches = new ArrayList<Branch>();
    }

    // Getter

    public void printBranches() {
        String branchList = "\n**** Branches ****";
        for (int i = 0; i < this.branches.size(); i++) {
            branchList += "\n" + (i+1) + ": " + this.branches.get(i).getBranchName();
        }
        System.out.println(branchList);
    }

    // Methods
    public void newCustomer(String customerName, double transaction, String branch) {
        int position = findBranch(branch);
        if (position < 0) {
            System.out.println("Customer cannot be added to non-existent branch...");
        } else {
            if (branches.get(position).addNewCustomer(customerName, transaction)) {
                System.out.println("Customer: " + customerName + "\n"
                                  + "Transaction: " + transaction + "\n"
                                   + "Added! " + customerName + " is now a member of " + branch
                                  );
            }

        }
    }
    public void addCustomerTransaction(String customerName, double transaction, String branch) {
        int position = findBranch(branch);
        if (position < 0) {
            System.out.println("Branch does not exist...");
        } else {
            Customer customer = branches.get(position).queryCustomer(customerName);
            if (customer != null) {
                branches.get(position).addTransaction(customer, transaction);
            } else {
                System.out.println("Customer not found...");
            }

        }
    }
    public void printBranchCustomers(String branch) {
        int position = findBranch(branch);
        if (position < 0) {
            System.out.println("Branch does not exist...");
        } else {
            branches.get(position).printCustomerNames();
        }
    }
    public void printBranchCustomerTransactions(String branch, String customerName) {
        int position = findBranch(branch);
        if (position < 0) {
            System.out.println("Branch does not exist...");
        } else {
            Customer customer = branches.get(position).queryCustomer(customerName);
            if (customer != null) {
                branches.get(position).printCustomerTransactions(customer);
            }
        }
    }
    public void printBranchCustomerBalance(String branch, String customerName) {
        int position = findBranch(branch);
        if (position < 0) {
            System.out.println("Branch does not exist...");
        } else {
            Customer customer = branches.get(position).queryCustomer(customerName);
            if (customer != null) {
                branches.get(position).printCustomerBalance(customer);
            }
        }
    }
    public boolean createNewBranch(String branchName) {
        int position = findBranch(branchName);
        if (position < 0) {
            Branch newBranch = new Branch(branchName);
            branches.add(newBranch);
            return true;
        } else {
            System.out.println("Branch already exists...cannot create...");
            return false;
        }
    }
    public void printBranchNames() {
        System.out.println("****Branches Listing****");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i+1) + ". " + "--> " + branches.get(i).getBranchName());
        }
    }
    private int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }
}
