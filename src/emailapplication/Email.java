package emailapplication;

import java.util.Scanner;

public class Email {

    private final String fname;
    private final String lname;
    private String pass;
    private final String email;
    private final String department;
    private int mailBoxCapacity = 200;
    private int passLength = 12;
    private String altEmail;
    private String compannySuffix = "company.com";

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New user created " + this.fname + " " + this.lname);

        this.department = setDepartment();

        this.pass = genRandPass(passLength);
        System.out.println("Your password is: " + this.pass);

        email = fname.toLowerCase() + "." + lname.toLowerCase() + "@" + department + "." + compannySuffix;
    }

    private String setDepartment() {

        System.out.print("Select the department:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter your choice: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "accounting";
            default:
                return "";
        }

    }

    private String genRandPass(int length) {
        String symbols = "ABCDEFGEFGHIJKLMOPQRSTUVWXYX0123456789!@#$%^&*()";

        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * symbols.length());
            password[i] = symbols.charAt(random);
        }

        return new String(password);
    }
    
    public String show() {
        return "Name: " + fname + " " + lname  + "\nEmail: " + email + "\nMailbox capacity: " + mailBoxCapacity;
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public void changePassword(String pass) {
        this.pass = pass;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public String getChangedPass() {
        return pass;
    }
}
