package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactorySession {

    public static Session openSession() {


        Connection conn = getConnection();

        Session session = new SessionImpl(conn);

        return session;
    }



    private static Connection getConnection() {

        //Crear instancia DRIVER!! ponerlo en el pom, buscar en google
        Connection conn = null;
        try {
            //String driver = "com.mysql.jdbc.Driver";
            String dbname = "testdb";
            String username = "root";
            String password = ""; //posar contrasenya corresponent
            //Class.forName(driver);
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/"+ dbname +
                            "?user=" + username+ "&password="+password+"");

            System.out.println("Connectat a la bbdd correctament.");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
