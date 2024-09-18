package vladdossik.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vladdossik.jdbc.jpa.model.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String PROPERTIES_PATH = "src/main/resources/application.properties";
    private static Connection connection;
    private static SessionFactory sessionFactory;

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_PATH)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        Properties properties = loadProperties();
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        return new Configuration().addProperties(loadProperties()).addAnnotatedClass(User.class).buildSessionFactory();
    }
}
