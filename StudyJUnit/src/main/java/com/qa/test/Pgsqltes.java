package com.qa.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Pgsqltes {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://192.168.1.18:5432/sonar",
                            "postgres", "Postgres");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

}

