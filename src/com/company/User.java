package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.pinHash = messageDigest.digest(pin.getBytes());
        this.uuid = theBank.getNewUserUUID();
        this.accounts = new ArrayList<>();

        System.out.printf("New user with %s, %s with %s ID created.  \n", firstName, lastName, uuid);

    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getUUID() {
        return this.uuid;
    }

    public boolean validatePin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return  MessageDigest.isEqual(md.digest(pin.getBytes()),this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}






