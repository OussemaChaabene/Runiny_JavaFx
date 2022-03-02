/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class MyDB {

    private final String url = "jdbc:mysql://localhost:3306/dbsami";
    private final String user = "root";
    private final String password = "";
    private Connection cnx;
    static MyDB instance;

    public MyDB() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static MyDB getInstance() {
        if (instance == null) {
            instance = new MyDB();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

}
