package vladdossik.jdbc.jpa;

import vladdossik.jdbc.jpa.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Oleg", "Ivanov", (byte) 15);
        userService.saveUser("Egor", "Stepanov", (byte) 12);
        userService.saveUser("Igor", "Kornilov", (byte) 29);
        userService.saveUser("Alex", "Johnson", (byte) 19);

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
