package com.example.sigema.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
    }

    public static void main(String[] args) {
        try {
            Connection con = ConnectionMySql.getConnection();
            System.out.println("Conexión exitosa con la base de datos");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
