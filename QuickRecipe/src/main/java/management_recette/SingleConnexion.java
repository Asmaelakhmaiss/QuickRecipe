package management_recette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/quickrecipe";
    private static final String USER = "root";
    private static final String MY_PASSWORD = "inpt@1234567";
    
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Échec du chargement du pilote JDBC", e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, MY_PASSWORD);
    }
}