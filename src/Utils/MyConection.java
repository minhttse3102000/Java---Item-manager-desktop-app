package Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author minhv
 */
public class MyConection {
    public static Connection makeConnection(){
        Connection cn=null;
        
        try {
            //buoc 1; Nap driver;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ItemManagement";
            cn=DriverManager.getConnection(url, "sa", "minhlk123");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}
