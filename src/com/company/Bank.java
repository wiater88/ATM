package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();

    }

    public String getNewUserUUID() {

        String uuid;
        Random random = new Random();
        int userIdLength = 6;
        boolean nonUnique;

        do {
            nonUnique= false;
            uuid = "";
            for (int i = 0; i< userIdLength; i++){
                uuid += ((Integer)random.nextInt(10)).toString();
            }
            for (User u : this.users){
                if(uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);
        return uuid;
    }

    public String getNewAccountUUID() {
        String uuid;
        Random random = new Random();
        int userIdLength = 10;
        boolean nonUnique;

        do {
            nonUnique= false;
            uuid = "";
            for (int i = 0; i< userIdLength; i++){
                uuid += ((Integer)random.nextInt(10)).toString();
            }
            for (Account account : this.accounts){
                if(uuid.compareTo(account.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);
        return uuid;
    }


    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public User addUser(String firstName, String lastName, String pin){
        User newUser = new User(firstName,lastName,pin,this);
        this.users.add(newUser);

        Account newAccount = new Account("Savings",newUser,this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    public User userLogin (String userID, String pin){
        for (User u : this.users){
            if(u.getUUID().compareTo(userID)==0&& (u.validatePin(pin))){
                return u;
            }

        }
        return null;
    }
}
