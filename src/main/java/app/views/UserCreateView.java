package app.views;

import app.entities.User;

import java.util.Scanner;

public class UserCreateView {
    public User getData() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        String string = "Enter first name: ";
        System.out.print(string);
        user.setFirstName(scanner.nextLine().trim());

        string = "Enter last name: ";
        System.out.print(string);
        user.setLastName(scanner.nextLine().trim());

        string = "Enter phone in format xxx xxx-xxxx: ";
        System.out.print(string);
        user.setPhone(scanner.nextLine().trim());

        string = "Enter email in format example@mail.com: ";
        System.out.print(string);
        user.setEmail(scanner.nextLine().trim());

        return user;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
