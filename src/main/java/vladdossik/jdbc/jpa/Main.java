package vladdossik.jdbc.jpa;

import vladdossik.jdbc.jpa.service.UserServiceImpl;
import vladdossik.jdbc.jpa.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
    }
}
