/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3h.ecommerce.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BINH
 */
public class DatabaseConnection {
    public static Connection mySQLConnection() throws ClassNotFoundException, SQLException{
        String sqlUrl = "jdbc:mysql://localhost:3306/ecommerce";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(sqlUrl,"root","");
        return con;
    }
}
