package com.example.LoginServlet.model;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB extends HttpServlet {
    public static Connection connection = null;

    public void init()
    {
        ServletConfig config = getServletConfig();
        String url = config.getInitParameter("url");
        String userName = config.getInitParameter("userName");
        String password = config.getInitParameter("password");
        getConnectionObject(url, userName, password);
    }

    private static Connection getConnectionObject(String url, String userName, String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

        }
        catch(SQLException sql)
        {
            System.out.println(sql.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
