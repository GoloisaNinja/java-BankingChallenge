package com.company;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactions;

    // Constructor
    public Customer(String name) {
        this.customerName = name;
        this.transactions = new ArrayList<Double>();
    }

    // Getter
    public String getCustomerName() {
        return this.customerName;
    }
    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    // Methods
    public static Customer createCustomer(String name, double transaction) {
        Customer newCustomer = new Customer(name);
        newCustomer.transactions.add(transaction);
        return newCustomer;
    }

}
