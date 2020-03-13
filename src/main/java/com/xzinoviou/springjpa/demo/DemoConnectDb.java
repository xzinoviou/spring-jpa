package com.xzinoviou.springjpa.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoConnectDb {


    public static void main(String[] args) {


        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/spring_jpa_db?useSSL=FALSE&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "root");

            System.out.println("DemoConnectDb.main - SUCCESS CONNECTION WITH DB");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
