package com.company;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Bank theBank = new Bank("The IRON BANK");

        User aUser = theBank.addUser("John","Doe","1234");

        Account newAccount = new Account("Cheking", aUser,theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);


    }
}
