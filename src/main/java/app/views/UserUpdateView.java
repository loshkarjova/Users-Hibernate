package app.views;

import app.entities.User;

import java.util.Scanner;

public class UserUpdateView {

    public User doInputs() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        String string = "Enter user's ID: ";
        System.out.println(string);
        user.setId(scanner.nextInt());

        scanner.nextLine();

        string = "Enter new phone in format xxx xxx-xxxx: ";
        System.out.println(string);
        user.setPhone(scanner.nextLine().trim());

        return user;
    }

    public void getOutput(String output){
        System.out.println(output);
    }
}
