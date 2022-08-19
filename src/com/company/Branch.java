package com.company;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    // Constructor
    public Branch(String name) {
        this.branchName = name;
        this.customers = new ArrayList<Customer>();
    }

    // Getter
    public String getBranchName() {
        return this.branchName;
    }

    // Methods
    public void printCustomerNames() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Customer name: " + customers.get(i).getCustomerName());
        }
    }
    public void printCustomerBalance(Customer customer) {
        ArrayList<Double> transactions = customer.getTransactions();
        double balance = 0.0;
        for (int i = 0; i < transactions.size(); i++) {
            balance += transactions.get(i);
        }
        System.out.println("****Balance report for " + customer.getCustomerName());
        System.out.println("Balance currently: " + "$" + balance);
    }
    public void printCustomerTransactions(Customer customer) {
        ArrayList<Double> transactions = customer.getTransactions();
        System.out.println("****Transaction List****");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i+1) + ". " + "---> " + transactions.get(i));
        }
    }
    public boolean addNewCustomer(String name, double transaction) {
        if (findCustomer(name) >= 0) {
            System.out.println("Customer already exists at branch - new customer could not be created...");
            return false;
        }
        Customer newCustomer = Customer.createCustomer(name, transaction);
        customers.add(newCustomer);
        return true;

    }
    public void addTransaction(Customer customer, double transaction) {
        customer.getTransactions().add(transaction);
    }
    public Customer queryCustomer(String customerName) {
        int position = findCustomer(customerName);
        if (position < 0) {
            System.out.println("Customer could not be found...");
            return null;
        } else {
            return customers.get(position);
        }
    }
    private int findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getCustomerName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    private int findCustomer(Customer customer) {
       return customers.indexOf(customer);
    }
}
