package app.views;

import app.entities.User;

import java.util.Scanner;

public class UserDeleteView {

    public User getData() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        String title = "Enter user's ID: ";
        System.out.print(title);
        user.setId(scanner.nextInt());

        return user;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
